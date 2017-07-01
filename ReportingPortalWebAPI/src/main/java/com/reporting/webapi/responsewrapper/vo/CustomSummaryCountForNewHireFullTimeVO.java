package com.reporting.webapi.responsewrapper.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.reporting.webapi.response.vo.SummaryCountForNewHireFullTimeVO;

@XmlRootElement(name = "customSummaryCountForNewHireFullTimeVO")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomSummaryCountForNewHireFullTimeVO implements Serializable{
	
	
	private List<SummaryCountForNewHireFullTimeVO> summaryCountForNewHireFullTimeVO;

	public List<SummaryCountForNewHireFullTimeVO> getSummaryCountForNewHireFullTimeVO() {
		return summaryCountForNewHireFullTimeVO;
	}

	public void setSummaryCountForNewHireFullTimeVO(List<SummaryCountForNewHireFullTimeVO> summaryCountForNewHireFullTimeVO) {
		this.summaryCountForNewHireFullTimeVO = summaryCountForNewHireFullTimeVO;
	}
	
	

}
