package com.onboarding.webapi.responsewrapper.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.onboarding.webapi.response.vo.ALEVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomALEVO implements Serializable{
	
	private ALEVO ale;

	public ALEVO getAle() {
		return ale;
	}

	public void setAle(ALEVO ale) {
		this.ale = ale;
	}
	
	

}
