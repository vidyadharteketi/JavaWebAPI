package com.reporting.webapi.bean;

import java.util.List;

public class NewHireNonFullTimeReferanceDataBean {

	private List<String> workYearList;
	
	private List<String> workMonthList;
	
	private List<String> controlGroupList;
	
	private List<String> unionTypeList;
	
	private List<String> employeeTypeList;

	public List<String> getWorkYearList() {
		return workYearList;
	}

	public void setWorkYearList(List<String> workYearList) {
		this.workYearList = workYearList;
	}

	public List<String> getWorkMonthList() {
		return workMonthList;
	}

	public void setWorkMonthList(List<String> workMonthList) {
		this.workMonthList = workMonthList;
	}

	public List<String> getControlGroupList() {
		return controlGroupList;
	}

	public void setControlGroupList(List<String> controlGroupList) {
		this.controlGroupList = controlGroupList;
	}

	public List<String> getUnionTypeList() {
		return unionTypeList;
	}

	public void setUnionTypeList(List<String> unionTypeList) {
		this.unionTypeList = unionTypeList;
	}

	public List<String> getEmployeeTypeList() {
		return employeeTypeList;
	}

	public void setEmployeeTypeList(List<String> employeeTypeList) {
		this.employeeTypeList = employeeTypeList;
	}
	
	
}
