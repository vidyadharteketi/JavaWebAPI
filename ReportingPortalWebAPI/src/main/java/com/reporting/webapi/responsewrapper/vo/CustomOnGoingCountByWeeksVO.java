package com.reporting.webapi.responsewrapper.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.reporting.webapi.response.vo.OnGoingCountByWeeksVO;

@XmlRootElement(name = "customOnGoingCountByWeeks")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomOnGoingCountByWeeksVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<OnGoingCountByWeeksVO> onGoingCountByWeeks;


	public List<OnGoingCountByWeeksVO> getOnGoingCountByWeeks() {
		return onGoingCountByWeeks;
	}


	public void setOnGoingCountByWeeks(List<OnGoingCountByWeeksVO> onGoingCountByWeeks) {
		this.onGoingCountByWeeks = onGoingCountByWeeks;
	}
	
	
}
