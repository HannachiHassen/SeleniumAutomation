package com.tmb.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.constants.FrameworkConstants;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

/**
 * Explicit wait factory produces different waits before operating on webelement
 * 
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public final class ExplicitWaitFactory {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
    private ExplicitWaitFactory() {
		
	}

    /**
     * 
     * @author Hassen
     * Sep 10, 2022
     * @param waitstrategy Strategy to be applied to find a webelement {@link com.tmb.enums.WaitStrategy}
	 * @param by By locator of the webelement
	 * @return webelement Locates and return the webelement
     */
	public static WebElement preformExplicitWait(By by, WaitStrategy waitstrategy) {
		WebElement element=null;

		if (waitstrategy == WaitStrategy.CLICKABLE) {
			element= new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
			.until(ExpectedConditions.elementToBeClickable(by));
			} 
		else if (waitstrategy == WaitStrategy.PRESENCE) {
			element= new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
			.until(ExpectedConditions.presenceOfElementLocated(by));
			}
		else if (waitstrategy == WaitStrategy.VISIBLE) {
			element= new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
			.until(ExpectedConditions.visibilityOfElementLocated(by));
			}
		else if (waitstrategy == WaitStrategy.NONE) {
			element= DriverManager.getDriver().findElement(by);
			}
		return element;
	}	
}
