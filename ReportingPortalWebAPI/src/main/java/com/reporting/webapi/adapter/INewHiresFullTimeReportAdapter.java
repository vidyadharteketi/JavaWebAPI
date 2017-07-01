package com.reporting.webapi.adapter;

import java.util.List;

import com.reporting.webapi.bean.NewHireFullTimeReferanceDataBean;
import com.reporting.webapi.response.vo.ReportsByACAEligibleCountVO;
import com.reporting.webapi.response.vo.SummaryCountForNewHireFullTimeVO;

public interface INewHiresFullTimeReportAdapter {

	public NewHireFullTimeReferanceDataBean getNewHiresFullTimeReportReferenceData() throws Exception;

	public List<SummaryCountForNewHireFullTimeVO> getNewHiresFullTimeCountByWeek(String workYear, String workMonth,
			String controlGroup)throws Exception;

	public List<ReportsByACAEligibleCountVO> getNewHiresFullTimeReportData(String workYear, String workMonth,
			String controlGroup, String acaEligibleCount)throws Exception;

}
