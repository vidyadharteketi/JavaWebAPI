package com.reporting.webapi.response.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "demoGraphicsReportData")
public class DemoGraphicsReportDataVO implements Serializable{
	
	@XmlElementWrapper(name = "ParentCompany")
	@XmlElement(name = "ParentCompany")
	private String parentCompany;
	
	@XmlElementWrapper(name = "ProductionCompany")
	@XmlElement(name = "ProductionCompany")
	private String productionCompany;
	
	@XmlElementWrapper(name = "ShowName")
	@XmlElement(name = "ShowName")
	private String showName;
	
	@XmlElementWrapper(name = "PayrollCompany")
	@XmlElement(name = "PayrollCompany")
	private String payrollCompany;
	
	
	@XmlElementWrapper(name = "EmployeeName")
	@XmlElement(name = "EmployeeName")
	private String employeeName;
	
	
	@XmlElementWrapper(name = "UnionStatus")
	@XmlElement(name = "UnionStatus")
	private String unionStatus;
	
	
	@XmlElementWrapper(name = "SSN")
	@XmlElement(name = "SSN")
	private String ssn;
	
	@XmlElementWrapper(name = "ACAEmploymentBasis")
	@XmlElement(name = "ACAEmploymentBasis")
	private String aCAEmploymentBasis;
	
	@XmlElementWrapper(name = "ScheduleCode")
	@XmlElement(name = "ScheduleCode")
	private String scheduleCode;
	
	@XmlElementWrapper(name = "PayRate")
	@XmlElement(name = "PayRate")
	private String payRate;
	
	@XmlElementWrapper(name = "JobDescription")
	@XmlElement(name = "JobDescription")
	private String jobDescription;
	
	
	@XmlElementWrapper(name = "Gender")
	@XmlElement(name = "Gender")
	private String gender;
	
	
	@XmlElementWrapper(name = "DateOfBirth")
	@XmlElement(name = "DateOfBirth")
	private String dateOfBirth;
	
	
	@XmlElementWrapper(name = "Email")
	@XmlElement(name = "Email")
	private String email;
	
	@XmlElementWrapper(name = "Address")
	@XmlElement(name = "Address")
	private String address;
	
	@XmlElementWrapper(name = "City")
	@XmlElement(name = "City")
	private String city;
	
	@XmlElementWrapper(name = "State")
	@XmlElement(name = "State")
	private String state;
	
	@XmlElementWrapper(name = "Zip")
	@XmlElement(name = "Zip")
	private String zip;
	
	@XmlElementWrapper(name = "ControlGroup")
	@XmlElement(name = "ControlGroup")
	private String controlGroup;

	@XmlElementWrapper(name = "WorkYear")
	@XmlElement(name = "WorkYear")
	private String workYear;
	
	public String getParentCompany() {
		return parentCompany;
	}

	public void setParentCompany(String parentCompany) {
		this.parentCompany = parentCompany;
	}

	public String getProductionCompany() {
		return productionCompany;
	}

	public void setProductionCompany(String productionCompany) {
		this.productionCompany = productionCompany;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getPayrollCompany() {
		return payrollCompany;
	}

	public void setPayrollCompany(String payrollCompany) {
		this.payrollCompany = payrollCompany;
	}

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

	public String getaCAEmploymentBasis() {
		return aCAEmploymentBasis;
	}

	public void setaCAEmploymentBasis(String aCAEmploymentBasis) {
		this.aCAEmploymentBasis = aCAEmploymentBasis;
	}

	public String getScheduleCode() {
		return scheduleCode;
	}

	public void setScheduleCode(String scheduleCode) {
		this.scheduleCode = scheduleCode;
	}

	public String getPayRate() {
		return payRate;
	}

	public void setPayRate(String payRate) {
		this.payRate = payRate;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getControlGroup() {
		return controlGroup;
	}

	public void setControlGroup(String controlGroup) {
		this.controlGroup = controlGroup;
	}

	public String getWorkYear() {
		return workYear;
	}

	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}

	
	
}
