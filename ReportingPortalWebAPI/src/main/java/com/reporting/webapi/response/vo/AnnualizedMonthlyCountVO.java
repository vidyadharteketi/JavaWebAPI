package com.reporting.webapi.response.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "annualizedMonthlyCount")
public class AnnualizedMonthlyCountVO {

	@XmlElement(name = "ANNUALIZED_MONTHLY_COUNT")
	private String ANNUALIZED_MONTHLY_COUNT;

	public String getANNUALIZED_MONTHLY_COUNT() {
		return ANNUALIZED_MONTHLY_COUNT;
	}

	public void setANNUALIZED_MONTHLY_COUNT(String aNNUALIZED_MONTHLY_COUNT) {
		ANNUALIZED_MONTHLY_COUNT = aNNUALIZED_MONTHLY_COUNT;
	}
	
	
}
