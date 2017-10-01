package com.ebook.common.utility;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ebook.common.constants.AppTLIConstantsWeb;

public class RemoteObjCall {
	private static final Logger LOGGER = ConfigManager.getLogger(RemoteObjCall.class);
	Object ejbBeanRemote = null;
	private static final ApplicationContext context = new FileSystemXmlApplicationContext(AppTLIConstantsWeb.EJB_CONFIGURATION_FILE);

	public static Object remoteObj(String beanId) {
		try {
			LOGGER.info("Loading configuration for remote Bean : " + beanId);
			AppEjbConfigurationBean appEjbConfigurationBean = (AppEjbConfigurationBean) context.getBean(beanId);
			Properties properties = new Properties();
			properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			properties.put(Context.URL_PKG_PREFIXES, "org.jboss.namingrg.jnp.interfaces");
			properties.put(Context.PROVIDER_URL, appEjbConfigurationBean.getProviderUrl());
			InitialContext ic = new InitialContext(properties);
			return ic.lookup(appEjbConfigurationBean.getLookupName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
