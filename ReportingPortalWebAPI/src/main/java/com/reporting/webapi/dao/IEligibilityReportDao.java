package com.reporting.webapi.dao;

import java.util.List;

import com.reporting.webapi.bean.EligibilityServiceReferanceDataBean;
import com.reporting.webapi.response.vo.EligibilityReportDataVO;

public interface IEligibilityReportDao {
	public EligibilityServiceReferanceDataBean getEligibilityServiceReferenceData()throws Exception;
	public List<EligibilityReportDataVO> getEligibilityReportData(String workYear,String controlGroup,String unionStatus,String typeOfHours) throws Exception;
}
