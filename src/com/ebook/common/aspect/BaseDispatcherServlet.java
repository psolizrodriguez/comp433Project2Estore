package com.ebook.common.aspect;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.springframework.web.servlet.DispatcherServlet;

import com.ebook.common.utility.ConfigManager;

public class BaseDispatcherServlet extends DispatcherServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// ServletContext context = config.getServletContext();

		try {
			if (ConfigManager.getLogger(BaseDispatcherServlet.class) == null) {
				System.out.println("Logger is Null...");
			} else {
				System.out.println("Logger is Initialized....");
			}

		} catch (Exception e) {
			System.out.println(" exception = " + e);
			e.printStackTrace();
		}
	}
}