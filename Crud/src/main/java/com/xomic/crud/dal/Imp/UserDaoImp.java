package com.xomic.crud.dal.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xomic.crud.dal.UserDao;
import com.xomic.crud.pojo.Country;
import com.xomic.crud.pojo.MasterLanguage;
import com.xomic.crud.pojo.MasterUserType;
import com.xomic.crud.pojo.State;
import com.xomic.crud.pojo.UserMaster;
import com.xomic.crud.request.UserRequest;
import com.xomic.crud.rowmapper.MasterCountryRowMapper;
import com.xomic.crud.rowmapper.MasterLanguageRowMapper;
import com.xomic.crud.rowmapper.StateRowMapper;
import com.xomic.crud.rowmapper.UserMasterMapper;
import com.xomic.crud.rowmapper.UserTypeRowMapper;

import lombok.Getter;
import lombok.Setter;

@Component
@Setter
@Getter
public class UserDaoImp implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String check() {
		System.out.println(jdbcTemplate.hashCode());
		return "hello";
	}

	@Override
	public List<State> getState() {
		String query = "select * from master_state join master_country on master_state.countryid=master_country.countryid";
		return jdbcTemplate.query(query, new StateRowMapper());
	}

	@Override
	public List<State> getStateById(Short id) {
		String query = "select * from master_state where countryid=?";
		return jdbcTemplate.query(query, new Object[] { id }, new StateRowMapper());
	}

	@Override
	public List<Country> allCoun() {
		// TODO Auto-generated method stub
		String query = "select * from master_country";
		return jdbcTemplate.query(query, new MasterCountryRowMapper());
	}

	@Override
	public List<MasterUserType> userType() {
		String query = "select * from master_usertype";
		return jdbcTemplate.query(query, new UserTypeRowMapper());
	}

	@Override
	public List<MasterLanguage> getLan() {
		String query = "select * from master_language";
		return jdbcTemplate.query(query, new MasterLanguageRowMapper());
	}

	@Override
	@Transactional
	public void saveUsers(final UserRequest userRequest) {
		byte[] lan = userRequest.getLanguageId();
		String queryForInsertUserDetails = "insert into user_details(userid,firstname,lastname,city,mobile,usertypeid,stateid) value(?,?,?,?,?,?,?)";
		String experience = "insert into user_experiences(userid,noofyears,jondescription,company,createdon) value(?,?,?,?,?)";
		String languageQuery = "insert into user_language(userid,languageid,createdon) value(?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				String qureyForInsertUserMaster = "insert into user_master(emailid,password,createddon,isActive) value(?,?,?,?)";
				PreparedStatement preparedStatement = connection.prepareStatement(qureyForInsertUserMaster,
						Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, userRequest.getEmailId());
				preparedStatement.setString(2, userRequest.getPassword());
				preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
				preparedStatement.setBoolean(4, true);
				return preparedStatement;
			}
		}, keyHolder);

		int userId = (int) keyHolder.getKey().longValue();

		jdbcTemplate.update(queryForInsertUserDetails, userId, userRequest.getFirstName(), userRequest.getLastName(),
				userRequest.getCityName(), userRequest.getMobileNuber(), userRequest.getUserTypeId(),
				userRequest.getStateId());

		
		
		for (int i = 0; i < lan.length; i++) {
			jdbcTemplate.update(languageQuery, userId, lan[i], Timestamp.valueOf(LocalDateTime.now()));
		}
		
		
		for (int i = 0; i < userRequest.getUserExperiences().size(); i++) {
			jdbcTemplate.update(experience, userId, userRequest.getUserExperiences().get(i).getNoOfYears(),
					userRequest.getUserExperiences().get(i).getDescription(),
					userRequest.getUserExperiences().get(i).getCompanyName(), Timestamp.valueOf(LocalDateTime.now()));
		}

	}

	@Override
	public List<UserMaster> getAllUserS() {
		// TODO Auto-generated method stub
		String query="  select * from user_master m\r\n"
				+ "    join user_details u on u.userid=m.userid";
		return jdbcTemplate.query(query,new UserMasterMapper());
	}

}
