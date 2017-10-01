package com.ebook.common.utility;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.j2ee.servlets.BaseHttpServlet;

public class JasperReportViewer extends BaseHttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<JasperPrint> jasperPrintList = BaseHttpServlet.getJasperPrintList(request);
		if (jasperPrintList == null) {
			throw new ServletException("No JasperPrint documents found on the HTTP session.");
		}
		Boolean isBuffered = Boolean.valueOf(request.getParameter(BaseHttpServlet.BUFFERED_OUTPUT_REQUEST_PARAMETER));
		if (isBuffered.booleanValue()) {
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, jasperPrintList);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
			try {
				exporter.exportReport();
			} catch (JRException e) {
				throw new ServletException(e);
			}
			byte[] bytes = baos.toByteArray();
			if (bytes != null && bytes.length > 0) {
				response.setContentType("application/pdf");
				response.setContentLength(bytes.length);
				ServletOutputStream ouputStream = response.getOutputStream();
				try {
					ouputStream.write(bytes, 0, bytes.length);
					ouputStream.flush();
				} finally {
					if (ouputStream != null) {
						try {
							ouputStream.close();
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
				}
			} else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<body bgcolor=\"white\">");
				out.println("<span class=\"bold\">Empty response.</span>");
				out.println("</body>");
				out.println("</html>");
			}
		} else {
			response.setContentType("application/pdf");
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, jasperPrintList);
			OutputStream ouputStream = response.getOutputStream();
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
			try {
				exporter.exportReport();
			} catch (JRException e) {
				throw new ServletException(e);
			} finally {
				if (ouputStream != null) {
					try {
						ouputStream.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		}
	}
}
