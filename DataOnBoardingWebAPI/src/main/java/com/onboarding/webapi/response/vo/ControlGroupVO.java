package com.onboarding.webapi.response.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "controlGroupData")
public class ControlGroupVO implements Serializable{

	@XmlElementWrapper(name = "controlGroupId")
	@XmlElement(name = "controlGroupId")
	private String controlGroupId;
	
	@XmlElementWrapper(name = "controlGroupEIN")
	@XmlElement(name = "controlGroupEIN")
	private String controlGroupEIN;
	
	@XmlElementWrapper(name = "controlGroupName")
	@XmlElement(name = "controlGroupName")
	private String controlGroupName;
	
	@XmlElementWrapper(name = "createdBy")
	@XmlElement(name = "createdBy")
	private String createdBy;
	
	@XmlElementWrapper(name = "createdDate")
	@XmlElement(name = "createdDate")
	private String createdDate;
	
	@XmlElementWrapper(name = "active")
	@XmlElement(name = "active")
	private String active;
	
	@XmlElementWrapper(name = "deleted")
	@XmlElement(name = "deleted")
	private String deleted;
	
	@XmlElementWrapper(name = "measurementEndDate")
	@XmlElement(name = "measurementEndDate")
	private String measurementEndDate;
	
	@XmlElementWrapper(name = "measurementEndDate1")
	@XmlElement(name = "measurementEndDate1")
	private String measurementEndDate1;
	
	@XmlElementWrapper(name = "measurementEndDate3")
	@XmlElement(name = "measurementEndDate3")
	private String measurementEndDate3;
	
	@XmlElementWrapper(name = "measurementEndDate4")
	@XmlElement(name = "measurementEndDate4")
	private String measurementEndDate4;
	
	@XmlElementWrapper(name = "measurementEndDate2")
	@XmlElement(name = "measurementEndDate2")
	private String measurementEndDate2;
	
	@XmlElementWrapper(name = "measurementStartDate")
	@XmlElement(name = "measurementStartDate")
	private String measurementStartDate;
	
	@XmlElementWrapper(name = "modifiedBy")
	@XmlElement(name = "modifiedBy")
	private String modifiedBy;

	@XmlElementWrapper(name = "modifiedDate")
	@XmlElement(name = "modifiedDate")
	private String modifiedDate;
	
	public String getControlGroupId() {
		return controlGroupId;
	}

	public void setControlGroupId(String controlGroupId) {
		this.controlGroupId = controlGroupId;
	}

	public String getControlGroupEIN() {
		return controlGroupEIN;
	}

	public void setControlGroupEIN(String controlGroupEIN) {
		this.controlGroupEIN = controlGroupEIN;
	}

	public String getControlGroupName() {
		return controlGroupName;
	}

	public void setControlGroupName(String controlGroupName) {
		this.controlGroupName = controlGroupName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getMeasurementEndDate() {
		return measurementEndDate;
	}

	public void setMeasurementEndDate(String measurementEndDate) {
		this.measurementEndDate = measurementEndDate;
	}

	public String getMeasurementEndDate1() {
		return measurementEndDate1;
	}

	public void setMeasurementEndDate1(String measurementEndDate1) {
		this.measurementEndDate1 = measurementEndDate1;
	}

	public String getMeasurementEndDate3() {
		return measurementEndDate3;
	}

	public void setMeasurementEndDate3(String measurementEndDate3) {
		this.measurementEndDate3 = measurementEndDate3;
	}

	public String getMeasurementEndDate4() {
		return measurementEndDate4;
	}

	public void setMeasurementEndDate4(String measurementEndDate4) {
		this.measurementEndDate4 = measurementEndDate4;
	}

	public String getMeasurementEndDate2() {
		return measurementEndDate2;
	}

	public void setMeasurementEndDate2(String measurementEndDate2) {
		this.measurementEndDate2 = measurementEndDate2;
	}

	public String getMeasurementStartDate() {
		return measurementStartDate;
	}

	public void setMeasurementStartDate(String measurementStartDate) {
		this.measurementStartDate = measurementStartDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	
	
}
