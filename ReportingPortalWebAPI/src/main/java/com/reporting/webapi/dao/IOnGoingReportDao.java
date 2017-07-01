package com.reporting.webapi.dao;

import java.util.List;

import com.reporting.webapi.bean.OngoingReferanceDataBean;
import com.reporting.webapi.response.vo.OnGoingCountByWeeksVO;
import com.reporting.webapi.response.vo.OnGoingReportsByWeekCountVO;

public interface IOnGoingReportDao {

	public OngoingReferanceDataBean getOnGoingReportReferenceData() throws Exception;

	public List<OnGoingCountByWeeksVO> getOnGoingReportCountByWeek(String measurementEndDate, String avgWeeklyHours,
			String controlGroup, String typeOfHours) throws Exception;

	public List<OnGoingReportsByWeekCountVO> getOnGoingReportData(String measurementEndDate, String avgWeeklyHours,
			String controlGroup, String typeOfHours, String reportOfWeek) throws Exception;

}
