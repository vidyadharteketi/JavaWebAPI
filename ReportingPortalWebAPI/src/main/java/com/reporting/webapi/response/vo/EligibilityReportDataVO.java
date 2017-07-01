package com.reporting.webapi.response.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "eligibilityReportData")
public class EligibilityReportDataVO implements Serializable{
	
	@XmlElementWrapper(name = "EmployeeName")
	@XmlElement(name = "EmployeeName")
	private String employeeName;
	
	@XmlElementWrapper(name = "UnionStatus")
	@XmlElement(name = "UnionStatus")
	private String unionStatus;
	
	@XmlElementWrapper(name = "SSN")
	@XmlElement(name = "SSN")
	private String ssn;
	
	@XmlElementWrapper(name = "MostRecentShow")
	@XmlElement(name = "MostRecentShow")
	private String mostRecentShow;
	
	@XmlElementWrapper(name = "MostRecentJobTitle")
	@XmlElement(name = "MostRecentJobTitle")
	private String mostRecentJobTitle;
	
	@XmlElementWrapper(name = "AverageWeeklyHours")
	@XmlElement(name = "AverageWeeklyHours")
	private String averageWeeklyHours;
	
	@XmlElementWrapper(name = "TotalHours")
	@XmlElement(name = "TotalHours")
	private String totalHours;
	
	@XmlElementWrapper(name = "StandardMeasuredEligibility")
	@XmlElement(name = "StandardMeasuredEligibility")
	private String standardMeasuredEligibility;
	
	@XmlElementWrapper(name = "BenefitsEffective")
	@XmlElement(name = "BenefitsEffective")
	private String benefitsEffective;
	
	@XmlElementWrapper(name = "ControlGroup")
	@XmlElement(name = "ControlGroup")
	private String controlGroup;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getUnionStatus() {
		return unionStatus;
	}

	public void setUnionStatus(String unionStatus) {
		this.unionStatus = unionStatus;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getMostRecentShow() {
		return mostRecentShow;
	}

	public void setMostRecentShow(String mostRecentShow) {
		this.mostRecentShow = mostRecentShow;
	}

	public String getMostRecentJobTitle() {
		return mostRecentJobTitle;
	}

	public void setMostRecentJobTitle(String mostRecentJobTitle) {
		this.mostRecentJobTitle = mostRecentJobTitle;
	}

	public String getAverageWeeklyHours() {
		return averageWeeklyHours;
	}

	public void setAverageWeeklyHours(String averageWeeklyHours) {
		this.averageWeeklyHours = averageWeeklyHours;
	}

	public String getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(String totalHours) {
		this.totalHours = totalHours;
	}

	public String getStandardMeasuredEligibility() {
		return standardMeasuredEligibility;
	}

	public void setStandardMeasuredEligibility(String standardMeasuredEligibility) {
		this.standardMeasuredEligibility = standardMeasuredEligibility;
	}

	public String getBenefitsEffective() {
		return benefitsEffective;
	}

	public void setBenefitsEffective(String benefitsEffective) {
		this.benefitsEffective = benefitsEffective;
	}

	public String getControlGroup() {
		return controlGroup;
	}

	public void setControlGroup(String controlGroup) {
		this.controlGroup = controlGroup;
	}
	
	
}
