package com.reporting.webapi.pdfbuilder.beans;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.property.TextAlignment;

@Component
public class PDFHeader implements IEventHandler {
	
	private final Logger logger = Logger.getLogger(PDFHeader.class);
	
	private String header;
    
    public void setHeader(String header){
    	this.header = header;
    }
    
    @Override
	public void handleEvent(Event event) {
		Canvas canvas = null;
		try {
			// Retrieve document and
			PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
			PdfDocument pdf = docEvent.getDocument();
			PdfPage page = docEvent.getPage();
			Rectangle pageSize = page.getPageSize();
			PdfCanvas pdfCanvas = new PdfCanvas(page.getLastContentStream(), page.getResources(), pdf);
			canvas = new Canvas(pdfCanvas, pdf, pageSize);
			canvas.setFontSize(18f);
			// Write text at position
			canvas.showTextAligned(header, pageSize.getWidth() / 2, pageSize.getTop() - 30, TextAlignment.CENTER);
		} catch (Exception e) {
			logger.error(" PDFHeader :: handleEvent : Error while initializing the Page Layout :: ", e);
		} finally {
			if(null != canvas) canvas.close();
		}
	}
}
