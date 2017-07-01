package com.reporting.webapi.responsewrapper.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.reporting.webapi.response.vo.DemoGraphicsReferanceDataVO;
import com.reporting.webapi.response.vo.DemoGraphicsReportDataVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomDemoGraphicsReportVO implements Serializable {
	
	private List<DemoGraphicsReportDataVO> demoGraphicsReportData;

	public List<DemoGraphicsReportDataVO> getDemoGraphicsReportData() {
		return demoGraphicsReportData;
	}

	public void setDemoGraphicsReportData(List<DemoGraphicsReportDataVO> demoGraphicsReportData) {
		this.demoGraphicsReportData = demoGraphicsReportData;
	}


	
}
