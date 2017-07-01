package com.reporting.webapi.response.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "onGoingCountByWeeks")
public class OnGoingCountByWeeksVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "WEEKS_WORKED")
	private String WEEKS_WORKED;
	
	@XmlElement(name = "WEEKS_WORKED_COUNT")
	private String WEEKS_WORKED_COUNT;

	public String getWEEKS_WORKED() {
		return WEEKS_WORKED;
	}
	public void setWEEKS_WORKED(String wEEKS_WORKED) {
		WEEKS_WORKED = wEEKS_WORKED;
	}
	public String getWEEKS_WORKED_COUNT() {
		return WEEKS_WORKED_COUNT;
	}
	public void setWEEKS_WORKED_COUNT(String wEEKS_WORKED_COUNT) {
		WEEKS_WORKED_COUNT = wEEKS_WORKED_COUNT;
	}
}
