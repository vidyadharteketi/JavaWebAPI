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
		@UniqueConstraint(columnNames = "control_group_name") })
public class ControlGroupDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "control_group_id", unique = true, nullable = false)
	private Integer controlGroupId;
	@Column(name = "control_group_name", unique = true, nullable = false)
	private String controlGroupName;
	@Column(name = "control_group_ein")
	private String controlGroupEIN;
	@Column(name = "measurement_start_date")
	@Temporal(TemporalType.DATE)
	private Date measurementStartDate;
	@Column(name = "measurement_end_date")
	@Temporal(TemporalType.DATE)
	private Date measurementEndDate;
	@Column(name = "measurement_end_date_1")
	@Temporal(TemporalType.DATE)
	private Date measurementEndDate1;
	@Column(name = "measurement_end_date_2")
	@Temporal(TemporalType.DATE)
	private Date measurementEndDate2;
	@Column(name = "measurement_end_date_3")
	@Temporal(TemporalType.DATE)
	private Date measurementEndDate3;
	@Column(name = "measurement_end_date_4")
	@Temporal(TemporalType.DATE)
	private Date measurementEndDate4;
	@Column(name = "is_active")
	private boolean active;
	@Column(name = "is_deleted")
	private boolean deleted;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Column(name = "modified_by")
	private String modifiedBy;
	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	
	
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
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
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
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}	
	
}
