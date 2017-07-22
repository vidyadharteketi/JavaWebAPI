package com.onboarding.webapi.responsewrapper.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.onboarding.webapi.response.vo.AleMapVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomALEMapVO {

	private List<AleMapVO> aleDropDownList;

	public List<AleMapVO> getAleDropDownList() {
		return aleDropDownList;
	}

	public void setAleDropDownList(List<AleMapVO> aleDropDownList) {
		this.aleDropDownList = aleDropDownList;
	}
	
	
	/*
	private Map<String,String> aleMap;

	public Map<String, String> getAleMap() {
		return aleMap;
	}

	public void setAleMap(Map<String, String> aleMap) {
		this.aleMap = aleMap;
	}
	*/
	
}
