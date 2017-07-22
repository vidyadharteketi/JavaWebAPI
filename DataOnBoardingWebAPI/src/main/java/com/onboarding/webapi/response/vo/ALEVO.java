package com.onboarding.webapi.response.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ale")
public class ALEVO implements Serializable{

	@XmlElementWrapper(name = "aleId")
	@XmlElement(name = "aleId")
	private String aleId;
	@XmlElementWrapper(name = "aleName")
	@XmlElement(name = "aleName")
	private String aleName;
	@XmlElementWrapper(name = "aleFein")
	@XmlElement(name = "aleFein")
	private String aleFein;
	@XmlElementWrapper(name = "aleAddress1")
	@XmlElement(name = "aleAddress1")
	private String aleAddress1;
	@XmlElementWrapper(name = "aleAddress2")
	@XmlElement(name = "aleAddress2")
	private String aleAddress2;
	@XmlElementWrapper(name = "aleCity")
	@XmlElement(name = "aleCity")
	private String aleCity;
	@XmlElementWrapper(name = "aleProvince")
	@XmlElement(name = "aleProvince")
	private String aleProvince;
	@XmlElementWrapper(name = "aleState")
	@XmlElement(name = "aleState")
	private String aleState;
	@XmlElementWrapper(name = "aleZip")
	@XmlElement(name = "aleZip")
	private String aleZip;
	@XmlElementWrapper(name = "aleCountry")
	@XmlElement(name = "aleCountry")
	private String aleCountry;
	@XmlElementWrapper(name = "aleContactFirstName")
	@XmlElement(name = "aleContactFirstName")
	private String aleContactFirstName;
	@XmlElementWrapper(name = "aleContactLastName")
	@XmlElement(name = "aleContactLastName")
	private String aleContactLastName;
	@XmlElementWrapper(name = "aleContactContactNumber")
	@XmlElement(name = "aleContactContactNumber")
	private String aleContactContactNumber;
	@XmlElementWrapper(name = "active")
	@XmlElement(name = "active")
	private String active;
	@XmlElementWrapper(name = "deleted")
	@XmlElement(name = "deleted")
	private String deleted;
	@XmlElementWrapper(name = "createdBy")
	@XmlElement(name = "createdBy")
	private String createdBy;
	@XmlElementWrapper(name = "createdDate")
	@XmlElement(name = "createdDate")
	private String createdDate;
	@XmlElementWrapper(name = "modifiedBy")
	@XmlElement(name = "modifiedBy")
	private String modifiedBy;
	@XmlElementWrapper(name = "modifiedDate")
	@XmlElement(name = "modifiedDate")
	private String modifiedDate;
	
	public String getAleId() {
		return aleId;
	}
	public void setAleId(String aleId) {
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
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
	
	
	
}
