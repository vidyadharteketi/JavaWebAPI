package com.reporting.webapi.response.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ongoingReportVO")
public class OngoingReportVO {
	
	@XmlElementWrapper(name = "measurementDate")
	@XmlElement(name = "measurementDate")
	private List<String> measurementDate;
	
	@XmlElementWrapper(name = "avgWeeklyHours")
	@XmlElement(name = "avgWeeklyHours")
	private List<String> avgWeeklyHours;
	
	@XmlElementWrapper(name = "ControlGroup")
	@XmlElement(name = "ControlGroup")
	private List<String> controlgroups;
	
	@XmlElementWrapper(name = "typeOfHours")
	@XmlElement(name = "typeOfHours")
	private List<String> typeOfHours;

	public List<String> getMeasurementDate() {
		return measurementDate;
	}

	public void setMeasurementDate(List<String> measurementDate) {
		this.measurementDate = measurementDate;
	}

	public List<String> getAvgWeeklyHours() {
		return avgWeeklyHours;
	}

	public void setAvgWeeklyHours(List<String> avgWeeklyHours) {
		this.avgWeeklyHours = avgWeeklyHours;
	}

	public List<String> getControlgroups() {
		return controlgroups;
	}

	public void setControlgroups(List<String> controlgroups) {
		this.controlgroups = controlgroups;
	}

	public List<String> getTypeOfHours() {
		return typeOfHours;
	}

	public void setTypeOfHours(List<String> typeOfHours) {
		this.typeOfHours = typeOfHours;
	}
	

}
