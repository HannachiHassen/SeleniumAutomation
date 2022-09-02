package com.tmb.constans;


import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtlis;

public final class FrameworkConstants {
	
    private FrameworkConstants() {
		
	}
	
    private static final int EXPLICITWAIT = 10;
    
    private static final String RESOURCESPATH= System.getProperty("user.dir") +"/src/test/resources/";
    
	private static final String CHROMEDRIVERPATH= RESOURCESPATH + "/executables/chromedriver.exe";
	private static final String GECKODRIVERPATH= RESOURCESPATH + "/executables/geckodriver.exe";
	private static final String CONFIGFILEPATH= RESOURCESPATH + "/config/config.properties";
	private static final String JSONCONFIGFILEPATH= RESOURCESPATH + "/jsons/config.json";
	private static final String EXCELFILEPATH= RESOURCESPATH + "/excel/testdata.xlsx";
	private static final String RUNMANGERSHEET = "RUNMANAGER";
	private static final String ITERATIONDATASHEET = "DATA";
	
	private static final String EXTENTREPORTFOLDERPATH= System.getProperty("user.dir") +"/extent-test-output/";
	
	private static String extentReportFilePath= "";
	
	public static String getExtentReportFilePath() throws Exception {
		if (extentReportFilePath.isEmpty()) {
			return extentReportFilePath=createReportPath();
		}
		return extentReportFilePath;
	}	

	private static String createReportPath() throws Exception {
		if (PropertyUtlis.get(ConfigProperties.OVERRIDEREPORTS).equals("no")) {
			return EXTENTREPORTFOLDERPATH + System.currentTimeMillis()+ "/index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH + "/index.html";
		}
	}
		
	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}
	
	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

	public static String getChromeDriverpath() {
		return CHROMEDRIVERPATH;
	}	

	public static String getGeckodriverpath() {
		return GECKODRIVERPATH ;
	}

	public static String getJsonconfigfilepath() {
		return JSONCONFIGFILEPATH;
	}
	
	public static String getExcelfilepath() {
		return EXCELFILEPATH;
	}
	
	public static String getRunmangersheet() {
		return RUNMANGERSHEET;
	}

	public static String getIterationdatasheet() {
		return ITERATIONDATASHEET;
	}
}
