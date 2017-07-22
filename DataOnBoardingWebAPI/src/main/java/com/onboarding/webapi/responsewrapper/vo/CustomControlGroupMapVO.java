package com.onboarding.webapi.responsewrapper.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.onboarding.webapi.response.vo.ControlGroupMapVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomControlGroupMapVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ControlGroupMapVO> controlGroupDropDownList;

	public List<ControlGroupMapVO> getControlGroupDropDownList() {
		return controlGroupDropDownList;
	}

	public void setControlGroupDropDownList(List<ControlGroupMapVO> controlGroupDropDownList) {
		this.controlGroupDropDownList = controlGroupDropDownList;
	}
	
	
	
	/*
	private Map<String,String> controlGroupMap;

	public Map<String, String> getControlGroupMap() {
		return controlGroupMap;
	}

	public void setControlGroupMap(Map<String, String> controlGroupMap) {
		this.controlGroupMap = controlGroupMap;
	}
	*/

	
	
	
}
