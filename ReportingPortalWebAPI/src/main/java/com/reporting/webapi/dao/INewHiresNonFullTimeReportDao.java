package com.reporting.webapi.dao;

import java.util.List;

import com.reporting.webapi.bean.NewHireNonFullTimeReferanceDataBean;
import com.reporting.webapi.response.vo.ReportCountByWeekVO;
import com.reporting.webapi.response.vo.ReportsByWeeksCountVO;

public interface INewHiresNonFullTimeReportDao {

	public NewHireNonFullTimeReferanceDataBean getNewHiresNonFullTimeReportReferenceData() throws Exception;

	public List<ReportCountByWeekVO> getNewHiresNonFullTimeCountByWeek(String workYear, String workMonth, String controlGroup,
			String unionType, String employeeType) throws Exception;

	public List<ReportsByWeeksCountVO> getNewHiresNonFullTimeReportData(String workYear, String workMonth, String controlGroup,
			String unionType, String employeeType, String reportOfWeek)throws Exception;

	
}
