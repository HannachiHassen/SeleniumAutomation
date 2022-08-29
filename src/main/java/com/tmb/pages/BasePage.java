package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.constans.FrameworkConstants;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;

public class BasePage {
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	protected void click(By by, WaitStrategy waitstrategy) {
		WebElement element= ExplicitWaitFactory.preformExplicitWait(by, waitstrategy);
		element.click();		
	}
	
	protected void sendKeys(By by, WaitStrategy waitstrategy, String value) {
		
		WebElement element= ExplicitWaitFactory.preformExplicitWait(by, waitstrategy);
		element.sendKeys(value);
	}	
	
	private void explicityWaitForElementToBeClickable(By by) {
		new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
		   .until(ExpectedConditions.elementToBeClickable(by));
	}
	
	private void explicityWaitForElementToBePresent(By by) {
		new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
		   .until(ExpectedConditions.presenceOfElementLocated(by));
	}
}
