package com.reporting.webapi.responsewrapper.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.reporting.webapi.response.vo.EligibilityReferanceDataVO;
import com.reporting.webapi.response.vo.EligibilityReportDataVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomEligibilityReportVO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<EligibilityReportDataVO> eligibilityReportData;

	public List<EligibilityReportDataVO> getEligibilityReportData() {
		return eligibilityReportData;
	}

	public void setEligibilityReportData(List<EligibilityReportDataVO> eligibilityReportData) {
		this.eligibilityReportData = eligibilityReportData;
	}


}
