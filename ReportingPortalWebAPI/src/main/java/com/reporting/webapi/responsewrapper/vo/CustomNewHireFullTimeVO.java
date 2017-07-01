package com.reporting.webapi.responsewrapper.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.reporting.webapi.response.vo.NewHireFullTimeReferenceDataVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomNewHireFullTimeVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private NewHireFullTimeReferenceDataVO EligibilityNewHiresFullTimeReferenceData;


	public NewHireFullTimeReferenceDataVO getEligibilityNewHiresFullTimeReferenceData() {
		return EligibilityNewHiresFullTimeReferenceData;
	}


	public void setEligibilityNewHiresFullTimeReferenceData(
			NewHireFullTimeReferenceDataVO eligibilityNewHiresFullTimeReferenceData) {
		EligibilityNewHiresFullTimeReferenceData = eligibilityNewHiresFullTimeReferenceData;
	}
	
	
	

}
