package com.reporting.webapi.adapter.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reporting.webapi.adapter.IDemographicsReportAdapter;
import com.reporting.webapi.bean.DemoGraphicsServiceReferanceDataBean;
import com.reporting.webapi.dao.IDemographicsReportDao;
import com.reporting.webapi.response.vo.DemoGraphicsReportDataVO;

@Service
public class DemographicsReportAdapterImpl implements IDemographicsReportAdapter{

	private final Logger logger = Logger.getLogger(DemographicsReportAdapterImpl.class);
	
	@Autowired
	private IDemographicsReportDao demographicsReportDao;
	
	@Override
	public DemoGraphicsServiceReferanceDataBean getDemographicsServiceReferenceData() throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: DemographicsReportAdapterImpl : getDemographicsServiceReferenceData : Method to getDemographicsServiceReferenceData");
		}
		DemoGraphicsServiceReferanceDataBean demoGraphicsServiceReferanceDataBean = demographicsReportDao.getDemographicsServiceReferenceData();
		if(logger.isDebugEnabled()){
			logger.debug("END :: DemographicsReportAdapterImpl : getDemographicsServiceReferenceData : Method to getDemographicsServiceReferenceData");
		}
		return demoGraphicsServiceReferanceDataBean;
	}
	
	@Override
	public List<DemoGraphicsReportDataVO> getDemographicsReportData(String workYear,String controlGroup,String parentCompnay,String proudctioncompany,String payrollCompany) throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: DemographicsReportAdapterImpl : getDemographicsReportData : Method to getDemographicsReportData");
		}
		List<DemoGraphicsReportDataVO> demoGraphicsReferanceDataVO = demographicsReportDao.getDemographicsReportData(workYear,controlGroup,parentCompnay,proudctioncompany,payrollCompany);
		if(logger.isDebugEnabled()){
			logger.debug("END :: DemographicsReportAdapterImpl : getDemographicsReportData : Method to getDemographicsReportData");
		}
		return demoGraphicsReferanceDataVO;
	}

}
