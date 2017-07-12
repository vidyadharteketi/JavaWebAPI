package com.onboarding.webapi.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;


public class FileUploaderClient {
	
	private final Logger logger = Logger.getLogger(FileUploaderClient.class);

	public static void main(String[] args) {

		FileInputStream fis = null;
		try {
			DefaultHttpClient httpclient = new DefaultHttpClient(new BasicHttpParams());

			// server back-end URL
			HttpPost httppost = new HttpPost("http://localhost:9988/DataOnBoardingWebAPI/rest/uploadfile");
			
			MultipartEntity entity = new MultipartEntity();
			
			// set the Upload Location
			String uploadLocation = new String("C:/DataOnBoarding_Files/uploadedFiles/");
			
			// Initialize File we want to Upload and alsoFileInputStream
			File inFile = new File("C:/Users/abeerkur/Downloads/Bhubuksha-One Meal One Smile.jpg");
			fis = new FileInputStream(inFile);
			
			// set the location as argument
			entity.addPart("location", new StringBody(uploadLocation, "text/plain", Charset.forName( "UTF-8" )));
			
			// set the file input stream and file name as arguments
			entity.addPart("file", new InputStreamBody(fis, inFile.getName()));
			
			// set the entity to POST Request
			httppost.setEntity(entity);
			
			// execute the request
			HttpResponse response = httpclient.execute(httppost);

			int statusCode = response.getStatusLine().getStatusCode();
			HttpEntity responseEntity = response.getEntity();
			String responseString = EntityUtils.toString(responseEntity, "UTF-8");

			System.out.println("[" + statusCode + "] " + responseString);

		} catch (ClientProtocolException e) {
			System.err.println("Unable to make connection");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Unable to read file");
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				System.err.println("Error while closing the stream :: " + e.getMessage());
			}
		}

	}
}
