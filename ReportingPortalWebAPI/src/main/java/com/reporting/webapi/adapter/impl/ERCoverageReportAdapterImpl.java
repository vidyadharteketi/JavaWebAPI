package com.reporting.webapi.adapter.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reporting.webapi.adapter.IERCoverageReportAdapter;
import com.reporting.webapi.bean.ERCoverageReferanceDataBean;
import com.reporting.webapi.dao.IERCoverageReportDao;
import com.reporting.webapi.response.vo.AnnualizedMonthlyCountVO;
import com.reporting.webapi.response.vo.ReportsByAnnualizedMonthlyCountVO;

@Service
public class ERCoverageReportAdapterImpl implements IERCoverageReportAdapter{
	
	private final Logger logger = Logger.getLogger(ERCoverageReportAdapterImpl.class);

	@Autowired
	private IERCoverageReportDao eRCoverageReportDao;

	@Override
	public ERCoverageReferanceDataBean getERCoverageReportReferenceData() throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: ERCoverageReportAdapterImpl : getERCoverageReportReferenceData : Method to getERCoverageReportReferenceData");
		}
		ERCoverageReferanceDataBean erCoverageReferanceDataBean = eRCoverageReportDao.getERCoverageReportReferenceData();
		if(logger.isDebugEnabled()){
			logger.debug("END :: ERCoverageReportAdapterImpl : getERCoverageReportReferenceData : Method to getERCoverageReportReferenceData");
		}
		return erCoverageReferanceDataBean;
	}

	@Override
	public List<AnnualizedMonthlyCountVO> getERCoverageReportCount(String workYear, String controlGroup)
			throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: ERCoverageReportAdapterImpl : getERCoverageReportCount : Method to getERCoverageReportCount");
		}
		List<AnnualizedMonthlyCountVO> list = eRCoverageReportDao.getERCoverageReportCount(workYear, controlGroup);
		if(logger.isDebugEnabled()){
			logger.debug("END :: ERCoverageReportAdapterImpl : getERCoverageReportCount : Method to getERCoverageReportCount");
		}
		return list;
	}

	@Override
	public List<ReportsByAnnualizedMonthlyCountVO> getERCoverageReportData(String workYear,
			String controlGroup, String annualizedMonthlyCount) throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: ERCoverageReportAdapterImpl : getERCoverageReportData : Method to getERCoverageReportData");
		}
		List<ReportsByAnnualizedMonthlyCountVO> list = eRCoverageReportDao.getERCoverageReportData(workYear, controlGroup, annualizedMonthlyCount);
		if(logger.isDebugEnabled()){
			logger.debug("END :: ERCoverageReportAdapterImpl : getERCoverageReportData : Method to getERCoverageReportData");
		}
		return list;
	}

	
	
	
	
	
}
