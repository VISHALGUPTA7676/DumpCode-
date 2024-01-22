package com.xomic.crud.pojo;

public class MasterUserType {
	
	private byte userTypeId;
	private String userType;
	
	@Override
	public String toString() {
		return "MasterUserType [userTypeId=" + userTypeId + ", userType=" + userType + "]";
	}
	public byte getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(byte userTypeId) {
		this.userTypeId = userTypeId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	

}
