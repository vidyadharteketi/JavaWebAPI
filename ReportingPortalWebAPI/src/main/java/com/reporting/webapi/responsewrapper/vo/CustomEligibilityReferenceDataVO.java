package com.reporting.webapi.responsewrapper.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.reporting.webapi.response.vo.EligibilityReferanceDataVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomEligibilityReferenceDataVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EligibilityReferanceDataVO eligibilityReferanceData;

	public EligibilityReferanceDataVO getEligibilityReferanceData() {
		return eligibilityReferanceData;
	}

	public void setEligibilityReferanceData(EligibilityReferanceDataVO eligibilityReferanceData) {
		this.eligibilityReferanceData = eligibilityReferanceData;
	}

	
	
	

}
