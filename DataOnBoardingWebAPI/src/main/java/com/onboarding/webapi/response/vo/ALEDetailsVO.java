package com.onboarding.webapi.response.vo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "aceDetails")
public class ALEDetailsVO implements Serializable{
	
	@XmlElementWrapper(name = "aleDetailsId")
	@XmlElement(name = "aleDetailsId")
	private String aleDetailsId;
	@XmlElementWrapper(name = "aleId")
	@XmlElement(name = "aleId")
	private String aleId;
	@XmlElementWrapper(name = "aleTaxYear")
	@XmlElement(name = "aleTaxYear")
	private String aleTaxYear;
	@XmlElementWrapper(name = "isAcaSubscriber")
	@XmlElement(name = "isAcaSubscriber")
	private String isAcaSubscriber;
	@XmlElementWrapper(name = "isFilingAuthoritative1094c")
	@XmlElement(name = "isFilingAuthoritative1094c")
	private String isFilingAuthoritative1094c;
	@XmlElementWrapper(name = "isAcaReportingShared")
	@XmlElement(name = "isAcaReportingShared")
	private String isAcaReportingShared;
	@XmlElementWrapper(name = "hTransitionRelief")
	@XmlElement(name = "hTransitionRelief")
	private String hTransitionRelief;
	@XmlElementWrapper(name = "additional1095cCount")
	@XmlElement(name = "additional1095cCount")
	private String additional1095cCount;
	@XmlElementWrapper(name = "controlGroupId")
	@XmlElement(name = "controlGroupId")
	private String controlGroupId;
	@XmlElementWrapper(name = "additiontionalFulltimeEeJan")
	@XmlElement(name = "additiontionalFulltimeEeJan")
	private String additiontionalFulltimeEeJan;
	@XmlElementWrapper(name = "additiontionalFulltimeEeFeb")
	@XmlElement(name = "additiontionalFulltimeEeFeb")
	private String additiontionalFulltimeEeFeb;
	@XmlElementWrapper(name = "additiontionalFulltimeEeMar")
	@XmlElement(name = "additiontionalFulltimeEeMar")
	private String additiontionalFulltimeEeMar;
	@XmlElementWrapper(name = "additiontionalFulltimeEeApr")
	@XmlElement(name = "additiontionalFulltimeEeApr")
	private String additiontionalFulltimeEeApr;
	@XmlElementWrapper(name = "additiontionalFulltimeEeMay")
	@XmlElement(name = "additiontionalFulltimeEeMay")
	private String additiontionalFulltimeEeMay;
	@XmlElementWrapper(name = "additiontionalFulltimeEeJun")
	@XmlElement(name = "additiontionalFulltimeEeJun")
	private String additiontionalFulltimeEeJun;
	@XmlElementWrapper(name = "additiontionalFulltimeEeJul")
	@XmlElement(name = "additiontionalFulltimeEeJul")
	private String additiontionalFulltimeEeJul;
	@XmlElementWrapper(name = "additiontionalFulltimeEeAug")
	@XmlElement(name = "additiontionalFulltimeEeAug")
	private String additiontionalFulltimeEeAug;
	@XmlElementWrapper(name = "additiontionalFulltimeEeSep")
	@XmlElement(name = "additiontionalFulltimeEeSep")
	private String additiontionalFulltimeEeSep;
	@XmlElementWrapper(name = "additiontionalFulltimeEeOct")
	@XmlElement(name = "additiontionalFulltimeEeOct")
	private String additiontionalFulltimeEeOct;
	@XmlElementWrapper(name = "additiontionalFulltimeEeNov")
	@XmlElement(name = "additiontionalFulltimeEeNov")
	private String additiontionalFulltimeEeNov;
	@XmlElementWrapper(name = "additiontionalFulltimeEeDec")
	@XmlElement(name = "additiontionalFulltimeEeDec")
	private String additiontionalFulltimeEeDec;
	@XmlElementWrapper(name = "additiontionalTotalEeJan")
	@XmlElement(name = "additiontionalTotalEeJan")
	private String additiontionalTotalEeJan;
	@XmlElementWrapper(name = "additiontionalTotalEeFeb")
	@XmlElement(name = "additiontionalTotalEeFeb")
	private String additiontionalTotalEeFeb;
	@XmlElementWrapper(name = "additiontionalTotalEeMar")
	@XmlElement(name = "additiontionalTotalEeMar")
	private String additiontionalTotalEeMar;
	@XmlElementWrapper(name = "additiontionalTotalEeApr")
	@XmlElement(name = "additiontionalTotalEeApr")
	private String additiontionalTotalEeApr;
	@XmlElementWrapper(name = "additiontionalTotalEeMay")
	@XmlElement(name = "additiontionalTotalEeMay")
	private String additiontionalTotalEeMay;
	@XmlElementWrapper(name = "additiontionalTotalEeJun")
	@XmlElement(name = "additiontionalTotalEeJun")
	private String additiontionalTotalEeJun;
	@XmlElementWrapper(name = "additiontionalTotalEeJul")
	@XmlElement(name = "additiontionalTotalEeJul")
	private String additiontionalTotalEeJul;
	@XmlElementWrapper(name = "additiontionalTotalEeAug")
	@XmlElement(name = "additiontionalTotalEeAug")
	private String additiontionalTotalEeAug;
	@XmlElementWrapper(name = "additiontionalTotalEeSep")
	@XmlElement(name = "additiontionalTotalEeSep")
	private String additiontionalTotalEeSep;
	@XmlElementWrapper(name = "additiontionalTotalEeOct")
	@XmlElement(name = "additiontionalTotalEeOct")
	private String additiontionalTotalEeOct;
	@XmlElementWrapper(name = "additiontionalTotalEeNov")
	@XmlElement(name = "additiontionalTotalEeNov")
	private String additiontionalTotalEeNov;
	@XmlElementWrapper(name = "additiontionalTotalEeDec")
	@XmlElement(name = "additiontionalTotalEeDec")
	private String additiontionalTotalEeDec;
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
	
	public String getAleDetailsId() {
		return aleDetailsId;
	}
	public void setAleDetailsId(String aleDetailsId) {
		this.aleDetailsId = aleDetailsId;
	}
	public String getAleId() {
		return aleId;
	}
	public void setAleId(String aleId) {
		this.aleId = aleId;
	}
	public String getAleTaxYear() {
		return aleTaxYear;
	}
	public void setAleTaxYear(String aleTaxYear) {
		this.aleTaxYear = aleTaxYear;
	}
	public String getIsAcaSubscriber() {
		return isAcaSubscriber;
	}
	public void setIsAcaSubscriber(String isAcaSubscriber) {
		this.isAcaSubscriber = isAcaSubscriber;
	}
	public String getIsFilingAuthoritative1094c() {
		return isFilingAuthoritative1094c;
	}
	public void setIsFilingAuthoritative1094c(String isFilingAuthoritative1094c) {
		this.isFilingAuthoritative1094c = isFilingAuthoritative1094c;
	}
	public String getIsAcaReportingShared() {
		return isAcaReportingShared;
	}
	public void setIsAcaReportingShared(String isAcaReportingShared) {
		this.isAcaReportingShared = isAcaReportingShared;
	}
	public String gethTransitionRelief() {
		return hTransitionRelief;
	}
	public void sethTransitionRelief(String hTransitionRelief) {
		this.hTransitionRelief = hTransitionRelief;
	}
	public String getAdditional1095cCount() {
		return additional1095cCount;
	}
	public void setAdditional1095cCount(String additional1095cCount) {
		this.additional1095cCount = additional1095cCount;
	}
	public String getControlGroupId() {
		return controlGroupId;
	}
	public void setControlGroupId(String controlGroupId) {
		this.controlGroupId = controlGroupId;
	}
	public String getAdditiontionalFulltimeEeJan() {
		return additiontionalFulltimeEeJan;
	}
	public void setAdditiontionalFulltimeEeJan(String additiontionalFulltimeEeJan) {
		this.additiontionalFulltimeEeJan = additiontionalFulltimeEeJan;
	}
	public String getAdditiontionalFulltimeEeFeb() {
		return additiontionalFulltimeEeFeb;
	}
	public void setAdditiontionalFulltimeEeFeb(String additiontionalFulltimeEeFeb) {
		this.additiontionalFulltimeEeFeb = additiontionalFulltimeEeFeb;
	}
	public String getAdditiontionalFulltimeEeMar() {
		return additiontionalFulltimeEeMar;
	}
	public void setAdditiontionalFulltimeEeMar(String additiontionalFulltimeEeMar) {
		this.additiontionalFulltimeEeMar = additiontionalFulltimeEeMar;
	}
	public String getAdditiontionalFulltimeEeApr() {
		return additiontionalFulltimeEeApr;
	}
	public void setAdditiontionalFulltimeEeApr(String additiontionalFulltimeEeApr) {
		this.additiontionalFulltimeEeApr = additiontionalFulltimeEeApr;
	}
	public String getAdditiontionalFulltimeEeMay() {
		return additiontionalFulltimeEeMay;
	}
	public void setAdditiontionalFulltimeEeMay(String additiontionalFulltimeEeMay) {
		this.additiontionalFulltimeEeMay = additiontionalFulltimeEeMay;
	}
	public String getAdditiontionalFulltimeEeJun() {
		return additiontionalFulltimeEeJun;
	}
	public void setAdditiontionalFulltimeEeJun(String additiontionalFulltimeEeJun) {
		this.additiontionalFulltimeEeJun = additiontionalFulltimeEeJun;
	}
	public String getAdditiontionalFulltimeEeJul() {
		return additiontionalFulltimeEeJul;
	}
	public void setAdditiontionalFulltimeEeJul(String additiontionalFulltimeEeJul) {
		this.additiontionalFulltimeEeJul = additiontionalFulltimeEeJul;
	}
	public String getAdditiontionalFulltimeEeAug() {
		return additiontionalFulltimeEeAug;
	}
	public void setAdditiontionalFulltimeEeAug(String additiontionalFulltimeEeAug) {
		this.additiontionalFulltimeEeAug = additiontionalFulltimeEeAug;
	}
	public String getAdditiontionalFulltimeEeSep() {
		return additiontionalFulltimeEeSep;
	}
	public void setAdditiontionalFulltimeEeSep(String additiontionalFulltimeEeSep) {
		this.additiontionalFulltimeEeSep = additiontionalFulltimeEeSep;
	}
	public String getAdditiontionalFulltimeEeOct() {
		return additiontionalFulltimeEeOct;
	}
	public void setAdditiontionalFulltimeEeOct(String additiontionalFulltimeEeOct) {
		this.additiontionalFulltimeEeOct = additiontionalFulltimeEeOct;
	}
	public String getAdditiontionalFulltimeEeNov() {
		return additiontionalFulltimeEeNov;
	}
	public void setAdditiontionalFulltimeEeNov(String additiontionalFulltimeEeNov) {
		this.additiontionalFulltimeEeNov = additiontionalFulltimeEeNov;
	}
	public String getAdditiontionalFulltimeEeDec() {
		return additiontionalFulltimeEeDec;
	}
	public void setAdditiontionalFulltimeEeDec(String additiontionalFulltimeEeDec) {
		this.additiontionalFulltimeEeDec = additiontionalFulltimeEeDec;
	}
	public String getAdditiontionalTotalEeJan() {
		return additiontionalTotalEeJan;
	}
	public void setAdditiontionalTotalEeJan(String additiontionalTotalEeJan) {
		this.additiontionalTotalEeJan = additiontionalTotalEeJan;
	}
	public String getAdditiontionalTotalEeFeb() {
		return additiontionalTotalEeFeb;
	}
	public void setAdditiontionalTotalEeFeb(String additiontionalTotalEeFeb) {
		this.additiontionalTotalEeFeb = additiontionalTotalEeFeb;
	}
	public String getAdditiontionalTotalEeMar() {
		return additiontionalTotalEeMar;
	}
	public void setAdditiontionalTotalEeMar(String additiontionalTotalEeMar) {
		this.additiontionalTotalEeMar = additiontionalTotalEeMar;
	}
	public String getAdditiontionalTotalEeApr() {
		return additiontionalTotalEeApr;
	}
	public void setAdditiontionalTotalEeApr(String additiontionalTotalEeApr) {
		this.additiontionalTotalEeApr = additiontionalTotalEeApr;
	}
	public String getAdditiontionalTotalEeMay() {
		return additiontionalTotalEeMay;
	}
	public void setAdditiontionalTotalEeMay(String additiontionalTotalEeMay) {
		this.additiontionalTotalEeMay = additiontionalTotalEeMay;
	}
	public String getAdditiontionalTotalEeJun() {
		return additiontionalTotalEeJun;
	}
	public void setAdditiontionalTotalEeJun(String additiontionalTotalEeJun) {
		this.additiontionalTotalEeJun = additiontionalTotalEeJun;
	}
	public String getAdditiontionalTotalEeJul() {
		return additiontionalTotalEeJul;
	}
	public void setAdditiontionalTotalEeJul(String additiontionalTotalEeJul) {
		this.additiontionalTotalEeJul = additiontionalTotalEeJul;
	}
	public String getAdditiontionalTotalEeAug() {
		return additiontionalTotalEeAug;
	}
	public void setAdditiontionalTotalEeAug(String additiontionalTotalEeAug) {
		this.additiontionalTotalEeAug = additiontionalTotalEeAug;
	}
	public String getAdditiontionalTotalEeSep() {
		return additiontionalTotalEeSep;
	}
	public void setAdditiontionalTotalEeSep(String additiontionalTotalEeSep) {
		this.additiontionalTotalEeSep = additiontionalTotalEeSep;
	}
	public String getAdditiontionalTotalEeOct() {
		return additiontionalTotalEeOct;
	}
	public void setAdditiontionalTotalEeOct(String additiontionalTotalEeOct) {
		this.additiontionalTotalEeOct = additiontionalTotalEeOct;
	}
	public String getAdditiontionalTotalEeNov() {
		return additiontionalTotalEeNov;
	}
	public void setAdditiontionalTotalEeNov(String additiontionalTotalEeNov) {
		this.additiontionalTotalEeNov = additiontionalTotalEeNov;
	}
	public String getAdditiontionalTotalEeDec() {
		return additiontionalTotalEeDec;
	}
	public void setAdditiontionalTotalEeDec(String additiontionalTotalEeDec) {
		this.additiontionalTotalEeDec = additiontionalTotalEeDec;
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
