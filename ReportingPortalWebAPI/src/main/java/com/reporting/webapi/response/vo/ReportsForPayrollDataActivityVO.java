package com.reporting.webapi.response.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "reportsForPayrollDataActivity")
public class ReportsForPayrollDataActivityVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "ssnNumber")
	private String SSN_NUMBER;
	@XmlElement(name = "firstName")
	private String FIRST_NAME;
	@XmlElement(name = "lastName")
	private String LAST_NAME;
	@XmlElement(name = "ein")
	private String EIN;
	@XmlElement(name = "productionCompany")
	private String PRODUCTION_COMPANY;
	@XmlElement(name = "hireDate")
	private String HIRE_DATE;
	@XmlElement(name = "lastDateWorked")
	private String LAST_DATE_WORKED;
	@XmlElement(name = "project")
	private String PROJECT;
	@XmlElement(name = "clientId")
	private String CLIENT_ID;
	@XmlElement(name = "source")
	private String SOURCE;
	@XmlElement(name = "employmentStatus")
	private String EMPLOYMENT_STATUS;
	@XmlElement(name = "unionHours")
	private String UNION_HOURS;
	@XmlElement(name = "jan")
	private String JANUARY;
	@XmlElement(name = "feb")
	private String FEBRUARY;
	@XmlElement(name = "mar")
	private String MARCH;
	@XmlElement(name = "apr")
	private String APRIL;
	@XmlElement(name = "may")
	private String MAY;
	@XmlElement(name = "jun")
	private String JUNE;
	@XmlElement(name = "jul")
	private String JULY;
	@XmlElement(name = "aug")
	private String AUGUST;
	@XmlElement(name = "sep")
	private String SEPTEMBER;
	@XmlElement(name = "oct")
	private String OCTOBER;
	@XmlElement(name = "nov")
	private String NOVEMBER;
	@XmlElement(name = "dec")
	private String DECEMBER;
	@XmlElement(name = "ControlGroup")
	private String controlGroup;
	
	public String getSSN_NUMBER() {
		return SSN_NUMBER;
	}
	public void setSSN_NUMBER(String sSN_NUMBER) {
		SSN_NUMBER = sSN_NUMBER;
	}
	public String getFIRST_NAME() {
		return FIRST_NAME;
	}
	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}
	public String getLAST_NAME() {
		return LAST_NAME;
	}
	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}
	public String getEIN() {
		return EIN;
	}
	public void setEIN(String eIN) {
		EIN = eIN;
	}
	public String getPRODUCTION_COMPANY() {
		return PRODUCTION_COMPANY;
	}
	public void setPRODUCTION_COMPANY(String pRODUCTION_COMPANY) {
		PRODUCTION_COMPANY = pRODUCTION_COMPANY;
	}
	public String getHIRE_DATE() {
		return HIRE_DATE;
	}
	public void setHIRE_DATE(String hIRE_DATE) {
		HIRE_DATE = hIRE_DATE;
	}
	public String getLAST_DATE_WORKED() {
		return LAST_DATE_WORKED;
	}
	public void setLAST_DATE_WORKED(String lAST_DATE_WORKED) {
		LAST_DATE_WORKED = lAST_DATE_WORKED;
	}
	public String getPROJECT() {
		return PROJECT;
	}
	public void setPROJECT(String pROJECT) {
		PROJECT = pROJECT;
	}
	public String getCLIENT_ID() {
		return CLIENT_ID;
	}
	public void setCLIENT_ID(String cLIENT_ID) {
		CLIENT_ID = cLIENT_ID;
	}
	public String getSOURCE() {
		return SOURCE;
	}
	public void setSOURCE(String sOURCE) {
		SOURCE = sOURCE;
	}
	public String getEMPLOYMENT_STATUS() {
		return EMPLOYMENT_STATUS;
	}
	public void setEMPLOYMENT_STATUS(String eMPLOYMENT_STATUS) {
		EMPLOYMENT_STATUS = eMPLOYMENT_STATUS;
	}
	public String getUNION_HOURS() {
		return UNION_HOURS;
	}
	public void setUNION_HOURS(String uNION_HOURS) {
		UNION_HOURS = uNION_HOURS;
	}
	public String getJANUARY() {
		return JANUARY;
	}
	public void setJANUARY(String jANUARY) {
		JANUARY = jANUARY;
	}
	public String getFEBRUARY() {
		return FEBRUARY;
	}
	public void setFEBRUARY(String fEBRUARY) {
		FEBRUARY = fEBRUARY;
	}
	public String getMARCH() {
		return MARCH;
	}
	public void setMARCH(String mARCH) {
		MARCH = mARCH;
	}
	public String getAPRIL() {
		return APRIL;
	}
	public void setAPRIL(String aPRIL) {
		APRIL = aPRIL;
	}
	public String getMAY() {
		return MAY;
	}
	public void setMAY(String mAY) {
		MAY = mAY;
	}
	public String getJUNE() {
		return JUNE;
	}
	public void setJUNE(String jUNE) {
		JUNE = jUNE;
	}
	public String getJULY() {
		return JULY;
	}
	public void setJULY(String jULY) {
		JULY = jULY;
	}
	public String getAUGUST() {
		return AUGUST;
	}
	public void setAUGUST(String aUGUST) {
		AUGUST = aUGUST;
	}
	public String getSEPTEMBER() {
		return SEPTEMBER;
	}
	public void setSEPTEMBER(String sEPTEMBER) {
		SEPTEMBER = sEPTEMBER;
	}
	public String getOCTOBER() {
		return OCTOBER;
	}
	public void setOCTOBER(String oCTOBER) {
		OCTOBER = oCTOBER;
	}
	public String getNOVEMBER() {
		return NOVEMBER;
	}
	public void setNOVEMBER(String nOVEMBER) {
		NOVEMBER = nOVEMBER;
	}
	public String getDECEMBER() {
		return DECEMBER;
	}
	public void setDECEMBER(String dECEMBER) {
		DECEMBER = dECEMBER;
	}
	public String getControlGroup() {
		return controlGroup;
	}
	public void setControlGroup(String controlGroup) {
		this.controlGroup = controlGroup;
	}
	
		
	
}
