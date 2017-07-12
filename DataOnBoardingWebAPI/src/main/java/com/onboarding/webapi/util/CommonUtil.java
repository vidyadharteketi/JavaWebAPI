package com.onboarding.webapi.util;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

	private final Logger logger = Logger.getLogger(CommonUtil.class);
	
	
	/* ******************************************************************************************* */
	/* ******************* Common Methods for FolderZipUtil Functionality ************************ */
	/* ******************************************************************************************* */
	/**
	 * Method to fetch All File Names in a particular directory and its corresponding sub-directories
	 * @param node
	 * @param fileList
	 * @param sourceFolderPath
	 * @return
	 */
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
	/**
	 * Method to Fetch the Exact File name from the Absolute Path
	 * @param file
	 * @param sourceFolderPath
	 * @return
	 */
	private String generateZipEntry(String file, String sourceFolderPath) {
		logger.info(" generateZipEntry method :: Value for File :: " + file);
		logger.info(" generateZipEntry method :: Value for sourceFolderPath :: " + sourceFolderPath);
		return file.substring(sourceFolderPath.length(), file.length());
	}
	
	/* ******************************************************************************************* */
	/* ******************* Common Methods for FolderZipUtil Functionality ************************ */
	/* ******************************************************************************************* */
	
	
	public Date convertStringToDate(String date) throws ParseException {

		String start_dt = date;
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date convertDate = null;
		try {
			convertDate = (Date) formatter.parse(start_dt);
		} catch (Exception e) {
			logger.error("Error while invoking : convertStringToDate(String date) :: " + e.getMessage());
		}
		return convertDate;
	}

	public Date convertStringToDate() throws ParseException {

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String format = formatter.format(date);
		Date convertDate = null;
		try {
			convertDate = (Date) formatter.parse(format);
		} catch (Exception e) {
			logger.error("Error while invoking : convertStringToDate() :: " + e.getMessage());
		}
		return convertDate;
	}
	
	/**
	 * Creates a folder to desired location if it not already exists
	 * 
	 * @param dirName - full path to the folder
	 * @throws SecurityException - in case you don't have permission to create the folder
	 */
	public void createFolderIfNotExists(String dirName) throws SecurityException {
		File theDir = new File(dirName);
		if (!theDir.exists()) {
			theDir.mkdir();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static <K extends Comparable, V> Map<K,V> sortByKeys(Map<K,V> map) {
	    return new TreeMap<>(map);
	}
	
}
