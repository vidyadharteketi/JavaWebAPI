package com.reporting.webapi.response.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "breakInReferanceData")
public class BreakInServiceReferanceDataVO implements Serializable{
	
	@XmlElementWrapper(name = "WorkYear")
	@XmlElement(name = "WorkYear")
	private List<String> workYears;
	
	@XmlElementWrapper(name = "ControlGroup")
	@XmlElement(name = "ControlGroup")
	private List<String> controlgroups;
	
	@XmlElementWrapper(name = "WeekStarting")
	@XmlElement(name = "WeekStarting")
	private List<String> weekStarting;
	
	@XmlElementWrapper(name = "WeekEnding")
	@XmlElement(name = "WeekEnding")
	private List<String> weekEnding;

	public List<String> getWorkYears() {
		return workYears;
	}

	public void setWorkYears(List<String> workYears) {
		this.workYears = workYears;
	}

	public List<String> getControlgroups() {
		return controlgroups;
	}

	public void setControlgroups(List<String> controlgroups) {
		this.controlgroups = controlgroups;
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
