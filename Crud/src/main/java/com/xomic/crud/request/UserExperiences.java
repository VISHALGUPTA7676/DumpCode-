package com.xomic.crud.request;

public class UserExperiences {

	
	private byte noOfYears;
	private String companyName;
	private String description;
	public byte getNoOfYears() {
		return noOfYears;
	}
	public void setNoOfYears(byte noOfYears) {
		this.noOfYears = noOfYears;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "UserExperiences [noOfYears=" + noOfYears + ", companyName=" + companyName + ", description="
				+ description + "]";
	}
	
}
