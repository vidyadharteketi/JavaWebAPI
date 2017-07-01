package com.reporting.webapi.bean;

import java.util.List;

public class ERCoverageReferanceDataBean {

	private List<String> workYears;
	
	private List<String> controlGroups;

	public List<String> getWorkYears() {
		return workYears;
	}

	public void setWorkYears(List<String> workYears) {
		this.workYears = workYears;
	}

	public List<String> getControlGroups() {
		return controlGroups;
	}

	public void setControlGroups(List<String> controlGroups) {
		this.controlGroups = controlGroups;
	}
	
}
