package com.onboarding.webapi.response.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "aleDropDownListData")
public class AleMapVO {

	@XmlElementWrapper(name = "aleId")
	@XmlElement(name = "aleId")
	private String aleId;
	
	@XmlElementWrapper(name = "aleName")
	@XmlElement(name = "aleName")
	private String aleName;

	public String getAleId() {
		return aleId;
	}

	public void setAleId(String aleId) {
		this.aleId = aleId;
	}

	public String getAleName() {
		return aleName;
	}

	public void setAleName(String aleName) {
		this.aleName = aleName;
	}
	
	
}
