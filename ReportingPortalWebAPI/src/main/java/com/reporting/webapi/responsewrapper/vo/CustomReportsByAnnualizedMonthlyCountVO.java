package com.reporting.webapi.responsewrapper.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.reporting.webapi.response.vo.ReportsByAnnualizedMonthlyCountVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomReportsByAnnualizedMonthlyCountVO implements Serializable{

	private List<ReportsByAnnualizedMonthlyCountVO> reportsByAnnualizedMonthlyCountVO;

	public List<ReportsByAnnualizedMonthlyCountVO> getReportsByAnnualizedMonthlyCountVO() {
		return reportsByAnnualizedMonthlyCountVO;
	}

	public void setReportsByAnnualizedMonthlyCountVO(
			List<ReportsByAnnualizedMonthlyCountVO> reportsByAnnualizedMonthlyCountVO) {
		this.reportsByAnnualizedMonthlyCountVO = reportsByAnnualizedMonthlyCountVO;
	}

	
	
	
}
