package com.reporting.webapi.response.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "reportsByAnnualizedMonthlyCount")
public class ReportsByAnnualizedMonthlyCountVO implements Serializable{

	@XmlElement(name = "controlGroup")
	private String CONTROL_GROUP;
	@XmlElement(name = "workYear")
	private String WORK_YEAR;
	@XmlElement(name = "workMonth")
	private String WORK_MONTH;
	@XmlElement(name = "workerPoolFteStatus")
	private String WORKED_POOL_FTE_STATUS;
	@XmlElement(name = "firstName")
	private String FIRST_NAME;
	@XmlElement(name = "lastName")
	private String LAST_NAME;
	@XmlElement(name = "workedHours")
	private String HOURS_WORKED;
	@XmlElement(name = "workerPoolFteCount")
	private String WORKED_POOL_FTE_COUNT;
	public String getCONTROL_GROUP() {
		return CONTROL_GROUP;
	}
	public void setCONTROL_GROUP(String cONTROL_GROUP) {
		CONTROL_GROUP = cONTROL_GROUP;
	}
	public String getWORK_YEAR() {
		return WORK_YEAR;
	}
	public void setWORK_YEAR(String wORK_YEAR) {
		WORK_YEAR = wORK_YEAR;
	}
	public String getWORK_MONTH() {
		return WORK_MONTH;
	}
	public void setWORK_MONTH(String wORK_MONTH) {
		WORK_MONTH = wORK_MONTH;
	}
	public String getWORKED_POOL_FTE_STATUS() {
		return WORKED_POOL_FTE_STATUS;
	}
	public void setWORKED_POOL_FTE_STATUS(String wORKED_POOL_FTE_STATUS) {
		WORKED_POOL_FTE_STATUS = wORKED_POOL_FTE_STATUS;
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
	public String getHOURS_WORKED() {
		return HOURS_WORKED;
	}
	public void setHOURS_WORKED(String hOURS_WORKED) {
		HOURS_WORKED = hOURS_WORKED;
	}
	public String getWORKED_POOL_FTE_COUNT() {
		return WORKED_POOL_FTE_COUNT;
	}
	public void setWORKED_POOL_FTE_COUNT(String wORKED_POOL_FTE_COUNT) {
		WORKED_POOL_FTE_COUNT = wORKED_POOL_FTE_COUNT;
	}
	
	
}
