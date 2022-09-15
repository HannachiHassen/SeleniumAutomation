package com.tmb.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tmb.driver.Driver;

/**
 * 
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public class BaseTest {
	
	/**
	 * 
	 */
	protected BaseTest() {
		
	}
	
	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param data
	 */
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data) { //Map<String,String>
		Map<String,String> map = (Map<String,String>)data[0];
		Driver.initDriver(map.get("browser"),map.get("version"));
	}
	
	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 */
	@AfterMethod
	protected void tearDown() {		
		Driver.quitDriver();
	}
}
