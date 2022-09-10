package com.tmb.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.CategoryType;
import com.tmb.enums.DeviceType;

/**
 * Perform initialization and termination of {@link com.aventstack.extentreports.ExtentReports}
 * After creating an instance for {@link com.aventstack.extentreports.ExtentTest}, it is delegated to ThreadLocal 
 * variable for providing thread safety.
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 * @see com.tmb.listeners.ListenerClass
 * @see com.tmb.annotations.FrameworkAnnotation
 */
public final class ExtentReport {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentReport() {
	
	}
	
	private static ExtentReports extent;
	
	/**
	 * Set the initial configuration for the Extent Reports and decides the report generation path
	 * @author Hassen
	 * Sep 10, 2022
	 */
	public static void initReports() {
		if (Objects.isNull(extent)) {
			extent=new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			
			spark.config().setDocumentTitle("Test Results");
			spark.config().setReportName("ExtentReports - CRMPro Automation");
			spark.config().setTheme(Theme.STANDARD);	
			spark.config().setEncoding("utf-8");
			spark.config().setProtocol(Protocol.HTTPS);
			
			extent.setSystemInfo("Tested By","Hassen Hannachi");	
			extent.setSystemInfo("GUI Testing", "QA");
			extent.setSystemInfo("Application","crmpro.com/index.html");
		} 
		
	}
	
	/**
	 * Flushing the reports ensures extent logs are reflected properly. 
	 * Opens the report in the default desktop browser.
	 * Sets the ThreadLocal variable to default value
	 * @author Hassen
	 * Sep 10, 2022
	 */
	public static void flushReports() {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}	
		ExtentManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}	
	
	/**
	 * Creates a test node in the extent report. Delegates to {@link ExtentManager} for providing thread safety 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param testcasename Test Name that needs to be reflected in the report
	 */
	public static void createTest(String testcasename) {
		ExtentTest test =extent.createTest(testcasename);
		ExtentManager.setExtentTest(test);
	}
	
	/**
	 * Logs the authors details in the authors view in the extent report.
	 * Gives an clear idea of Authors Vs Percentage success metrics
	 * @author Hassen
	 * Sep 10, 2022
	 * @param authors
	 */
	public static void addAuthors(String[] authors) {
		for (String temp:authors) {
			ExtentManager.getExtentTest().assignAuthor(temp);
		}		
	}
	
	/**
	 * Adds the category a particular test case belongs to.
	 * Gives an clear idea of Group Vs Percentage success metrics. 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param categories category a particular test case belongs to.
	 */
    public static void addCategories(CategoryType[] categories) {
    	for (CategoryType temp:categories) {
			ExtentManager.getExtentTest().assignCategory(temp.toString());
		}
	}
    
    /**
     * Adds the device a particular test case belongs to.
	 * Gives an clear idea of device Vs Percentage success metrics. 
     * @author Hassen
     * Sep 10, 2022
     * @param devices device a particular test case belongs to.
     */
    public static void addDevices(DeviceType[] devices) {
    	for (DeviceType temp:devices) {
			ExtentManager.getExtentTest().assignDevice(temp.toString());
		}
	}
}
