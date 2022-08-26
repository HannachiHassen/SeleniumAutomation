package com.tmb.constans;

public final class FrameworkConstants {
	
    private FrameworkConstants() {
		
	}
	
    private static final String RESOURCESPATH= System.getProperty("user.dir") +"/src/test/resources/";
	private static final String CHROMEDRIVERPATH= RESOURCESPATH + "/executables/chromedriver.exe";
	private static final String CONFIGFILEPATH= RESOURCESPATH + "/config/config.properties";
	
	
	
	public static String getChromeDriverpath() {
		return CHROMEDRIVERPATH;
	}

	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}
}
