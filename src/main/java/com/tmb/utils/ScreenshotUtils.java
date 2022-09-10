package com.tmb.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.tmb.driver.DriverManager;

/**
 * 
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public final class ScreenshotUtils {
	/**
	 * 
	 */
	private ScreenshotUtils() {

	}

	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @return
	 */
	public static String getBase64Image() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
