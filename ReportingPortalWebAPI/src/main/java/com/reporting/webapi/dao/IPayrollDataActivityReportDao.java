package com.reporting.webapi.dao;

import java.util.List;

import com.reporting.webapi.bean.PayrollRefDataBean;
import com.reporting.webapi.response.vo.ReportsForPayrollDataActivityVO;

public interface IPayrollDataActivityReportDao {

	PayrollRefDataBean getPayrollDataActivityReportReferenceData() throws Exception;

	List<ReportsForPayrollDataActivityVO> getPayrollDataActivityReportData(String workYear, String controlGroup) throws Exception;
}
