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

@Entity
@Table(name = "tbl_data_ale_details")
public class ALEDetailsDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ALE_DETAILS_ID", nullable = false)
	private Integer aleDetailsId;
	@Column(name = "ALE_ID", nullable = false)
	private Integer aleId;
	@Column(name = "ALE_TAX_YEAR", nullable = false)
	private Integer aleTaxYear;
	@Column(name = "IS_ACA_SUBSCRIBER")
	private String isAcaSubscriber;
	@Column(name = "IS_FILING_AUTHORITATIVE_1094C")
	private String isFilingAuthoritative1094c;
	@Column(name = "IS_ACA_REPORTING_SHARED")
	private String isAcaReportingShared;
	@Column(name = "4980H_TRANSITION_RELIEF")
	private String hTransitionRelief;
	@Column(name = "ADDITIONAL_1095C_COUNT")
	private Integer additional1095cCount;
	@Column(name = "CONTROL_GROUP_ID")
	private Integer controlGroupId;
	@Column(name = "ADDITIONTIONAL_FULLTIME_EE_JAN")
	private Integer additiontionalFulltimeEeJan;
	@Column(name = "ADDITIONTIONAL_FULLTIME_EE_FEB")
	private Integer additiontionalFulltimeEeFeb;
	@Column(name = "ADDITIONTIONAL_FULLTIME_EE_MAR")
	private Integer additiontionalFulltimeEeMar;
	@Column(name = "ADDITIONTIONAL_FULLTIME_EE_APR")
	private Integer additiontionalFulltimeEeApr;
	@Column(name = "ADDITIONTIONAL_FULLTIME_EE_MAY")
	private Integer additiontionalFulltimeEeMay;
	@Column(name = "ADDITIONTIONAL_FULLTIME_EE_JUN")
	private Integer additiontionalFulltimeEeJun;
	@Column(name = "ADDITIONTIONAL_FULLTIME_EE_JUL")
	private Integer additiontionalFulltimeEeJul;
	@Column(name = "ADDITIONTIONAL_FULLTIME_EE_AUG")
	private Integer additiontionalFulltimeEeAug;
	@Column(name = "ADDITIONTIONAL_FULLTIME_EE_SEP")
	private Integer additiontionalFulltimeEeSep;
	@Column(name = "ADDITIONTIONAL_FULLTIME_EE_OCT")
	private Integer additiontionalFulltimeEeOct;
	@Column(name = "ADDITIONTIONAL_FULLTIME_EE_NOV")
	private Integer additiontionalFulltimeEeNov;
	@Column(name = "ADDITIONTIONAL_FULLTIME_EE_DEC")
	private Integer additiontionalFulltimeEeDec;
	@Column(name = "ADDITIONTIONAL_TOTAL_EE_JAN")
	private Integer additiontionalTotalEeJan;
	@Column(name = "ADDITIONTIONAL_TOTAL_EE_FEB")
	private Integer additiontionalTotalEeFeb;
	@Column(name = "ADDITIONTIONAL_TOTAL_EE_MAR")
	private Integer additiontionalTotalEeMar;
	@Column(name = "ADDITIONTIONAL_TOTAL_EE_APR")
	private Integer additiontionalTotalEeApr;
	@Column(name = "ADDITIONTIONAL_TOTAL_EE_MAY")
	private Integer additiontionalTotalEeMay;
	@Column(name = "ADDITIONTIONAL_TOTAL_EE_JUN")
	private Integer additiontionalTotalEeJun;
	@Column(name = "ADDITIONTIONAL_TOTAL_EE_JUL")
	private Integer additiontionalTotalEeJul;
	@Column(name = "ADDITIONTIONAL_TOTAL_EE_AUG")
	private Integer additiontionalTotalEeAug;
	@Column(name = "ADDITIONTIONAL_TOTAL_EE_SEP")
	private Integer additiontionalTotalEeSep;
	@Column(name = "ADDITIONTIONAL_TOTAL_EE_OCT")
	private Integer additiontionalTotalEeOct;
	@Column(name = "ADDITIONTIONAL_TOTAL_EE_NOV")
	private Integer additiontionalTotalEeNov;
	@Column(name = "ADDITIONTIONAL_TOTAL_EE_DEC")
	private Integer additiontionalTotalEeDec;	
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
	
	public Integer getAleDetailsId() {
		return aleDetailsId;
	}
	public void setAleDetailsId(Integer aleDetailsId) {
		this.aleDetailsId = aleDetailsId;
	}
	public Integer getAleId() {
		return aleId;
	}
	public void setAleId(Integer aleId) {
		this.aleId = aleId;
	}
	public Integer getAleTaxYear() {
		return aleTaxYear;
	}
	public void setAleTaxYear(Integer aleTaxYear) {
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
	public Integer getAdditional1095cCount() {
		return additional1095cCount;
	}
	public void setAdditional1095cCount(Integer additional1095cCount) {
		this.additional1095cCount = additional1095cCount;
	}
	public Integer getControlGroupId() {
		return controlGroupId;
	}
	public void setControlGroupId(Integer controlGroupId) {
		this.controlGroupId = controlGroupId;
	}
	public Integer getAdditiontionalFulltimeEeJan() {
		return additiontionalFulltimeEeJan;
	}
	public void setAdditiontionalFulltimeEeJan(Integer additiontionalFulltimeEeJan) {
		this.additiontionalFulltimeEeJan = additiontionalFulltimeEeJan;
	}
	public Integer getAdditiontionalFulltimeEeFeb() {
		return additiontionalFulltimeEeFeb;
	}
	public void setAdditiontionalFulltimeEeFeb(Integer additiontionalFulltimeEeFeb) {
		this.additiontionalFulltimeEeFeb = additiontionalFulltimeEeFeb;
	}
	public Integer getAdditiontionalFulltimeEeMar() {
		return additiontionalFulltimeEeMar;
	}
	public void setAdditiontionalFulltimeEeMar(Integer additiontionalFulltimeEeMar) {
		this.additiontionalFulltimeEeMar = additiontionalFulltimeEeMar;
	}
	public Integer getAdditiontionalFulltimeEeApr() {
		return additiontionalFulltimeEeApr;
	}
	public void setAdditiontionalFulltimeEeApr(Integer additiontionalFulltimeEeApr) {
		this.additiontionalFulltimeEeApr = additiontionalFulltimeEeApr;
	}
	public Integer getAdditiontionalFulltimeEeMay() {
		return additiontionalFulltimeEeMay;
	}
	public void setAdditiontionalFulltimeEeMay(Integer additiontionalFulltimeEeMay) {
		this.additiontionalFulltimeEeMay = additiontionalFulltimeEeMay;
	}
	public Integer getAdditiontionalFulltimeEeJun() {
		return additiontionalFulltimeEeJun;
	}
	public void setAdditiontionalFulltimeEeJun(Integer additiontionalFulltimeEeJun) {
		this.additiontionalFulltimeEeJun = additiontionalFulltimeEeJun;
	}
	public Integer getAdditiontionalFulltimeEeJul() {
		return additiontionalFulltimeEeJul;
	}
	public void setAdditiontionalFulltimeEeJul(Integer additiontionalFulltimeEeJul) {
		this.additiontionalFulltimeEeJul = additiontionalFulltimeEeJul;
	}
	public Integer getAdditiontionalFulltimeEeAug() {
		return additiontionalFulltimeEeAug;
	}
	public void setAdditiontionalFulltimeEeAug(Integer additiontionalFulltimeEeAug) {
		this.additiontionalFulltimeEeAug = additiontionalFulltimeEeAug;
	}
	public Integer getAdditiontionalFulltimeEeSep() {
		return additiontionalFulltimeEeSep;
	}
	public void setAdditiontionalFulltimeEeSep(Integer additiontionalFulltimeEeSep) {
		this.additiontionalFulltimeEeSep = additiontionalFulltimeEeSep;
	}
	public Integer getAdditiontionalFulltimeEeOct() {
		return additiontionalFulltimeEeOct;
	}
	public void setAdditiontionalFulltimeEeOct(Integer additiontionalFulltimeEeOct) {
		this.additiontionalFulltimeEeOct = additiontionalFulltimeEeOct;
	}
	public Integer getAdditiontionalFulltimeEeNov() {
		return additiontionalFulltimeEeNov;
	}
	public void setAdditiontionalFulltimeEeNov(Integer additiontionalFulltimeEeNov) {
		this.additiontionalFulltimeEeNov = additiontionalFulltimeEeNov;
	}
	public Integer getAdditiontionalFulltimeEeDec() {
		return additiontionalFulltimeEeDec;
	}
	public void setAdditiontionalFulltimeEeDec(Integer additiontionalFulltimeEeDec) {
		this.additiontionalFulltimeEeDec = additiontionalFulltimeEeDec;
	}
	public Integer getAdditiontionalTotalEeJan() {
		return additiontionalTotalEeJan;
	}
	public void setAdditiontionalTotalEeJan(Integer additiontionalTotalEeJan) {
		this.additiontionalTotalEeJan = additiontionalTotalEeJan;
	}
	public Integer getAdditiontionalTotalEeFeb() {
		return additiontionalTotalEeFeb;
	}
	public void setAdditiontionalTotalEeFeb(Integer additiontionalTotalEeFeb) {
		this.additiontionalTotalEeFeb = additiontionalTotalEeFeb;
	}
	public Integer getAdditiontionalTotalEeMar() {
		return additiontionalTotalEeMar;
	}
	public void setAdditiontionalTotalEeMar(Integer additiontionalTotalEeMar) {
		this.additiontionalTotalEeMar = additiontionalTotalEeMar;
	}
	public Integer getAdditiontionalTotalEeApr() {
		return additiontionalTotalEeApr;
	}
	public void setAdditiontionalTotalEeApr(Integer additiontionalTotalEeApr) {
		this.additiontionalTotalEeApr = additiontionalTotalEeApr;
	}
	public Integer getAdditiontionalTotalEeMay() {
		return additiontionalTotalEeMay;
	}
	public void setAdditiontionalTotalEeMay(Integer additiontionalTotalEeMay) {
		this.additiontionalTotalEeMay = additiontionalTotalEeMay;
	}
	public Integer getAdditiontionalTotalEeJun() {
		return additiontionalTotalEeJun;
	}
	public void setAdditiontionalTotalEeJun(Integer additiontionalTotalEeJun) {
		this.additiontionalTotalEeJun = additiontionalTotalEeJun;
	}
	public Integer getAdditiontionalTotalEeJul() {
		return additiontionalTotalEeJul;
	}
	public void setAdditiontionalTotalEeJul(Integer additiontionalTotalEeJul) {
		this.additiontionalTotalEeJul = additiontionalTotalEeJul;
	}
	public Integer getAdditiontionalTotalEeAug() {
		return additiontionalTotalEeAug;
	}
	public void setAdditiontionalTotalEeAug(Integer additiontionalTotalEeAug) {
		this.additiontionalTotalEeAug = additiontionalTotalEeAug;
	}
	public Integer getAdditiontionalTotalEeSep() {
		return additiontionalTotalEeSep;
	}
	public void setAdditiontionalTotalEeSep(Integer additiontionalTotalEeSep) {
		this.additiontionalTotalEeSep = additiontionalTotalEeSep;
	}
	public Integer getAdditiontionalTotalEeOct() {
		return additiontionalTotalEeOct;
	}
	public void setAdditiontionalTotalEeOct(Integer additiontionalTotalEeOct) {
		this.additiontionalTotalEeOct = additiontionalTotalEeOct;
	}
	public Integer getAdditiontionalTotalEeNov() {
		return additiontionalTotalEeNov;
	}
	public void setAdditiontionalTotalEeNov(Integer additiontionalTotalEeNov) {
		this.additiontionalTotalEeNov = additiontionalTotalEeNov;
	}
	public Integer getAdditiontionalTotalEeDec() {
		return additiontionalTotalEeDec;
	}
	public void setAdditiontionalTotalEeDec(Integer additiontionalTotalEeDec) {
		this.additiontionalTotalEeDec = additiontionalTotalEeDec;
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
