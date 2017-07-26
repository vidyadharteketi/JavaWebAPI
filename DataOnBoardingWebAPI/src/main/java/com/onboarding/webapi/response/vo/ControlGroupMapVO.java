package com.onboarding.webapi.response.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "controlGroupDropDownListData")
public class ControlGroupMapVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElementWrapper(name = "controlGroupId")
	@XmlElement(name = "controlGroupId")
	private String controlGroupId;
	
	@XmlElementWrapper(name = "controlGroupName")
	@XmlElement(name = "controlGroupName")
	private String controlGroupName;

	public String getControlGroupId() {
		return controlGroupId;
	}

	public void setControlGroupId(String controlGroupId) {
		this.controlGroupId = controlGroupId;
	}

	public String getControlGroupName() {
		return controlGroupName;
	}

	public void setControlGroupName(String controlGroupName) {
		this.controlGroupName = controlGroupName;
	}
	
	
}
