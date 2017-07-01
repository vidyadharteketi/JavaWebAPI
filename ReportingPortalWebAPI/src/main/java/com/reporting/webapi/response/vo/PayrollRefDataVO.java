package com.reporting.webapi.response.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "payrollRefData")
public class PayrollRefDataVO {

	@XmlElementWrapper(name = "ControlGroups")
	@XmlElement(name = "ControlGroups")
	private List<String> controlgroups;
	
	
	@XmlElementWrapper(name = "WorkYears")
	@XmlElement(name = "WorkYears")
	private List<String> workYears;


	public List<String> getControlgroups() {
		return controlgroups;
	}


	public void setControlgroups(List<String> controlgroups) {
		this.controlgroups = controlgroups;
	}


	public List<String> getWorkYears() {
		return workYears;
	}


	public void setWorkYears(List<String> workYears) {
		this.workYears = workYears;
	}
}
