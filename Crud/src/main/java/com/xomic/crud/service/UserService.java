package com.xomic.crud.service;

import java.util.List;

import com.xomic.crud.pojo.Country;
import com.xomic.crud.pojo.MasterLanguage;
import com.xomic.crud.pojo.MasterUserType;
import com.xomic.crud.pojo.State;
import com.xomic.crud.pojo.UserMaster;
import com.xomic.crud.request.UserRequest;

public interface UserService {

	public String getaD();

	List<State> ffT();

	public List<State> getAllStateById(short id);

	public List<Country> getALLCO();

	public List<MasterUserType> getUser();

	public List<MasterLanguage> fetchLanguage();

	public void saveUSer(UserRequest userRequest);

	public List<UserMaster> fetALLUser();
	

}
