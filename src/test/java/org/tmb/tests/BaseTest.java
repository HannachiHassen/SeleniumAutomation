package org.tmb.tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tmb.driver.Driver;

public class BaseTest {
	
	protected BaseTest() {
		
	}
			
	@BeforeMethod
	protected void setUp() throws Exception {		
		Driver.initDriver();
	}
	
	@AfterMethod
	protected void tearDown(ITestResult result) {		
		Driver.quitDriver();
	}
}
