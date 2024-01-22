package com.xomic.crud.request;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRequest {
	private int userid;
	private String emailId;
	private String password;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	private boolean isActive;
	private int userDetailIs;
	private String firstName;
	private String lastName;
	private String mobileNuber;
	private String cityName;
	
	private short stateId;
	private short countryId;
	private byte userTypeId;
	
	private byte[] languageId;
	private List<UserExperiences>  userExperiences = new ArrayList<>();
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getUserDetailIs() {
		return userDetailIs;
	}
	public void setUserDetailIs(int userDetailIs) {
		this.userDetailIs = userDetailIs;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNuber() {
		return mobileNuber;
	}
	public void setMobileNuber(String mobileNuber) {
		this.mobileNuber = mobileNuber;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public short getStateId() {
		return stateId;
	}
	public void setStateId(short stateId) {
		this.stateId = stateId;
	}
	public short getCountryId() {
		return countryId;
	}
	public void setCountryId(short countryId) {
		this.countryId = countryId;
	}
	public byte getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(byte userTypeId) {
		this.userTypeId = userTypeId;
	}
	public byte[] getLanguageId() {
		return languageId;
	}
	public void setLanguageId(byte[] languageId) {
		this.languageId = languageId;
	}
	public List<UserExperiences> getUserExperiences() {
		return userExperiences;
	}
	public void setUserExperiences(List<UserExperiences> userExperiences) {
		this.userExperiences = userExperiences;
	}
	@Override
	public String toString() {
		return "UserRequest [userid=" + userid + ", emailId=" + emailId + ", password=" + password + ", createdOn="
				+ createdOn + ", updatedOn=" + updatedOn + ", isActive=" + isActive + ", userDetailIs=" + userDetailIs
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNuber=" + mobileNuber + ", cityName="
				+ cityName + ", stateId=" + stateId + ", countryId=" + countryId + ", userTypeId=" + userTypeId
				+ ", languageId=" + Arrays.toString(languageId) + ", userExperiences=" + userExperiences + "]";
	}
	
}
