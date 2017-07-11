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

	@XmlElementWrapper(name = "ControlGroupId")
	@XmlElement(name = "ControlGroupId")
	private String controlGroupId;
	
	@XmlElementWrapper(name = "ControlGroupEIN")
	@XmlElement(name = "ControlGroupEIN")
	private String controlGroupEIN;
	
	@XmlElementWrapper(name = "ControlGroupName")
	@XmlElement(name = "ControlGroupName")
	private String controlGroupName;
	
	@XmlElementWrapper(name = "CreatedBy")
	@XmlElement(name = "CreatedBy")
	private String createdBy;
	
	@XmlElementWrapper(name = "CreatedDate")
	@XmlElement(name = "CreatedDate")
	private String createdDate;
	
	@XmlElementWrapper(name = "IsActive")
	@XmlElement(name = "IsActive")
	private boolean isActive;
	
	@XmlElementWrapper(name = "IsDeleted")
	@XmlElement(name = "IsDeleted")
	private String isDeleted;
	
	@XmlElementWrapper(name = "MeasurementEndDate")
	@XmlElement(name = "MeasurementEndDate")
	private String measurementEndDate;
	
	@XmlElementWrapper(name = "MeasurementEndDate1")
	@XmlElement(name = "MeasurementEndDate1")
	private String measurementEndDate1;
	
	@XmlElementWrapper(name = "MeasurementEndDate3")
	@XmlElement(name = "MeasurementEndDate3")
	private String measurementEndDate3;
	
	@XmlElementWrapper(name = "MeasurementEndDate4")
	@XmlElement(name = "MeasurementEndDate4")
	private String measurementEndDate4;
	
	@XmlElementWrapper(name = "MeasurementEndDate2")
	@XmlElement(name = "MeasurementEndDate2")
	private String measurementEndDate2;
	
	@XmlElementWrapper(name = "MeasurementStartDate")
	@XmlElement(name = "MeasurementStartDate")
	private String measurementStartDate;
	
	@XmlElementWrapper(name = "ModifiedBy")
	@XmlElement(name = "ModifiedBy")
	private String modifiedBy;

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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
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

	
	
}
