package com.reporting.webapi.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.reporting.webapi.bean.ERCoverageReferanceDataBean;
import com.reporting.webapi.dao.IERCoverageReportDao;
import com.reporting.webapi.response.vo.AnnualizedMonthlyCountVO;
import com.reporting.webapi.response.vo.ReportsByAnnualizedMonthlyCountVO;

@Repository
public class ERCoverageReportDaoImpl implements IERCoverageReportDao{

	private final Logger logger = Logger.getLogger(ERCoverageReportDaoImpl.class);
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	public ERCoverageReferanceDataBean getERCoverageReportReferenceData() throws Exception {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: ERCoverageReportDaoImpl : getERCoverageReportReferenceData : Method to getERCoverageReportReferenceData");
		}
		
		Session session = sessionFactory.openSession();
		List<String> workYearList = null;
		List<String> workMonthList = null;
		List<String> controlGroupList = null;
		ERCoverageReferanceDataBean erCoverageReferanceDataBean = new ERCoverageReferanceDataBean();
		try{
			Query workHourQuery = session.getNamedQuery("PRC_ERCoverage_ReferenceData_WorkYear");
			erCoverageReferanceDataBean.setWorkYears(workHourQuery.list());
			
			Query controlGroupQuery = session.getNamedQuery("PRC_ERCoverage_ReferenceData_ControlGroup");
			erCoverageReferanceDataBean.setControlGroups(controlGroupQuery.list());
			
			
		}catch(Exception e){
			
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: ERCoverageReportDaoImpl : getERCoverageReportReferenceData : Method to getERCoverageReportReferenceData");
		}
		
		return erCoverageReferanceDataBean;
	}

	@Override
	public List<AnnualizedMonthlyCountVO> getERCoverageReportCount(String workYear, String controlGroup)
			throws Exception {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: ERCoverageReportDaoImpl : getERCoverageReportCount : Method to getERCoverageReportCount");
		}
		Session session = sessionFactory.openSession();
		List<AnnualizedMonthlyCountVO> list = null;
		List<AnnualizedMonthlyCountVO> listVO = null;
		AnnualizedMonthlyCountVO annualizedMonthlyCountVO = null;
		try {
			Query query = session.getNamedQuery("PRC_ERCoverage_AnnualizedMonthlyCount");
			query.setParameter("workYear", workYear);
			query.setParameter("controlGroup", controlGroup);
			list = query.list();

			listVO = new ArrayList<AnnualizedMonthlyCountVO>();
			if (list != null && list.size() > 0) {
				for (Object obj : list) {
					annualizedMonthlyCountVO = new AnnualizedMonthlyCountVO();
					if (null != obj) {
						annualizedMonthlyCountVO.setANNUALIZED_MONTHLY_COUNT(obj.toString());
					}
					listVO.add(annualizedMonthlyCountVO);
				}
			}
		} catch (Exception e) {

		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: ERCoverageReportDaoImpl : getERCoverageReportCount : Method to getERCoverageReportCount");
		}
		
		
		return listVO;
	}

	@Override
	public List<ReportsByAnnualizedMonthlyCountVO> getERCoverageReportData(String workYear,
			String controlGroup, String annualizedMonthlyCount) throws Exception {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: ERCoverageReportDaoImpl : getERCoverageReportData : Method to getERCoverageReportData");
		}
		
		Session session = sessionFactory.openSession();
		List<ReportsByAnnualizedMonthlyCountVO> list = null;
		List<ReportsByAnnualizedMonthlyCountVO> listVo = null;
		ReportsByAnnualizedMonthlyCountVO reportsByAnnualizedMonthlyCountVO = null;
		try {
			Query query = session.getNamedQuery("PRC_ERCoverage_ReportsByAnnualizedMonthlyCount");
			query.setParameter("workYear", workYear);
			query.setParameter("controlGroup", controlGroup);
			query.setParameter("annualizedMonthlyCount", annualizedMonthlyCount);//add this in the procedure

			list = query.list();

			listVo = new ArrayList<ReportsByAnnualizedMonthlyCountVO>();
			if (list != null && list.size() > 0) {
				for (Object o : list) {
					
					System.out.println(o.toString());
					
					reportsByAnnualizedMonthlyCountVO = new ReportsByAnnualizedMonthlyCountVO();

					Object[] column = (Object[]) o;
					if (null != column[0]) {
						reportsByAnnualizedMonthlyCountVO.setCONTROL_GROUP((column[0].toString()));
					}
					if (null != column[1]) {
						reportsByAnnualizedMonthlyCountVO.setWORK_YEAR((column[1].toString()));
					}
					if (null != column[2]) {
						reportsByAnnualizedMonthlyCountVO.setWORK_MONTH((column[2].toString()));
					}
					if (null != column[3]) {
						reportsByAnnualizedMonthlyCountVO.setWORKED_POOL_FTE_STATUS((column[3].toString()));
					}
					if (null != column[4]) {
						reportsByAnnualizedMonthlyCountVO.setFIRST_NAME((column[4].toString()));
					}
					if (null != column[5]) {
						reportsByAnnualizedMonthlyCountVO.setLAST_NAME((column[5].toString()));
					}
					if (null != column[6]) {
						reportsByAnnualizedMonthlyCountVO.setHOURS_WORKED((column[6].toString()));
					}
					if (null != column[7]) {
						reportsByAnnualizedMonthlyCountVO.setWORKED_POOL_FTE_COUNT((column[7].toString()));
					}
					
					listVo.add(reportsByAnnualizedMonthlyCountVO);
				}

			}

		} catch (Exception e) {

		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: ERCoverageReportDaoImpl : getERCoverageReportData : Method to getERCoverageReportData");
		}
		
		return listVo;
	}
	
	
	
}
