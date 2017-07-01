package com.reporting.webapi.responsewrapper.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.reporting.webapi.response.vo.NewHireNonFullTimeReferenceDataVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomNewHireNonFullTimeVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private NewHireNonFullTimeReferenceDataVO EligibilityNewHiresNonFullTimeReferenceData;
	
	

	public NewHireNonFullTimeReferenceDataVO getEligibilityNewHiresNonFullTimeReferenceData() {
		return EligibilityNewHiresNonFullTimeReferenceData;
	}

	public void setEligibilityNewHiresNonFullTimeReferenceData(
			NewHireNonFullTimeReferenceDataVO eligibilityNewHiresNonFullTimeReferenceData) {
		EligibilityNewHiresNonFullTimeReferenceData = eligibilityNewHiresNonFullTimeReferenceData;
	}

}
