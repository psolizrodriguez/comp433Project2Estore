package com.ebook.common.aspect;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.springframework.web.servlet.DispatcherServlet;

import com.ebook.common.constants.AppBaseConstantsWeb;

public class BaseDispatcherServlet extends DispatcherServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("Initializing Links Properties");
		if (AppBaseConstantsWeb.LINKS_PROPERTIES == null) {
			synchronized (AppBaseConstantsWeb.LINKS_PROPERTIES = new Properties()) {
				try {
					AppBaseConstantsWeb.LINKS_PROPERTIES.load(
							Thread.currentThread().getContextClassLoader().getResourceAsStream("links.properties"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (AppBaseConstantsWeb.SERVICES_URL == null) {
			InetAddress ip;
			try {
				ip = InetAddress.getLocalHost();
				AppBaseConstantsWeb.SERVICES_URL = "http://" + ip.getHostAddress()
						+ ":8080/comp433Project2Estore/services/";
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}