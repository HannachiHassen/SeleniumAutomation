package com.tmb.constans;

public class FrameworkConstants {
	private static final String CHROMEDRIVERPATH= System.getProperty("user.dir") +"/src/test/resources/executables/chromedriver.exe";

	private FrameworkConstants() {
		
	}
	
	public static String getChromeDriverpath() {
		return CHROMEDRIVERPATH;
	}

}
