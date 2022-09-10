package com.tmb.constants;


import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtlis;
/**
 * Framework Constants holds all the constant values used within the framework. 
 * If some value needs to be changed or modified often, then it should be stored in the property files
 * 
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 * @see com.tmb.utils.PropertyUtlis
 */
public final class FrameworkConstants {
	
	/**
	 * 
	 * Private constructor to avoid external instantiation
	 */
	
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
	
	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @return Extent Report path where the index.html file will be generated.
	 */
	public static String getExtentReportFilePath() {
		if (extentReportFilePath.isEmpty()) {
			return extentReportFilePath=createReportPath();
		}
		return extentReportFilePath;
	}	

	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @return  If Override reports value in the 
	 * property file is no,then the timestamp will be appended
	 */
	private static String createReportPath() {
		if (PropertyUtlis.get(ConfigProperties.OVERRIDEREPORTS).equals("no")) {
			return EXTENTREPORTFOLDERPATH + System.currentTimeMillis()+ "/index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH + "/index.html";
		}
	}
	
	/* 
	 * TODO Lombak Plugin to remove the boiler plate code
	 */
	
	public static int getExplicitWait() {
		return EXPLICITWAIT;
	}
	
	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	
	public static String getGeckoDriverPath() {
		return GECKODRIVERPATH ;
	}
	
	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}	

	public static String getJsonConfigFilePath() {
		return JSONCONFIGFILEPATH;
	}
	
	public static String getExcelFilePath() {
		return EXCELFILEPATH;
	}
	
	public static String getRunmangerDatasheet() {
		return RUNMANGERSHEET;
	}

	public static String getIterationDatasheet() {
		return ITERATIONDATASHEET;
	}
}
