package com.reporting.webapi.responsewrapper.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.reporting.webapi.response.vo.ReportsByACAEligibleCountVO;

@XmlRootElement(name = "customReportsByACAEligibleCount")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomReportByACAEligibleCountVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ReportsByACAEligibleCountVO> reportByACAEligibleCount;

	public List<ReportsByACAEligibleCountVO> getReportByACAEligibleCount() {
		return reportByACAEligibleCount;
	}

	public void setReportByACAEligibleCount(List<ReportsByACAEligibleCountVO> reportByACAEligibleCount) {
		this.reportByACAEligibleCount = reportByACAEligibleCount;
	}
	
	
	
}
