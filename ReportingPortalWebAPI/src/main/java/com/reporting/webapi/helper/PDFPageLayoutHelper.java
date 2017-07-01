package com.reporting.webapi.helper;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;

@Component
public class PDFPageLayoutHelper implements IEventHandler {

	private final Logger logger = Logger.getLogger(PDFPageLayoutHelper.class);
	
	protected PdfFormXObject placeholder;
    protected float side = 20;
    protected float x = 300;
    protected float y = 25;
    protected float space = 4.5f;
    protected float descent = 3;
    
	public void setPlaceholder(PdfDocument pdf) {
		placeholder = new PdfFormXObject(new Rectangle(0, 0, side, side));
	}
    
	@Override
	public void handleEvent(Event event) {
		Canvas canvas = null;
		try {
			PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
			PdfDocument pdf = docEvent.getDocument();
			PdfPage page = docEvent.getPage();
			int pageNumber = pdf.getPageNumber(page);
			Rectangle pageSize = page.getPageSize();
			PdfCanvas pdfCanvas = new PdfCanvas(page.getLastContentStream(), page.getResources(), pdf);
			canvas = new Canvas(pdfCanvas, pdf, pageSize);
			Paragraph p = new Paragraph().add("Page ").add(String.valueOf(pageNumber)).add(" of");
			canvas.showTextAligned(p, x, y, TextAlignment.RIGHT);
			pdfCanvas.addXObject(placeholder, x + space, y - descent);
			pdfCanvas.release();
		} catch (Exception e) {
			logger.error(" PDFPageLayoutHelper :: handleEvent : Error while initializing the Page Layout :: ", e);
		} finally {
			if(null != canvas) canvas.close();
		}
	}
	
	public void writeTotal(PdfDocument pdf) {
		Canvas canvas = null;
		try {
			canvas = new Canvas(placeholder, pdf);
			canvas.showTextAligned(String.valueOf(pdf.getNumberOfPages()), 0, descent, TextAlignment.LEFT);
		} catch (Exception e) {
			logger.error(" PDFPageLayoutHelper :: writeTotal : Error while initializing the Page Layout :: ", e);
		} finally {
			canvas = null;
		}
	}

}
