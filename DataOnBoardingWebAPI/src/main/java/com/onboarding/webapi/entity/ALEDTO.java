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
@Table(name = "tbl_data_ale", uniqueConstraints = {
		@UniqueConstraint(columnNames={"ale_name", "ale_fein"}) })
public class ALEDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ALE_ID", unique = true, nullable = false)
	private Integer aleId;
	@Column(name = "ALE_NAME", unique = true, nullable = false)
	private String aleName;
	@Column(name = "ALE_FEIN", unique = true, nullable = false)
	private String aleFein;
	@Column(name = "ALE_ADDRESS1")
	private String aleAddress1;
	@Column(name = "ALE_ADDRESS2")
	private String aleAddress2;
	@Column(name = "ALE_CITY")
	private String aleCity;
	@Column(name = "ALE_PROVINCE")
	private String aleProvince;
	@Column(name = "ALE_STATE")
	private String aleState;
	@Column(name = "ALE_ZIP")
	private String aleZip;
	@Column(name = "ALE_COUNTRY")
	private String aleCountry;
	@Column(name = "ALE_CONTACT_FIRST_NAME")
	private String aleContactFirstName;
	@Column(name = "ALE_CONTACT_LAST_NAME")
	private String aleContactLastName;
	@Column(name = "ALE_CONTACT_CONTACT_NUMBER")
	private String aleContactContactNumber;
	@Column(name = "IS_ACTIVE")
	private boolean active;
	@Column(name = "IS_DELETED")
	private boolean deleted;
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	@Column(name = "MODIFIED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	
	public Integer getAleId() {
		return aleId;
	}
	public void setAleId(Integer aleId) {
		this.aleId = aleId;
	}
	public String getAleName() {
		return aleName;
	}
	public void setAleName(String aleName) {
		this.aleName = aleName;
	}
	public String getAleFein() {
		return aleFein;
	}
	public void setAleFein(String aleFein) {
		this.aleFein = aleFein;
	}
	public String getAleAddress1() {
		return aleAddress1;
	}
	public void setAleAddress1(String aleAddress1) {
		this.aleAddress1 = aleAddress1;
	}
	public String getAleAddress2() {
		return aleAddress2;
	}
	public void setAleAddress2(String aleAddress2) {
		this.aleAddress2 = aleAddress2;
	}
	public String getAleCity() {
		return aleCity;
	}
	public void setAleCity(String aleCity) {
		this.aleCity = aleCity;
	}
	public String getAleProvince() {
		return aleProvince;
	}
	public void setAleProvince(String aleProvince) {
		this.aleProvince = aleProvince;
	}
	public String getAleState() {
		return aleState;
	}
	public void setAleState(String aleState) {
		this.aleState = aleState;
	}
	public String getAleZip() {
		return aleZip;
	}
	public void setAleZip(String aleZip) {
		this.aleZip = aleZip;
	}
	public String getAleCountry() {
		return aleCountry;
	}
	public void setAleCountry(String aleCountry) {
		this.aleCountry = aleCountry;
	}
	public String getAleContactFirstName() {
		return aleContactFirstName;
	}
	public void setAleContactFirstName(String aleContactFirstName) {
		this.aleContactFirstName = aleContactFirstName;
	}
	public String getAleContactLastName() {
		return aleContactLastName;
	}
	public void setAleContactLastName(String aleContactLastName) {
		this.aleContactLastName = aleContactLastName;
	}
	public String getAleContactContactNumber() {
		return aleContactContactNumber;
	}
	public void setAleContactContactNumber(String aleContactContactNumber) {
		this.aleContactContactNumber = aleContactContactNumber;
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
