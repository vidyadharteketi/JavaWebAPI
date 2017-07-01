package com.reporting.webapi.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.reporting.webapi.adapter.INewHiresNonFullTimeReportAdapter;
import com.reporting.webapi.bean.NewHireNonFullTimeReferanceDataBean;
import com.reporting.webapi.response.vo.NewHireNonFullTimeReferenceDataVO;
import com.reporting.webapi.response.vo.ReportCountByWeekVO;
import com.reporting.webapi.response.vo.ReportsByWeeksCountVO;
import com.reporting.webapi.responsewrapper.vo.CustomNewHireNonFullTimeVO;
import com.reporting.webapi.responsewrapper.vo.CustomReportCountByWeekVO;
import com.reporting.webapi.responsewrapper.vo.CustomReportsByWeekCountVO;
import com.reporting.webapi.util.CommonConstants;
import com.reporting.webapi.util.ReportsExcelBuilderUtil;

@Component
@Path(value=CommonConstants.NEW_HIRES_NON_FULL_TIME_SERVICE)
public class NewHiresNonFullTimeReportService {
	
	private final Logger logger = Logger.getLogger(NewHiresNonFullTimeReportService.class);
	
	@Autowired
	private INewHiresNonFullTimeReportAdapter newHiresNonFullTimeReportAdapter;
	
	@Autowired
	private ReportsExcelBuilderUtil reportsExcelBuilderUtil;
	
	@Path(CommonConstants.NEW_HIRES_NON_FULL_TIME_SERVICE_REFERENCE_DATA)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response getNewHiresNonFullTimeReportReferenceData() {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: NewHiresNonFullTimeReportService : getNewHiresNonFullTimeReportReferenceData : Method to getNewHiresNonFullTimeReportReferenceData");
		}
		
		CustomNewHireNonFullTimeVO customNewHireNonFullTimeVO = new CustomNewHireNonFullTimeVO();
		try{
			NewHireNonFullTimeReferanceDataBean newHireNonFullTimeReferanceData = newHiresNonFullTimeReportAdapter.getNewHiresNonFullTimeReportReferenceData();
			
			NewHireNonFullTimeReferenceDataVO newHireNonFullTimeReferenceDataVO =  new NewHireNonFullTimeReferenceDataVO();
			newHireNonFullTimeReferenceDataVO.setWorkYears(newHireNonFullTimeReferanceData.getWorkYearList());
			newHireNonFullTimeReferenceDataVO.setWorkMonths(newHireNonFullTimeReferanceData.getWorkMonthList());
			newHireNonFullTimeReferenceDataVO.setControlgroups(newHireNonFullTimeReferanceData.getControlGroupList());
			newHireNonFullTimeReferenceDataVO.setUnionTypes(newHireNonFullTimeReferanceData.getUnionTypeList());
			newHireNonFullTimeReferenceDataVO.setEmployeeTypes(newHireNonFullTimeReferanceData.getEmployeeTypeList());
			
			customNewHireNonFullTimeVO.setEligibilityNewHiresNonFullTimeReferenceData(newHireNonFullTimeReferenceDataVO);
			
		} catch (Exception e) {
			logger.error("Error while invoking getNewHiresNonFullTimeReportReferenceData : " + e.getMessage());
		}
		
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: NewHiresNonFullTimeReportService : getNewHiresNonFullTimeReportReferenceData : Method to getNewHiresNonFullTimeReportReferenceData");
		}
		
		return Response.ok(customNewHireNonFullTimeVO).build();
	}
	
	@Path(CommonConstants.NEW_HIRES_NON_FULL_TIME_SERVICE_COUNT_BY_WEEK)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response getNewHiresNonFullTimeCountByWeek(@QueryParam(CommonConstants.WORK_YEAR) String workYear, @QueryParam(CommonConstants.WORK_MONTH) String workMonth,
			@QueryParam(CommonConstants.CONTROL_GROUP) String controlGroup, @QueryParam(CommonConstants.UNION_TYPE) String unionType,
			@QueryParam(CommonConstants.EMPLOYEE_TYPE) String employeeType) {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: NewHiresNonFullTimeReportService : getNewHiresNonFullTimeCountByWeek : Method to getNewHiresNonFullTimeCountByWeek");
		}
		
		CustomReportCountByWeekVO customReportCountByWeekVO = new CustomReportCountByWeekVO();
		List<ReportCountByWeekVO> reportCountByWeek = null;
		try{
			
			if(null != workYear && workYear.contains("''") &&  workYear.length() == 2) {
				workYear = null;
			}
			if(null != workMonth && workMonth.contains("''") &&  workMonth.length() == 2) {
				workMonth = null;
			}
			if(null != controlGroup && controlGroup.contains("''") &&  controlGroup.length() == 2) {
				controlGroup = null;
			}
			if(null != unionType && unionType.contains("''") &&  unionType.length() == 2) {
				unionType = null;
			}
			if(null != employeeType && employeeType.contains("''") &&  employeeType.length() == 2) {
				employeeType = null;
			}
			
			reportCountByWeek =  newHiresNonFullTimeReportAdapter.getNewHiresNonFullTimeCountByWeek(workYear,workMonth,controlGroup,
					unionType,employeeType);
			customReportCountByWeekVO.setReportCountByWeek(reportCountByWeek);
		} catch (Exception e) {
			logger.error("Error while invoking getNewHiresNonFullTimeCountByWeek : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: NewHiresNonFullTimeReportService : getNewHiresNonFullTimeCountByWeek : Method to getNewHiresNonFullTimeCountByWeek");
		}
		
		return Response.ok(customReportCountByWeekVO).build();
	}
	
	@Path(CommonConstants.NEW_HIRES_NON_FULL_TIME_SERVICE_REPORT_DATA)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response getNewHiresNonFullTimeReportData(@QueryParam(CommonConstants.WORK_YEAR) String workYear, @QueryParam(CommonConstants.WORK_MONTH) String workMonth,
			@QueryParam(CommonConstants.CONTROL_GROUP) String controlGroup, @QueryParam(CommonConstants.UNION_TYPE) String unionType,
			@QueryParam(CommonConstants.EMPLOYEE_TYPE) String employeeType,@QueryParam(CommonConstants.REPORT_OF_WEEK) String reportOfWeek) {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: NewHiresNonFullTimeReportService : getNewHiresNonFullTimeReportData : Method to getNewHiresNonFullTimeReportData");
		}
		
		CustomReportsByWeekCountVO customReportsByWeekCountVO = new CustomReportsByWeekCountVO();
		List<ReportsByWeeksCountVO> reportByWeeksCount = null;
		try{
			
			if(null != workYear && workYear.contains("''") &&  workYear.length() == 2) {
				workYear = null;
			}
			if(null != workMonth && workMonth.contains("''") &&  workMonth.length() == 2) {
				workMonth = null;
			}
			if(null != controlGroup && controlGroup.contains("''") &&  controlGroup.length() == 2) {
				controlGroup = null;
			}
			if(null != unionType && unionType.contains("''") &&  unionType.length() == 2) {
				unionType = null;
			}
			if(null != employeeType && employeeType.contains("''") &&  employeeType.length() == 2) {
				employeeType = null;
			}
			if(null != reportOfWeek && reportOfWeek.contains("''") &&  reportOfWeek.length() == 2) {
				reportOfWeek = null;
			}
			
			reportByWeeksCount =  newHiresNonFullTimeReportAdapter.getNewHiresNonFullTimeReportData(workYear,workMonth,controlGroup,
					unionType,employeeType,reportOfWeek);
			customReportsByWeekCountVO.setReportByWeekCount(reportByWeeksCount);
		} catch (Exception e) {
			logger.error("Error while invoking getNewHiresNonFullTimeReportData : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: NewHiresNonFullTimeReportService : getNewHiresNonFullTimeReportData : Method to getNewHiresNonFullTimeReportData");
		}
		
		return Response.ok(customReportsByWeekCountVO).build();
	}
	
	@Path(CommonConstants.NEW_HIRES_NON_FULL_TIME_SERVICE_PROCESS_EXCEL_ZIP_DOWNLOAD)
	@GET
	@Produces(CommonConstants.APPLICATION_ZIP)
	public Response processNewHireNonFullTimeExcelUpload(@QueryParam(CommonConstants.WORK_YEAR) String workYear, @QueryParam(CommonConstants.WORK_MONTH) String workMonth,
			@QueryParam(CommonConstants.CONTROL_GROUP) String controlGroup, @QueryParam(CommonConstants.UNION_TYPE) String unionType,
			@QueryParam(CommonConstants.EMPLOYEE_TYPE) String employeeType,@QueryParam(CommonConstants.REPORT_OF_WEEK) String reportOfWeek) {
		
		List<ReportsByWeeksCountVO> reportByWeeksCount = null;
		String generatedReportsPath = "";
		try{
			
			if(null != workYear && workYear.contains("''") &&  workYear.length() == 2) {
				workYear = null;
			}
			if(null != workMonth && workMonth.contains("''") &&  workMonth.length() == 2) {
				workMonth = null;
			}
			if(null != controlGroup && controlGroup.contains("''") &&  controlGroup.length() == 2) {
				controlGroup = null;
			}
			if(null != unionType && unionType.contains("''") &&  unionType.length() == 2) {
				unionType = null;
			}
			if(null != employeeType && employeeType.contains("''") &&  employeeType.length() == 2) {
				employeeType = null;
			}
			if(null != reportOfWeek && reportOfWeek.contains("''") &&  reportOfWeek.length() == 2) {
				reportOfWeek = null;
			}
			
			reportByWeeksCount =  newHiresNonFullTimeReportAdapter.getNewHiresNonFullTimeReportData(workYear,workMonth,controlGroup,
					unionType,employeeType,reportOfWeek);
			
			// Code To Invoke Excel Builder 
			Map<String, List<?>> reportsDataMap = new HashMap<>();
			reportsDataMap.put(CommonConstants.NEW_HIRES_NON_FULL_TIME_REPORTS, reportByWeeksCount);
			
			NewHireNonFullTimeReferanceDataBean newHireNonFullTimeReferanceData = newHiresNonFullTimeReportAdapter.getNewHiresNonFullTimeReportReferenceData();
			List<String> controlGroupList = newHireNonFullTimeReferanceData.getControlGroupList();
			
			generatedReportsPath = reportsExcelBuilderUtil.buildExcelDocument(reportsDataMap, controlGroupList, workYear, workMonth, controlGroup,
					unionType, employeeType, reportOfWeek);
			
			
		} catch (Exception e) {
			logger.error("Error while invoking : " + e.getMessage());
		}
		File downloadDocumentFile = new File(generatedReportsPath + ".zip");
		String buildZipFilename = "NewHireNonFullTimeReports_" + generatedReportsPath.substring(generatedReportsPath.lastIndexOf("/")+1, generatedReportsPath.length()) + ".zip";
		ResponseBuilder responseBuilder = Response.ok((Object) downloadDocumentFile);
        responseBuilder.header("Content-Disposition", "attachment; filename=" + buildZipFilename );
		return responseBuilder.build();
	}

}
