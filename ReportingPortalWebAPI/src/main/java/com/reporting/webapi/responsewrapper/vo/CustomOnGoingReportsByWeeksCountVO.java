package com.reporting.webapi.responsewrapper.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.reporting.webapi.response.vo.OnGoingReportsByWeekCountVO;

@XmlRootElement(name = "customOnGoingReportsByWeeksCount")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomOnGoingReportsByWeeksCountVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<OnGoingReportsByWeekCountVO> onGoingReportsByWeekCount;

	public List<OnGoingReportsByWeekCountVO> getOnGoingReportsByWeekCount() {
		return onGoingReportsByWeekCount;
	}

	public void setOnGoingReportsByWeekCount(List<OnGoingReportsByWeekCountVO> onGoingReportsByWeekCount) {
		this.onGoingReportsByWeekCount = onGoingReportsByWeekCount;
	}
	
	
}
