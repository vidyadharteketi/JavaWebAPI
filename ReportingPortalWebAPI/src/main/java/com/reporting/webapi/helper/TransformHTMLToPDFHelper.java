package com.reporting.webapi.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.allcolor.yahp.converter.CYaHPConverter;
import org.allcolor.yahp.converter.IHtmlToPdfTransformer;
import org.allcolor.yahp.converter.IHtmlToPdfTransformer.CConvertException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransformHTMLToPDFHelper {
	
	private final Logger logger = Logger.getLogger(TransformHTMLToPDFHelper.class);
	
	public void transform(File inputFile, File outputFile) throws Exception {

		FileOutputStream out = null;
		Map properties = new HashMap();
		List headerFooterList = new ArrayList();
		CYaHPConverter converter = new CYaHPConverter();
		
		Scanner scanner = new Scanner(inputFile).useDelimiter("\\Z");
		String htmlContents = scanner.next();

		try {
			logger.debug(" TransformHTMLToPDFHelper : Initializing the Output File ::");
			out = new FileOutputStream(outputFile);
			
			logger.debug(" TransformHTMLToPDFHelper : Initializing the properties ::");
			properties.put(IHtmlToPdfTransformer.PDF_RENDERER_CLASS, IHtmlToPdfTransformer.FLYINGSAUCER_PDF_RENDERER);

			logger.debug(" TransformHTMLToPDFHelper : Invoking the convertToPdf Method ::");
			converter.convertToPdf(htmlContents, IHtmlToPdfTransformer.A4P, headerFooterList, "file:///C:/ReportingPortalWebAPI-UploadExcel/HTMLSource/ACA_Solutions_files/", out,
					properties);
			
			logger.debug(" TransformHTMLToPDFHelper : FLush the contents of Output Stream ::");
			out.flush();

		} catch (FileNotFoundException fe) {
			logger.error(" : transform method :: Error while initializing the Output File :: ", fe);
		} catch (CConvertException cce) {
			logger.error(" : transform method :: Error while invoking convertToPdf method on CYaHPConverter :: ", cce);
		} catch (IOException ioe) {
			logger.error(" : transform method :: Error while writing the output stream for the outputFile in transform method :: ", ioe);
		} catch (Exception e) {
			logger.error(" : transform method :: Error while invoking transform method :: ", e);
		} finally {
			if (null != out) {
				out.close();
			}
		}

	}

}
