package com.reporting.webapi.responsewrapper.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.reporting.webapi.response.vo.OngoingReportVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomOngoingReportVO implements Serializable  {
	
private static final long serialVersionUID = 1L;
	
	private OngoingReportVO ongoingReportVO;

	public OngoingReportVO getEligibilityReportOngoingVO() {
		return ongoingReportVO;
	}

	public void setEligibilityReportOngoingVO(OngoingReportVO ongoingReportVO) {
		this.ongoingReportVO = ongoingReportVO;
	}
	
	

}
