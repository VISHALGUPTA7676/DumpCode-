package com.xomic.crud.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xomic.crud.pojo.Country;
import com.xomic.crud.pojo.State;

public class StateRowMapper implements RowMapper<State> {

	@Override
	public State mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		State state = new State();
		state.setStateId(rs.getShort("stateid"));
		state.setStateName(rs.getString("statename"));
	
		return state;
	
	}

}
