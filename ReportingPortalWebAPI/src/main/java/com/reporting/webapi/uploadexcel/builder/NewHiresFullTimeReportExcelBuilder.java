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

import com.reporting.webapi.response.vo.ReportsByACAEligibleCountVO;
import com.reporting.webapi.util.CommonUtil;
import com.reporting.webapi.util.FolderZipUtil;


@Component
public class NewHiresFullTimeReportExcelBuilder {

	private final Logger logger = Logger.getLogger(NewHiresFullTimeReportExcelBuilder.class);

	@Autowired
	private CommonUtil commonUtil;
	
	@Autowired
	private FolderZipUtil folderZipUtil;
	
	public String processExcelContent(Map<String, List<ReportsByACAEligibleCountVO>> reportsMapByControlGroup, String[] argParams) throws UnsupportedEncodingException {
		
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		XSSFCellStyle style = null;
		Set<String> keySetValues = reportsMapByControlGroup.keySet();
		
		String folderNameTimeStampString = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");
		
		String pathArr[] = fullPath.split("/WEB-INF/classes/");
		String reportsPath = pathArr[0]+"/reportsData/NewHireFullTimeReports/"+folderNameTimeStampString;
	    
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
			List<ReportsByACAEligibleCountVO> reportsList = reportsMapByControlGroup.get(reportMapKey);
			
			// Set the Control Group Name to controlGroup param in argParams
			argParams[2] = reportMapKey;
			
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
	        
	        // Setting the Header Names
			Row header = sheet.createRow(0);
	        header.createCell(0).setCellValue("Control Group");
	        header.getCell(0).setCellStyle(style);
	        header.createCell(1).setCellValue("Most Recent Production Company");
	        header.getCell(1).setCellStyle(style);
	        header.createCell(2).setCellValue("Most Recent Project");
	        header.getCell(2).setCellStyle(style);
	        header.createCell(3).setCellValue("SSN Number");
	        header.getCell(3).setCellStyle(style);
	        header.createCell(4).setCellValue("First Name");
	        header.getCell(4).setCellStyle(style);
	        header.createCell(5).setCellValue("Last Name");
	        header.getCell(5).setCellStyle(style);
	        header.createCell(6).setCellValue("Last Worked Date");
	        header.getCell(6).setCellStyle(style);
	        header.createCell(7).setCellValue("Hire Date");
	        header.getCell(7).setCellStyle(style);
	        header.createCell(8).setCellValue("Union / Non Union");
	        header.getCell(8).setCellStyle(style);
	        header.createCell(9).setCellValue("Payroll Source");
	        header.getCell(9).setCellStyle(style);
	        header.createCell(10).setCellValue("Average Hours");
	        header.getCell(10).setCellStyle(style);
	        header.createCell(11).setCellValue("Total Hours");
	        header.getCell(11).setCellStyle(style);
        
	        int rowCount = 1;
	        for(Object reportObj : reportsList) {
	        	ReportsByACAEligibleCountVO reportRowBean = (ReportsByACAEligibleCountVO)reportObj;
	        	
	        	Row newRow = sheet.createRow(rowCount++);
	        	
	        	newRow.createCell(0).setCellValue(reportRowBean.getCONTROL_GROUP());
	        	newRow.createCell(1).setCellValue(reportRowBean.getMOST_RECENT_PRODUCTION_COMPANY());
	        	newRow.createCell(2).setCellValue(reportRowBean.getMOST_RECENT_PROJECT());
	        	newRow.createCell(3).setCellValue(reportRowBean.getSSN_NUMBER());
	        	newRow.createCell(4).setCellValue(reportRowBean.getFIRST_NAME());
	        	newRow.createCell(5).setCellValue(reportRowBean.getLAST_NAME());
	        	newRow.createCell(6).setCellValue(reportRowBean.getLAST_WORKED_DATE());
	        	newRow.createCell(7).setCellValue(reportRowBean.getHIRE_DATE());
	        	newRow.createCell(8).setCellValue(reportRowBean.getUNION_NON_UNION());
	        	newRow.createCell(9).setCellValue(reportRowBean.getPAYROLL_SOURCE());
	        	newRow.createCell(10).setCellValue(reportRowBean.getAVERAGE_HOURS());
	        	newRow.createCell(11).setCellValue(reportRowBean.getTOTAL_HOURS_WEEKS());
	        }
        
	        // Generating the Excel Document in the specific Folder
			try{
	        	String fileName = commonUtil.buildUploadExcelFileName(argParams);
	        	System.out.println("FileName Built with aegument params : " + fileName);
	        	logger.info("NewHiresFullTimeReportExcelBuilder :: FileName Built with aegument params : " + fileName);
	        	
	        	FileOutputStream outputStream = new FileOutputStream(reportsPath+"/"+fileName);
	        	
	        	workbook.write(outputStream);
	            workbook.close();
	            
	        } catch(FileNotFoundException fe) {
	        	logger.error(" NewHiresFullTimeReportExcelBuilder :: Error while Building the Excel Report file : ", fe);
	        } catch(Exception e) {
	        	logger.error(" NewHiresFullTimeReportExcelBuilder :: Error while Building the Excel Report file : ", e);
	        } finally {
	        	workbook = null;
	        	sheet = null;
	        	style = null;
	        }
		}
		
		// Process ZIP the generated reports - with the Directory Name generated for Reports
		List<String> fileList = new ArrayList<String>(); 
		String sourceFolderPath = pathArr[0]+"/reportsData/NewHireFullTimeReports/"+folderNameTimeStampString;
		String outputZipFileName = sourceFolderPath + ".zip";
				
		fileList = commonUtil.generateFileList(reportsDirectory, fileList, sourceFolderPath);
		folderZipUtil.zipIt(outputZipFileName, sourceFolderPath, fileList,folderNameTimeStampString);
		
		return reportsPath;
	}
	
	public Map<String, List<ReportsByACAEligibleCountVO>> processReportsMapByControlGroup(List<?> reportsList, List<String> controlGroupList) {
		Map<String, List<ReportsByACAEligibleCountVO>> reportsMapByControlGroup = new HashMap<String, List<ReportsByACAEligibleCountVO>>();
		for(String controlGroupName : controlGroupList) {
			List<ReportsByACAEligibleCountVO> reportList = new ArrayList<ReportsByACAEligibleCountVO>();
			for(Object objRef : reportsList) {
				ReportsByACAEligibleCountVO nhnftReportObj = (ReportsByACAEligibleCountVO)objRef;
				if(controlGroupName.equalsIgnoreCase(nhnftReportObj.getCONTROL_GROUP())) {
					reportList.add(nhnftReportObj);
				}
			}
			reportsMapByControlGroup.put(controlGroupName, reportList);
		}
		return reportsMapByControlGroup;
	}
}
