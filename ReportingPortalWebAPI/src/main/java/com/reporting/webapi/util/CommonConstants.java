package com.reporting.webapi.util;


public class CommonConstants {
	
	public static final String APPLICATION_ZIP = "application/zip";
	
	//Query Params
	public static final String WORK_YEAR = "WorkYear";
	public static final String WORK_MONTH = "WorkMonth";
	public static final String CONTROL_GROUP = "ControlGroup";
	public static final String WEEK_STARTING = "WeekStarting";
	public static final String WEEK_ENDING = "WeekEnding";
	public static final String PARENT_COMPANY = "ParentCompnay";
	public static final String PRODUCTION_COMPANY = "Proudctioncompany";
	public static final String PAYROLL_COMPANY = "PayrollCompany";
	public static final String UNION_STATUS = "UnionStatus";
	public static final String UNION_TYPE = "UnionType";
	public static final String TYPE_OF_HOURS = "TypeOfHours";
	public static final String EMPLOYEE_TYPE = "EmployeeType";
	public static final String REPORT_OF_WEEK = "ReportOfWeek";
	public static final String ACA_ELIGIBLE_COUNT = "AcaEligibleCount";
	public static final String MEASUREMENT_END_DATE = "MeasurementEndDate";
	public static final String AVERAGE_WEEKLY_HOURS = "AvgWeeklyHours";
	public static final String ANNUALIZED_MONTHLY_COUNT = "annualizedMonthlyCount";
	
	//Setting Report Name to Map
	public static final String NEW_HIRES_NON_FULL_TIME_REPORTS = "NewHiresNonFullTimeReport";
	public static final String NEW_HIRES_FULL_TIME_REPORTS = "NewHiresFullTimeReport";
	public static final String ON_GOING_REPORT = "OnGoingReport";
	public static final String ER_COVERAGE_REPORT = "ERCoverageReport";
	public static final String PAYROLL_DATA_ACTIVITY_REPORT = "PayrollDataActivityReport";
	public static final String BREAK_IN_REPORT = "BreakInReport";
	public static final String DEMO_GRAPHICS_REPORT = "DemographicsReport";
	public static final String ELIGIBILITY_REPORT = "EligibilityReport";
	
	//New Hires Non FullTime Report Service Constants
	public static final String NEW_HIRES_NON_FULL_TIME_SERVICE = "/newhiresnonfulltimereportservice";
	public static final String NEW_HIRES_NON_FULL_TIME_SERVICE_REFERENCE_DATA = "/getNewHiresNonFullTimeReportReferenceData";
	public static final String NEW_HIRES_NON_FULL_TIME_SERVICE_COUNT_BY_WEEK = "/getNewHiresNonFullTimeCountByWeek";
	public static final String NEW_HIRES_NON_FULL_TIME_SERVICE_REPORT_DATA = "/getNewHiresNonFullTimeReportData";
	public static final String NEW_HIRES_NON_FULL_TIME_SERVICE_PROCESS_EXCEL_ZIP_DOWNLOAD = "/processnewhiresnonfulltimeexcelzipdownload";
	
	//New Hires FullTime Report Service Constants
	public static final String NEW_HIRES_FULL_TIME_SERVICE = "/newhiresfulltimereportservice";
	public static final String NEW_HIRES_FULL_TIME_SERVICE_REFERENCE_DATA = "/getNewHiresFullTimeReportReferenceData";
	public static final String NEW_HIRES_FULL_TIME_SERVICE_COUNT_BY_WEEK = "/getNewHiresFullTimeCountByWeek";
	public static final String NEW_HIRES_FULL_TIME_SERVICE_REPORT_DATA = "/getNewHiresFullTimeReportData";
	public static final String NEW_HIRES_FULL_TIME_SERVICE_PROCESS_EXCEL_ZIP_DOWNLOAD = "/processNewHireFullTimeExcelUpload";
	
	//On Going Report Service Constants
	public static final String ON_GOING_SERVICE = "/ongoingreportservice";
	public static final String ON_GOING_SERVICE_REFERENCE_DATA = "/getonGoingreportreferencedata";
	public static final String ON_GOING_SERVICE_COUNT_BY_WEEK = "/getOnGoingReportCountByWeek";
	public static final String ON_GOING_SERVICE_REPORT_DATA = "/getOnGoingReportReportData";
	public static final String ON_GOING_SERVICE_PROCESS_EXCEL_ZIP_DOWNLOAD = "/processOnGoingReportExcelUpload";
	
	//ER Coverage Report Service Constants
	public static final String ER_COVERAGE_SERVICE = "/ercoveragereportservice";
	public static final String ER_COVERAGE_SERVICE_REFERENCE_DATA = "/getERCoverageReportReferenceData";
	public static final String ER_COVERAGE_SERVICE_COUNT_BY_WEEK = "/getERCoverageReportCountByWeek";
	public static final String ER_COVERAGE_SERVICE_REPORT_DATA = "/getERCoverageReportData";
	public static final String ER_COVERAGE_SERVICE_PROCESS_EXCEL_ZIP_DOWNLOAD = "/processERCoverageReportExcelUpload";
	
	//Pay Roll Data Active Report Service Constants
	public static final String PAY_ROLL_DATA_ACTIVE_SERVICE = "/payrolldataactivityreportservice";
	public static final String PAY_ROLL_DATA_ACTIVE_SERVICE_REFERENCE_DATA = "/getPayrollDataActivityReportReferenceData";
	public static final String PAY_ROLL_DATA_ACTIVE_SERVICE_REPORT_DATA = "/getPayrollDataActivityReportData";
	public static final String PAY_ROLL_DATA_ACTIVE_SERVICE_PROCESS_EXCEL_ZIP_DOWNLOAD = "/processPayrollDataActivityReportExcelUpload";
	
	//Break In Report Service Constants
	public static final String BREAK_IN_SERVICE = "/breakinreportservice";
	public static final String BREAK_IN_SERVICE_REFERENCE_DATA = "/getBreakInReportReferenceData";
	public static final String BREAK_IN_SERVICE_REPORT_DATA = "/getBreakInServiceReportData";
	public static final String BREAK_IN_SERVICE_PROCESS_EXCEL_ZIP_DOWNLOAD = "/processBreakInServiceReportExcelUpload";

	//Demo Graphics Report Service Constants
	public static final String DEMO_GRAPHICS_SERVICE = "/demographicsreportservice";
	public static final String DEMO_GRAPHICS_SERVICE_REFERENCE_DATA = "/getDemographicsReferenceData";
	public static final String DEMO_GRAPHICS_SERVICE_REPORT_DATA = "/getDemographicsReportData";
	public static final String DEMO_GRAPHICS_SERVICE_PROCESS_EXCEL_ZIP_DOWNLOAD = "/processDemographicsServiceReportExcelUpload";
	
	//Eligibility Report Service Constants
	public static final String Eligibility_SERVICE = "/eligibilityreportservice";
	public static final String Eligibility_SERVICE_REFERENCE_DATA = "/getEligibilityReferenceData";
	public static final String Eligibility_SERVICE_REPORT_DATA = "/getEligibilityReportData";
	public static final String Eligibility_SERVICE_PROCESS_EXCEL_ZIP_DOWNLOAD = "/processEligibilityServiceReportExcelUpload";
}
