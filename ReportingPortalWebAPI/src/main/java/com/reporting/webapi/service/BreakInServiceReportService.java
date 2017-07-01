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

import com.reporting.webapi.adapter.IBreakInServiceReportAdapter;
import com.reporting.webapi.bean.BreakInServiceReferanceDataBean;
import com.reporting.webapi.bean.ERCoverageReferanceDataBean;
import com.reporting.webapi.response.vo.BreakInReportDataVO;
import com.reporting.webapi.response.vo.BreakInServiceReferanceDataVO;
import com.reporting.webapi.response.vo.ReportsByAnnualizedMonthlyCountVO;
import com.reporting.webapi.responsewrapper.vo.CustomBreakInReferenceDataVO;
import com.reporting.webapi.responsewrapper.vo.CustomBreakInReportVO;
import com.reporting.webapi.util.CommonConstants;
import com.reporting.webapi.util.CommonUtil;
import com.reporting.webapi.util.ReportsExcelBuilderUtil;

@Component
@Path(value=CommonConstants.BREAK_IN_SERVICE)
public class BreakInServiceReportService {
	
	private final Logger logger = Logger.getLogger(BreakInServiceReportService.class);
	
	@Autowired
	private IBreakInServiceReportAdapter breakInServiceReportAdapter;
	
	@Autowired
	private CommonUtil commonUtil;
	
	@Autowired
	private ReportsExcelBuilderUtil reportsExcelBuilderUtil;
	
	@Path(CommonConstants.BREAK_IN_SERVICE_REFERENCE_DATA)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response getBreakInServiceReportReferenceData() {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: BreakInServiceReportService : getBreakInServiceReportReferenceData : Method to getBreakInServiceReportReferenceData");
		}
		
		CustomBreakInReferenceDataVO customBreakInReferenceDataVO = new CustomBreakInReferenceDataVO();
		try{
			BreakInServiceReferanceDataBean breakInServiceReferanceDataBean = breakInServiceReportAdapter.getBreakInServiceReportReferenceData();
			
			BreakInServiceReferanceDataVO breakInServiceReferanceDataVO =  new BreakInServiceReferanceDataVO();
			breakInServiceReferanceDataVO.setWorkYears(breakInServiceReferanceDataBean.getWorkYearList());
			breakInServiceReferanceDataVO.setControlgroups(breakInServiceReferanceDataBean.getControlGroupList());
			breakInServiceReferanceDataVO.setWeekStarting(breakInServiceReferanceDataBean.getWeekStarting());
			breakInServiceReferanceDataVO.setWeekEnding(breakInServiceReferanceDataBean.getWeekEnding());
			
			customBreakInReferenceDataVO.setBreakInReferanceData(breakInServiceReferanceDataVO);
			
		} catch (Exception e) {
			logger.error("Error while invoking getBreakInServiceReportReferenceData : " + e.getMessage());
		}	
		if(logger.isDebugEnabled()){
			logger.debug("END :: BreakInServiceReportService : getBreakInServiceReportReferenceData : Method to getBreakInServiceReportReferenceData");
		}
		
		return Response.ok(customBreakInReferenceDataVO).build();
	}
	
	
	@Path(CommonConstants.BREAK_IN_SERVICE_REPORT_DATA)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response getBreakInReportData(@QueryParam(CommonConstants.WORK_YEAR) String workYear,
			@QueryParam(CommonConstants.CONTROL_GROUP) String controlGroup,@QueryParam(CommonConstants.WEEK_STARTING) String weekStarting,
			@QueryParam(CommonConstants.WEEK_ENDING) String weekEnding) {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: BreakInServiceReportService : getBreakInReportData : Method to getBreakInReportData");
		}
		
		CustomBreakInReportVO customBreakInReportVO = new CustomBreakInReportVO();
		try{
			if(null != workYear && workYear.contains("''") &&  workYear.length() == 2) {
				workYear = null;
			}
			if(null != controlGroup && controlGroup.contains("''") &&  controlGroup.length() == 2) {
				controlGroup = null;
			}
			if(null != weekStarting && weekStarting.contains("''") &&  weekStarting.length() == 2) {
				weekStarting = null;
			}
			if(null != weekEnding && weekEnding.contains("''") &&  weekEnding.length() == 2) {
				weekEnding = null;
			}
			
			//commonUtil.validateQueryParams("BreakIn",workYear,controlGroup,weekStarting,weekEnding);
			
			List<BreakInReportDataVO> breakInReferanceData = breakInServiceReportAdapter.getBreakInReportData(workYear,controlGroup,weekStarting,weekEnding);
			
			customBreakInReportVO.setBreakInReportData(breakInReferanceData);
			
		} catch (Exception e) {
			logger.error("Error while invoking getBreakInReportData : " + e.getMessage());
		}
		
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: BreakInServiceReportService : getBreakInReportData : Method to getBreakInReportData");
		}
		
		return Response.ok(customBreakInReportVO).build();
	}
	
	@Path(CommonConstants.BREAK_IN_SERVICE_PROCESS_EXCEL_ZIP_DOWNLOAD)
	@GET
	@Produces(CommonConstants.APPLICATION_ZIP)
	public Response processBreakInReportExcelUpload(@QueryParam(CommonConstants.WORK_YEAR) String workYear,
			@QueryParam(CommonConstants.CONTROL_GROUP) String controlGroup,@QueryParam(CommonConstants.WEEK_STARTING) String weekStarting,
			@QueryParam(CommonConstants.WEEK_ENDING) String weekEnding) {
		List<BreakInReportDataVO> breakInReferanceData = null;
		String generatedReportsPath = "";
		try{
			if(null != workYear && workYear.contains("''") &&  workYear.length() == 2) {
				workYear = null;
			}
			if(null != controlGroup && controlGroup.contains("''") &&  controlGroup.length() == 2) {
				controlGroup = null;
			}
			if(null != weekStarting && weekStarting.contains("''") &&  weekStarting.length() == 2) {
				weekStarting = null;
			}
			if(null != weekEnding && weekEnding.contains("''") &&  weekEnding.length() == 2) {
				weekEnding = null;
			}
			
			breakInReferanceData = breakInServiceReportAdapter.getBreakInReportData(workYear,controlGroup,weekStarting,weekEnding);
			
			// Code To Invoke Excel Builder 
			Map<String, List<?>> reportsDataMap = new HashMap<>();
			reportsDataMap.put(CommonConstants.BREAK_IN_REPORT, breakInReferanceData);
			
			BreakInServiceReferanceDataBean breakInServiceReferanceDataBean = breakInServiceReportAdapter.getBreakInServiceReportReferenceData();
			List<String> controlGroupList = breakInServiceReferanceDataBean.getControlGroupList();
			
			generatedReportsPath = reportsExcelBuilderUtil.buildExcelDocument(reportsDataMap, controlGroupList, workYear,controlGroup,weekStarting,weekEnding);
						
		} catch (Exception e) {
			//logger.error("Error while invoking getHireWorkYears : " + e.getMessage());
		}
		
		File downloadDocumentFile = new File(generatedReportsPath + ".zip");
		String buildZipFilename = "BreakInServiceReport_" + generatedReportsPath.substring(generatedReportsPath.lastIndexOf("/")+1, generatedReportsPath.length()) + ".zip";
		ResponseBuilder responseBuilder = Response.ok((Object) downloadDocumentFile);
        responseBuilder.header("Content-Disposition", "attachment; filename=" + buildZipFilename );
		return responseBuilder.build();
	}

}
