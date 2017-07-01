package com.reporting.webapi.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.reporting.webapi.bean.NewHireNonFullTimeReferanceDataBean;
import com.reporting.webapi.dao.INewHiresNonFullTimeReportDao;
import com.reporting.webapi.response.vo.ReportCountByWeekVO;
import com.reporting.webapi.response.vo.ReportsByWeeksCountVO;

@Repository
public class NewHiresNonFullTimeReportDaoImpl implements INewHiresNonFullTimeReportDao {
	
	private final Logger logger = Logger.getLogger(NewHiresNonFullTimeReportDaoImpl.class);

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public NewHireNonFullTimeReferanceDataBean getNewHiresNonFullTimeReportReferenceData() throws Exception{
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: NewHiresNonFullTimeReportDaoImpl : getNewHiresNonFullTimeReportReferenceData : Method to getNewHiresNonFullTimeReportReferenceData");
		}
		
		Session session = sessionFactory.openSession();
		List<String> workYearList = null;
		List<String> workMonthList = null;
		List<String> controlGroupList = null;
		List<String> unionTypeList = null;
		List<String> employeeTypeList = null;
		NewHireNonFullTimeReferanceDataBean newHireNonFullTimeReferanceData = new NewHireNonFullTimeReferanceDataBean();
		
		try{
			Query workYearQuery = session.getNamedQuery("PRC_NewHiresNonFullTime_ReferenceData_WorkYear");
			newHireNonFullTimeReferanceData.setWorkYearList(workYearQuery.list());
			
			Query workMonthrQuery = session.getNamedQuery("PRC_NewHiresNonFullTime_ReferenceData_WorkMonth");
			newHireNonFullTimeReferanceData.setWorkMonthList(workMonthrQuery.list());
			
			Query controlGroupQuery = session.getNamedQuery("PRC_NewHiresNonFullTime_ReferenceData_ControlGroup");
			newHireNonFullTimeReferanceData.setControlGroupList(controlGroupQuery.list());
			
			Query unionTypeQuery = session.getNamedQuery("PRC_NewHiresNonFullTime_ReferenceData_UnionType");
			newHireNonFullTimeReferanceData.setUnionTypeList(unionTypeQuery.list());
			
			Query employeeTypeQuery = session.getNamedQuery("PRC_NewHiresNonFullTime_ReferenceData_EmployeeType");
			newHireNonFullTimeReferanceData.setEmployeeTypeList(employeeTypeQuery.list());
			
		}catch(Exception e){
			logger.error("Error while fetching data getNewHiresNonFullTimeReportReferenceData : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: NewHiresNonFullTimeReportDaoImpl : getNewHiresNonFullTimeReportReferenceData : Method to getNewHiresNonFullTimeReportReferenceData");
		}
		return newHireNonFullTimeReferanceData;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReportCountByWeekVO> getNewHiresNonFullTimeCountByWeek(String workYear,String workMonth,String controlGroup,
			String unionType, String employeeType) throws Exception {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: NewHiresNonFullTimeReportDaoImpl : getNewHiresNonFullTimeCountByWeek : Method to getNewHiresNonFullTimeCountByWeek");
		}
		
		Session session = sessionFactory.openSession();
		List<ReportCountByWeekVO> list = null;
		List<ReportCountByWeekVO> listVo = null;
		ReportCountByWeekVO reportCountByWeekVO = null;
		try {
			Query query = session.getNamedQuery("PRC_NewHiresNonFullTime_ReportCountByWeek");
			query.setParameter("workYear", workYear);
			query.setParameter("workMonth", workMonth);
			query.setParameter("controlGroup", controlGroup);
			query.setParameter("unionType", unionType);
			query.setParameter("employeeType", employeeType);
			list = query.list();

			listVo = new ArrayList<ReportCountByWeekVO>();
			if (list != null && list.size() > 0) {
				for (Object o : list) {
					
					System.out.println(o.toString());
					
					reportCountByWeekVO = new ReportCountByWeekVO();

					Object[] column = (Object[]) o;
					if (null != column[0]) {
						reportCountByWeekVO.setWEEKS_WORKED((column[0].toString()));
					}
					if (null != column[1]) {
						reportCountByWeekVO.setWEEKS_WORKED_COUNT((column[1].toString()));
					}
					listVo.add(reportCountByWeekVO);
				}

			}

		} catch (Exception e) {
			logger.error("Error while fetching data getNewHiresNonFullTimeCountByWeek : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: NewHiresNonFullTimeReportDaoImpl : getNewHiresNonFullTimeCountByWeek : Method to getNewHiresNonFullTimeCountByWeek");
		}
		
		return listVo;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ReportsByWeeksCountVO> getNewHiresNonFullTimeReportData(String workYear, String workMonth, String controlGroup,
			String unionType, String employeeType, String reportOfWeek) throws Exception {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: NewHiresNonFullTimeReportDaoImpl : getNewHiresNonFullTimeReportData : Method to getNewHiresNonFullTimeReportData");
		}
		
		Session session = sessionFactory.openSession();
		List<ReportsByWeeksCountVO> list = null;
		List<ReportsByWeeksCountVO> listVo = null;
		ReportsByWeeksCountVO reportsByWeeksCountVO = null;
		try {
			Query query = session.getNamedQuery("PRC_NewHiresNonFullTime_ReportByWeeksCount");
			query.setParameter("workYear", workYear);
			query.setParameter("workMonth", workMonth);
			query.setParameter("controlGroup", controlGroup);
			query.setParameter("unionType", unionType);
			query.setParameter("employeeType", employeeType);
			query.setParameter("reportOfWeek", reportOfWeek);
			list = query.list();

			listVo = new ArrayList<ReportsByWeeksCountVO>();
			if (list != null && list.size() > 0) {
				for (Object o : list) {
					
					reportsByWeeksCountVO = new ReportsByWeeksCountVO();

					Object[] column = (Object[]) o;
					if (null != column[0]) {
						reportsByWeeksCountVO.setCONTROL_GROUP((column[0].toString()));
					}
					if (null != column[1]) {
						reportsByWeeksCountVO.setWORK_YEAR((column[1].toString()));
					}
					if (null != column[2]) {
						reportsByWeeksCountVO.setWORK_MONTH((column[2].toString()));
					}
					if (null != column[3]) {
						reportsByWeeksCountVO.setMOST_RECENT_PRODUCTION_COMPANY((column[3].toString()));
					}
					if (null != column[4]) {
						reportsByWeeksCountVO.setMOST_RECENT_PROJECT((column[4].toString()));
					}
					if (null != column[5]) {
						reportsByWeeksCountVO.setSSN_NUMBER((column[5].toString()));
					}
					if (null != column[6]) {
						reportsByWeeksCountVO.setFIRST_NAME((column[6].toString()));
					}
					if (null != column[7]) {
						reportsByWeeksCountVO.setLAST_NAME((column[7].toString()));
					}
					if (null != column[8]) {
						reportsByWeeksCountVO.setLAST_WORKED_DATE((column[8].toString()));
					}
					if (null != column[9]) {
						reportsByWeeksCountVO.setHIRE_DATE((column[9].toString()));
					}
					if (null != column[10]) {
						reportsByWeeksCountVO.setUNION_NON_UNION((column[10].toString()));
					}
					if (null != column[11]) {
						reportsByWeeksCountVO.setPAYROLL_SOURCE((column[11].toString()));
					}
					if (null != column[12]) {
						reportsByWeeksCountVO.setAVERAGE_HOURS((column[12].toString()));
					}
					if (null != column[13]) {
						reportsByWeeksCountVO.setTOTAL_HOURS_WEEKS((column[13].toString()));
					}
					if (null != column[14]) {
						reportsByWeeksCountVO.setEMPLOYEE_TYPE((column[14].toString()));
					}
					
					listVo.add(reportsByWeeksCountVO);
				}

			}

		} catch (Exception e) {
			logger.error("Error while fetching data getNewHiresNonFullTimeReportData : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: NewHiresNonFullTimeReportDaoImpl : getNewHiresNonFullTimeReportData : Method to getNewHiresNonFullTimeReportData");
		}
		
		return listVo;
	}
}
