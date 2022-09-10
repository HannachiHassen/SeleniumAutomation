package com.tmb.utils;

/**
 * 
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public final class DynamicXpathUtils {

	/**
	 * 
	 */
	private DynamicXpathUtils() {
		
	}

	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param xpath
	 * @param value
	 * @return
	 */
	public static String getXpath(String xpath, String value) {
		return String.format(xpath, value);
	}
	
	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param xpath
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static String getXpath(String xpath, String value1, String value2) {
		return String.format(xpath, value1,value2);
	}
}
