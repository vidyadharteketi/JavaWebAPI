package com.reporting.webapi.adapter;

import java.util.List;

import com.reporting.webapi.bean.PayrollRefDataBean;
import com.reporting.webapi.response.vo.ReportsForPayrollDataActivityVO;

public interface IPayrollDataActivityReportAdapter {

	public PayrollRefDataBean getPayrollDataActivityReportReferenceData() throws Exception;
	
	public List<ReportsForPayrollDataActivityVO> getPayrollDataActivityReportData(String workYear, String controlGroup) throws Exception;
}
