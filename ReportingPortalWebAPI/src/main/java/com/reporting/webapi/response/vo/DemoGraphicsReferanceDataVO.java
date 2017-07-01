package com.reporting.webapi.response.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "demoGraphicsReferanceData")
public class DemoGraphicsReferanceDataVO implements Serializable{

	@XmlElementWrapper(name = "WorkYear")
	@XmlElement(name = "WorkYear")
	private List<String> workYears;
	
	@XmlElementWrapper(name = "ControlGroup")
	@XmlElement(name = "ControlGroup")
	private List<String> controlgroups;
	
	@XmlElementWrapper(name = "ParentCompany")
	@XmlElement(name = "ParentCompany")
	private List<String> parentCompany;
	
	@XmlElementWrapper(name = "ProductionCompany")
	@XmlElement(name = "ProductionCompany")
	private List<String> productionCompany;
	
	@XmlElementWrapper(name = "PayrollCompany")
	@XmlElement(name = "PayrollCompany")
	private List<String> payrollCompany;

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

	public List<String> getParentCompany() {
		return parentCompany;
	}

	public void setParentCompany(List<String> parentCompany) {
		this.parentCompany = parentCompany;
	}

	public List<String> getProductionCompany() {
		return productionCompany;
	}

	public void setProductionCompany(List<String> productionCompany) {
		this.productionCompany = productionCompany;
	}

	public List<String> getPayrollCompany() {
		return payrollCompany;
	}

	public void setPayrollCompany(List<String> payrollCompany) {
		this.payrollCompany = payrollCompany;
	}

	

	
}
