package com.reporting.webapi.responsewrapper.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.reporting.webapi.response.vo.ReportsByWeeksCountVO;

@XmlRootElement(name = "customReportsByWeekCount")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomReportsByWeekCountVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ReportsByWeeksCountVO> reportByWeekCount;

	public List<ReportsByWeeksCountVO> getReportByWeekCount() {
		return reportByWeekCount;
	}

	public void setReportByWeekCount(List<ReportsByWeeksCountVO> reportByWeekCount) {
		this.reportByWeekCount = reportByWeekCount;
	}

	


}

