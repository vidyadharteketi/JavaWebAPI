package com.reporting.webapi.responsewrapper.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.reporting.webapi.response.vo.BreakInServiceReferanceDataVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomBreakInReferenceDataVO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private BreakInServiceReferanceDataVO breakInReferanceData;
	public BreakInServiceReferanceDataVO getBreakInReferanceData() {
		return breakInReferanceData;
	}
	public void setBreakInReferanceData(BreakInServiceReferanceDataVO breakInReferanceData) {
		this.breakInReferanceData = breakInReferanceData;
	}
}
