package com.ebook.common.utility;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/***
 * @className : ConfigManager.java
 * @description : Allows log4j.properties to be read and executed
 * @author : Percy Soliz
 * @date : February-2012
 ***/

public final class ConfigManager {

	private static final ConfigManager INSTANCE = new ConfigManager();
	private static Properties properties = null;

	private ConfigManager() {
		super();
	}

	public static ConfigManager getConfigManager() {
		return INSTANCE;
	}

	public static void init() throws IOException {
		if (properties == null) {
			synchronized (properties = new Properties()) {
				properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("log4j.properties"));
				PropertyConfigurator.configure(properties);
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public static Logger getLogger(final Class cls) {
		getConfigManager();
		try {
			init();
		} catch (IOException e) {
			Logger.getLogger(cls).error("Exception found : " + e.getMessage());
			Logger.getLogger(cls).error("Cause : " + e.getCause());
			Logger.getLogger(cls).error("Message : " + e.getLocalizedMessage());
			Logger.getLogger(cls).error("***********************");
			for (int j = 0; j < e.getStackTrace().length; j++) {
				Logger.getLogger(cls).error(e.getStackTrace()[j]);
			}
			Logger.getLogger(cls).error("***********************");
		}
		return Logger.getLogger(cls);
	}

}
