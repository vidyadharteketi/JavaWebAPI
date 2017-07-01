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

import com.reporting.webapi.response.vo.DemoGraphicsReportDataVO;
import com.reporting.webapi.util.CommonUtil;
import com.reporting.webapi.util.FolderZipUtil;


@Component
public class DemographicsReportExcelBuilder {

	private final Logger logger = Logger.getLogger(DemographicsReportExcelBuilder.class);

	@Autowired
	private CommonUtil commonUtil;
	
	@Autowired
	private FolderZipUtil folderZipUtil;
	
	public String processExcelContent(Map<String, List<DemoGraphicsReportDataVO>> reportsMapByControlGroup, String[] argParams) throws UnsupportedEncodingException {
		
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		XSSFCellStyle style = null;
		Set<String> keySetValues = reportsMapByControlGroup.keySet();
		
		String forderNameTimeStampString = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");
		
		String pathArr[] = fullPath.split("/WEB-INF/classes/");
		String reportsPath = pathArr[0]+"/reportsData/DemographicsReports/"+forderNameTimeStampString;
		
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
			List<DemoGraphicsReportDataVO> reportsList = reportsMapByControlGroup.get(reportMapKey);

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
        header.createCell(0).setCellValue("Parent Company");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("Production Company");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("Show Name");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("Payroll Company");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("Employee Name");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("Union Status");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("SSN");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("ACA Employeement Basis");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("Schedule Code");
        header.getCell(8).setCellStyle(style);
        header.createCell(9).setCellValue("Pay Rate");
        header.getCell(9).setCellStyle(style);
        header.createCell(10).setCellValue("Job Description");
        header.getCell(10).setCellStyle(style);
        header.createCell(11).setCellValue("Gender");
        header.getCell(11).setCellStyle(style);
        header.createCell(12).setCellValue("Date of Birth");
        header.getCell(12).setCellStyle(style);
        header.createCell(13).setCellValue("Email");
        header.getCell(13).setCellStyle(style);
        header.createCell(14).setCellValue("Address");
        header.getCell(14).setCellStyle(style);
        header.createCell(15).setCellValue("City");
        header.getCell(15).setCellStyle(style);
        header.createCell(16).setCellValue("State");
        header.getCell(16).setCellStyle(style);
        header.createCell(17).setCellValue("Zip");
        header.getCell(17).setCellStyle(style);
        header.createCell(18).setCellValue("Control Group");
        header.getCell(18).setCellStyle(style);
        
        
        int rowCount = 1;
        for(Object reportObj : reportsList) {
        	DemoGraphicsReportDataVO reportRowBean = (DemoGraphicsReportDataVO)reportObj;
        	
        	Row newRow = sheet.createRow(rowCount++);
        	
        	newRow.createCell(0).setCellValue(reportRowBean.getParentCompany());
        	newRow.createCell(1).setCellValue(reportRowBean.getProductionCompany());
        	newRow.createCell(2).setCellValue(reportRowBean.getShowName());
        	newRow.createCell(3).setCellValue(reportRowBean.getPayrollCompany());
        	newRow.createCell(4).setCellValue(reportRowBean.getEmployeeName());
        	newRow.createCell(5).setCellValue(reportRowBean.getUnionStatus());
        	newRow.createCell(6).setCellValue(reportRowBean.getSsn());
        	newRow.createCell(7).setCellValue(reportRowBean.getaCAEmploymentBasis());
        	newRow.createCell(8).setCellValue(reportRowBean.getScheduleCode());
        	newRow.createCell(9).setCellValue(reportRowBean.getPayRate());
        	newRow.createCell(10).setCellValue(reportRowBean.getJobDescription());
        	newRow.createCell(11).setCellValue(reportRowBean.getGender());
        	newRow.createCell(12).setCellValue(reportRowBean.getDateOfBirth());
        	newRow.createCell(13).setCellValue(reportRowBean.getEmail());
        	newRow.createCell(14).setCellValue(reportRowBean.getAddress());
        	newRow.createCell(15).setCellValue(reportRowBean.getCity());
        	newRow.createCell(16).setCellValue(reportRowBean.getState());
        	newRow.createCell(17).setCellValue(reportRowBean.getZip());
        	newRow.createCell(18).setCellValue(reportRowBean.getControlGroup());
        }
        
		try{
        	String fileName = commonUtil.buildUploadExcelFileName(argParams);
        	System.out.println("FileName Built with aegument params : " + fileName);
        	logger.info("DemographicsReportExcelBuilder :: FileName Built with aegument params : " + fileName);
        	
        	FileOutputStream outputStream = new FileOutputStream(reportsPath+"/"+fileName);
        	
        	workbook.write(outputStream);
            workbook.close();
            
        } catch(FileNotFoundException fe) {
        	logger.error(" DemographicsReportExcelBuilder :: Error while Building the Excel Report file : ", fe);
        } catch(Exception e) {
        	logger.error(" DemographicsReportExcelBuilder :: Error while Building the Excel Report file : ", e);
        	}finally {
	        	workbook = null;
	        	sheet = null;
	        	style = null;
	        }
		
		}
		
		// Process ZIP the generated reports - with the Directory Name generated for Reports
				List<String> fileList = new ArrayList<String>(); 
				String sourceFolderPath = pathArr[0]+"/reportsData/DemographicsReports/"+forderNameTimeStampString;
				String outputZipFileName = sourceFolderPath + ".zip";
						
				fileList = commonUtil.generateFileList(reportsDirectory, fileList, sourceFolderPath);
				folderZipUtil.zipIt(outputZipFileName, sourceFolderPath, fileList,forderNameTimeStampString);
				
				return reportsPath;
	}
	
	public Map<String, List<DemoGraphicsReportDataVO>> processReportsMapByControlGroup(List<?> reportsList, List<String> controlGroupList) {
		Map<String, List<DemoGraphicsReportDataVO>> reportsMapByControlGroup = new HashMap<String, List<DemoGraphicsReportDataVO>>();
		for(String controlGroupName : controlGroupList) {
			List<DemoGraphicsReportDataVO> reportList = new ArrayList<DemoGraphicsReportDataVO>();
			for(Object objRef : reportsList) {
				DemoGraphicsReportDataVO nhnftReportObj = (DemoGraphicsReportDataVO)objRef;
				if(controlGroupName.equalsIgnoreCase(nhnftReportObj.getControlGroup())) {
					reportList.add(nhnftReportObj);
				}
			}
			reportsMapByControlGroup.put(controlGroupName, reportList);
		}
		return reportsMapByControlGroup;
	}
}
