package com.webmailhostopia.common.utils;

import java.text.Collator;
import java.util.Locale;

import com.webmailhostopia.selenium.webdriver.AbstractPageObject;

public class Verify extends AbstractPageObject{

	public static boolean compareStringsInEnglish(String[] actual, String[] expected, boolean ignorecase){
		boolean isTrue=true;
		if(actual.length!=expected.length)
		{
			Log.info("Actual and Expected arrays Lengths are not equal: Actual: "+ actual.length+ "  Expected: "+expected.length);
			return false;
		}
		else
		{
			for(int i=0;i<actual.length;i++)
			{
				if(ignorecase){
					if(actual[i].equalsIgnoreCase(expected[i])){
						Log.info("Actual and Expected string are equal. Actual: "+ actual[i]+ "  Expected: "+expected[i]);
						continue;
					}
					else{
						isTrue=false;
						Log.info("Actual and Expected string are not equal. Actual: "+ actual[i]+ "  Expected: "+expected[i]);
					}
				}
				else
				{
					if(actual[i].equals(expected[i])){
						Log.info("Actual and Expected string are equal. Actual: "+ actual[i]+ "  Expected: "+expected[i]);
						continue;
					}
					else{
						isTrue=false;
						Log.info("Actual and Expected string are not equal. Actual: "+ actual[i]+ "  Expected: "+expected[i]);
					}
				}
			}
		}
		return isTrue;
	}

	public static boolean compareMultipleStrings(String[] actual, String[] expected,Locale locale)throws Exception{

		boolean isTrue=true;
		Collator collator = Collator.getInstance(locale);

		if(actual.length!=expected.length){
			Log.error("Actual and Expected arrays Lengths are not equal: Actual: "+ actual.length+ "  Expected: "+expected.length);
			return false;
		}else{
			for(int i=0;i<actual.length;i++)
			{
				if(collator.compare(actual[i].trim(), expected[i].trim()) == 0){
				//	Log.info("Actual and Expected string are equal. Actual: "+ actual[i]+ "  Expected: "+expected[i]);
					Log.info("Actual and Expected strings are equal and displaying in " + SUTprop.getProperty("LANGUAGE")+  " Language only. Actual: "+ actual[i]+ "  and Expected: "+expected[i]);
					continue;
				}else{
					isTrue=false;
					//Log.error("Actual and Expected string are not equal. Actual: "+ actual[i]+ "  Expected: "+expected[i]);
					Log.error("Actual and Expected string are not equal. Actual: "+ actual[i]+ " is not displaying in  " + SUTprop.getProperty("LANGUAGE")+  " Language and Expected is : "+expected[i]);
				}
			}
			return isTrue;
		}
	}

	/**
	 * @param actual
	 * @param expected
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	public static boolean compareSingleString(String actual, String expected,Locale locale)throws Exception{

		boolean isTrue=true;
		Collator collator = Collator.getInstance(locale);

		if(collator.compare(actual.trim(), expected.trim()) == 0){
			Log.info("Actual and Expected string are equal and displaying in " + SUTprop.getProperty("LANGUAGE")+  " Language only. Actual: "+ actual+ "  and Expected: "+expected);
		}else{
			isTrue=false;
			Log.error("Actual and Expected string are not equal. Actual: "+ actual+ " is not displaying in  " + SUTprop.getProperty("LANGUAGE")+  " Language and Expected is : "+expected);
		}
		return isTrue;
	}
	
/*	public static boolean compareStrings(String[] actual, String[] expected,Locale locale)throws Exception{

		boolean isTrue=true;
		Collator collator = Collator.getInstance(locale);

		if(actual.length!=expected.length){
			Log.info("Actual and Expected arrays Lengths are not equal: Actual: "+ actual.length+ "  Expected: "+expected.length);
			return false;
		}else{
			for(int i=0;i<actual.length;i++)
			{
				if(collator.compare(actual[i].trim(), expected[i].trim()) == 0){
					Log.info("Actual and Expected string are equal. Actual: "+ actual[i]+ "  Expected: "+expected[i]);
					continue;
				}else{
					isTrue=false;
					Log.error("Actual and Expected string are not equal in "+ locale + " language. Actual:  "+ actual[i]+ "  Expected: "+expected[i]);
				}
			}
			return isTrue;
		}
	}
	
	public static boolean compareString(String actual, String expected,Locale locale)throws Exception{

		boolean isTrue=true;
		Collator collator = Collator.getInstance(locale);

		if(collator.compare(actual.trim(), expected.trim()) == 0){
			Log.info("Actual and Expected string are displaying in corect language:" +locale+ "  Actual: "+ actual+ "  Expected: "+expected);
		}else{
			isTrue=false;
			Log.error("Actual and Expected string are not displayinh in Expected language : "+ locale+" But displying as Actual"+ actual+ "  Expected: "+expected);
		}
		return isTrue;
	}*/
}