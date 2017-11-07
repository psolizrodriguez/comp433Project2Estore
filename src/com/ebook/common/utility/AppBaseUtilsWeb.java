package com.ebook.common.utility;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import com.ebook.common.constants.AppBaseConstantsWeb;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.j2ee.servlets.BaseHttpServlet;

public class AppBaseUtilsWeb {

	public static Date stringToDate(String date, String format) {
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (Exception e) {
			return null;
		}

	}

	public static String dateToString(Date date, String format) {
		return new SimpleDateFormat(format).format(date);
	}

	public static BigDecimal StringToBigDecimal(String value) {
		try {
			return new BigDecimal(value);
		} catch (Exception e) {
			return null;
		}

	}

	public static BigDecimal IntToBigDecimal(int value) {
		try {
			return new BigDecimal(value);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static int StringToInt(String value) {
		return Integer.parseInt(value);
	}

	public static Calendar getCurrentTime() {
		return Calendar.getInstance();
	}

	public static Date getCurrentDate() {
		return new Date();
	}

	public static String CalendarToString(Calendar value, String format) {
		return new SimpleDateFormat(format).format(value.getTime());
	}

	public static Calendar StringToCalendar(String value, String format) {
		Calendar cal = Calendar.getInstance();
		try {
			cal = Calendar.getInstance();
			cal.setTime(new SimpleDateFormat(format).parse(value));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cal;
	}

	public static Calendar DateToCalendar(Date value) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(value);
		return cal;
	}

	public static String encriptText(String value) {
		ShaPasswordEncoder shaPwdEncd = new ShaPasswordEncoder(AppBaseConstantsWeb.BYTES_FOR_ENCRIPTION);
		String newValue = shaPwdEncd.encodePassword(value, AppBaseConstantsWeb.KEY_FOR_ENCRIPTION);
		shaPwdEncd = new ShaPasswordEncoder();
		newValue = shaPwdEncd.encodePassword(newValue, AppBaseConstantsWeb.KEY_FOR_ENCRIPTION);
		return newValue;
	}

	public static void printException(Logger localLogger, Exception e) {
		localLogger.error("Exception found : " + e.getMessage());
		localLogger.error("Cause : " + e.getCause());
		localLogger.error("Message : " + e.getLocalizedMessage());
		localLogger.error("***********************");
		for (int j = 0; j < e.getStackTrace().length; j++) {
			localLogger.error(e.getStackTrace()[j]);
		}
		localLogger.error("***********************");
	}

	public static double roundTo(double value, int numDecimales) {
		double mult = 1;
		for (int i = 0; i < numDecimales; i++) {
			mult = mult * 10;
		}
		int newValue = (int) (value * mult);

		return ((double) newValue) / mult;
	}

	public static BigDecimal roundTo(BigDecimal bdValue, int numDecimales) {
		double mult = 1;
		for (int i = 0; i < numDecimales; i++) {
			mult = mult * 10;
		}
		int newValue = (int) (bdValue.doubleValue() * mult);

		return BigDecimal.valueOf(((double) newValue) / mult);
	}

	public static void loadReportIntoSession(HttpServletRequest request, String reportName, String reportTitle,
			String[] fields, Map<String, Object> reportParameters, List<Object[]> data) {
		try {
			if (data == null) {
				data = new ArrayList<Object[]>();
			}
			JasperDesign jasperDesign;
			;
			jasperDesign = JRXmlLoader.load(AppBaseUtilsWeb.class.getResourceAsStream(reportName));
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			// JRBeanCollectionDataSource ds = new
			// JRBeanCollectionDataSource(data);
			HibernateQueryResultDataSource ds = new HibernateQueryResultDataSource(data, fields);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, reportParameters, ds);
			request.getSession().setAttribute(BaseHttpServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object[] listToArray(List<?> list) {
		Object[] result = new Object[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	public static List<Object> mergeTwoLists(List<Object> resultList, List<Object> addList) {
		for (Object obj : addList) {
			if (!resultList.contains(obj)) {
				resultList.add(obj);
			}
		}
		return resultList;
	}

	public static HibernateQueryResultDataSource createDataSource(String[] fields, List<Object[]> data) {
		return new HibernateQueryResultDataSource(data, fields);
	}

	public static JasperReport getJasperReportAsStream(String reportName) {
		try {
			return JasperCompileManager
					.compileReport(JRXmlLoader.load(AppBaseUtilsWeb.class.getResourceAsStream(reportName)));
		} catch (JRException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static final Integer getInteger(Object obj) {
		Integer rv = null;
		try {
			if ((obj.getClass() == Double.class)) {
				rv = Integer.parseInt(String.valueOf(Math.round((Double.parseDouble(String.valueOf(obj))))));
			} else {
				if ((obj.getClass() == Integer.class) || (obj.getClass() == Long.class)
						|| (obj.getClass() == Double.class)) {
					rv = Integer.parseInt(obj.toString());
				} else if ((obj.getClass() == int.class) || (obj.getClass() == long.class)
						|| (obj.getClass() == double.class)) {
					rv = (Integer) obj;
				} else if (obj.getClass() == String.class) {
					rv = Integer.parseInt(obj.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rv;
	}

	public static final Double getDouble(Object obj) {
		Double rv = null;
		try {
			if ((obj.getClass() == Integer.class) || (obj.getClass() == Long.class)
					|| (obj.getClass() == Double.class)) {
				rv = Double.parseDouble(obj.toString());
			} else if ((obj.getClass() == int.class) || (obj.getClass() == long.class)
					|| (obj.getClass() == double.class)) {
				rv = (Double) obj;
			} else if (obj.getClass() == String.class) {
				rv = Double.parseDouble(obj.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rv;
	}

	public static String[] getValuesOfPropertiesForLinks(String service, String uri, int methodNumber,
			String... params) {
		String resourcePath = "link." + service + "." + uri + "." + methodNumber + ".";
		String[] result = new String[4];
		System.out.println(resourcePath);
		result[0] = AppBaseConstantsWeb.LINKS_PROPERTIES.getProperty(resourcePath + "type");
		result[1] = AppBaseConstantsWeb.LINKS_PROPERTIES.getProperty(resourcePath + "method");
		result[2] = AppBaseConstantsWeb.LINKS_PROPERTIES.getProperty(resourcePath + "rel");
		result[3] = AppBaseConstantsWeb.LINKS_PROPERTIES.getProperty(resourcePath + "href");
		if (params != null) {
			result[3] = MessageFormat.format(result[3], params);
		}
		result[3] = AppBaseConstantsWeb.SERVICES_URL + result[3];
		
		return result;
	}
}
