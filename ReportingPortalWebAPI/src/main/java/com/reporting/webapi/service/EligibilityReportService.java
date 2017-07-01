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

import com.reporting.webapi.adapter.IEligibilityReportAdapter;
import com.reporting.webapi.bean.BreakInServiceReferanceDataBean;
import com.reporting.webapi.bean.EligibilityServiceReferanceDataBean;
import com.reporting.webapi.response.vo.BreakInReportDataVO;
import com.reporting.webapi.response.vo.EligibilityReferanceDataVO;
import com.reporting.webapi.response.vo.EligibilityReportDataVO;
import com.reporting.webapi.responsewrapper.vo.CustomEligibilityReferenceDataVO;
import com.reporting.webapi.responsewrapper.vo.CustomEligibilityReportVO;
import com.reporting.webapi.util.CommonConstants;
import com.reporting.webapi.util.ReportsExcelBuilderUtil;

@Component
@Path(value=CommonConstants.Eligibility_SERVICE)
public class EligibilityReportService {
	
	private final Logger logger = Logger.getLogger(EligibilityReportService.class);
	
	@Autowired
	private IEligibilityReportAdapter eligibilityReportAdapter;
	
	@Autowired
	private ReportsExcelBuilderUtil reportsExcelBuilderUtil;
	
	@Path(CommonConstants.Eligibility_SERVICE_REFERENCE_DATA)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response getEligibilityServiceReferenceData() {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: EligibilityReportService : getEligibilityServiceReferenceData : Method to getEligibilityServiceReferenceData");
		}
		
		CustomEligibilityReferenceDataVO customEligibilityReferenceDataVO = new CustomEligibilityReferenceDataVO();
		try{
			EligibilityServiceReferanceDataBean eligibilityServiceReferanceDataBean = eligibilityReportAdapter.getEligibilityServiceReferenceData();
			
			EligibilityReferanceDataVO eligibilityReferanceDataVO =  new EligibilityReferanceDataVO();
			eligibilityReferanceDataVO.setWorkYears(eligibilityServiceReferanceDataBean.getWorkYearList());
			eligibilityReferanceDataVO.setControlgroups(eligibilityServiceReferanceDataBean.getControlGroupList());
			eligibilityReferanceDataVO.setUnionStatus(eligibilityServiceReferanceDataBean.getUnionStatus());
			eligibilityReferanceDataVO.setTypeOfHours(eligibilityServiceReferanceDataBean.getTypeOfHours());
						
			customEligibilityReferenceDataVO.setEligibilityReferanceData(eligibilityReferanceDataVO);
			
		} catch (Exception e) {
			logger.error("Error while invoking getEligibilityServiceReferenceData : " + e.getMessage());
		}	
		if(logger.isDebugEnabled()){
			logger.debug("END :: EligibilityReportService : getEligibilityServiceReferenceData : Method to getEligibilityServiceReferenceData");
		}
		
		return Response.ok(customEligibilityReferenceDataVO).build();
	}
	
	@Path(CommonConstants.Eligibility_SERVICE_REPORT_DATA)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response getEligibilityReportData(@QueryParam(CommonConstants.WORK_YEAR) String workYear,
			@QueryParam(CommonConstants.CONTROL_GROUP) String controlGroup,@QueryParam(CommonConstants.UNION_STATUS) String unionStatus,
			@QueryParam(CommonConstants.TYPE_OF_HOURS) String typeOfHours) {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: EligibilityReportService : getEligibilityReportData : Method to getEligibilityReportData");
		}
		
		CustomEligibilityReportVO customEligibilityReportVO = new CustomEligibilityReportVO();
		try{
			if(null != workYear && workYear.contains("''") &&  workYear.length() == 2) {
				workYear = null;
			}
			if(null != controlGroup && controlGroup.contains("''") &&  controlGroup.length() == 2) {
				controlGroup = null;
			}
			if(null != unionStatus && unionStatus.contains("''") &&  unionStatus.length() == 2) {
				unionStatus = null;
			}
			if(null != typeOfHours && typeOfHours.contains("''") &&  typeOfHours.length() == 2) {
				typeOfHours = null;
			}
			List<EligibilityReportDataVO> eligibilityReportDataVO = eligibilityReportAdapter.getEligibilityReportData(workYear,controlGroup,unionStatus,typeOfHours);
			
			customEligibilityReportVO.setEligibilityReportData(eligibilityReportDataVO);
			
		} catch (Exception e) {
			logger.error("Error while invoking getEligibilityReportData : " + e.getMessage());
		}
		
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: EligibilityReportService : getEligibilityReportData : Method to getEligibilityReportData");
		}
		
		return Response.ok(customEligibilityReportVO).build();
	}
	
	@Path(CommonConstants.Eligibility_SERVICE_PROCESS_EXCEL_ZIP_DOWNLOAD)
	@GET
	@Produces(CommonConstants.APPLICATION_ZIP)
	public Response processBreakInReportExcelUpload(@QueryParam(CommonConstants.WORK_YEAR) String workYear,
			@QueryParam(CommonConstants.CONTROL_GROUP) String controlGroup,@QueryParam(CommonConstants.UNION_STATUS) String unionStatus,
			@QueryParam(CommonConstants.TYPE_OF_HOURS) String typeOfHours) {
		List<EligibilityReportDataVO> eligibilityReportDataVO = null;
		String generatedReportsPath = "";
		try{
			if(null != workYear && workYear.contains("''") &&  workYear.length() == 2) {
				workYear = null;
			}
			if(null != controlGroup && controlGroup.contains("''") &&  controlGroup.length() == 2) {
				controlGroup = null;
			}
			if(null != unionStatus && unionStatus.contains("''") &&  unionStatus.length() == 2) {
				unionStatus = null;
			}
			if(null != typeOfHours && typeOfHours.contains("''") &&  typeOfHours.length() == 2) {
				typeOfHours = null;
			}
			
			eligibilityReportDataVO = eligibilityReportAdapter.getEligibilityReportData(workYear,controlGroup,unionStatus,typeOfHours);
			
			// Code To Invoke Excel Builder 
			Map<String, List<?>> reportsDataMap = new HashMap<>();
			reportsDataMap.put(CommonConstants.ELIGIBILITY_REPORT, eligibilityReportDataVO);
			
			EligibilityServiceReferanceDataBean eligibilityServiceReferanceDataBean = eligibilityReportAdapter.getEligibilityServiceReferenceData();
			List<String> controlGroupList = eligibilityServiceReferanceDataBean.getControlGroupList();
			
			generatedReportsPath = reportsExcelBuilderUtil.buildExcelDocument(reportsDataMap, controlGroupList, workYear,controlGroup,unionStatus,typeOfHours);
						
		} catch (Exception e) {
			//logger.error("Error while invoking getHireWorkYears : " + e.getMessage());
		}
		
		File downloadDocumentFile = new File(generatedReportsPath + ".zip");
		String buildZipFilename = "EligibilityReport_" + generatedReportsPath.substring(generatedReportsPath.lastIndexOf("/")+1, generatedReportsPath.length()) + ".zip";
		ResponseBuilder responseBuilder = Response.ok((Object) downloadDocumentFile);
        responseBuilder.header("Content-Disposition", "attachment; filename=" + buildZipFilename );
		return responseBuilder.build();
	}

}
