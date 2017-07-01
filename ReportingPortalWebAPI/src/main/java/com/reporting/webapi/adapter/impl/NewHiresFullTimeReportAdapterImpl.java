package com.reporting.webapi.adapter.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reporting.webapi.adapter.INewHiresFullTimeReportAdapter;
import com.reporting.webapi.bean.NewHireFullTimeReferanceDataBean;
import com.reporting.webapi.dao.INewHiresFullTimeReportDao;
import com.reporting.webapi.response.vo.ReportsByACAEligibleCountVO;
import com.reporting.webapi.response.vo.SummaryCountForNewHireFullTimeVO;

@Service
public class NewHiresFullTimeReportAdapterImpl implements INewHiresFullTimeReportAdapter{

	private final Logger logger = Logger.getLogger(NewHiresFullTimeReportAdapterImpl.class);
	
	@Autowired
	private INewHiresFullTimeReportDao newHiresFullTimeReportDao;
	
	@Override
	public NewHireFullTimeReferanceDataBean getNewHiresFullTimeReportReferenceData() throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: NewHiresFullTimeReportAdapterImpl : getNewHiresFullTimeReportReferenceData : Method to getNewHiresFullTimeReportReferenceData");
		}
		NewHireFullTimeReferanceDataBean newHireFullTimeReferanceData = newHiresFullTimeReportDao.getNewHiresFullTimeReportReferenceData();
		if(logger.isDebugEnabled()){
			logger.debug("END :: NewHiresFullTimeReportAdapterImpl : getNewHiresFullTimeReportReferenceData : Method to getNewHiresFullTimeReportReferenceData");
		}
		return newHireFullTimeReferanceData;
	}

	@Override
	public List<SummaryCountForNewHireFullTimeVO> getNewHiresFullTimeCountByWeek(String workYear, String workMonth,
			String controlGroup) throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: NewHiresFullTimeReportAdapterImpl : getNewHiresFullTimeCountByWeek : Method to getNewHiresFullTimeCountByWeek");
		}
		List<SummaryCountForNewHireFullTimeVO> list = newHiresFullTimeReportDao.getNewHiresFullTimeCountByWeek(workYear,workMonth,controlGroup);
		if(logger.isDebugEnabled()){
			logger.debug("END :: NewHiresFullTimeReportAdapterImpl : getNewHiresFullTimeCountByWeek : Method to getNewHiresFullTimeCountByWeek");
		}
		return list;
	}

	@Override
	public List<ReportsByACAEligibleCountVO> getNewHiresFullTimeReportData(String workYear, String workMonth,
			String controlGroup, String acaEligibleCount) throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: NewHiresFullTimeReportAdapterImpl : getNewHiresFullTimeReportData : Method to getNewHiresFullTimeReportData");
		}
		List<ReportsByACAEligibleCountVO> list = newHiresFullTimeReportDao.getNewHiresFullTimeReportData(workYear,workMonth,controlGroup,acaEligibleCount);
		if(logger.isDebugEnabled()){
			logger.debug("END :: NewHiresFullTimeReportAdapterImpl : getNewHiresFullTimeReportData : Method to getNewHiresFullTimeReportData");
		}
		return list;
	}

}
