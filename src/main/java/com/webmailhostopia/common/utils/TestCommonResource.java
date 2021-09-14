package com.webmailhostopia.common.utils;

import java.io.File;

/**
 * 
 *@author Vamsi Malleni
 *This class is used to get the resources folder path under src/main/java
 */

public class TestCommonResource {

	private static final String SEPERATOR = File.separator;
	
	private static final String MAIN_RESOURCE_DIR = System.getProperty("user.dir") + SEPERATOR + "src\\main\\java\\resources" + SEPERATOR;
	private static final String TEST_RESOURCE_DIR = System.getProperty("user.dir") + SEPERATOR + "src\\test\\java\\resources" + SEPERATOR;
	
	public static String getResourceDirectoryPath(){
		return MAIN_RESOURCE_DIR;
	}
	
	public static String getTestResourceDirctoryPath(){
		return TEST_RESOURCE_DIR;
	}
}
