package com.onboarding.webapi.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;

import com.onboarding.webapi.util.CommonUtil;

@Path("/uploadfile")
public class FileUploadService {

	private static final Logger logger = Logger.getLogger(FileUploadService.class);
	
	/** The path to the folder where we want to store the uploaded files */
	private static final String UPLOAD_FOLDER = "c:/DataOnBoarding_Files/uploadedFiles/";
	
	@Autowired
	private CommonUtil commonUtil;
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail,
			@FormDataParam("location") String uploadLocation) {

		// check if all form parameters are provided
		if (uploadedInputStream == null || fileDetail == null) {
			return Response.status(400).entity("Invalid form data").build();
		}
		
		// create our destination folder, if it not exists
		try {
			logger.info("Value of uploadLocation : " + uploadLocation);
			commonUtil.createFolderIfNotExists(uploadLocation);
		} catch (SecurityException se) {
			return Response.status(500).entity("Can not create destination folder on server").build();
		}

		String uploadedFileLocation = uploadLocation + fileDetail.getFileName();
		logger.info("Value of uploadedFileLocation : " + uploadedFileLocation);
		
		try {
			saveToFile(uploadedInputStream, uploadedFileLocation);
		} catch (IOException e) {
			return Response.status(500).entity("Can not save file").build();
		}
		return Response.status(200).entity("File saved to : " + uploadedFileLocation).build();
	}
	
	/**
	 * Method to Read the File InputStream and Write the content to the Destination Folder
	 * @param inStream
	 * @param target
	 * @throws IOException
	 */
	private void saveToFile(InputStream inStream, String target) throws IOException {
		OutputStream out = null;
		int read = 0;
		byte[] bytes = new byte[1024];
		try {
			out = new FileOutputStream(new File(target));
			while ((read = inStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
		} catch (Exception e) {
			logger.error("Error while invoking saveToFile : " + e.getMessage());
		} finally {
			if (null != out) {
				out.close();
			}
		}
	}
}
