package com.onboarding.webapi.responsewrapper.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.onboarding.webapi.response.vo.ControlGroupVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomControlGroupOutputVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer result;

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}
	
	
}
