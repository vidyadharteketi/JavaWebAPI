package com.reporting.webapi.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.reporting.webapi.bean.OngoingReferanceDataBean;
import com.reporting.webapi.dao.IOnGoingReportDao;
import com.reporting.webapi.response.vo.OnGoingCountByWeeksVO;
import com.reporting.webapi.response.vo.OnGoingReportsByWeekCountVO;

@Repository
public class OnGoingReportDaoImpl implements IOnGoingReportDao{
	
	private final Logger logger = Logger.getLogger(OnGoingReportDaoImpl.class);
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	public OngoingReferanceDataBean getOnGoingReportReferenceData() throws Exception {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: OnGoingReportDaoImpl : getOnGoingReportReferenceData : Method to getOnGoingReportReferenceData");
		}
		
		Session session = sessionFactory.openSession();
		List<String> workYearList = null;
		List<String> workMonthList = null;
		List<String> controlGroupList = null;
		List<String> unionTypeList = null;
		List<String> employeeTypeList = null;
		OngoingReferanceDataBean ongoingReferanceDataBean = new OngoingReferanceDataBean();
		
		try{
			
			Query controlGroupQuery = session.getNamedQuery("PRC_OnGoing_ReferenceData_ControlGroup");
			ongoingReferanceDataBean.setControlGroupList(controlGroupQuery.list());
			
			Query measurementEndDateQuery = session.getNamedQuery("PRC_OnGoing_ReferenceData_MeasurementEndDate");
			ongoingReferanceDataBean.setMeasurementEndDate(measurementEndDateQuery.list());
			
			Query unionTypeQuery = session.getNamedQuery("PRC_OnGoing_ReferenceData_UnionType");
			ongoingReferanceDataBean.setUnionType(unionTypeQuery.list());
			
			
		}catch(Exception e){
			logger.error("Error while fetching data getOnGoingReportReferenceData : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: OnGoingReportDaoImpl : getOnGoingReportReferenceData : Method to getOnGoingReportReferenceData");
		}
		
		return ongoingReferanceDataBean;
	}

	@Override
	public List<OnGoingCountByWeeksVO> getOnGoingReportCountByWeek(String measurementEndDate, String avgWeeklyHours,
			String controlGroup, String typeOfHours) throws Exception {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: OnGoingReportDaoImpl : getOnGoingReportCountByWeek : Method to getOnGoingReportCountByWeek");
		}
		
		Session session = sessionFactory.openSession();
		List<OnGoingCountByWeeksVO> list = null;
		List<OnGoingCountByWeeksVO> listVO = null;
		OnGoingCountByWeeksVO onGoingCountByWeeksVO = null;
		try {
			Query query = session.getNamedQuery("PRC_OnGoing_CountByWeek");
			query.setParameter("controlGroup", controlGroup);
			query.setParameter("measurementEndDate", measurementEndDate);
			query.setParameter("avgWeeklyThreshold", avgWeeklyHours);
			query.setParameter("unionType", typeOfHours);
			list = query.list();

			listVO = new ArrayList<OnGoingCountByWeeksVO>();
			if (list != null && list.size() > 0) {
				for (Object obj : list) {
					Object[] column = (Object[]) obj;
					onGoingCountByWeeksVO = new OnGoingCountByWeeksVO();
					if (null != column[0]) {
						onGoingCountByWeeksVO.setWEEKS_WORKED((column[0].toString()));
					}
					if (null != column[1]) {
						onGoingCountByWeeksVO.setWEEKS_WORKED_COUNT((column[1].toString()));
					}
					listVO.add(onGoingCountByWeeksVO);
				}
			}
		} catch (Exception e) {
			logger.error("Error while fetching data getOnGoingReportCountByWeek : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: OnGoingReportDaoImpl : getOnGoingReportCountByWeek : Method to getOnGoingReportCountByWeek");
		}
		
		return listVO;
	}

	@Override
	public List<OnGoingReportsByWeekCountVO> getOnGoingReportData(String measurementEndDate, String avgWeeklyHours,
			String controlGroup, String typeOfHours, String reportOfWeek) throws Exception {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: OnGoingReportDaoImpl : getOnGoingReportData : Method to getOnGoingReportData");
		}
		
		Session session = sessionFactory.openSession();
		List<OnGoingReportsByWeekCountVO> list = null;
		List<OnGoingReportsByWeekCountVO> listVO = null;
		OnGoingReportsByWeekCountVO onGoingReportsByWeekCountVO = null;
		try {
			Query query = session.getNamedQuery("PRC_OnGoing_ReportsForCountByWeek");
			query.setParameter("controlGroup", controlGroup);
			query.setParameter("measurementEndDate", measurementEndDate);
			query.setParameter("avgWeeklyThreshold", avgWeeklyHours);
			query.setParameter("unionType", typeOfHours);
			query.setParameter("reportForWeek", reportOfWeek);
			list = query.list();

			listVO = new ArrayList<OnGoingReportsByWeekCountVO>();
			if (list != null && list.size() > 0) {
				for (Object o : list) {
					
					onGoingReportsByWeekCountVO = new OnGoingReportsByWeekCountVO();

					Object[] column = (Object[]) o;
					if (null != column[0]) {
						onGoingReportsByWeekCountVO.setCONTROL_GROUP((column[0].toString()));
					}
					if (null != column[1]) {
						onGoingReportsByWeekCountVO.setMOST_RECENT_PRODUCTION_COMPANY((column[1].toString()));
					}
					if (null != column[2]) {
						onGoingReportsByWeekCountVO.setMOST_RECENT_PROJECT((column[2].toString()));
					}
					if (null != column[3]) {
						onGoingReportsByWeekCountVO.setSSN_NUMBER((column[3].toString()));
					}
					if (null != column[4]) {
						onGoingReportsByWeekCountVO.setFIRST_NAME((column[4].toString()));
					}
					if (null != column[5]) {
						onGoingReportsByWeekCountVO.setLAST_NAME((column[5].toString()));
					}
					if (null != column[6]) {
						onGoingReportsByWeekCountVO.setLAST_WORKED_DATE((column[6].toString()));
					}
					if (null != column[7]) {
						onGoingReportsByWeekCountVO.setHIRE_DATE((column[7].toString()));
					}
					if (null != column[8]) {
						onGoingReportsByWeekCountVO.setUNION_NON_UNION((column[8].toString()));
					}
					if (null != column[9]) {
						onGoingReportsByWeekCountVO.setWEEKS_SINCE_LAST_WORKED((column[9].toString()));
					}
					if (null != column[10]) {
						onGoingReportsByWeekCountVO.setAVEAGE_HOURS_SMP((column[10].toString()));
					}
					if (null != column[11]) {
						onGoingReportsByWeekCountVO.setTOTAL_HOURS_WEEKS((column[11].toString()));
					}
					if (null != column[12]) {
						onGoingReportsByWeekCountVO.setEMPLOYEE_TYPE((column[12].toString()));
					}
					
					listVO.add(onGoingReportsByWeekCountVO);
				}

			}

		} catch (Exception e) {
			logger.error("Error while fetching data getOnGoingReportData : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: OnGoingReportDaoImpl : getOnGoingReportData : Method to getOnGoingReportData");
		}
		
		return listVO;
	}
	
	

}
