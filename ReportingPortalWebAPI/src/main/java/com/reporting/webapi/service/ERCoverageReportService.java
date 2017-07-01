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

import com.reporting.webapi.adapter.IERCoverageReportAdapter;
import com.reporting.webapi.bean.ERCoverageReferanceDataBean;
import com.reporting.webapi.response.vo.AnnualizedMonthlyCountVO;
import com.reporting.webapi.response.vo.ERCoverageReferanceDataVO;
import com.reporting.webapi.response.vo.ReportsByAnnualizedMonthlyCountVO;
import com.reporting.webapi.responsewrapper.vo.CustomAnnualizedMonthlyCountVO;
import com.reporting.webapi.responsewrapper.vo.CustomERCoverageReportVO;
import com.reporting.webapi.responsewrapper.vo.CustomReportsByAnnualizedMonthlyCountVO;
import com.reporting.webapi.util.CommonConstants;
import com.reporting.webapi.util.ReportsExcelBuilderUtil;

@Component
@Path(value=CommonConstants.ER_COVERAGE_SERVICE)
public class ERCoverageReportService {

	private final Logger logger = Logger.getLogger(ERCoverageReportService.class);
	
	@Autowired
	private IERCoverageReportAdapter eRCoverageReportAdapter;
	
	@Autowired
	private ReportsExcelBuilderUtil reportsExcelBuilderUtil;
	
	@Path(CommonConstants.ER_COVERAGE_SERVICE_REFERENCE_DATA)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response getERCoverageReportReferenceData() {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: ERCoverageReportService : getERCoverageReportReferenceData : Method to getERCoverageReportReferenceData");
		}
		
		CustomERCoverageReportVO customERCoverageReportVO = new CustomERCoverageReportVO();
		try{
			ERCoverageReferanceDataBean erCoverageReferanceDataBean = eRCoverageReportAdapter.getERCoverageReportReferenceData();
			
			ERCoverageReferanceDataVO erCoverageReferanceDataVO =  new ERCoverageReferanceDataVO();
			erCoverageReferanceDataVO.setWorkYears(erCoverageReferanceDataBean.getWorkYears());
			erCoverageReferanceDataVO.setControlgroups(erCoverageReferanceDataBean.getControlGroups());
			
			customERCoverageReportVO.setErCoverageReferanceDataVO(erCoverageReferanceDataVO);
			
		} catch (Exception e) {
			logger.error("Error while invoking getERCoverageReportReferenceData : " + e.getMessage());
		}
		
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: ERCoverageReportService : getERCoverageReportReferenceData : Method to getERCoverageReportReferenceData");
		}
		
		return Response.ok(customERCoverageReportVO).build();
	}
	
	@Path(CommonConstants.ER_COVERAGE_SERVICE_COUNT_BY_WEEK)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response getERCoverageReportCount(@QueryParam(CommonConstants.WORK_YEAR) String workYear,@QueryParam(CommonConstants.CONTROL_GROUP) String controlGroup) {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: ERCoverageReportService : getERCoverageReportCount : Method to getERCoverageReportCount");
		}
		
		CustomAnnualizedMonthlyCountVO customAnnualizedMonthlyCountVO = new CustomAnnualizedMonthlyCountVO();
		List<AnnualizedMonthlyCountVO> annualizedMonthlyCount = null;
		try{
			if(null != workYear && workYear.contains("''") &&  workYear.length() == 2) {
				workYear = null;
			}
			if(null != controlGroup && controlGroup.contains("''") &&  controlGroup.length() == 2) {
				controlGroup = null;
			}
			
			annualizedMonthlyCount =  eRCoverageReportAdapter.getERCoverageReportCount(workYear,controlGroup);
			customAnnualizedMonthlyCountVO.setAnnualizedMonthlyCountVO(annualizedMonthlyCount);
			
		} catch (Exception e) {
			logger.error("Error while invoking getERCoverageReportCountByWeek : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: ERCoverageReportService : getERCoverageReportCount : Method to getERCoverageReportCount");
		}
		
		return Response.ok(customAnnualizedMonthlyCountVO).build();
	}
	
	@Path(CommonConstants.ER_COVERAGE_SERVICE_REPORT_DATA)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response getERCoverageReportData(@QueryParam(CommonConstants.WORK_YEAR) String workYear,@QueryParam(CommonConstants.CONTROL_GROUP) String controlGroup,
			@QueryParam("annualizedMonthlyCount") String annualizedMonthlyCount) {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: ERCoverageReportService : getERCoverageReportData : Method to getERCoverageReportData");
		}
		
		CustomReportsByAnnualizedMonthlyCountVO customReportsByAnnualizedMonthlyCountVO = new CustomReportsByAnnualizedMonthlyCountVO();
		List<ReportsByAnnualizedMonthlyCountVO> reportsByAnnualizedMonthlyCountVO = null;
		try{
			if(null != workYear && workYear.contains("''") &&  workYear.length() == 2) {
				workYear = null;
			}
			if(null != controlGroup && controlGroup.contains("''") &&  controlGroup.length() == 2) {
				controlGroup = null;
			}
			if(null != annualizedMonthlyCount && annualizedMonthlyCount.contains("''") &&  annualizedMonthlyCount.length() == 2) {
				annualizedMonthlyCount = null;
			}
			
			reportsByAnnualizedMonthlyCountVO =  eRCoverageReportAdapter.getERCoverageReportData(workYear,controlGroup,annualizedMonthlyCount);
			customReportsByAnnualizedMonthlyCountVO.setReportsByAnnualizedMonthlyCountVO(reportsByAnnualizedMonthlyCountVO);
		} catch (Exception e) {
			logger.error("Error while invoking getERCoverageReportReportData : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: ERCoverageReportService : getERCoverageReportData : Method to getERCoverageReportData");
		}
		
		return Response.ok(customReportsByAnnualizedMonthlyCountVO).build();
	}
	
	@Path(CommonConstants.ER_COVERAGE_SERVICE_PROCESS_EXCEL_ZIP_DOWNLOAD)
	@GET
	@Produces(CommonConstants.APPLICATION_ZIP)
	public Response processERCoverageReportExcelUpload(
			@QueryParam(CommonConstants.WORK_YEAR) String workYear,
			@QueryParam(CommonConstants.CONTROL_GROUP) String controlGroup,
			@QueryParam(CommonConstants.ANNUALIZED_MONTHLY_COUNT) String annualizedMonthlyCount) {
		List<ReportsByAnnualizedMonthlyCountVO> reportsByAnnualizedMonthlyCountVO = null;
		String generatedReportsPath = "";
		try{
			if(null != workYear && workYear.contains("''") &&  workYear.length() == 2) {
				workYear = null;
			}
			if(null != controlGroup && controlGroup.contains("''") &&  controlGroup.length() == 2) {
				controlGroup = null;
			}
			if(null != annualizedMonthlyCount && annualizedMonthlyCount.contains("''") &&  annualizedMonthlyCount.length() == 2) {
				annualizedMonthlyCount = null;
			}
			
			reportsByAnnualizedMonthlyCountVO =  eRCoverageReportAdapter.getERCoverageReportData(workYear,controlGroup,annualizedMonthlyCount);
			
			// Code To Invoke Excel Builder 
			Map<String, List<?>> reportsDataMap = new HashMap<>();
			reportsDataMap.put(CommonConstants.ER_COVERAGE_REPORT, reportsByAnnualizedMonthlyCountVO);
			
			ERCoverageReferanceDataBean erCoverageReferanceDataBean = eRCoverageReportAdapter.getERCoverageReportReferenceData();
			List<String> controlGroupList = erCoverageReferanceDataBean.getControlGroups();
			
			generatedReportsPath = reportsExcelBuilderUtil.buildExcelDocument(reportsDataMap, controlGroupList, workYear, controlGroup, annualizedMonthlyCount);
						
		} catch (Exception e) {
			//logger.error("Error while invoking getHireWorkYears : " + e.getMessage());
		}
		
		File downloadDocumentFile = new File(generatedReportsPath + ".zip");
		String buildZipFilename = "ERCoverageReport_" + generatedReportsPath.substring(generatedReportsPath.lastIndexOf("/")+1, generatedReportsPath.length()) + ".zip";
		ResponseBuilder responseBuilder = Response.ok((Object) downloadDocumentFile);
        responseBuilder.header("Content-Disposition", "attachment; filename=" + buildZipFilename );
		return responseBuilder.build();
	}
}
