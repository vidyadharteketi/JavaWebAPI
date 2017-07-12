package com.onboarding.webapi.responsewrapper.vo;

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomControlGroupMapVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String,String> controlGroupMap;

	public Map<String, String> getControlGroupMap() {
		return controlGroupMap;
	}

	public void setControlGroupMap(Map<String, String> controlGroupMap) {
		this.controlGroupMap = controlGroupMap;
	}

	
	
	
}
