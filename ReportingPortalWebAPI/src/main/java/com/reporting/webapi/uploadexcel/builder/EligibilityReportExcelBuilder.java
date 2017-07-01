package com.reporting.webapi.uploadexcel.builder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.reporting.webapi.response.vo.EligibilityReportDataVO;
import com.reporting.webapi.response.vo.ReportsByAnnualizedMonthlyCountVO;
import com.reporting.webapi.util.CommonUtil;
import com.reporting.webapi.util.FolderZipUtil;


@Component
public class EligibilityReportExcelBuilder {

	private final Logger logger = Logger.getLogger(EligibilityReportExcelBuilder.class);

	@Autowired
	private CommonUtil commonUtil;
	
	@Autowired
	private FolderZipUtil folderZipUtil;
	
	public String processExcelContent(Map<String, List<EligibilityReportDataVO>> reportsMapByControlGroup, String[] argParams) throws UnsupportedEncodingException {
		
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		XSSFCellStyle style = null;
		Set<String> keySetValues = reportsMapByControlGroup.keySet();
		
		String forderNameTimeStampString = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");
		
		String pathArr[] = fullPath.split("/WEB-INF/classes/");
		String reportsPath = pathArr[0]+"/reportsData/EligibilityReports/"+forderNameTimeStampString;
		
		File reportsDirectory = new File(reportsPath);
		if(!reportsDirectory.exists()){
			try{
				reportsDirectory.mkdirs();
			} 
			catch(SecurityException se){
				logger.error(" processExcelContent :: Error while creating the required Directory : ", se);
			}      
		}
		
		for(String reportMapKey : keySetValues) {

			// Retrieving the ReportList specific to the ControlGroup matching reportMapKey
			List<EligibilityReportDataVO> reportsList = reportsMapByControlGroup.get(reportMapKey);

			// Set the Control Group Name to controlGroup param in argParams
			argParams[1] = reportMapKey;

			// Initializing workbook, sheet and style
			// initialize work book
			workbook = new XSSFWorkbook();

			// initialize sheet
			sheet = workbook.createSheet("Sheet1");

			sheet.setDefaultColumnWidth(30);

			XSSFCellStyle headerCellStyle = workbook.createCellStyle();
			XSSFFont boldFont = workbook.createFont();
			boldFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			headerCellStyle.setFont(boldFont);

			style = workbook.createCellStyle();
			XSSFFont font = workbook.createFont();

			font.setFontName("Arial");
			style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			font.setColor(IndexedColors.WHITE.getIndex());
			style.setFont(font);

			logger.info(" processExcelContent :: 'workbook', 'sheet' and 'style' have been initialized ");	
		
		Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Employee Name");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("Union Status");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("SSN");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("Most Recent Show");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("Most Recent Job Title");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("Average Weekly Hours");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("Total Hours");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("Standard Measured Eligibility");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("Benefits Effective");
        header.getCell(8).setCellStyle(style);
        
        int rowCount = 1;
        for(Object reportObj : reportsList) {
        	EligibilityReportDataVO reportRowBean = (EligibilityReportDataVO)reportObj;
        	
        	Row newRow = sheet.createRow(rowCount++);
        	
        	newRow.createCell(0).setCellValue(reportRowBean.getEmployeeName());
        	newRow.createCell(1).setCellValue(reportRowBean.getUnionStatus());
        	newRow.createCell(2).setCellValue(reportRowBean.getSsn());
        	newRow.createCell(3).setCellValue(reportRowBean.getMostRecentShow());
        	newRow.createCell(4).setCellValue(reportRowBean.getMostRecentJobTitle());
        	newRow.createCell(5).setCellValue(reportRowBean.getAverageWeeklyHours());
        	newRow.createCell(6).setCellValue(reportRowBean.getTotalHours());
        	newRow.createCell(7).setCellValue(reportRowBean.getStandardMeasuredEligibility());
        	newRow.createCell(8).setCellValue(reportRowBean.getBenefitsEffective());
        }
        
		try{
        	String fileName = commonUtil.buildUploadExcelFileName(argParams);
        	System.out.println("FileName Built with aegument params : " + fileName);
        	logger.info("ERCoverageReportExcelBuilder :: FileName Built with aegument params : " + fileName);
        	
        	FileOutputStream outputStream = new FileOutputStream(reportsPath+"/"+fileName);
        	
        	workbook.write(outputStream);
            workbook.close();
            
        } catch(FileNotFoundException fe) {
        	logger.error(" ERCoverageReportExcelBuilder :: Error while Building the Excel Report file : ", fe);
        } catch(Exception e) {
        	logger.error(" ERCoverageReportExcelBuilder :: Error while Building the Excel Report file : ", e);
        	}finally {
	        	workbook = null;
	        	sheet = null;
	        	style = null;
	        }
		
		}
		
		// Process ZIP the generated reports - with the Directory Name generated for Reports
				List<String> fileList = new ArrayList<String>(); 
				String sourceFolderPath = pathArr[0]+"/reportsData/EligibilityReports/"+forderNameTimeStampString;
				String outputZipFileName = sourceFolderPath + ".zip";
						
				fileList = commonUtil.generateFileList(reportsDirectory, fileList, sourceFolderPath);
				folderZipUtil.zipIt(outputZipFileName, sourceFolderPath, fileList,forderNameTimeStampString);
				
				return reportsPath;
	}
	
	public Map<String, List<EligibilityReportDataVO>> processReportsMapByControlGroup(List<?> reportsList, List<String> controlGroupList) {
		Map<String, List<EligibilityReportDataVO>> reportsMapByControlGroup = new HashMap<String, List<EligibilityReportDataVO>>();
		for(String controlGroupName : controlGroupList) {
			List<EligibilityReportDataVO> reportList = new ArrayList<EligibilityReportDataVO>();
			for(Object objRef : reportsList) {
				EligibilityReportDataVO nhnftReportObj = (EligibilityReportDataVO)objRef;
				if(controlGroupName.equalsIgnoreCase(nhnftReportObj.getControlGroup())) {
					reportList.add(nhnftReportObj);
				}
			}
			reportsMapByControlGroup.put(controlGroupName, reportList);
		}
		return reportsMapByControlGroup;
	}
}
