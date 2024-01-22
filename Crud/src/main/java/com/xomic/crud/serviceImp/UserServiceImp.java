package com.xomic.crud.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xomic.crud.dal.UserDao;
import com.xomic.crud.pojo.Country;
import com.xomic.crud.pojo.MasterLanguage;
import com.xomic.crud.pojo.MasterUserType;
import com.xomic.crud.pojo.State;
import com.xomic.crud.pojo.UserMaster;
import com.xomic.crud.request.UserRequest;
import com.xomic.crud.service.UserService;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public String getaD() {
		System.err.println(userDao.hashCode());
		return userDao.check();
	}
	
	@Override
	public List<State> ffT(){
		return userDao.getState();
	}

	@Override
	public List<State> getAllStateById(short id) {
		// TODO Auto-generated method stub
		return userDao.getStateById(id);
	}

	@Override
	public List<Country> getALLCO() {
		// TODO Auto-generated method stub
		return userDao.allCoun();
	}

	@Override
	public List<MasterUserType> getUser() {
		// TODO Auto-generated method stub
		return userDao.userType();
	}

	@Override
	public List<MasterLanguage> fetchLanguage() {
		// TODO Auto-generated method stub
		return userDao.getLan();
	}

	@Override
	public void saveUSer(UserRequest userRequest) {
		userDao.saveUsers(userRequest);
	}

	@Override
	public List<UserMaster> fetALLUser() {
		// TODO Auto-generated method stub
		return userDao.getAllUserS();
	}
}
