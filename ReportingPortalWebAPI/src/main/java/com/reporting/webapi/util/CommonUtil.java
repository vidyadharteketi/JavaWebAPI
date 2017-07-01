package com.reporting.webapi.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

	private final Logger logger = Logger.getLogger(CommonUtil.class);
	
	/**
	 * Method to build Excel FileName
	 * @param argParams
	 * @return
	 */
	public String buildUploadExcelFileName(String[] argParams) {
		StringBuilder fileName = new StringBuilder();
		for(String param : argParams) {
			if(null != param && param.length() > 0){
				logger.info("Excel File added :: " + fileName);
				fileName = fileName.append(param).append("_");
			}
		}
		
		// Adding Current System TimeStamp to fileName
		String dateTimeStampString = new SimpleDateFormat("yyyyMMddHHmmsss").format(new Date());
		fileName.append(dateTimeStampString);
		
		// Appending .xlsx extension to fileName
		fileName.append(".xlsx");
		
		return fileName.toString();
	}
	
	public List<String> generateFileList(File node, List<String> fileList, String sourceFolderPath) {
		// add file only
		if (node.isFile()) {
			logger.info(" generateFileList method :: File added to fileList :: " + node.toString());
			fileList.add(generateZipEntry(node.toString(), sourceFolderPath));
		}
		
		if (node.isDirectory()) {
			String[] subNode = node.list();
			for (String filename : subNode) {
				generateFileList(new File(node, filename), fileList, sourceFolderPath);
			}
		}
		return fileList;
	}

	private String generateZipEntry(String file, String sourceFolderPath) {
		logger.info(" generateZipEntry method :: Value for File :: " + file);
		logger.info(" generateZipEntry method :: Value for sourceFolderPath :: " + sourceFolderPath);
		return file.substring(sourceFolderPath.length(), file.length());
	}

	
	
	/*public void initializeWorkBookDetails(XSSFWorkbook workbook, XSSFSheet sheet, XSSFCellStyle style) {
		
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
        
        logger.info(" ReportsExcelBuilderUtil :: 'workbook', 'sheet' and 'style' have been initialized ");
	}*/
}
