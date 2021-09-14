package com.webmailhostopia.common.utils;

import org.apache.log4j.Logger;



public class Logs {

	private static Logger logs = Logger.getLogger(Logs.class.getName());

	public static void info(String message) {
		logs.info(message);
		
	}

	public static void warn(String message) {
		logs.warn(message);
	}

	public static void error(String message) {
		logs.error(message);
		
	}

	public static void debug(String message) {
		logs.debug(message);
	}
}
