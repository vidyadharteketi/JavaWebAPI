package com.onboarding.webapi.responsewrapper.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.onboarding.webapi.response.vo.ControlGroupVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomControlGroupListVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ControlGroupVO> controlGroupData;

	public List<ControlGroupVO> getControlGroupVO() {
		return controlGroupData;
	}

	public void setControlGroupVO(List<ControlGroupVO> controlGroupData) {
		this.controlGroupData = controlGroupData;
	}
	
	
	
}
