package com.onboarding.webapi.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "controlGroup")
public class ControlGroupBean implements Serializable{
	
	private static final long serialVersionUID = -4934306614378400459L;
	
	private String controlGroupId;
	private String controlGroupName;
	private String controlGroupEIN;
	private String measurementStartDate;
	private String measurementEndDate;
	private String measurementEndDate1;
	private String measurementEndDate2;
	private String measurementEndDate3;
	private String measurementEndDate4;
	private boolean isActive;
	private boolean isDeleted;
	private String createdBy;
	private String createdDate;
	private String modifiedBy;
	
	public String getControlGroupId() {
		return controlGroupId;
	}
	public void setControlGroupId(String controlGroupId) {
		this.controlGroupId = controlGroupId;
	}
	public String getControlGroupName() {
		return controlGroupName;
	}
	public void setControlGroupName(String controlGroupName) {
		this.controlGroupName = controlGroupName;
	}
	public String getControlGroupEIN() {
		return controlGroupEIN;
	}
	public void setControlGroupEIN(String controlGroupEIN) {
		this.controlGroupEIN = controlGroupEIN;
	}
	public String getMeasurementStartDate() {
		return measurementStartDate;
	}
	public void setMeasurementStartDate(String measurementStartDate) {
		this.measurementStartDate = measurementStartDate;
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
	public String getMeasurementEndDate2() {
		return measurementEndDate2;
	}
	public void setMeasurementEndDate2(String measurementEndDate2) {
		this.measurementEndDate2 = measurementEndDate2;
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
}
