package com.reporting.webapi.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.reporting.webapi.bean.NewHireFullTimeReferanceDataBean;
import com.reporting.webapi.dao.INewHiresFullTimeReportDao;
import com.reporting.webapi.response.vo.ReportsByACAEligibleCountVO;
import com.reporting.webapi.response.vo.SummaryCountForNewHireFullTimeVO;

@Repository
public class NewHiresFullTimeReportDaoImpl implements INewHiresFullTimeReportDao{

	private final Logger logger = Logger.getLogger(NewHiresFullTimeReportDaoImpl.class);
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	public NewHireFullTimeReferanceDataBean getNewHiresFullTimeReportReferenceData() throws Exception {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: NewHiresFullTimeReportDaoImpl : getNewHiresFullTimeReportReferenceData : Method to getNewHiresFullTimeReportReferenceData");
		}
		
		Session session = sessionFactory.openSession();
		List<String> workYearList = null;
		List<String> workMonthList = null;
		List<String> controlGroupList = null;
		List<String> unionTypeList = null;
		List<String> employeeTypeList = null;
		NewHireFullTimeReferanceDataBean newHireFullTimeReferanceData = new NewHireFullTimeReferanceDataBean();
		
		try{
			Query workYearQuery = session.getNamedQuery("PRC_NewHiresFullTime_ReferenceData_WorkYear");
			newHireFullTimeReferanceData.setWorkYearList(workYearQuery.list());
			
			Query workMonthrQuery = session.getNamedQuery("PRC_NewHiresFullTime_ReferenceData_WorkMonth");
			newHireFullTimeReferanceData.setHireMonthList(workMonthrQuery.list());
			
			Query controlGroupQuery = session.getNamedQuery("PRC_NewHiresFullTime_ReferenceData_ControlGroup");
			newHireFullTimeReferanceData.setControlGroupList(controlGroupQuery.list());
			
		}catch(Exception e){
			logger.error("Error while fetching data getNewHiresFullTimeReportReferenceData : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: NewHiresFullTimeReportDaoImpl : getNewHiresFullTimeReportReferenceData : Method to getNewHiresgetNewHiresFullTimeReportReferenceDataFullTimeReportReferenceData");
		}
		
		return newHireFullTimeReferanceData;
	}

	@Override
	public List<SummaryCountForNewHireFullTimeVO> getNewHiresFullTimeCountByWeek(String workYear, String workMonth, String controlGroup) throws Exception {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: NewHiresFullTimeReportDaoImpl : getNewHiresFullTimeCountByWeek : Method to getNewHiresFullTimeCountByWeek");
		}
		
		Session session = sessionFactory.openSession();
		List<SummaryCountForNewHireFullTimeVO> list = null;
		List<SummaryCountForNewHireFullTimeVO> listVo = null;
		SummaryCountForNewHireFullTimeVO summaryCountForNewHireFullTimeVO = null;
		try {
			Query query = session.getNamedQuery("PRC_NewHiresFullTime_ACAEligibleCount");
			query.setParameter("workYear", workYear);
			query.setParameter("workMonth", workMonth);
			query.setParameter("controlGroup", controlGroup);
			list = query.list();

			listVo = new ArrayList<SummaryCountForNewHireFullTimeVO>();
			if (list != null && list.size() > 0) {
				for (Object acaEligibleCountObj : list) {
					summaryCountForNewHireFullTimeVO = new SummaryCountForNewHireFullTimeVO();
					if (null != acaEligibleCountObj) {
						summaryCountForNewHireFullTimeVO.setSUMMARY_COUNT(acaEligibleCountObj.toString());
					}
					listVo.add(summaryCountForNewHireFullTimeVO);
				}
			}
		} catch (Exception e) {
			logger.error("Error while fetching data getNewHiresFullTimeCountByWeek : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: NewHiresFullTimeReportDaoImpl : getNewHiresFullTimeCountByWeek : Method to getNewHiresFullTimeCountByWeek");
		}
		
		return listVo;
	}

	@Override
	public List<ReportsByACAEligibleCountVO> getNewHiresFullTimeReportData(String workYear, String workMonth,
			String controlGroup, String acaEligibleCount) throws Exception {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: NewHiresFullTimeReportDaoImpl : getNewHiresFullTimeReportData : Method to getNewHiresFullTimeReportData");
		}
		
		Session session = sessionFactory.openSession();
		List<ReportsByACAEligibleCountVO> list = null;
		List<ReportsByACAEligibleCountVO> listVo = null;
		ReportsByACAEligibleCountVO reportsByACAEligibleCountVO = null;
		try {
			Query query = session.getNamedQuery("PRC_NewHiresFullTime_ReportByACAEligibleCount");
			query.setParameter("workYear", workYear);
			query.setParameter("workMonth", workMonth);
			query.setParameter("controlGroup", controlGroup);
			query.setParameter("acaEligibleCount", acaEligibleCount);

			list = query.list();

			listVo = new ArrayList<ReportsByACAEligibleCountVO>();
			if (list != null && list.size() > 0) {
				for (Object o : list) {
			
					reportsByACAEligibleCountVO = new ReportsByACAEligibleCountVO();

					Object[] column = (Object[]) o;
					if (null != column[0]) {
						reportsByACAEligibleCountVO.setCONTROL_GROUP((column[0].toString()));
					}
					if (null != column[1]) {
						reportsByACAEligibleCountVO.setMOST_RECENT_PRODUCTION_COMPANY((column[1].toString()));
					}
					if (null != column[2]) {
						reportsByACAEligibleCountVO.setMOST_RECENT_PROJECT((column[2].toString()));
					}
					if (null != column[3]) {
						reportsByACAEligibleCountVO.setSSN_NUMBER((column[3].toString()));
					}
					if (null != column[4]) {
						reportsByACAEligibleCountVO.setFIRST_NAME((column[4].toString()));
					}
					if (null != column[5]) {
						reportsByACAEligibleCountVO.setLAST_NAME((column[5].toString()));
					}
					if (null != column[6]) {
						reportsByACAEligibleCountVO.setLAST_WORKED_DATE((column[6].toString()));
					}
					if (null != column[7]) {
						reportsByACAEligibleCountVO.setHIRE_DATE((column[7].toString()));
					}
					if (null != column[8]) {
						reportsByACAEligibleCountVO.setUNION_NON_UNION((column[8].toString()));
					}
					if (null != column[9]) {
						reportsByACAEligibleCountVO.setPAYROLL_SOURCE((column[9].toString()));
					}
					if (null != column[10]) {
						reportsByACAEligibleCountVO.setAVERAGE_HOURS((column[10].toString()));
					}
					if (null != column[11]) {
						reportsByACAEligibleCountVO.setTOTAL_HOURS_WEEKS((column[11].toString()));
					}
					
					listVo.add(reportsByACAEligibleCountVO);
				}

			}

		} catch (Exception e) {
			logger.error("Error while fetching data getNewHiresFullTimeReportData : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: NewHiresFullTimeReportDaoImpl : getNewHiresFullTimeReportData : Method to getNewHiresFullTimeReportData");
		}
		
		return listVo;
	}

}
