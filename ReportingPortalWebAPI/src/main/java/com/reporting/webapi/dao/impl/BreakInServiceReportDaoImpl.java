package com.reporting.webapi.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.reporting.webapi.bean.BreakInServiceReferanceDataBean;
import com.reporting.webapi.dao.IBreakInServiceReportDao;
import com.reporting.webapi.response.vo.BreakInReportDataVO;

@Repository
public class BreakInServiceReportDaoImpl implements IBreakInServiceReportDao {

private final Logger logger = Logger.getLogger(BreakInServiceReportDaoImpl.class);
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@SuppressWarnings({"unchecked" })
	@Override
	public BreakInServiceReferanceDataBean getBreakInServiceReportReferenceData() throws Exception {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: BreakInServiceReportDaoImpl : getBreakInServiceReportReferenceData : Method to getBreakInServiceReportReferenceData");
		}
		
		Session session = sessionFactory.openSession();
		BreakInServiceReferanceDataBean breakInServiceReferanceDataBean = new BreakInServiceReferanceDataBean();
		
		try{
			Query workYearQuery = session.getNamedQuery("PRC_BreakIn_ReferenceData_WorkYear");
			breakInServiceReferanceDataBean.setWorkYearList(workYearQuery.list());
			
			Query controlGroupQuery = session.getNamedQuery("PRC_BreakIn_ReferenceData_ControlGroup");
			breakInServiceReferanceDataBean.setControlGroupList(controlGroupQuery.list());
			
			Query weekStartingQuery = session.getNamedQuery("PRC_BreakIn_ReferenceData_Week_Starting");
			breakInServiceReferanceDataBean.setWeekStarting(weekStartingQuery.list());
			
			Query weekEndingQuery = session.getNamedQuery("PRC_BreakIn_ReferenceData_Week_Ending");
			breakInServiceReferanceDataBean.setWeekEnding(weekEndingQuery.list());
			
		}catch(Exception e){
			logger.error("Error while fetching data getBreakInServiceReportReferenceData : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: BreakInServiceReportDaoImpl : getBreakInServiceReportReferenceData : Method to getBreakInServiceReportReferenceData");
		}
		
		return breakInServiceReferanceDataBean;
	}


	@Override
	public List<BreakInReportDataVO> getBreakInReportData(String workYear,String controlGroup,String weekStarting,String weekEnding) throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("START :: BreakInServiceReportDaoImpl : getBreakInReportData : Method to getBreakInReportData");
		}
		
		Session session = sessionFactory.openSession();
		BreakInReportDataVO breakInReportDataVO = null;
		List<BreakInReportDataVO> listVo = null;
		try{
			Query query = session.getNamedQuery("PRC_BreakInService_ReportData");
			query.setParameter("workYear", workYear);
			query.setParameter("controlGroup", controlGroup);
			query.setParameter("weekStarting", weekStarting);
			query.setParameter("weekEnding", weekEnding);
			List<?> list = query.list();
			
			listVo = new ArrayList<BreakInReportDataVO>();
			if (list != null && list.size() > 0) {
			Iterator<?> iterator = list.iterator();
			while(iterator.hasNext()){
				Object column[] = (Object[])iterator.next();
				breakInReportDataVO = new BreakInReportDataVO();
				if (null != column[0]) {
					breakInReportDataVO.setFirstName((column[0].toString()));
				}
				if (null != column[1]) {
					breakInReportDataVO.setLastName((column[1].toString()));
				}
				if (null != column[2]) {
					breakInReportDataVO.setSsn((column[2].toString()));
				}
				if (null != column[3]) {
					breakInReportDataVO.setServiceStatus((column[3].toString()));
				}
				if (null != column[4]) {
					breakInReportDataVO.setWeekStarting((column[4].toString()));
				}
				if (null != column[5]) {
					breakInReportDataVO.setWeekEnding((column[5].toString()));
				}
				if (null != column[6]) {
					breakInReportDataVO.setWeekCount((column[6].toString()));
				}
				if (null != column[7]) {
					breakInReportDataVO.setControlGroup((column[7].toString()));
				}
				listVo.add(breakInReportDataVO);
			}
			}else{
				listVo=null;
			}
			
		}catch(Exception e){
			
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: BreakInServiceReportDaoImpl : getBreakInReportData : Method to getBreakInReportData");
		}
		
		return listVo;
	}
	
}
