package com.onboarding.webapi.responsewrapper.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.onboarding.webapi.response.vo.ALEVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomALEListVO implements Serializable{
	
	private List<ALEVO> aleData;

	public List<ALEVO> getAleData() {
		return aleData;
	}

	public void setAleData(List<ALEVO> aleData) {
		this.aleData = aleData;
	}


}
