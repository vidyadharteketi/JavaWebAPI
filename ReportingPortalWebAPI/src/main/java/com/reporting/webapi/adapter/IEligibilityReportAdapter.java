package com.reporting.webapi.adapter;

import java.util.List;

import com.reporting.webapi.bean.EligibilityServiceReferanceDataBean;
import com.reporting.webapi.response.vo.EligibilityReportDataVO;

public interface IEligibilityReportAdapter {
	public EligibilityServiceReferanceDataBean getEligibilityServiceReferenceData()throws Exception;
	public List<EligibilityReportDataVO> getEligibilityReportData(String workYear,String controlGroup,String unionStatus,String typeOfHours) throws Exception;
}
