package com.reporting.webapi.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.reporting.webapi.bean.PayrollRefDataBean;
import com.reporting.webapi.dao.IPayrollDataActivityReportDao;
import com.reporting.webapi.response.vo.ReportsForPayrollDataActivityVO;

@Repository
public class PayrollDataActivityReportDaoImpl implements IPayrollDataActivityReportDao{

	private final Logger logger = Logger.getLogger(PayrollDataActivityReportDaoImpl.class);
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public PayrollRefDataBean getPayrollDataActivityReportReferenceData() throws Exception {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: PayrollDataActivityReportDaoImpl : getPayrollDataActivityReportReferenceData : Method to getPayrollDataActivityReportReferenceData");
		}
		
		Session session = sessionFactory.openSession();
		List<String> workYearList = null;
		List<String> controlGroupList = null;
		PayrollRefDataBean payrollRefDataBean = new PayrollRefDataBean();
		try{
			Query workHourQuery = session.getNamedQuery("PRC_PayrollDataActivity_ReferenceData_WorkYear");
			payrollRefDataBean.setWorkYears(workHourQuery.list());
			
			Query controlGroupQuery = session.getNamedQuery("PRC_PayrollDataActivity_ReferenceData_ControlGroup");
			payrollRefDataBean.setControlGroups(controlGroupQuery.list());
			
			
		}catch(Exception e){
			
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: PayrollDataActivityReportDaoImpl : getPayrollDataActivityReportReferenceData : Method to getPayrollDataActivityReportReferenceData");
		}
		
		return payrollRefDataBean;
	}

	@Override
	public List<ReportsForPayrollDataActivityVO> getPayrollDataActivityReportData(String workYear, String controlGroup)
			throws Exception {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: PayrollDataActivityReportDaoImpl : getPayrollDataActivityReportData : Method to getPayrollDataActivityReportData");
		}
		
		Session session = sessionFactory.openSession();
		List<ReportsForPayrollDataActivityVO> list = null;
		List<ReportsForPayrollDataActivityVO> listVo = null;
		ReportsForPayrollDataActivityVO reportsForPayrollDataActivityVO = null;
		try{
			Query query = session.getNamedQuery("PRC_PayrollDataActivity_ReportsForPayrollDataActivity");
			query.setParameter("workYear", workYear);
			query.setParameter("controlGroup", controlGroup);

			list = query.list();

			listVo = new ArrayList<ReportsForPayrollDataActivityVO>();
			if (list != null && list.size() > 0) {
				for (Object o : list) {
					
					System.out.println(o.toString());
					
					reportsForPayrollDataActivityVO = new ReportsForPayrollDataActivityVO();

					Object[] column = (Object[]) o;
					if (null != column[0]) {
						reportsForPayrollDataActivityVO.setSSN_NUMBER((column[0].toString()));
					}
					if (null != column[1]) {
						reportsForPayrollDataActivityVO.setFIRST_NAME((column[1].toString()));
					}
					if (null != column[2]) {
						reportsForPayrollDataActivityVO.setLAST_NAME((column[2].toString()));
					}
					if (null != column[3]) {
						reportsForPayrollDataActivityVO.setEIN((column[3].toString()));
					}
					if (null != column[4]) {
						reportsForPayrollDataActivityVO.setPRODUCTION_COMPANY((column[4].toString()));
					}
					if (null != column[5]) {
						reportsForPayrollDataActivityVO.setHIRE_DATE((column[5].toString()));
					}
					if (null != column[6]) {
						reportsForPayrollDataActivityVO.setLAST_DATE_WORKED((column[6].toString()));
					}
					if (null != column[7]) {
						reportsForPayrollDataActivityVO.setPROJECT((column[7].toString()));
					}
					if (null != column[8]) {
						reportsForPayrollDataActivityVO.setCLIENT_ID((column[8].toString()));
					}
					if (null != column[9]) {
						reportsForPayrollDataActivityVO.setSOURCE((column[9].toString()));
					}
					if (null != column[10]) {
						reportsForPayrollDataActivityVO.setEMPLOYMENT_STATUS((column[10].toString()));
					}
					if (null != column[11]) {
						reportsForPayrollDataActivityVO.setUNION_HOURS((column[11].toString()));
					}
					if (null != column[12]) {
						reportsForPayrollDataActivityVO.setJANUARY((column[12].toString()));
					}
					if (null != column[13]) {
						reportsForPayrollDataActivityVO.setFEBRUARY((column[13].toString()));
					}
					if (null != column[14]) {
						reportsForPayrollDataActivityVO.setMARCH((column[14].toString()));
					}
					if (null != column[15]) {
						reportsForPayrollDataActivityVO.setAPRIL((column[15].toString()));
					}
					if (null != column[16]) {
						reportsForPayrollDataActivityVO.setMAY((column[16].toString()));
					}
					if (null != column[17]) {
						reportsForPayrollDataActivityVO.setJUNE((column[17].toString()));
					}
					if (null != column[18]) {
						reportsForPayrollDataActivityVO.setJULY((column[18].toString()));
					}
					if (null != column[19]) {
						reportsForPayrollDataActivityVO.setAUGUST((column[19].toString()));
					}
					if (null != column[20]) {
						reportsForPayrollDataActivityVO.setSEPTEMBER((column[20].toString()));
					}
					if (null != column[21]) {
						reportsForPayrollDataActivityVO.setOCTOBER((column[21].toString()));
					}
					if (null != column[22]) {
						reportsForPayrollDataActivityVO.setNOVEMBER((column[22].toString()));
					}
					if (null != column[23]) {
						reportsForPayrollDataActivityVO.setDECEMBER((column[23].toString()));
					}
					if (null != column[24]) {
						reportsForPayrollDataActivityVO.setControlGroup((column[24].toString()));
					}
					
					listVo.add(reportsForPayrollDataActivityVO);
				}					
			}
		}catch (Exception e) {

		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: PayrollDataActivityReportDaoImpl : getPayrollDataActivityReportData : Method to getPayrollDataActivityReportData");
		}
		
		
		return listVo;
	}
	
	
}
