package com.reporting.webapi.pdfbuilder.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.licensekey.LicenseKey;
import com.reporting.webapi.helper.PDFPageLayoutHelper;

@Component
public class PDFDocumentParser {

	private final Logger logger = Logger.getLogger(PDFDocumentParser.class);
	
	public static final String LICENSE = "/html2pdf-license/itextkey-key1.xml";
	
	private PdfWriter writer;
	
	private PdfDocument pdfDocument;
	
	private InputStream licenseIs;
	
	@Autowired
	private PDFHeader headerHandler;
	
	@Autowired
	private PDFPageLayoutHelper layoutHandler;

	public void parseHeaderFooter(String htmlSource, String pdfDest, String resoureLoc) throws IOException {
		try {
			licenseIs = getClass().getClassLoader().getResourceAsStream(LICENSE);
			
			if(null != licenseIs) {
				
				LicenseKey.loadLicenseFile(licenseIs);
				
				File pdf = new File(pdfDest);
				pdf.getParentFile().mkdirs();

				// Create Document
				writer = new PdfWriter(pdfDest);
				pdfDocument = new PdfDocument(writer);

				// Create event-handlers
				headerHandler.setHeader("ACA Solutions");
				layoutHandler.setPlaceholder(pdfDocument);

				// Assign event-handlers
				pdfDocument.addEventHandler(PdfDocumentEvent.START_PAGE, headerHandler);
				pdfDocument.addEventHandler(PdfDocumentEvent.END_PAGE, layoutHandler);

				// Convert
				ConverterProperties converterProperties = new ConverterProperties().setBaseUri(resoureLoc);
				HtmlConverter.convertToDocument(new FileInputStream(htmlSource), pdfDocument, converterProperties);
				
				// Write the total number of pages to the placeholder
				layoutHandler.writeTotal(pdfDocument);
				
			} else {
				logger.info(" :: parseHeaderFooter :: Unable to Load Licence Key for Converting the HTML to PDF ");
			}
			
		} catch (Exception e) {
			logger.error(" PDFDocumentParser :: parseHeaderFooter : Error while initializing the Page Layout :: ", e);
		} finally {
			if (null != pdfDocument) {
				pdfDocument.close();
			}
			if(null != licenseIs) {
				licenseIs.close();
			}
		}
	}
    
}
