package com.xomic.crud.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xomic.crud.pojo.MasterLanguage;

public class MasterLanguageRowMapper implements RowMapper<MasterLanguage>{

	@Override
	public MasterLanguage mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		MasterLanguage language= new MasterLanguage();
		language.setLanguageId(rs.getByte("languageid"));
		language.setLanguage(rs.getString("language"));
		return language;
	}

}
