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
import com.tmb.constans.FrameworkConstants;
import com.tmb.enums.CategoryType;
import com.tmb.enums.DeviceType;

public final class ExtentReport {

	private ExtentReport() {
	
	}
	
	private static ExtentReports extent;
	
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
	
	public static void createTest(String testcasename) {
		ExtentTest test =extent.createTest(testcasename);
		ExtentManager.setExtentTest(test);
	}
	
	public static void addAuthors(String[] authors) {
		for (String temp:authors) {
			ExtentManager.getExtentTest().assignAuthor(temp);
		}		
	}
	
    public static void addCategories(CategoryType[] categories) {
    	for (CategoryType temp:categories) {
			ExtentManager.getExtentTest().assignCategory(temp.toString());
		}
	}
    
    public static void addDevices(DeviceType[] devices) {
    	for (DeviceType temp:devices) {
			ExtentManager.getExtentTest().assignDevice(temp.toString());
		}
	}
}
