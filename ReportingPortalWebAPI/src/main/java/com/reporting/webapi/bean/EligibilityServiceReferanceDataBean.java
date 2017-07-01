package com.reporting.webapi.bean;

import java.util.List;

public class EligibilityServiceReferanceDataBean {

	private List<String> workYearList;
	private List<String> controlGroupList;
	private List<String> unionStatus;
	private List<String> typeOfHours;
	public List<String> getWorkYearList() {
		return workYearList;
	}
	public void setWorkYearList(List<String> workYearList) {
		this.workYearList = workYearList;
	}
	public List<String> getControlGroupList() {
		return controlGroupList;
	}
	public void setControlGroupList(List<String> controlGroupList) {
		this.controlGroupList = controlGroupList;
	}
	public List<String> getUnionStatus() {
		return unionStatus;
	}
	public void setUnionStatus(List<String> unionStatus) {
		this.unionStatus = unionStatus;
	}
	public List<String> getTypeOfHours() {
		return typeOfHours;
	}
	public void setTypeOfHours(List<String> typeOfHours) {
		this.typeOfHours = typeOfHours;
	}
	
	
	
}
