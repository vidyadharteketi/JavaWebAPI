package com.reporting.webapi.adapter;

import java.util.List;

import com.reporting.webapi.bean.BreakInServiceReferanceDataBean;
import com.reporting.webapi.response.vo.BreakInReportDataVO;

public interface IBreakInServiceReportAdapter {

	public BreakInServiceReferanceDataBean getBreakInServiceReportReferenceData() throws Exception;

	public List<BreakInReportDataVO> getBreakInReportData(String workYear,String controlGroup,String weekStarting,String weekEnding)throws Exception;

}
