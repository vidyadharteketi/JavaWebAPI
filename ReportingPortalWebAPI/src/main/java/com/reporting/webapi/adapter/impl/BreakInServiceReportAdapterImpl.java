package com.reporting.webapi.adapter.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reporting.webapi.adapter.IBreakInServiceReportAdapter;
import com.reporting.webapi.bean.BreakInServiceReferanceDataBean;
import com.reporting.webapi.dao.IBreakInServiceReportDao;
import com.reporting.webapi.response.vo.BreakInReportDataVO;

@Service
public class BreakInServiceReportAdapterImpl implements IBreakInServiceReportAdapter {

private final Logger logger = Logger.getLogger(BreakInServiceReportAdapterImpl.class);
	
	@Autowired
	private IBreakInServiceReportDao breakInServiceReportDao;
	
	@Override
	public BreakInServiceReferanceDataBean getBreakInServiceReportReferenceData() throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: BreakInServiceReportAdapterImpl : getBreakInServiceReportReferenceData : Method to getBreakInServiceReportReferenceData");
		}
		BreakInServiceReferanceDataBean breakInServiceReferanceDataBean = breakInServiceReportDao.getBreakInServiceReportReferenceData();
		if(logger.isDebugEnabled()){
			logger.debug("END :: BreakInServiceReportAdapterImpl : getBreakInServiceReportReferenceData : Method to getBreakInServiceReportReferenceData");
		}
		return breakInServiceReferanceDataBean;
	}


	@Override
	public List<BreakInReportDataVO> getBreakInReportData(String workYear,String controlGroup,String weekStarting,String weekEnding) throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: BreakInServiceReportAdapterImpl : getBreakInReportData : Method to getBreakInReportData");
		}
		List<BreakInReportDataVO> breakInReportData = breakInServiceReportDao.getBreakInReportData(workYear,controlGroup,weekStarting,weekEnding);
		if(logger.isDebugEnabled()){
			logger.debug("END :: BreakInServiceReportAdapterImpl : getBreakInReportData : Method to getBreakInReportData");
		}
		return breakInReportData;
	}
}
