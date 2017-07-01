package com.reporting.webapi.dao;

import java.util.List;

import com.reporting.webapi.bean.ERCoverageReferanceDataBean;
import com.reporting.webapi.response.vo.AnnualizedMonthlyCountVO;
import com.reporting.webapi.response.vo.ReportsByAnnualizedMonthlyCountVO;

public interface IERCoverageReportDao {

	ERCoverageReferanceDataBean getERCoverageReportReferenceData() throws Exception;

	List<AnnualizedMonthlyCountVO> getERCoverageReportCount(String workYear, String controlGroup) throws Exception;

	List<ReportsByAnnualizedMonthlyCountVO> getERCoverageReportData(String workYear, String controlGroup, String annualizedMonthlyCount) throws Exception;
}
