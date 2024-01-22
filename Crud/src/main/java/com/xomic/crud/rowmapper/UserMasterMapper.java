package com.xomic.crud.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xomic.crud.pojo.UserDetails;
import com.xomic.crud.pojo.UserMaster;

public class UserMasterMapper implements RowMapper<UserMaster> {

	@Override
	public UserMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		UserMaster userMaster = new UserMaster();
		userMaster.setUserid(rs.getInt("userid"));
		userMaster.setActive(rs.getBoolean("isActive"));
		userMaster.setCreatedOn(rs.getTimestamp("createddon").toLocalDateTime());
		userMaster.setEmailId(rs.getString("emailid"));
		if(rs.getTimestamp("updatedon") == null) {
			
		}else {
			userMaster.setUpdatedOn(rs.getTimestamp("updatedon").toLocalDateTime());
		}
	//	
		
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName(rs.getString("firstname"));
		userDetails.setLastName(rs.getString("lastname"));
		userDetails.setUserDetailIs(rs.getInt("userdetailid"));		
		userMaster.setDetails(userDetails);
		return userMaster;
	}

}
