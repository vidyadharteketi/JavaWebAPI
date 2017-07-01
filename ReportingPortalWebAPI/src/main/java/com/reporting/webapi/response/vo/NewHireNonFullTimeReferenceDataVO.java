package com.reporting.webapi.response.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "EligibilityNewHiresNonFullTimeReferenceData")
public class NewHireNonFullTimeReferenceDataVO implements Serializable{
	
	private static final long serialVersionUID = -357803928259592298L;

	@XmlElementWrapper(name = "WorkYear")
	@XmlElement(name = "WorkYear")
	private List<String> workYears;
	
	@XmlElementWrapper(name = "WorkMonth")
	@XmlElement(name = "WorkMonth")
	private List<String> workMonths;
	
	@XmlElementWrapper(name = "ControlGroup")
	@XmlElement(name = "ControlGroup")
	private List<String> controlgroups;
	
	@XmlElementWrapper(name = "UnionType")
	@XmlElement(name = "UnionType")
	private List<String> unionTypes;
	
	@XmlElementWrapper(name = "EmployeeType")
	@XmlElement(name = "EmployeeType")
	private List<String> employeeTypes;

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

	public List<String> getUnionTypes() {
		return unionTypes;
	}

	public void setUnionTypes(List<String> unionTypes) {
		this.unionTypes = unionTypes;
	}

	public List<String> getEmployeeTypes() {
		return employeeTypes;
	}

	public void setEmployeeTypes(List<String> employeeTypes) {
		this.employeeTypes = employeeTypes;
	}


}
