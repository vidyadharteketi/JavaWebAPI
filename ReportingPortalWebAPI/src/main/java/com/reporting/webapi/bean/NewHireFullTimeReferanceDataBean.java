package com.reporting.webapi.bean;

import java.util.List;

public class NewHireFullTimeReferanceDataBean {
	
	private List<String> workYearList;
	
	private List<String> hireMonthList;
	
	private List<String> controlGroupList;

	public List<String> getWorkYearList() {
		return workYearList;
	}

	public void setWorkYearList(List<String> workYearList) {
		this.workYearList = workYearList;
	}

	public List<String> getHireMonthList() {
		return hireMonthList;
	}

	public void setHireMonthList(List<String> hireMonthList) {
		this.hireMonthList = hireMonthList;
	}

	public List<String> getControlGroupList() {
		return controlGroupList;
	}

	public void setControlGroupList(List<String> controlGroupList) {
		this.controlGroupList = controlGroupList;
	}

}
