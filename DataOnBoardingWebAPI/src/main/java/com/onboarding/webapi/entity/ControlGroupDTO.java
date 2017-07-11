package com.onboarding.webapi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tbl_data_control_group", uniqueConstraints = {
		@UniqueConstraint(columnNames = "CONTROL_GROUP_NAME") })
public class ControlGroupDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CONTROL_GROUP_ID", unique = true, nullable = false)
	private Integer controlGroupId;
	@Column(name = "CONTROL_GROUP_NAME", unique = true, nullable = false)
	private String controlGroupName;
	@Column(name = "CONTROL_GROUP_EIN")
	private String controlGroupEIN;
	@Column(name = "MEASUREMENT_START_DATE")
	@Temporal(TemporalType.DATE)
	private Date measurementStartDate;
	@Column(name = "MEASUREMENT_END_DATE")
	@Temporal(TemporalType.DATE)
	private Date measurementEndDate;
	@Column(name = "MEASUREMENT_END_DATE_1")
	@Temporal(TemporalType.DATE)
	private Date measurementEndDate1;
	@Column(name = "MEASUREMENT_END_DATE_2")
	@Temporal(TemporalType.DATE)
	private Date measurementEndDate2;
	@Column(name = "MEASUREMENT_END_DATE_3")
	@Temporal(TemporalType.DATE)
	private Date measurementEndDate3;
	@Column(name = "MEASUREMENT_END_DATE_4")
	@Temporal(TemporalType.DATE)
	private Date measurementEndDate4;
	@Column(name = "IS_ACTIVE")
	private boolean isActive;
	@Column(name = "IS_DELETED")
	private boolean isDeleted;
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	
	public Integer getControlGroupId() {
		return controlGroupId;
	}
	public void setControlGroupId(Integer controlGroupId) {
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
	public Date getMeasurementStartDate() {
		return measurementStartDate;
	}
	public void setMeasurementStartDate(Date measurementStartDate) {
		this.measurementStartDate = measurementStartDate;
	}
	public Date getMeasurementEndDate() {
		return measurementEndDate;
	}
	public void setMeasurementEndDate(Date measurementEndDate) {
		this.measurementEndDate = measurementEndDate;
	}
	public Date getMeasurementEndDate1() {
		return measurementEndDate1;
	}
	public void setMeasurementEndDate1(Date measurementEndDate1) {
		this.measurementEndDate1 = measurementEndDate1;
	}
	public Date getMeasurementEndDate2() {
		return measurementEndDate2;
	}
	public void setMeasurementEndDate2(Date measurementEndDate2) {
		this.measurementEndDate2 = measurementEndDate2;
	}
	public Date getMeasurementEndDate3() {
		return measurementEndDate3;
	}
	public void setMeasurementEndDate3(Date measurementEndDate3) {
		this.measurementEndDate3 = measurementEndDate3;
	}
	public Date getMeasurementEndDate4() {
		return measurementEndDate4;
	}
	public void setMeasurementEndDate4(Date measurementEndDate4) {
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
	
}
