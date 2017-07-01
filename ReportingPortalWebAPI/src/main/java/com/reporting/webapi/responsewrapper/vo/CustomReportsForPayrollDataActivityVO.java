package com.reporting.webapi.responsewrapper.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.reporting.webapi.response.vo.ReportsForPayrollDataActivityVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomReportsForPayrollDataActivityVO implements Serializable{

	private List<ReportsForPayrollDataActivityVO> reportsForPayrollDataActivity;

	public List<ReportsForPayrollDataActivityVO> getReportsForPayrollDataActivity() {
		return reportsForPayrollDataActivity;
	}

	public void setReportsForPayrollDataActivity(List<ReportsForPayrollDataActivityVO> reportsForPayrollDataActivity) {
		this.reportsForPayrollDataActivity = reportsForPayrollDataActivity;
	}

	
	
}
