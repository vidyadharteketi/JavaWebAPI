package com.reporting.webapi.response.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "eligibilityReferanceData")
public class EligibilityReferanceDataVO implements Serializable{
	
	@XmlElementWrapper(name = "WorkYear")
	@XmlElement(name = "WorkYear")
	private List<String> workYears;
	
	@XmlElementWrapper(name = "ControlGroup")
	@XmlElement(name = "ControlGroup")
	private List<String> controlgroups;
	
	@XmlElementWrapper(name = "UnionStatus")
	@XmlElement(name = "UnionStatus")
	private List<String> unionStatus;
	
	@XmlElementWrapper(name = "TypeOfHours")
	@XmlElement(name = "TypeOfHours")
	private List<String> typeOfHours;

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
