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

public final class ExtentReport {

	private ExtentReport() {
	
	}
	
	private static ExtentReports extent;
	
	public static void initReports() {
		if (Objects.isNull(extent)) {
			extent=new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
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
	
	public static void flushReports() throws IOException {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}		
		Desktop.getDesktop().browse(new File("index.hmtl").toURI());		
	}	
	
	public static void createTest(String testcasename) {
		ExtentTest test =extent.createTest(testcasename);
		ExtentManager.setExtentTest(test);
	}
}
