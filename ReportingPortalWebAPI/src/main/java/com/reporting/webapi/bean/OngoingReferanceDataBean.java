package com.reporting.webapi.bean;

import java.util.List;

public class OngoingReferanceDataBean {
	
private List<String> measurementEndDate;
	
	private List<String> avgWeeklyHours;
	
	private List<String> controlGroupList;
	
	private List<String> typeOfHours;
	
	private List<String> unionType;

	public List<String> getMeasurementEndDate() {
		return measurementEndDate;
	}

	public void setMeasurementEndDate(List<String> measurementEndDate) {
		this.measurementEndDate = measurementEndDate;
	}

	public List<String> getAvgWeeklyHours() {
		return avgWeeklyHours;
	}

	public void setAvgWeeklyHours(List<String> avgWeeklyHours) {
		this.avgWeeklyHours = avgWeeklyHours;
	}

	public List<String> getControlGroupList() {
		return controlGroupList;
	}

	public void setControlGroupList(List<String> controlGroupList) {
		this.controlGroupList = controlGroupList;
	}

	public List<String> getTypeOfHours() {
		return typeOfHours;
	}

	public void setTypeOfHours(List<String> typeOfHours) {
		this.typeOfHours = typeOfHours;
	}

	public List<String> getUnionType() {
		return unionType;
	}

	public void setUnionType(List<String> unionType) {
		this.unionType = unionType;
	}
	
	

}
