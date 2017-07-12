package com.onboarding.webapi.responsewrapper.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.onboarding.webapi.response.vo.ALEDetailsVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomALEDetailsVO implements Serializable{
	
	private ALEDetailsVO aceDetails;

	public ALEDetailsVO getAceDetails() {
		return aceDetails;
	}

	public void setAceDetails(ALEDetailsVO aceDetails) {
		this.aceDetails = aceDetails;
	}
	
	

}
