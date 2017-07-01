package com.reporting.webapi.adapter;

import java.util.List;

import com.reporting.webapi.bean.ERCoverageReferanceDataBean;
import com.reporting.webapi.response.vo.AnnualizedMonthlyCountVO;
import com.reporting.webapi.response.vo.ReportsByAnnualizedMonthlyCountVO;

public interface IERCoverageReportAdapter {

	public ERCoverageReferanceDataBean getERCoverageReportReferenceData() throws Exception;

	public List<AnnualizedMonthlyCountVO> getERCoverageReportCount(String workYear, String controlGroup) throws Exception;

	public List<ReportsByAnnualizedMonthlyCountVO> getERCoverageReportData(String workYear, String controlGroup, String annualizedMonthlyCount)throws Exception;

}
