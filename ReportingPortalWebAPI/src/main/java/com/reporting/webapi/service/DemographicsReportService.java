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

import com.reporting.webapi.adapter.IDemographicsReportAdapter;
import com.reporting.webapi.bean.DemoGraphicsServiceReferanceDataBean;
import com.reporting.webapi.response.vo.DemoGraphicsReferanceDataVO;
import com.reporting.webapi.response.vo.DemoGraphicsReportDataVO;
import com.reporting.webapi.responsewrapper.vo.CustomDemoGraphicsReferenceDataVO;
import com.reporting.webapi.responsewrapper.vo.CustomDemoGraphicsReportVO;
import com.reporting.webapi.util.CommonConstants;
import com.reporting.webapi.util.ReportsExcelBuilderUtil;

@Component
@Path(value=CommonConstants.DEMO_GRAPHICS_SERVICE)
public class DemographicsReportService {
	
	private final Logger logger = Logger.getLogger(DemographicsReportService.class);
	
	@Autowired
	private IDemographicsReportAdapter demographicsReportAdapter;
	
	@Autowired
	private ReportsExcelBuilderUtil reportsExcelBuilderUtil;
	
	@Path(CommonConstants.DEMO_GRAPHICS_SERVICE_REFERENCE_DATA)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response getDemographicsServiceReferenceData() {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: DemographicsReportService : getDemographicsServiceReferenceData : Method to getDemographicsServiceReferenceData");
		}
		
		CustomDemoGraphicsReferenceDataVO customDemoGraphicsReferenceDataVO = new CustomDemoGraphicsReferenceDataVO();
		try{
			DemoGraphicsServiceReferanceDataBean demoGraphicsServiceReferanceDataBean = demographicsReportAdapter.getDemographicsServiceReferenceData();
			
			DemoGraphicsReferanceDataVO demoGraphicsReferanceDataVO =  new DemoGraphicsReferanceDataVO();
			demoGraphicsReferanceDataVO.setWorkYears(demoGraphicsServiceReferanceDataBean.getWorkYearList());
			demoGraphicsReferanceDataVO.setControlgroups(demoGraphicsServiceReferanceDataBean.getControlGroupList());
			demoGraphicsReferanceDataVO.setParentCompany(demoGraphicsServiceReferanceDataBean.getParentCompany());
			demoGraphicsReferanceDataVO.setProductionCompany(demoGraphicsServiceReferanceDataBean.getProductionCompany());
			demoGraphicsReferanceDataVO.setPayrollCompany(demoGraphicsServiceReferanceDataBean.getPayrollCompany());
			
			customDemoGraphicsReferenceDataVO.setDemoGraphicsReferanceData(demoGraphicsReferanceDataVO);
			
		} catch (Exception e) {
			logger.error("Error while invoking getDemographicsServiceReferenceData : " + e.getMessage());
		}	
		if(logger.isDebugEnabled()){
			logger.debug("END :: DemographicsReportService : getDemographicsServiceReferenceData : Method to getDemographicsServiceReferenceData");
		}
		
		return Response.ok(customDemoGraphicsReferenceDataVO).build();
	}
	
	@Path(CommonConstants.DEMO_GRAPHICS_SERVICE_REPORT_DATA)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response getDemographicsReportData(@QueryParam(CommonConstants.WORK_YEAR) String workYear,
			@QueryParam(CommonConstants.CONTROL_GROUP) String controlGroup,@QueryParam(CommonConstants.PARENT_COMPANY) String parentCompnay,
			@QueryParam(CommonConstants.PRODUCTION_COMPANY) String proudctioncompany,@QueryParam(CommonConstants.PAYROLL_COMPANY) String payrollCompany) {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: DemographicsReportService : getDemographicsReportData : Method to getDemographicsReportData");
		}
		
		CustomDemoGraphicsReportVO customDemoGraphicsReportVO = new CustomDemoGraphicsReportVO();
		try{
			if(null != workYear && workYear.contains("''") &&  workYear.length() == 2) {
				workYear = null;
			}
			if(null != controlGroup && controlGroup.contains("''") &&  controlGroup.length() == 2) {
				controlGroup = null;
			}
			if(null != parentCompnay && parentCompnay.contains("''") &&  parentCompnay.length() == 2) {
				parentCompnay = null;
			}
			if(null != proudctioncompany && proudctioncompany.contains("''") &&  proudctioncompany.length() == 2) {
				proudctioncompany = null;
			}
			if(null != payrollCompany && payrollCompany.contains("''") &&  payrollCompany.length() == 2) {
				payrollCompany = null;
			}
			
			List<DemoGraphicsReportDataVO> demoGraphicsReferanceData = demographicsReportAdapter.getDemographicsReportData(workYear,controlGroup,parentCompnay,proudctioncompany,payrollCompany);
			
			customDemoGraphicsReportVO.setDemoGraphicsReportData(demoGraphicsReferanceData);
			
		} catch (Exception e) {
			logger.error("Error while invoking getDemographicsReportData : " + e.getMessage());
		}
		
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: DemographicsReportService : getDemographicsReportData : Method to getDemographicsReportData");
		}
		
		return Response.ok(customDemoGraphicsReportVO).build();
	}
	
	@Path(CommonConstants.DEMO_GRAPHICS_SERVICE_PROCESS_EXCEL_ZIP_DOWNLOAD)
	@GET
	@Produces(CommonConstants.APPLICATION_ZIP)
	public Response processDemographicsReportExcelUpload(@QueryParam(CommonConstants.WORK_YEAR) String workYear,
			@QueryParam(CommonConstants.CONTROL_GROUP) String controlGroup,@QueryParam(CommonConstants.PARENT_COMPANY) String parentCompnay,
			@QueryParam(CommonConstants.PRODUCTION_COMPANY) String proudctioncompany,@QueryParam(CommonConstants.PAYROLL_COMPANY) String payrollCompany) {
		List<DemoGraphicsReportDataVO> demoGraphicsReferanceData = null;
		String generatedReportsPath = "";
		try{
			if(null != workYear && workYear.contains("''") &&  workYear.length() == 2) {
				workYear = null;
			}
			if(null != controlGroup && controlGroup.contains("''") &&  controlGroup.length() == 2) {
				controlGroup = null;
			}
			if(null != parentCompnay && parentCompnay.contains("''") &&  parentCompnay.length() == 2) {
				parentCompnay = null;
			}
			if(null != proudctioncompany && proudctioncompany.contains("''") &&  proudctioncompany.length() == 2) {
				proudctioncompany = null;
			}
			if(null != payrollCompany && payrollCompany.contains("''") &&  payrollCompany.length() == 2) {
				payrollCompany = null;
			}
			
			demoGraphicsReferanceData = demographicsReportAdapter.getDemographicsReportData(workYear,controlGroup,parentCompnay,proudctioncompany,payrollCompany);
			
			// Code To Invoke Excel Builder 
			Map<String, List<?>> reportsDataMap = new HashMap<>();
			reportsDataMap.put(CommonConstants.DEMO_GRAPHICS_REPORT, demoGraphicsReferanceData);
			
			DemoGraphicsServiceReferanceDataBean demoGraphicsServiceReferanceDataBean = demographicsReportAdapter.getDemographicsServiceReferenceData();
			List<String> controlGroupList = demoGraphicsServiceReferanceDataBean.getControlGroupList();
			
			generatedReportsPath = reportsExcelBuilderUtil.buildExcelDocument(reportsDataMap, controlGroupList, workYear,controlGroup,parentCompnay,proudctioncompany,payrollCompany);
						
		} catch (Exception e) {
			logger.error("Error while invoking  : " + e.getMessage());
		}
		
		File downloadDocumentFile = new File(generatedReportsPath + ".zip");
		String buildZipFilename = "DemographicsReport_" + generatedReportsPath.substring(generatedReportsPath.lastIndexOf("/")+1, generatedReportsPath.length()) + ".zip";
		ResponseBuilder responseBuilder = Response.ok((Object) downloadDocumentFile);
        responseBuilder.header("Content-Disposition", "attachment; filename=" + buildZipFilename );
		return responseBuilder.build();
	}

}
