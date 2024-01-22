package com.xomic.crud.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xomic.crud.pojo.Country;

public class MasterCountryRowMapper implements RowMapper<Country>{

	@Override
	public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Country country = new Country();
		country.setCountryId(rs.getShort("countryid"));
		country.setCountryName(rs.getString("countryname"));
		return country;
	}

	

}
