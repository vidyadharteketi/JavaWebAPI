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

import com.reporting.webapi.response.vo.ReportsForPayrollDataActivityVO;
import com.reporting.webapi.util.CommonUtil;
import com.reporting.webapi.util.FolderZipUtil;


@Component
public class PayrollDataActivityReportExcelBuilder {

	private final Logger logger = Logger.getLogger(PayrollDataActivityReportExcelBuilder.class);

	@Autowired
	private CommonUtil commonUtil;

	@Autowired
	private FolderZipUtil folderZipUtil;

	public String processExcelContent(Map<String, List<ReportsForPayrollDataActivityVO>> reportsMapByControlGroup, String[] argParams) throws UnsupportedEncodingException {

		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		XSSFCellStyle style = null;
		Set<String> keySetValues = reportsMapByControlGroup.keySet();

		String forderNameTimeStampString = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");

		String pathArr[] = fullPath.split("/WEB-INF/classes/");
		String reportsPath = pathArr[0]+"/reportsData/PayrollDataActivityReports/"+forderNameTimeStampString;

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
			List<ReportsForPayrollDataActivityVO> reportsList = reportsMapByControlGroup.get(reportMapKey);

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
			header.createCell(0).setCellValue("SSN");
			header.getCell(0).setCellStyle(style);
			header.createCell(1).setCellValue("Employee Name");
			header.getCell(1).setCellStyle(style);
			header.createCell(2).setCellValue("EIN");
			header.getCell(2).setCellStyle(style);
			header.createCell(3).setCellValue("Production Company");
			header.getCell(3).setCellStyle(style);
			header.createCell(4).setCellValue("Hire Date");
			header.getCell(4).setCellStyle(style);
			header.createCell(5).setCellValue("Last Date Worked");
			header.getCell(5).setCellStyle(style);
			header.createCell(6).setCellValue("Project");
			header.getCell(6).setCellStyle(style);
			header.createCell(7).setCellValue("ClientID");
			header.getCell(7).setCellStyle(style);
			header.createCell(8).setCellValue("Source");
			header.getCell(8).setCellStyle(style);
			header.createCell(9).setCellValue("Employment Status");
			header.getCell(9).setCellStyle(style);
			header.createCell(10).setCellValue("Union Hours");
			header.getCell(10).setCellStyle(style);
			header.createCell(11).setCellValue("Jan");
			header.getCell(11).setCellStyle(style);
			header.createCell(12).setCellValue("Feb");
			header.getCell(12).setCellStyle(style);
			header.createCell(13).setCellValue("Mar");
			header.getCell(13).setCellStyle(style);
			header.createCell(14).setCellValue("Apr");
			header.getCell(14).setCellStyle(style);
			header.createCell(15).setCellValue("May");
			header.getCell(15).setCellStyle(style);
			header.createCell(16).setCellValue("Jun");
			header.getCell(16).setCellStyle(style);
			header.createCell(17).setCellValue("Jul");
			header.getCell(17).setCellStyle(style);
			header.createCell(18).setCellValue("Aug");
			header.getCell(18).setCellStyle(style);
			header.createCell(19).setCellValue("Sep");
			header.getCell(19).setCellStyle(style);
			header.createCell(20).setCellValue("Oct");
			header.getCell(20).setCellStyle(style);
			header.createCell(21).setCellValue("Nov");
			header.getCell(21).setCellStyle(style);
			header.createCell(22).setCellValue("Dec");
			header.getCell(22).setCellStyle(style);

			int rowCount = 1;
			for(Object reportObj : reportsList) {
				ReportsForPayrollDataActivityVO reportRowBean = (ReportsForPayrollDataActivityVO)reportObj;

				Row newRow = sheet.createRow(rowCount++);

				newRow.createCell(0).setCellValue(reportRowBean.getSSN_NUMBER());
				newRow.createCell(1).setCellValue(reportRowBean.getFIRST_NAME() + " " + reportRowBean.getLAST_NAME());
				newRow.createCell(2).setCellValue(reportRowBean.getEIN());
				newRow.createCell(3).setCellValue(reportRowBean.getPRODUCTION_COMPANY());
				newRow.createCell(4).setCellValue(reportRowBean.getHIRE_DATE());
				newRow.createCell(5).setCellValue(reportRowBean.getLAST_DATE_WORKED());
				newRow.createCell(6).setCellValue(reportRowBean.getPROJECT());
				newRow.createCell(7).setCellValue(reportRowBean.getCLIENT_ID());
				newRow.createCell(8).setCellValue(reportRowBean.getSOURCE());
				newRow.createCell(9).setCellValue(reportRowBean.getEMPLOYMENT_STATUS());
				newRow.createCell(10).setCellValue(reportRowBean.getUNION_HOURS());
				newRow.createCell(11).setCellValue(reportRowBean.getJANUARY());
				newRow.createCell(12).setCellValue(reportRowBean.getFEBRUARY());
				newRow.createCell(13).setCellValue(reportRowBean.getMARCH());
				newRow.createCell(14).setCellValue(reportRowBean.getAPRIL());
				newRow.createCell(15).setCellValue(reportRowBean.getMAY());
				newRow.createCell(16).setCellValue(reportRowBean.getJUNE());
				newRow.createCell(17).setCellValue(reportRowBean.getJULY());
				newRow.createCell(18).setCellValue(reportRowBean.getAUGUST());
				newRow.createCell(19).setCellValue(reportRowBean.getSEPTEMBER());
				newRow.createCell(20).setCellValue(reportRowBean.getOCTOBER());
				newRow.createCell(21).setCellValue(reportRowBean.getNOVEMBER());
				newRow.createCell(22).setCellValue(reportRowBean.getDECEMBER());
			}

			try{
				String fileName = commonUtil.buildUploadExcelFileName(argParams);
				System.out.println("FileName Built with aegument params : " + fileName);
				logger.info("PayrollDataActivityReportExcelBuilder :: FileName Built with aegument params : " + fileName);

				FileOutputStream outputStream = new FileOutputStream(reportsPath+"/"+fileName);

				workbook.write(outputStream);
				workbook.close();

			} catch(FileNotFoundException fe) {
				logger.error(" PayrollDataActivityReportExcelBuilder :: Error while Building the Excel Report file : ", fe);
			} catch(Exception e) {
				logger.error(" PayrollDataActivityReportExcelBuilder :: Error while Building the Excel Report file : ", e);
			}finally {
				workbook = null;
				sheet = null;
				style = null;
			}

		}

		// Process ZIP the generated reports - with the Directory Name generated for Reports
		List<String> fileList = new ArrayList<String>(); 
		String sourceFolderPath = pathArr[0]+"/reportsData/PayrollDataActivityReports/"+forderNameTimeStampString;
		String outputZipFileName = sourceFolderPath + ".zip";

		fileList = commonUtil.generateFileList(reportsDirectory, fileList, sourceFolderPath);
		folderZipUtil.zipIt(outputZipFileName, sourceFolderPath, fileList,forderNameTimeStampString);

		return reportsPath;
	}
	
	public Map<String, List<ReportsForPayrollDataActivityVO>> processReportsMapByControlGroup(List<?> reportsList, List<String> controlGroupList) {
		Map<String, List<ReportsForPayrollDataActivityVO>> reportsMapByControlGroup = new HashMap<String, List<ReportsForPayrollDataActivityVO>>();
		for(String controlGroupName : controlGroupList) {
			List<ReportsForPayrollDataActivityVO> reportList = new ArrayList<ReportsForPayrollDataActivityVO>();
			for(Object objRef : reportsList) {
				ReportsForPayrollDataActivityVO nhnftReportObj = (ReportsForPayrollDataActivityVO)objRef;
				if(controlGroupName.equalsIgnoreCase(nhnftReportObj.getControlGroup())) {
					reportList.add(nhnftReportObj);
				}
			}
			reportsMapByControlGroup.put(controlGroupName, reportList);
		}
		return reportsMapByControlGroup;
	}

}
