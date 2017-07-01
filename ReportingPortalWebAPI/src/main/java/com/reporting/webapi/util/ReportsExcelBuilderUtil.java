package com.reporting.webapi.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.reporting.webapi.response.vo.BreakInReportDataVO;
import com.reporting.webapi.response.vo.DemoGraphicsReportDataVO;
import com.reporting.webapi.response.vo.EligibilityReportDataVO;
import com.reporting.webapi.response.vo.OnGoingReportsByWeekCountVO;
import com.reporting.webapi.response.vo.ReportsByACAEligibleCountVO;
import com.reporting.webapi.response.vo.ReportsByAnnualizedMonthlyCountVO;
import com.reporting.webapi.response.vo.ReportsByWeeksCountVO;
import com.reporting.webapi.response.vo.ReportsForPayrollDataActivityVO;
import com.reporting.webapi.uploadexcel.builder.BreakInServiceReportExcelBuilder;
import com.reporting.webapi.uploadexcel.builder.DemographicsReportExcelBuilder;
import com.reporting.webapi.uploadexcel.builder.ERCoverageReportExcelBuilder;
import com.reporting.webapi.uploadexcel.builder.EligibilityReportExcelBuilder;
import com.reporting.webapi.uploadexcel.builder.NewHiresFullTimeReportExcelBuilder;
import com.reporting.webapi.uploadexcel.builder.NewHiresNonFullTimeReportExcelBuilder;
import com.reporting.webapi.uploadexcel.builder.OnGoingReportExcelBuilder;
import com.reporting.webapi.uploadexcel.builder.PayrollDataActivityReportExcelBuilder;

@Component
public class ReportsExcelBuilderUtil extends AbstractExcelView {

	private final Logger logger = Logger.getLogger(ReportsExcelBuilderUtil.class);
	
	@Autowired
	private NewHiresNonFullTimeReportExcelBuilder nhnftExcelBuilder;
	
	@Autowired
	private NewHiresFullTimeReportExcelBuilder nhftExcelBuilder;
	
	@Autowired
	private OnGoingReportExcelBuilder ongoingExcelBuilder;
	
	@Autowired
	private ERCoverageReportExcelBuilder erCoverageExcelBuilder;
	
	@Autowired
	private BreakInServiceReportExcelBuilder breakInServiceReportExcelBuilder;
	
	@Autowired
	private PayrollDataActivityReportExcelBuilder payrollDataActivityExcelBuilder;
	
	@Autowired
	private DemographicsReportExcelBuilder demographicsReportExcelBuilder;
	
	@Autowired
	private EligibilityReportExcelBuilder eligibilityReportExcelBuilder;
	
	@SuppressWarnings("unchecked")
	public String buildExcelDocument(Map<String,List<?>> reportsDataMap, List<String> controlGroupList,String...argParams) throws Exception {
		
        Set<String> reportsListKeys = reportsDataMap.keySet();
        String generatedDocumentPath = null;
        
        if(CollectionUtils.isNotEmpty(reportsListKeys)){
        	for(String reportKey : reportsListKeys) {
            	switch(reportKey) {
            		case "NewHiresNonFullTimeReport" :
            			if(null != argParams[2]) {
            				String controlGroupValue = argParams[2];
            				Map<String, List<ReportsByWeeksCountVO>> reportsMapByControlGroup = new HashMap<String, List<ReportsByWeeksCountVO>>();
            				List<ReportsByWeeksCountVO> reportList = (List<ReportsByWeeksCountVO>)reportsDataMap.get(reportKey);
            				reportsMapByControlGroup.put(controlGroupValue, reportList);
            				generatedDocumentPath = nhnftExcelBuilder.processExcelContent(reportsMapByControlGroup,argParams);
            			} else {
            				Map<String, List<ReportsByWeeksCountVO>> reportsMapByControlGroup = nhnftExcelBuilder.processReportsMapByControlGroup(reportsDataMap.get(reportKey), controlGroupList);
            				generatedDocumentPath = nhnftExcelBuilder.processExcelContent(reportsMapByControlGroup,argParams);
            			}
            			break;
            		case "NewHiresFullTimeReport" :
            			if(null != argParams[2]) {
            				String controlGroupValue = argParams[2];
            				Map<String, List<ReportsByACAEligibleCountVO>> reportsMapByControlGroup = new HashMap<String, List<ReportsByACAEligibleCountVO>>();
            				List<ReportsByACAEligibleCountVO> reportList = (List<ReportsByACAEligibleCountVO>)reportsDataMap.get(reportKey);
            				reportsMapByControlGroup.put(controlGroupValue, reportList);
            				generatedDocumentPath = nhftExcelBuilder.processExcelContent(reportsMapByControlGroup,argParams);
            			} else {
            				Map<String, List<ReportsByACAEligibleCountVO>> reportsMapByControlGroup = nhftExcelBuilder.processReportsMapByControlGroup(reportsDataMap.get(reportKey), controlGroupList);
            				generatedDocumentPath = nhftExcelBuilder.processExcelContent(reportsMapByControlGroup,argParams);
            			}
            			break;
            		case "OnGoingReport" :
            			if(null != argParams[2]) {
            				String controlGroupValue = argParams[2];
            				Map<String, List<OnGoingReportsByWeekCountVO>> reportsMapByControlGroup = new HashMap<String, List<OnGoingReportsByWeekCountVO>>();
            				List<OnGoingReportsByWeekCountVO> reportList = (List<OnGoingReportsByWeekCountVO>)reportsDataMap.get(reportKey);
            				reportsMapByControlGroup.put(controlGroupValue, reportList);
            				generatedDocumentPath = ongoingExcelBuilder.processExcelContent(reportsMapByControlGroup,argParams);
            			} else {
            				Map<String, List<OnGoingReportsByWeekCountVO>> reportsMapByControlGroup = ongoingExcelBuilder.processReportsMapByControlGroup(reportsDataMap.get(reportKey), controlGroupList);
            				generatedDocumentPath = ongoingExcelBuilder.processExcelContent(reportsMapByControlGroup,argParams);
            			}
            			break;
            		case "ERCoverageReport" : 
            			if(null != argParams[1]) {
            				String controlGroupValue = argParams[1];
            				Map<String, List<ReportsByAnnualizedMonthlyCountVO>> reportsMapByControlGroup = new HashMap<String, List<ReportsByAnnualizedMonthlyCountVO>>();
            				List<ReportsByAnnualizedMonthlyCountVO> reportList = (List<ReportsByAnnualizedMonthlyCountVO>)reportsDataMap.get(reportKey);
            				reportsMapByControlGroup.put(controlGroupValue, reportList);
            				generatedDocumentPath = erCoverageExcelBuilder.processExcelContent(reportsMapByControlGroup,argParams);
            			} else {
            				Map<String, List<ReportsByAnnualizedMonthlyCountVO>> reportsMapByControlGroup = erCoverageExcelBuilder.processReportsMapByControlGroup(reportsDataMap.get(reportKey), controlGroupList);
            				generatedDocumentPath = erCoverageExcelBuilder.processExcelContent(reportsMapByControlGroup,argParams);
            			}
            			break;
            			case "PayrollDataActivityReport" :
            				if(null != argParams[1]) {
                				String controlGroupValue = argParams[1];
                				Map<String, List<ReportsForPayrollDataActivityVO>> reportsMapByControlGroup = new HashMap<String, List<ReportsForPayrollDataActivityVO>>();
                				List<ReportsForPayrollDataActivityVO> reportList = (List<ReportsForPayrollDataActivityVO>)reportsDataMap.get(reportKey);
                				reportsMapByControlGroup.put(controlGroupValue, reportList);
                				generatedDocumentPath = payrollDataActivityExcelBuilder.processExcelContent(reportsMapByControlGroup,argParams);
                			} else {
                				Map<String, List<ReportsForPayrollDataActivityVO>> reportsMapByControlGroup = payrollDataActivityExcelBuilder.processReportsMapByControlGroup(reportsDataMap.get(reportKey), controlGroupList);
                				generatedDocumentPath = payrollDataActivityExcelBuilder.processExcelContent(reportsMapByControlGroup,argParams);
                			}
            			break;
            			case "BreakInReport" :
            				if(null != argParams[1]) {
                				String controlGroupValue = argParams[1];
                				Map<String, List<BreakInReportDataVO>> reportsMapByControlGroup = new HashMap<String, List<BreakInReportDataVO>>();
                				List<BreakInReportDataVO> reportList = (List<BreakInReportDataVO>)reportsDataMap.get(reportKey);
                				reportsMapByControlGroup.put(controlGroupValue, reportList);
                				generatedDocumentPath = breakInServiceReportExcelBuilder.processExcelContent(reportsMapByControlGroup,argParams);
                			} else {
                				Map<String, List<BreakInReportDataVO>> reportsMapByControlGroup = breakInServiceReportExcelBuilder.processReportsMapByControlGroup(reportsDataMap.get(reportKey), controlGroupList);
                				generatedDocumentPath = breakInServiceReportExcelBuilder.processExcelContent(reportsMapByControlGroup,argParams);
                			}
            			break;
            			case "DemographicsReport" :
            				if(null != argParams[1]) {
                				String controlGroupValue = argParams[1];
                				Map<String, List<DemoGraphicsReportDataVO>> reportsMapByControlGroup = new HashMap<String, List<DemoGraphicsReportDataVO>>();
                				List<DemoGraphicsReportDataVO> reportList = (List<DemoGraphicsReportDataVO>)reportsDataMap.get(reportKey);
                				reportsMapByControlGroup.put(controlGroupValue, reportList);
                				generatedDocumentPath = demographicsReportExcelBuilder.processExcelContent(reportsMapByControlGroup,argParams);
                			} else {
                				Map<String, List<DemoGraphicsReportDataVO>> reportsMapByControlGroup = demographicsReportExcelBuilder.processReportsMapByControlGroup(reportsDataMap.get(reportKey), controlGroupList);
                				generatedDocumentPath = demographicsReportExcelBuilder.processExcelContent(reportsMapByControlGroup,argParams);
                			}
            			break;
            			case "EligibilityReport" :
            				if(null != argParams[1]) {
                				String controlGroupValue = argParams[1];
                				Map<String, List<EligibilityReportDataVO>> reportsMapByControlGroup = new HashMap<String, List<EligibilityReportDataVO>>();
                				List<EligibilityReportDataVO> reportList = (List<EligibilityReportDataVO>)reportsDataMap.get(reportKey);
                				reportsMapByControlGroup.put(controlGroupValue, reportList);
                				generatedDocumentPath = eligibilityReportExcelBuilder.processExcelContent(reportsMapByControlGroup,argParams);
                			} else {
                				Map<String, List<EligibilityReportDataVO>> reportsMapByControlGroup = eligibilityReportExcelBuilder.processReportsMapByControlGroup(reportsDataMap.get(reportKey), controlGroupList);
                				generatedDocumentPath = eligibilityReportExcelBuilder.processExcelContent(reportsMapByControlGroup,argParams);
                			}
            			break;
            		default :
            			logger.info("ReportsExcelBuilder is invoked but the requested Report to be generated is not yet configured in the Reporting Portal");
            	}
            }
        }
        
        
        return generatedDocumentPath;
	}
	
	@Override
	protected void buildExcelDocument(Map<String, Object> arg0, HSSFWorkbook arg1, HttpServletRequest arg2,
			HttpServletResponse arg3) throws Exception {
		
		// TODO Auto-generated method stub
		
	}

}
