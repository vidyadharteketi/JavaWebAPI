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

import com.reporting.webapi.adapter.INewHiresFullTimeReportAdapter;
import com.reporting.webapi.bean.NewHireFullTimeReferanceDataBean;
import com.reporting.webapi.response.vo.NewHireFullTimeReferenceDataVO;
import com.reporting.webapi.response.vo.ReportsByACAEligibleCountVO;
import com.reporting.webapi.response.vo.SummaryCountForNewHireFullTimeVO;
import com.reporting.webapi.responsewrapper.vo.CustomNewHireFullTimeVO;
import com.reporting.webapi.responsewrapper.vo.CustomReportByACAEligibleCountVO;
import com.reporting.webapi.responsewrapper.vo.CustomSummaryCountForNewHireFullTimeVO;
import com.reporting.webapi.util.CommonConstants;
import com.reporting.webapi.util.ReportsExcelBuilderUtil;

@Component
@Path(value=CommonConstants.NEW_HIRES_FULL_TIME_SERVICE)
public class NewHiresFullTimeReportService {
	
private final Logger logger = Logger.getLogger(NewHiresFullTimeReportService.class);
	
	@Autowired
	private INewHiresFullTimeReportAdapter newHiresFullTimeReportAdapter;
	
	@Autowired
	private ReportsExcelBuilderUtil reportsExcelBuilderUtil;

	@Path(CommonConstants.NEW_HIRES_FULL_TIME_SERVICE_REFERENCE_DATA)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response getNewHiresFullTimeReportReferenceData() {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: NewHiresFullTimeReportService : getNewHiresFullTimeReportReferenceData : Method to getNewHiresFullTimeReportReferenceData");
		}
		
		CustomNewHireFullTimeVO customNewHireNonFullTimeVO = new CustomNewHireFullTimeVO();
		try{
			NewHireFullTimeReferanceDataBean newHireNonFullTimeReferanceData = newHiresFullTimeReportAdapter.getNewHiresFullTimeReportReferenceData();
			
			NewHireFullTimeReferenceDataVO newHireFullTimeReferenceDataVO =  new NewHireFullTimeReferenceDataVO();
			newHireFullTimeReferenceDataVO.setWorkYears(newHireNonFullTimeReferanceData.getWorkYearList());
			newHireFullTimeReferenceDataVO.setWorkMonths(newHireNonFullTimeReferanceData.getHireMonthList());
			newHireFullTimeReferenceDataVO.setControlgroups(newHireNonFullTimeReferanceData.getControlGroupList());
			
			customNewHireNonFullTimeVO.setEligibilityNewHiresFullTimeReferenceData(newHireFullTimeReferenceDataVO);
			
		} catch (Exception e) {
			logger.error("Error while invoking getNewHiresFullTimeReportReferenceData : " + e.getMessage());
		}	
		if(logger.isDebugEnabled()){
			logger.debug("END :: NewHiresFullTimeReportService : getNewHiresFullTimeReportReferenceData : Method to getNewHiresFullTimeReportReferenceData");
		}
		
		return Response.ok(customNewHireNonFullTimeVO).build();
	}
	
	@Path(CommonConstants.NEW_HIRES_FULL_TIME_SERVICE_COUNT_BY_WEEK)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response getNewHiresFullTimeCountByWeek(@QueryParam(CommonConstants.WORK_YEAR) String workYear, @QueryParam(CommonConstants.WORK_MONTH) String workMonth,
			@QueryParam(CommonConstants.CONTROL_GROUP) String controlGroup) {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: NewHiresFullTimeReportService : getNewHiresFullTimeCountByWeek : Method to getNewHiresFullTimeCountByWeek");
		}
		
		CustomSummaryCountForNewHireFullTimeVO customSummaryCountForNewHireFullTimeVO = new CustomSummaryCountForNewHireFullTimeVO();
		List<SummaryCountForNewHireFullTimeVO> summaryCountForNewHireFullTime = null;
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
			
			summaryCountForNewHireFullTime =  newHiresFullTimeReportAdapter.getNewHiresFullTimeCountByWeek(workYear,workMonth,controlGroup);
			customSummaryCountForNewHireFullTimeVO.setSummaryCountForNewHireFullTimeVO(summaryCountForNewHireFullTime);
		} catch (Exception e) {
			logger.error("Error while invoking getNewHiresFullTimeCountByWeek : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: NewHiresFullTimeReportService : getNewHiresFullTimeCountByWeek : Method to getNewHiresFullTimeCountByWeek");
		}
		
		return Response.ok(customSummaryCountForNewHireFullTimeVO).build();
	}
	
	@Path(CommonConstants.NEW_HIRES_FULL_TIME_SERVICE_REPORT_DATA)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response getNewHiresFullTimeReportData(@QueryParam(CommonConstants.WORK_YEAR) String workYear, @QueryParam(CommonConstants.WORK_MONTH) String workMonth,
			@QueryParam(CommonConstants.CONTROL_GROUP) String controlGroup,@QueryParam(CommonConstants.ACA_ELIGIBLE_COUNT) String acaEligibleCount) {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: NewHiresFullTimeReportService : getNewHiresFullTimeReportData : Method to getNewHiresFullTimeReportData");
		}
		
		CustomReportByACAEligibleCountVO customReportByACAEligibleCountVO = new CustomReportByACAEligibleCountVO();
		List<ReportsByACAEligibleCountVO> reportsByACAEligibleCountVO = null;
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
			if(null != acaEligibleCount && acaEligibleCount.contains("''") &&  acaEligibleCount.length() == 2) {
				acaEligibleCount = null;
			}
			
			reportsByACAEligibleCountVO =  newHiresFullTimeReportAdapter.getNewHiresFullTimeReportData(workYear,workMonth,controlGroup,acaEligibleCount);
			customReportByACAEligibleCountVO.setReportByACAEligibleCount(reportsByACAEligibleCountVO);
		} catch (Exception e) {
			logger.error("Error while invoking getNewHiresFullTimeReportData : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: NewHiresFullTimeReportService : getNewHiresFullTimeReportData : Method to getNewHiresFullTimeReportData");
		}
		
		return Response.ok(customReportByACAEligibleCountVO).build();
	}
	
	@Path(CommonConstants.NEW_HIRES_FULL_TIME_SERVICE_PROCESS_EXCEL_ZIP_DOWNLOAD)
	@GET
	@Produces(CommonConstants.APPLICATION_ZIP)
	public Response processNewHireFullTimeExcelUpload(@QueryParam(CommonConstants.WORK_YEAR) String workYear, @QueryParam(CommonConstants.WORK_MONTH) String workMonth,
			@QueryParam(CommonConstants.CONTROL_GROUP) String controlGroup,@QueryParam(CommonConstants.ACA_ELIGIBLE_COUNT) String acaEligibleCount) {

		List<ReportsByACAEligibleCountVO> reportsByACAEligibleCountVO = null;
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
			if(null != acaEligibleCount && acaEligibleCount.contains("''") &&  acaEligibleCount.length() == 2) {
				acaEligibleCount = null;
			}
			
			reportsByACAEligibleCountVO =  newHiresFullTimeReportAdapter.getNewHiresFullTimeReportData(workYear,workMonth,controlGroup,acaEligibleCount);
			
			// Code To Invoke Excel Builder 
			Map<String, List<?>> reportsDataMap = new HashMap<>();
			reportsDataMap.put(CommonConstants.NEW_HIRES_FULL_TIME_REPORTS, reportsByACAEligibleCountVO);
			
			NewHireFullTimeReferanceDataBean newHireNonFullTimeReferanceData = newHiresFullTimeReportAdapter.getNewHiresFullTimeReportReferenceData();
			List<String> controlGroupList = newHireNonFullTimeReferanceData.getControlGroupList();
			
			generatedReportsPath = reportsExcelBuilderUtil.buildExcelDocument(reportsDataMap, controlGroupList, workYear, workMonth, controlGroup, acaEligibleCount);
			
		} catch (Exception e) {
			logger.error("Error while invoking getHireWorkYears : " + e.getMessage());
		}
		
		File downloadDocumentFile = new File(generatedReportsPath + ".zip");
		String buildZipFilename = "NewHireFullTimeReports_" + generatedReportsPath.substring(generatedReportsPath.lastIndexOf("/")+1, generatedReportsPath.length()) + ".zip";
		ResponseBuilder responseBuilder = Response.ok((Object) downloadDocumentFile);
        responseBuilder.header("Content-Disposition", "attachment; filename=" + buildZipFilename );
		return responseBuilder.build();
	}

}
