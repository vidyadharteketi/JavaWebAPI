package com.onboarding.webapi.responsewrapper.vo;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomALEMapVO {

	private Map<String,String> aleMap;

	public Map<String, String> getAleMap() {
		return aleMap;
	}

	public void setAleMap(Map<String, String> aleMap) {
		this.aleMap = aleMap;
	}
	
	
}
