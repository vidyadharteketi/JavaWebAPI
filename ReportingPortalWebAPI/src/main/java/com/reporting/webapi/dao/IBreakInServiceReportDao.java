package com.reporting.webapi.dao;

import java.util.List;

import com.reporting.webapi.bean.BreakInServiceReferanceDataBean;
import com.reporting.webapi.response.vo.BreakInReportDataVO;

public interface IBreakInServiceReportDao {

	public BreakInServiceReferanceDataBean getBreakInServiceReportReferenceData() throws Exception;
	
	public List<BreakInReportDataVO> getBreakInReportData(String workYear,String controlGroup,String weekStarting,String weekEnding) throws Exception;

}
