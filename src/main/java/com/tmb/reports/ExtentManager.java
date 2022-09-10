package com.tmb.reports;

import com.aventstack.extentreports.ExtentTest;

/**
 * ExtentManager class helps to achieve thread safety for the {@link com.aventstack.extentreports.ExtentTest} instance.
 * 
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 * @see com.tmb.driver.Driver
 */
public final class ExtentManager {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private  ExtentManager() {
		
	}
	
	private static ThreadLocal<ExtentTest> extTest= new ThreadLocal<>();

	/**
	 * Returns the thread safe {@link com.aventstack.extentreports.ExtentTest} instance fetched from ThreadLocal variable.
	 * @author Hassen
	 * Sep 10, 2022
	 * @return Thread safe {@link com.aventstack.extentreports.ExtentTest} instance.
	 */
	static ExtentTest getExtentTest() {  //deafult --> it can be only accessed within the package--> private packages
		return extTest.get();
	}
	
	/**
	 * Set the {@link com.aventstack.extentreports.ExtentTest} instance to thread local variable
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param test {@link com.aventstack.extentreports.ExtentTest} instance that needs to saved from Thread safety issues.<p>
	 */
	static void setExtentTest(ExtentTest test) {
		extTest.set(test);
	}
	
	/**
	 * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 * @author Hassen
	 * Sep 10, 2022
	 */
	static void unload() {
		extTest.remove();
	}
}
