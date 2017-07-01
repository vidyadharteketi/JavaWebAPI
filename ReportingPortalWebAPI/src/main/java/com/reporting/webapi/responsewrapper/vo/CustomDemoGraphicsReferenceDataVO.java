package com.reporting.webapi.responsewrapper.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.reporting.webapi.response.vo.DemoGraphicsReferanceDataVO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class CustomDemoGraphicsReferenceDataVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private DemoGraphicsReferanceDataVO demoGraphicsReferanceData;
	public DemoGraphicsReferanceDataVO getDemoGraphicsReferanceData() {
		return demoGraphicsReferanceData;
	}
	public void setDemoGraphicsReferanceData(DemoGraphicsReferanceDataVO demoGraphicsReferanceData) {
		this.demoGraphicsReferanceData = demoGraphicsReferanceData;
	}
	
	
	
	

}
