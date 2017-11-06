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

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		LOG.info("req.getServletPath():: " + req.getServletPath());
		resp.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
		resp.setHeader("Pragma", "no-cache");
		resp.addHeader("Access-Control-Allow-Headers",
				"origin, content-type, accept, x-requested-with, my-cool-header");
		resp.addHeader("Access-Control-Max-Age", "60"); // seconds to cache preflight request --> less OPTIONS traffic
		resp.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.setDateHeader("Expires", 0);
		System.out.println(req.getServletPath());
		filterChain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
