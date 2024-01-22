package com.xomic.crud.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xomic.crud.pojo.MasterUserType;

public class UserTypeRowMapper implements RowMapper<MasterUserType>{

	@Override
	public MasterUserType mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method 
		
		MasterUserType  masterUserType = new MasterUserType();
		masterUserType.setUserTypeId(rs.getByte("usertypeid"));
		masterUserType.setUserType(rs.getString("usertypename"));
		return masterUserType;
	}

}
