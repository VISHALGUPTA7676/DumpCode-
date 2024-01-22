package com.xomic.crud.dal;

import java.util.List;

import com.xomic.crud.pojo.Country;
import com.xomic.crud.pojo.MasterLanguage;
import com.xomic.crud.pojo.MasterUserType;
import com.xomic.crud.pojo.State;
import com.xomic.crud.pojo.UserMaster;
import com.xomic.crud.request.UserRequest;

public interface UserDao {

	String check();

	List<State> getState();

	List<State> getStateById(Short id);

	List<Country> allCoun();

	List<MasterUserType> userType();

	List<MasterLanguage> getLan();

	void saveUsers(UserRequest userRequest);

	List<UserMaster> getAllUserS();

}
