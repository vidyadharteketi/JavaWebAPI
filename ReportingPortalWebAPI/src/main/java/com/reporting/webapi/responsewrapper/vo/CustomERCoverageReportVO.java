package com.reporting.webapi.responsewrapper.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.reporting.webapi.response.vo.ERCoverageReferanceDataVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomERCoverageReportVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ERCoverageReferanceDataVO erCoverageReferanceDataVO;

	public ERCoverageReferanceDataVO getErCoverageReferanceDataVO() {
		return erCoverageReferanceDataVO;
	}

	public void setErCoverageReferanceDataVO(ERCoverageReferanceDataVO erCoverageReferanceDataVO) {
		this.erCoverageReferanceDataVO = erCoverageReferanceDataVO;
	}
	
	
}
