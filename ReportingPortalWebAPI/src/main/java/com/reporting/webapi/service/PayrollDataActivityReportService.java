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

import com.reporting.webapi.adapter.IPayrollDataActivityReportAdapter;
import com.reporting.webapi.bean.OngoingReferanceDataBean;
import com.reporting.webapi.bean.PayrollRefDataBean;
import com.reporting.webapi.response.vo.OnGoingReportsByWeekCountVO;
import com.reporting.webapi.response.vo.PayrollRefDataVO;
import com.reporting.webapi.response.vo.ReportsForPayrollDataActivityVO;
import com.reporting.webapi.responsewrapper.vo.CustomPayrollRefDataVO;
import com.reporting.webapi.responsewrapper.vo.CustomReportsForPayrollDataActivityVO;
import com.reporting.webapi.util.CommonConstants;
import com.reporting.webapi.util.ReportsExcelBuilderUtil;

@Component
@Path(value=CommonConstants.PAY_ROLL_DATA_ACTIVE_SERVICE)
public class PayrollDataActivityReportService {
	
	private final Logger logger = Logger.getLogger(PayrollDataActivityReportService.class);
	
	@Autowired
	private IPayrollDataActivityReportAdapter payrollDataActivityReportAdapter;
	
	@Autowired
	private ReportsExcelBuilderUtil reportsExcelBuilderUtil;
	
	@Path(CommonConstants.PAY_ROLL_DATA_ACTIVE_SERVICE_REFERENCE_DATA)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response getPayrollDataActivityReportReferenceData() {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: PayrollDataActivityReportService : getPayrollDataActivityReportReferenceData : Method to getPayrollDataActivityReportReferenceData");
		}
		
		CustomPayrollRefDataVO customPayrollRefDataVO = new CustomPayrollRefDataVO();
		try{
			PayrollRefDataBean payrollRefDataBean = payrollDataActivityReportAdapter.getPayrollDataActivityReportReferenceData();
			
			PayrollRefDataVO payrollRefDataVO =  new PayrollRefDataVO();
			payrollRefDataVO.setWorkYears(payrollRefDataBean.getWorkYears());
			payrollRefDataVO.setControlgroups(payrollRefDataBean.getControlGroups());
			
			customPayrollRefDataVO.setPayrollRefDataVO(payrollRefDataVO);
		}catch(Exception e){
			logger.error("Error while invoking getPayrollDataActivityReportReferenceData : " + e.getMessage());
		}
		if(logger.isDebugEnabled()){
			logger.debug("END :: PayrollDataActivityReportService : getPayrollDataActivityReportReferenceData : Method to getPayrollDataActivityReportReferenceData");
		}
		
		return Response.ok(customPayrollRefDataVO).build();
	}

	@Path(CommonConstants.PAY_ROLL_DATA_ACTIVE_SERVICE_REPORT_DATA)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response getPayrollDataActivityReportData(@QueryParam(CommonConstants.WORK_YEAR) String workYear,@QueryParam(CommonConstants.CONTROL_GROUP) String controlGroup) {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: PayrollDataActivityReportService : getPayrollDataActivityReportData : Method to getPayrollDataActivityReportData");
		}
		
		CustomReportsForPayrollDataActivityVO customReportsForPayrollDataActivityVO = new CustomReportsForPayrollDataActivityVO();
		List<ReportsForPayrollDataActivityVO> reportsForPayrollDataActivityVO = null;
		try{
			if(null != workYear && workYear.contains("''") &&  workYear.length() == 2) {
				workYear = null;
			}
			if(null != controlGroup && controlGroup.contains("''") &&  controlGroup.length() == 2) {
				controlGroup = null;
			}
			
			reportsForPayrollDataActivityVO =  payrollDataActivityReportAdapter.getPayrollDataActivityReportData(workYear,controlGroup);
			customReportsForPayrollDataActivityVO.setReportsForPayrollDataActivity(reportsForPayrollDataActivityVO);
			
		} catch (Exception e) {
			logger.error("Error while invoking getHireWorkYears : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: PayrollDataActivityReportService : getPayrollDataActivityReportData : Method to getPayrollDataActivityReportData");
		}
		
		return Response.ok(customReportsForPayrollDataActivityVO).build();
	}
	
	@Path(CommonConstants.PAY_ROLL_DATA_ACTIVE_SERVICE_PROCESS_EXCEL_ZIP_DOWNLOAD)
	@GET
	@Produces(CommonConstants.APPLICATION_ZIP)
	public Response processPayrollDataActivityReportExcelUpload(
			@QueryParam(CommonConstants.WORK_YEAR) String workYear, 
			@QueryParam(CommonConstants.CONTROL_GROUP) String controlGroup) {
		
		List<ReportsForPayrollDataActivityVO> reportsForPayrollDataActivityVO = null;
		String generatedReportsPath = "";
		try{
			
			
			if(null != workYear && workYear.contains("''") &&  workYear.length() == 2) {
				workYear = null;
			}
			if(null != controlGroup && controlGroup.contains("''") &&  controlGroup.length() == 2) {
				controlGroup = null;
			}
						
			reportsForPayrollDataActivityVO =  payrollDataActivityReportAdapter.getPayrollDataActivityReportData(workYear,controlGroup);
			
			// Code To Invoke Excel Builder 
			Map<String, List<?>> reportsDataMap = new HashMap<>();
			reportsDataMap.put(CommonConstants.PAYROLL_DATA_ACTIVITY_REPORT, reportsForPayrollDataActivityVO);
			
			PayrollRefDataBean payrollRefDataBean = payrollDataActivityReportAdapter.getPayrollDataActivityReportReferenceData();
			List<String> controlGroupList = payrollRefDataBean.getControlGroups();
			
			generatedReportsPath = reportsExcelBuilderUtil.buildExcelDocument(reportsDataMap, controlGroupList,workYear,controlGroup);
						
			
		} catch (Exception e) {
			logger.error("Error while invoking PayrollDataActivityReport Excel Download  : " + e.getMessage());
		}
		
		File downloadDocumentFile = new File(generatedReportsPath + ".zip");
		String buildZipFilename = "PayrollDataActivityReport_" + generatedReportsPath.substring(generatedReportsPath.lastIndexOf("/")+1, generatedReportsPath.length()) + ".zip";
		ResponseBuilder responseBuilder = Response.ok((Object) downloadDocumentFile);
        responseBuilder.header("Content-Disposition", "attachment; filename=" + buildZipFilename );
		return responseBuilder.build();
	}
}
