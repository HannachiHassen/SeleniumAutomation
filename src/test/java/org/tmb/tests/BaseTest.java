package org.tmb.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.tmb.driver.Driver;
import com.tmb.reports.ExtentReport;

public class BaseTest {
	
	protected BaseTest() {
		
	}
	
	@BeforeSuite
	public void beforeSuite() {
		ExtentReport.initReports();
	}
	
	@AfterSuite
	public void afterSuite() throws IOException {
		ExtentReport.flushReports();
	}
	
	@BeforeMethod
	protected void setUp() throws Exception {
		Driver.initDriver();
	}
	
	@AfterMethod
	protected void tearDown() {	
		Driver.quitDriver();
	}
}
