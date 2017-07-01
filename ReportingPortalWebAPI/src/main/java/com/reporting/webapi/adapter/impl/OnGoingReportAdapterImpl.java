package com.reporting.webapi.adapter.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reporting.webapi.adapter.IOnGoingReportAdapter;
import com.reporting.webapi.bean.OngoingReferanceDataBean;
import com.reporting.webapi.dao.IOnGoingReportDao;
import com.reporting.webapi.response.vo.OnGoingCountByWeeksVO;
import com.reporting.webapi.response.vo.OnGoingReportsByWeekCountVO;

@Service
public class OnGoingReportAdapterImpl implements IOnGoingReportAdapter{

	private final Logger logger = Logger.getLogger(OnGoingReportAdapterImpl.class);
	
	@Autowired
	private IOnGoingReportDao eligibilityReportOngoingDao;
	
	@Override
	public OngoingReferanceDataBean getOnGoingReportReferenceData() throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: OnGoingReportService : getOnGoingReportReferenceData : Method to getOnGoingReportReferenceData");
		}
		OngoingReferanceDataBean ongoingReferanceDataBean = eligibilityReportOngoingDao.getOnGoingReportReferenceData();
		if(logger.isDebugEnabled()){
			logger.debug("END :: OnGoingReportService : getOnGoingReportReferenceData : Method to getOnGoingReportReferenceData");
		}
		return ongoingReferanceDataBean;
	}

	@Override
	public List<OnGoingCountByWeeksVO> getOnGoingReportCountByWeek(String measurementEndDate, String avgWeeklyHours,
			String controlGroup, String typeOfHours) throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: OnGoingReportService : getOnGoingReportReferenceData : Method to getOnGoingReportReferenceData");
		}
		List<OnGoingCountByWeeksVO> list = eligibilityReportOngoingDao.getOnGoingReportCountByWeek(measurementEndDate,avgWeeklyHours,controlGroup,typeOfHours);
		if(logger.isDebugEnabled()){
			logger.debug("END :: OnGoingReportService : getOnGoingReportReferenceData : Method to getOnGoingReportReferenceData");
		}
		return list;
	}

	@Override
	public List<OnGoingReportsByWeekCountVO> getOnGoingReportData(String measurementEndDate, String avgWeeklyHours, String controlGroup,
			String typeOfHours,  String reportOfWeek) throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: OnGoingReportService : getOnGoingReportData : Method to getOnGoingReportData");
		}
		List<OnGoingReportsByWeekCountVO> list = eligibilityReportOngoingDao.getOnGoingReportData(measurementEndDate,avgWeeklyHours,controlGroup,typeOfHours,reportOfWeek);
		if(logger.isDebugEnabled()){
			logger.debug("END :: OnGoingReportService : getOnGoingReportData : Method to getOnGoingReportData");
		}
		return list;
	}

}
