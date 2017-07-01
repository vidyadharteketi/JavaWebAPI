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

import com.reporting.webapi.bean.DemoGraphicsServiceReferanceDataBean;
import com.reporting.webapi.dao.IDemographicsReportDao;
import com.reporting.webapi.response.vo.DemoGraphicsReportDataVO;

@Repository
public class DemographicsReportDaoImpl implements IDemographicsReportDao{
	
	private final Logger logger = Logger.getLogger(DemographicsReportDaoImpl.class);
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public DemoGraphicsServiceReferanceDataBean getDemographicsServiceReferenceData() throws Exception {

		if(logger.isDebugEnabled()){
			logger.debug("START :: DemographicsReportDaoImpl : getDemographicsServiceReferenceData : Method to getDemographicsServiceReferenceData");
		}
		
		Session session = sessionFactory.openSession();
		DemoGraphicsServiceReferanceDataBean demoGraphicsServiceReferanceDataBean = new DemoGraphicsServiceReferanceDataBean();
		
		try{
			Query workYearQuery = session.getNamedQuery("PRC_Demographics_ReferenceData_WorkYear");
			demoGraphicsServiceReferanceDataBean.setWorkYearList(workYearQuery.list());
			
			Query controlGroupQuery = session.getNamedQuery("PRC_Demographics_ReferenceData_ControlGroup");
			demoGraphicsServiceReferanceDataBean.setControlGroupList(controlGroupQuery.list());
			
			Query parentCompanyQuery = session.getNamedQuery("PRC_Demographics_ReferenceData_Parent_Company");
			demoGraphicsServiceReferanceDataBean.setParentCompany(parentCompanyQuery.list());
			
			Query productionCompanyQuery = session.getNamedQuery("PRC_Demographics_ReferenceData_Production_Company");
			demoGraphicsServiceReferanceDataBean.setProductionCompany(productionCompanyQuery.list());
			
			Query payrollCompanyQuery = session.getNamedQuery("PRC_Demographics_ReferenceData_Payroll_Company");
			demoGraphicsServiceReferanceDataBean.setPayrollCompany(payrollCompanyQuery.list());
			
		}catch(Exception e){
			logger.error("Error while fetching data getDemographicsServiceReferenceData : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: DemographicsReportDaoImpl : getDemographicsServiceReferenceData : Method to getDemographicsServiceReferenceData");
		}
		
		return demoGraphicsServiceReferanceDataBean;
	}
	

	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	public List<DemoGraphicsReportDataVO> getDemographicsReportData(String workYear,String controlGroup,String parentCompnay,String proudctioncompany,String payrollCompany) throws Exception {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: DemographicsReportDaoImpl : getDemographicsReportData : Method to getDemographicsReportData");
		}
		
		Session session = sessionFactory.openSession();
		DemoGraphicsReportDataVO demoGraphicsReportDataVO = null;
		List<DemoGraphicsReportDataVO> listVo = null;
		try{
			Query query = session.getNamedQuery("PRC_Demographics_ReportData");
			query.setParameter("workYear", workYear);
			query.setParameter("controlGroup", controlGroup);
			query.setParameter("parentCompnay", parentCompnay);
			query.setParameter("proudctioncompany", proudctioncompany);
			query.setParameter("payrollCompany", payrollCompany);
			
			
			List<?> list = query.list();
			
			listVo = new ArrayList<DemoGraphicsReportDataVO>();
			if (list != null && list.size() > 0) {
			Iterator<?> iterator = list.iterator();
			while(iterator.hasNext()){
				Object column[] = (Object[])iterator.next();
				demoGraphicsReportDataVO = new DemoGraphicsReportDataVO();
				if (null != column[0]) {
					demoGraphicsReportDataVO.setParentCompany((column[0].toString()));
				}
				if (null != column[1]) {
					demoGraphicsReportDataVO.setProductionCompany((column[1].toString()));
				}
				if (null != column[2]) {
					demoGraphicsReportDataVO.setShowName((column[2].toString()));
				}
				if (null != column[3]) {
					demoGraphicsReportDataVO.setPayrollCompany((column[3].toString()));
				}
				if (null != column[4]) {
					demoGraphicsReportDataVO.setEmployeeName((column[4].toString()+" "+column[5].toString()));
				}
				if (null != column[6]) {
					demoGraphicsReportDataVO.setUnionStatus((column[6].toString()));
				}
				if (null != column[7]) {
					demoGraphicsReportDataVO.setSsn((column[7].toString()));
				}
				if (null != column[8]) {
					demoGraphicsReportDataVO.setaCAEmploymentBasis((column[8].toString()));
				}
				if (null != column[9]) {
					demoGraphicsReportDataVO.setScheduleCode((column[9].toString()));
				}
				if (null != column[10]) {
					demoGraphicsReportDataVO.setPayRate((column[10].toString()));
				}
				if (null != column[11]) {
					demoGraphicsReportDataVO.setJobDescription((column[11].toString()));
				}
				if (null != column[12]) {
					demoGraphicsReportDataVO.setGender((column[12].toString()));
				}
				if (null != column[13]) {
					demoGraphicsReportDataVO.setDateOfBirth((column[13].toString()));
				}
				if (null != column[14]) {
					demoGraphicsReportDataVO.setEmail((column[14].toString()));
				}
				if (null != column[15]) {
					demoGraphicsReportDataVO.setAddress((column[15].toString()));
				}
				if (null != column[16]) {
					demoGraphicsReportDataVO.setCity((column[16].toString()));
				}
				if (null != column[17]) {
					demoGraphicsReportDataVO.setState((column[17].toString()));
				}
				if (null != column[18]) {
					demoGraphicsReportDataVO.setZip((column[18].toString()));
				}
				if (null != column[19]) {
					demoGraphicsReportDataVO.setControlGroup((column[19].toString()));
				}
				listVo.add(demoGraphicsReportDataVO);
			}
			}else{
				listVo=null;
			}
			
			
		}catch(Exception e){
			
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: DemographicsReportDaoImpl : getDemographicsReportData : Method to getDemographicsReportData");
		}
		
		return listVo;
	}

	

}
