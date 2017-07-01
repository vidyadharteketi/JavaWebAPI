package com.reporting.webapi.response.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "EligibilityNewHiresFullTimeReferenceData")
public class NewHireFullTimeReferenceDataVO {
	
	@XmlElementWrapper(name = "WorkYear")
	@XmlElement(name = "WorkYear")
	private List<String> workYears;
	
	@XmlElementWrapper(name = "WorkMonth")
	@XmlElement(name = "WorkMonth")
	private List<String> workMonths;
	
	@XmlElementWrapper(name = "ControlGroup")
	@XmlElement(name = "ControlGroup")
	private List<String> controlgroups;

	public List<String> getWorkYears() {
		return workYears;
	}

	public void setWorkYears(List<String> workYears) {
		this.workYears = workYears;
	}

	public List<String> getWorkMonths() {
		return workMonths;
	}

	public void setWorkMonths(List<String> workMonths) {
		this.workMonths = workMonths;
	}

	public List<String> getControlgroups() {
		return controlgroups;
	}

	public void setControlgroups(List<String> controlgroups) {
		this.controlgroups = controlgroups;
	}
	
	

}
