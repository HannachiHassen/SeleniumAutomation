package com.tmb.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtlis;
import com.tmb.utils.ScreenshotUtils;

/**
 * 
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 * @see com.tmb.reports.ExtentManager
 * @see com.tmb.utils.PropertyUtlis
 */
public final class ExtentLogger {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentLogger() {

	}
	
	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param message
	 */
	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param message
	 */
	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param message
	 */
	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}
	
	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param message
	 * @param isScreenshotNeeded
	 */
	public static void pass(String message, boolean isScreenshotNeeded) {
		if (PropertyUtlis.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			 ExtentManager.getExtentTest().pass(message, 
					 MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			pass(message);
		}
	}
	
	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param message
	 * @param isScreenshotNeeded
	 */
	public static void fail(String message, boolean isScreenshotNeeded) {
		if (PropertyUtlis.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			 ExtentManager.getExtentTest().fail(message, 
					 MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			fail(message);
		}
	}
	
	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param message
	 * @param isScreenshotNeeded
	 */
	public static void skip(String message, boolean isScreenshotNeeded){
		if (PropertyUtlis.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			 ExtentManager.getExtentTest().skip(message, 
					 MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			skip(message);
		}
	}	
}
