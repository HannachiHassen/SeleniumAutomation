package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;
import com.tmb.reports.ExtentLogger;

/**
 * 
 * 
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public class BasePage {
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	/**
	 * Locates element by given wait strategy, performs the clicking operation on webelement and
	 * writes the pass even to the extent report.
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * 
	 * @param by By Locator of the webelement
	 * @param waitstrategy Strategy to find webelement. Known  strategies {@link com.tmb.enums.WaitStrategy}
	 * @param elementname Name of the element that needs to be logged in the report.
	 */
	protected void click(By by, WaitStrategy waitstrategy, String elementname) {
		WebElement element= ExplicitWaitFactory.preformExplicitWait(by, waitstrategy);
		element.click();		
		try {
			ExtentLogger.pass(elementname + " is clicked", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Locates element by given wait strategy, sends the value to located webelement and
	 * writes the pass even to the extent report.
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * 
	 * @param by By Locator of the webelement
	 * @param value value to be send the text box
	 * @param waitstrategy Strategy to find webelement. Known  strategies {@link com.tmb.enums.WaitStrategy}
	 * @param elementname Name of the element that needs to be logged in the report.
	 */
	protected void sendKeys(By by, WaitStrategy waitstrategy, String value, String elementname) {
		
		WebElement element= ExplicitWaitFactory.preformExplicitWait(by, waitstrategy);
		element.sendKeys(value);
		try {
			ExtentLogger.pass(value + " is entered successfully in "+ elementname, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
