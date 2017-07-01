package com.reporting.webapi.response.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "breakInReportData")
public class BreakInReportDataVO implements Serializable{
	
	@XmlElementWrapper(name = "FirstName")
	@XmlElement(name = "FirstName")
	private String firstName;
	
	@XmlElementWrapper(name = "LastName")
	@XmlElement(name = "LastName")
	private String lastName;
	
	@XmlElementWrapper(name = "SSN")
	@XmlElement(name = "SSN")
	private String ssn;
	
	@XmlElementWrapper(name = "ServiceStatus")
	@XmlElement(name = "ServiceStatus")
	private String serviceStatus;
	
	
	@XmlElementWrapper(name = "WeekStarting")
	@XmlElement(name = "WeekStarting")
	private String weekStarting;
	
	
	@XmlElementWrapper(name = "WeekEnding")
	@XmlElement(name = "WeekEnding")
	private String weekEnding;
	
	
	@XmlElementWrapper(name = "WeekCount")
	@XmlElement(name = "WeekCount")
	private String weekCount;
	
	@XmlElementWrapper(name = "ControlGroup")
	@XmlElement(name = "ControlGroup")
	private String controlGroup;


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


	public String getSsn() {
		return ssn;
	}


	public void setSsn(String ssn) {
		this.ssn = ssn;
	}


	public String getServiceStatus() {
		return serviceStatus;
	}


	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}


	public String getWeekStarting() {
		return weekStarting;
	}


	public void setWeekStarting(String weekStarting) {
		this.weekStarting = weekStarting;
	}


	public String getWeekEnding() {
		return weekEnding;
	}


	public void setWeekEnding(String weekEnding) {
		this.weekEnding = weekEnding;
	}


	public String getWeekCount() {
		return weekCount;
	}


	public void setWeekCount(String weekCount) {
		this.weekCount = weekCount;
	}


	public String getControlGroup() {
		return controlGroup;
	}


	public void setControlGroup(String controlGroup) {
		this.controlGroup = controlGroup;
	}


	
}
