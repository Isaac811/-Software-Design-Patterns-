package com.work.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * AppConfig
 */
@Component
public class AppConfig {

	private static PropertiesLoader propertiesLoader;

	@Value("${user.cookie.name}")
	public String USER_COOKIE_NAME;

	@Value("${user.cookie.age}")
	public int USER_COOKIE_AGE;

	public static String getConfig(String key) {
		if (propertiesLoader == null){
			propertiesLoader = new PropertiesLoader("application.properties");
		}
		return propertiesLoader.getProperty(key);
	}
	public static String getAdminPath() {
		return getConfig("adminPath");
	}
	public static String getFrontPath() {
		return getConfig("frontPath");
	}
	public static String getUrlSuffix() {
		return getConfig("urlSuffix");
	}
}
