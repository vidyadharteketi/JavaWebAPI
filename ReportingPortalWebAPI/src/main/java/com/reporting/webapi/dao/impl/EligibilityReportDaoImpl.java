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

import com.reporting.webapi.bean.EligibilityServiceReferanceDataBean;
import com.reporting.webapi.dao.IEligibilityReportDao;
import com.reporting.webapi.response.vo.EligibilityReportDataVO;

@Repository
public class EligibilityReportDaoImpl implements IEligibilityReportDao{
	
	private final Logger logger = Logger.getLogger(EligibilityReportDaoImpl.class);

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public EligibilityServiceReferanceDataBean getEligibilityServiceReferenceData() throws Exception {

		if(logger.isDebugEnabled()){
			logger.debug("START :: DemographicsReportDaoImpl : getEligibilityServiceReferenceData : Method to getEligibilityServiceReferenceData");
		}
		
		Session session = sessionFactory.openSession();
		EligibilityServiceReferanceDataBean eligibilityServiceReferanceDataBean = new EligibilityServiceReferanceDataBean();
		
		try{
			Query workYearQuery = session.getNamedQuery("PRC_Eligibility_ReferenceData_WorkYear");
			eligibilityServiceReferanceDataBean.setWorkYearList(workYearQuery.list());
			
			Query controlGroupQuery = session.getNamedQuery("PRC_Eligibility_ReferenceData_ControlGroup");
			eligibilityServiceReferanceDataBean.setControlGroupList(controlGroupQuery.list());
			
			Query unionStatusQuery = session.getNamedQuery("PRC_Eligibility_ReferenceData_Union_Status");
			eligibilityServiceReferanceDataBean.setUnionStatus(unionStatusQuery.list());
			
			Query typeOfHoursQuery = session.getNamedQuery("PRC_Eligibility_ReferenceData_Type_Of_Hours");
			eligibilityServiceReferanceDataBean.setTypeOfHours(typeOfHoursQuery.list());
			
		}catch(Exception e){
			logger.error("Error while fetching data getEligibilityServiceReferenceData : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: DemographicsReportDaoImpl : getEligibilityServiceReferenceData : Method to getEligibilityServiceReferenceData");
		}
		
		return eligibilityServiceReferanceDataBean;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<EligibilityReportDataVO> getEligibilityReportData(String workYear,String controlGroup,String unionStatus,String typeOfHours) throws Exception {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: EligibilityReportDaoImpl : getEligibilityReportReferenceData : Method to getEligibilityReportReferenceData");
		}
		
		Session session = sessionFactory.openSession();
		EligibilityReportDataVO eligibilityReportDataVO = null;
		List<EligibilityReportDataVO> listVo = null;
		try{
			Query query = session.getNamedQuery("PRC_Eligibility_ReportData");
			query.setParameter("workYear", workYear);
			query.setParameter("controlGroup", controlGroup);
			query.setParameter("unionStatus", unionStatus);
			query.setParameter("typeOfHours", typeOfHours);
			List<?> list = query.list();
			
			listVo = new ArrayList<EligibilityReportDataVO>();
			if (list != null && list.size() > 0) {
			Iterator<?> iterator = list.iterator();
			while(iterator.hasNext()){
				Object column[] = (Object[])iterator.next();
				eligibilityReportDataVO = new EligibilityReportDataVO();
				if (null != column[0]) {
					eligibilityReportDataVO.setEmployeeName((column[0].toString()) + " ");
				}
				if(null != column[1]) {
					eligibilityReportDataVO.setEmployeeName(eligibilityReportDataVO.getEmployeeName() + (column[1].toString()));
				}
				if (null != column[2]) {
					eligibilityReportDataVO.setUnionStatus((column[2].toString()));
				}
				if (null != column[3]) {
					eligibilityReportDataVO.setSsn((column[3].toString()));
				}
				if (null != column[4]) {
					eligibilityReportDataVO.setMostRecentShow((column[4].toString()));
				}
				if (null != column[5]) {
					eligibilityReportDataVO.setMostRecentJobTitle((column[5].toString()));
				}
				if (null != column[6]) {
					eligibilityReportDataVO.setAverageWeeklyHours((column[6].toString()));
				}
				if (null != column[7]) {
					eligibilityReportDataVO.setTotalHours((column[7].toString()));
				}
				if (null != column[8]) {
					eligibilityReportDataVO.setStandardMeasuredEligibility((column[8].toString()));
				}
				if (null != column[9]) {
					eligibilityReportDataVO.setBenefitsEffective((column[9].toString()));
				}
				if (null != column[10]) {
					eligibilityReportDataVO.setControlGroup((column[10].toString()));
				}
				if (null != column[11]) {
					eligibilityReportDataVO.setWorkYear((column[11].toString()));
				}
				listVo.add(eligibilityReportDataVO);
			}
			}else{
				listVo=null;
			}
			
			
		}catch(Exception e){
			
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: EligibilityReportDaoImpl : getEligibilityReportReferenceData : Method to getEligibilityReportReferenceData");
		}
		
		return listVo;
	}
	
}
