package com.reporting.webapi.responsewrapper.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.reporting.webapi.response.vo.AnnualizedMonthlyCountVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomAnnualizedMonthlyCountVO implements Serializable {

	private List<AnnualizedMonthlyCountVO> annualizedMonthlyCountVO;

	public List<AnnualizedMonthlyCountVO> getAnnualizedMonthlyCountVO() {
		return annualizedMonthlyCountVO;
	}

	public void setAnnualizedMonthlyCountVO(List<AnnualizedMonthlyCountVO> annualizedMonthlyCountVO) {
		this.annualizedMonthlyCountVO = annualizedMonthlyCountVO;
	}

	
	
}
