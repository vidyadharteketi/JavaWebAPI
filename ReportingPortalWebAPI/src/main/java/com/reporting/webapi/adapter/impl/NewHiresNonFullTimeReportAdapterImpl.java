package com.reporting.webapi.adapter.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reporting.webapi.adapter.INewHiresNonFullTimeReportAdapter;
import com.reporting.webapi.bean.NewHireNonFullTimeReferanceDataBean;
import com.reporting.webapi.dao.INewHiresNonFullTimeReportDao;
import com.reporting.webapi.response.vo.ReportCountByWeekVO;
import com.reporting.webapi.response.vo.ReportsByWeeksCountVO;

@Service
public class NewHiresNonFullTimeReportAdapterImpl implements INewHiresNonFullTimeReportAdapter {

	private final Logger logger = Logger.getLogger(NewHiresNonFullTimeReportAdapterImpl.class);
	
	@Autowired
	private INewHiresNonFullTimeReportDao newHiresNonFullTimeReportDao;
	
	@Override
	public NewHireNonFullTimeReferanceDataBean getNewHiresNonFullTimeReportReferenceData() throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: NewHiresNonFullTimeReportAdapterImpl : getNewHiresNonFullTimeReportReferenceData : Method to getNewHiresNonFullTimeReportReferenceData");
		}
		NewHireNonFullTimeReferanceDataBean newHireNonFullTimeReferanceData = newHiresNonFullTimeReportDao.getNewHiresNonFullTimeReportReferenceData();
		if(logger.isDebugEnabled()){
			logger.debug("END :: NewHiresNonFullTimeReportAdapterImpl : getNewHiresNonFullTimeReportReferenceData : Method to getNewHiresNonFullTimeReportReferenceData");
		}
		return newHireNonFullTimeReferanceData;
	}
	
	@Override
	public List<ReportCountByWeekVO> getNewHiresNonFullTimeCountByWeek(String workYear,String workMonth,String controlGroup,
			String unionType,String employeeType) throws Exception{
		if(logger.isDebugEnabled()){
			logger.debug("START :: NewHiresNonFullTimeReportAdapterImpl : getNewHiresNonFullTimeCountByWeek : Method to getNewHiresNonFullTimeCountByWeek");
		}
		List<ReportCountByWeekVO> list = newHiresNonFullTimeReportDao.getNewHiresNonFullTimeCountByWeek(workYear,workMonth,controlGroup,
				unionType,employeeType);
		if(logger.isDebugEnabled()){
			logger.debug("END :: NewHiresNonFullTimeReportAdapterImpl : getNewHiresNonFullTimeCountByWeek : Method to getNewHiresNonFullTimeCountByWeek");
		}
		return list;
	}

	@Override
	public List<ReportsByWeeksCountVO> getNewHiresNonFullTimeReportData(String workYear, String workMonth, String controlGroup,
			String unionType, String employeeType, String reportOfWeek) throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: NewHiresNonFullTimeReportAdapterImpl : getNewHiresNonFullTimeReportData : Method to getNewHiresNonFullTimeReportData");
		}
		List<ReportsByWeeksCountVO> list = newHiresNonFullTimeReportDao.getNewHiresNonFullTimeReportData(workYear,workMonth,controlGroup,
				unionType,employeeType,reportOfWeek);
		if(logger.isDebugEnabled()){
			logger.debug("END :: NewHiresNonFullTimeReportAdapterImpl : getNewHiresNonFullTimeReportData : Method to getNewHiresNonFullTimeReportData");
		}
		return list;
	}
}
