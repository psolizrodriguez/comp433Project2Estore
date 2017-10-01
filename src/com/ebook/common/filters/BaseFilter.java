package com.ebook.common.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ebook.common.utility.ConfigManager;

public class BaseFilter implements Filter {
	private static final Logger LOG = ConfigManager.getLogger(BaseFilter.class);

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		LOG.info("req.getServletPath():: " + req.getServletPath());
		resp.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
		resp.setHeader("Pragma", "no-cache");
		resp.setDateHeader("Expires", 0);
		System.out.println(req.getServletPath());
		if (req.getServletPath().equalsIgnoreCase("/registerWithGSTIN.html")) {
			LOG.info("it is insecured url preLogin");
			filterChain.doFilter(request, response);
		} else {
			if (req.getServletPath().equalsIgnoreCase("/next.html")) {
				LOG.info("it is a secured url");
				filterChain.doFilter(request, response);
			} else {
				LOG.info("it is a insecured url postLogin");
				if (req.getSession().getAttribute("userDetails") == null) {
					// resp.sendRedirect("timeOut.html");
					filterChain.doFilter(request, response);// for insecured
															// test.
				} else {
					LOG.info("in else of else in filter");
					filterChain.doFilter(request, response);
				}
			}
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
