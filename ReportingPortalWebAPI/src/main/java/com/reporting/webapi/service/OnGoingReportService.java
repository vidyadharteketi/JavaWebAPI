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

import com.reporting.webapi.adapter.IOnGoingReportAdapter;
import com.reporting.webapi.bean.OngoingReferanceDataBean;
import com.reporting.webapi.response.vo.OnGoingCountByWeeksVO;
import com.reporting.webapi.response.vo.OnGoingReportsByWeekCountVO;
import com.reporting.webapi.response.vo.OngoingReportVO;
import com.reporting.webapi.responsewrapper.vo.CustomOnGoingCountByWeeksVO;
import com.reporting.webapi.responsewrapper.vo.CustomOnGoingReportsByWeeksCountVO;
import com.reporting.webapi.responsewrapper.vo.CustomOngoingReportVO;
import com.reporting.webapi.util.CommonConstants;
import com.reporting.webapi.util.ReportsExcelBuilderUtil;

@Component
@Path(value=CommonConstants.ON_GOING_SERVICE)
public class OnGoingReportService {

private final Logger logger = Logger.getLogger(OnGoingReportService.class);
	
	@Autowired
	private IOnGoingReportAdapter onGoingReportAdapter;
	
	@Autowired
	private ReportsExcelBuilderUtil reportsExcelBuilderUtil;

	@Path(CommonConstants.ON_GOING_SERVICE_REFERENCE_DATA)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response getOnGoingReportReferenceData() {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: OnGoingReportService : getOnGoingReportReferenceData : Method to getOnGoingReportReferenceData");
		}
		
		CustomOngoingReportVO customOngoingReportVO = new CustomOngoingReportVO();
		try{
			OngoingReferanceDataBean ongoingReferanceDataBean = onGoingReportAdapter.getOnGoingReportReferenceData();
			
			OngoingReportVO ongoingReportVO =  new OngoingReportVO();
			ongoingReportVO.setMeasurementDate(ongoingReferanceDataBean.getMeasurementEndDate());
			ongoingReportVO.setControlgroups(ongoingReferanceDataBean.getControlGroupList());
			ongoingReportVO.setTypeOfHours(ongoingReferanceDataBean.getUnionType());
			
			customOngoingReportVO.setEligibilityReportOngoingVO(ongoingReportVO);
			
		} catch (Exception e) {
			logger.error("Error while invoking getOnGoingReportReferenceData : " + e.getMessage());
		}
		
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: OnGoingReportService : getOnGoingReportReferenceData : Method to getOnGoingReportReferenceData");
		}
		
		return Response.ok(customOngoingReportVO).build();
	}
	
	@Path(CommonConstants.ON_GOING_SERVICE_COUNT_BY_WEEK)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response getOnGoingReportCountByWeek(@QueryParam(CommonConstants.MEASUREMENT_END_DATE) String measurementEndDate,@QueryParam(CommonConstants.AVERAGE_WEEKLY_HOURS) String avgWeeklyHours,
			@QueryParam(CommonConstants.CONTROL_GROUP) String controlGroup,@QueryParam(CommonConstants.TYPE_OF_HOURS) String typeOfHours) {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: OnGoingReportService : getOnGoingReportCountByWeek : Method to getOnGoingReportCountByWeek");
		}
		
		CustomOnGoingCountByWeeksVO customOnGoingCountByWeeksVO = new CustomOnGoingCountByWeeksVO();
		List<OnGoingCountByWeeksVO> onGoingCountByWeeks = null;
		try{
			if(null != measurementEndDate && measurementEndDate.contains("''") &&  measurementEndDate.length() == 2) {
				measurementEndDate = null;
			}
			if(null != avgWeeklyHours && avgWeeklyHours.contains("''") &&  avgWeeklyHours.length() == 2) {
				avgWeeklyHours = null;
			}
			if(null != controlGroup && controlGroup.contains("''") &&  controlGroup.length() == 2) {
				controlGroup = null;
			}
			if(null != typeOfHours && typeOfHours.contains("''") &&  typeOfHours.length() == 2) {
				typeOfHours = null;
			}
			
			onGoingCountByWeeks =  onGoingReportAdapter.getOnGoingReportCountByWeek(measurementEndDate,avgWeeklyHours,controlGroup,
					typeOfHours);
			customOnGoingCountByWeeksVO.setOnGoingCountByWeeks(onGoingCountByWeeks);
		} catch (Exception e) {
			logger.error("Error while invoking getOnGoingReportCountByWeek : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: OnGoingReportService : getOnGoingReportCountByWeek : Method to getOnGoingReportCountByWeek");
		}
		
		return Response.ok(customOnGoingCountByWeeksVO).build();
	}
	
	@Path(CommonConstants.ON_GOING_SERVICE_REPORT_DATA)
	@GET
	@Produces( { MediaType.APPLICATION_JSON})
	public Response getOnGoingReportData(@QueryParam(CommonConstants.MEASUREMENT_END_DATE) String measurementEndDate,@QueryParam(CommonConstants.AVERAGE_WEEKLY_HOURS) String avgWeeklyHours,
			@QueryParam(CommonConstants.CONTROL_GROUP) String controlGroup,@QueryParam(CommonConstants.TYPE_OF_HOURS) String typeOfHours,
			@QueryParam(CommonConstants.REPORT_OF_WEEK) String reportOfWeek) {
		
		if(logger.isDebugEnabled()){
			logger.debug("START :: OnGoingReportService : getOnGoingReportData : Method to getOnGoingReportData");
		}
		
		CustomOnGoingReportsByWeeksCountVO customOnGoingReportsByWeeksCountVO = new CustomOnGoingReportsByWeeksCountVO();
		List<OnGoingReportsByWeekCountVO> onGoingReportsByWeekCount = null;
		try{
			
			
			if(null != measurementEndDate && measurementEndDate.contains("''") &&  measurementEndDate.length() == 2) {
				measurementEndDate = null;
			}
			if(null != avgWeeklyHours && avgWeeklyHours.contains("''") &&  avgWeeklyHours.length() == 2) {
				avgWeeklyHours = null;
			}
			if(null != controlGroup && controlGroup.contains("''") &&  controlGroup.length() == 2) {
				controlGroup = null;
			}
			if(null != typeOfHours && typeOfHours.contains("''") &&  typeOfHours.length() == 2) {
				typeOfHours = null;
			}
			onGoingReportsByWeekCount =  onGoingReportAdapter.getOnGoingReportData(measurementEndDate,avgWeeklyHours,controlGroup,typeOfHours,reportOfWeek);
			customOnGoingReportsByWeeksCountVO.setOnGoingReportsByWeekCount(onGoingReportsByWeekCount);
		} catch (Exception e) {
			logger.error("Error while invoking getOnGoingReportReportData : " + e.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("END :: OnGoingReportService : getOnGoingReportData : Method to getOnGoingReportData");
		}
		
		return Response.ok(customOnGoingReportsByWeeksCountVO).build();
	}
	
	@Path(CommonConstants.ON_GOING_SERVICE_PROCESS_EXCEL_ZIP_DOWNLOAD)
	@GET
	@Produces(CommonConstants.APPLICATION_ZIP)
	public Response processOnGoingReportExcelUpload(
			@QueryParam(CommonConstants.MEASUREMENT_END_DATE) String measurementEndDate,@QueryParam(CommonConstants.AVERAGE_WEEKLY_HOURS) String avgWeeklyHours,
			@QueryParam(CommonConstants.CONTROL_GROUP) String controlGroup,@QueryParam(CommonConstants.TYPE_OF_HOURS) String typeOfHours,
			@QueryParam(CommonConstants.REPORT_OF_WEEK) String reportOfWeek) {
		
		List<OnGoingReportsByWeekCountVO> onGoingReportsByWeekCount = null;
		String generatedReportsPath = "";
		try{
			
			
			if(null != measurementEndDate && measurementEndDate.contains("''") &&  measurementEndDate.length() == 2) {
				measurementEndDate = null;
			}
			if(null != avgWeeklyHours && avgWeeklyHours.contains("''") &&  avgWeeklyHours.length() == 2) {
				avgWeeklyHours = null;
			}
			if(null != controlGroup && controlGroup.contains("''") &&  controlGroup.length() == 2) {
				controlGroup = null;
			}
			if(null != typeOfHours && typeOfHours.contains("''") &&  typeOfHours.length() == 2) {
				typeOfHours = null;
			}
			
			onGoingReportsByWeekCount =  onGoingReportAdapter.getOnGoingReportData(measurementEndDate,avgWeeklyHours,controlGroup,typeOfHours,reportOfWeek);
			
			// Code To Invoke Excel Builder 
			Map<String, List<?>> reportsDataMap = new HashMap<>();
			reportsDataMap.put(CommonConstants.ON_GOING_REPORT, onGoingReportsByWeekCount);
			
			OngoingReferanceDataBean ongoingReferanceDataBean = onGoingReportAdapter.getOnGoingReportReferenceData();
			List<String> controlGroupList = ongoingReferanceDataBean.getControlGroupList();
			
			generatedReportsPath = reportsExcelBuilderUtil.buildExcelDocument(reportsDataMap, controlGroupList, measurementEndDate, avgWeeklyHours, controlGroup, typeOfHours);
						
			
		} catch (Exception e) {
			//logger.error("Error while invoking getHireWorkYears : " + e.getMessage());
		}
		
		File downloadDocumentFile = new File(generatedReportsPath + ".zip");
		String buildZipFilename = "OnGoingReports_" + generatedReportsPath.substring(generatedReportsPath.lastIndexOf("/")+1, generatedReportsPath.length()) + ".zip";
		ResponseBuilder responseBuilder = Response.ok((Object) downloadDocumentFile);
        responseBuilder.header("Content-Disposition", "attachment; filename=" + buildZipFilename );
		return responseBuilder.build();
	}
	
}
