package com.reporting.webapi.responsewrapper.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.reporting.webapi.response.vo.BreakInReportDataVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomBreakInReportVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<BreakInReportDataVO> breakInReportData;
	public List<BreakInReportDataVO> getBreakInReportData() {
		return breakInReportData;
	}
	public void setBreakInReportData(List<BreakInReportDataVO> breakInReportData) {
		this.breakInReportData = breakInReportData;
	}


	
	
}
