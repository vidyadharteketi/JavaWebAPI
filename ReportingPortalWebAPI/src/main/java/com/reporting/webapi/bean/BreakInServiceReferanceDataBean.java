package com.reporting.webapi.bean;

import java.util.List;

public class BreakInServiceReferanceDataBean {
	
	private List<String> workYearList;
	private List<String> controlGroupList;
	private List<String> weekStarting;
	private List<String> weekEnding;

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

	public List<String> getWeekStarting() {
		return weekStarting;
	}

	public void setWeekStarting(List<String> weekStarting) {
		this.weekStarting = weekStarting;
	}

	public List<String> getWeekEnding() {
		return weekEnding;
	}

	public void setWeekEnding(List<String> weekEnding) {
		this.weekEnding = weekEnding;
	}
	
	
}
