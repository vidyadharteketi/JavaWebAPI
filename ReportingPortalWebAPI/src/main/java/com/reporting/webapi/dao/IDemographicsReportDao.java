package com.reporting.webapi.dao;

import java.util.List;

import com.reporting.webapi.bean.DemoGraphicsServiceReferanceDataBean;
import com.reporting.webapi.response.vo.DemoGraphicsReportDataVO;

public interface IDemographicsReportDao {
	public DemoGraphicsServiceReferanceDataBean getDemographicsServiceReferenceData() throws Exception;
	public List<DemoGraphicsReportDataVO> getDemographicsReportData(String workYear,String controlGroup,String parentCompnay,String proudctioncompany,String payrollCompany) throws Exception;
}
