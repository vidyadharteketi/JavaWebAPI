package com.reporting.webapi.response.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "summaryCountForNewHireFullTimeVO")
public class SummaryCountForNewHireFullTimeVO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "acaEligible")
	private String ACA_ELIGIBLE_FTE;
	
	@XmlElement(name = "acaEligibleCount")
	private String SUMMARY_COUNT;
	
	
	public String getSUMMARY_COUNT() {
		return SUMMARY_COUNT;
	}
	public void setSUMMARY_COUNT(String sUMMARY_COUNT) {
		SUMMARY_COUNT = sUMMARY_COUNT;
	}
	public String getACA_ELIGIBLE_FTE() {
		return ACA_ELIGIBLE_FTE;
	}
	public void setACA_ELIGIBLE_FTE(String aCA_ELIGIBLE_FTE) {
		ACA_ELIGIBLE_FTE = aCA_ELIGIBLE_FTE;
	}
	
	
	

}
