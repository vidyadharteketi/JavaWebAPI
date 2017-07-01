package com.reporting.webapi.responsewrapper.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.reporting.webapi.response.vo.PayrollRefDataVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomPayrollRefDataVO implements Serializable {

	private PayrollRefDataVO payrollRefDataVO;

	public PayrollRefDataVO getPayrollRefDataVO() {
		return payrollRefDataVO;
	}

	public void setPayrollRefDataVO(PayrollRefDataVO payrollRefDataVO) {
		this.payrollRefDataVO = payrollRefDataVO;
	}
	
	
}
