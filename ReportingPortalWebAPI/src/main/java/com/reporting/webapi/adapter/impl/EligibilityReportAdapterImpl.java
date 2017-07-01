package com.reporting.webapi.adapter.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reporting.webapi.adapter.IEligibilityReportAdapter;
import com.reporting.webapi.bean.EligibilityServiceReferanceDataBean;
import com.reporting.webapi.dao.IEligibilityReportDao;
import com.reporting.webapi.response.vo.EligibilityReportDataVO;

@Service
public class EligibilityReportAdapterImpl implements IEligibilityReportAdapter {

	private final Logger logger = Logger.getLogger(EligibilityReportAdapterImpl.class);

	@Autowired
	private IEligibilityReportDao eligibilityReportDao;
	
	@Override
	public EligibilityServiceReferanceDataBean getEligibilityServiceReferenceData() throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: EligibilityReportAdapterImpl : getEligibilityServiceReferenceData : Method to getEligibilityServiceReferenceData");
		}
		EligibilityServiceReferanceDataBean eligibilityServiceReferanceDataBean = eligibilityReportDao.getEligibilityServiceReferenceData();
		if(logger.isDebugEnabled()){
			logger.debug("END :: EligibilityReportAdapterImpl : getEligibilityServiceReferenceData : Method to getEligibilityServiceReferenceData");
		}
		return eligibilityServiceReferanceDataBean;
	}
	
	@Override
	public List<EligibilityReportDataVO> getEligibilityReportData(String workYear,String controlGroup,String unionStatus,String typeOfHours) throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: EligibilityReportAdapterImpl : getEligibilityReportData : Method to getEligibilityReportData");
		}
		List<EligibilityReportDataVO> eligibilityReportDataVO = eligibilityReportDao.getEligibilityReportData(workYear,controlGroup,unionStatus,typeOfHours);
		if(logger.isDebugEnabled()){
			logger.debug("END :: EligibilityReportAdapterImpl : getEligibilityReportData : Method to getEligibilityReportData");
		}
		return eligibilityReportDataVO;
	}
	
}
