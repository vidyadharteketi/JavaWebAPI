package com.reporting.webapi.adapter.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reporting.webapi.adapter.IPayrollDataActivityReportAdapter;
import com.reporting.webapi.bean.PayrollRefDataBean;
import com.reporting.webapi.dao.IPayrollDataActivityReportDao;
import com.reporting.webapi.response.vo.ReportsForPayrollDataActivityVO;

@Service
public class PayrollDataActivityReportAdapterImpl implements IPayrollDataActivityReportAdapter {

	private final Logger logger = Logger.getLogger(PayrollDataActivityReportAdapterImpl.class);
	
	@Autowired
	private IPayrollDataActivityReportDao payrollDataActivityReportDao;
	
	@Override
	public PayrollRefDataBean getPayrollDataActivityReportReferenceData() throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: PayrollDataActivityReportAdapterImpl : getPayrollDataActivityReportReferenceData : Method to getPayrollDataActivityReportReferenceData");
		}
		PayrollRefDataBean payrollRefDataBean = payrollDataActivityReportDao.getPayrollDataActivityReportReferenceData();
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: PayrollDataActivityReportAdapterImpl : getPayrollDataActivityReportReferenceData : Method to getPayrollDataActivityReportReferenceData");
		}
		
		return payrollRefDataBean;
	}

	@Override
	public List<ReportsForPayrollDataActivityVO> getPayrollDataActivityReportData(String workYear, String controlGroup)
			throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: PayrollDataActivityReportAdapterImpl : getPayrollDataActivityReportData : Method to getPayrollDataActivityReportData");
		}
		List<ReportsForPayrollDataActivityVO> list = payrollDataActivityReportDao.getPayrollDataActivityReportData(workYear, controlGroup);
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: PayrollDataActivityReportAdapterImpl : getPayrollDataActivityReportData : Method to getPayrollDataActivityReportData");
		}
		
		return list;
	}

}
