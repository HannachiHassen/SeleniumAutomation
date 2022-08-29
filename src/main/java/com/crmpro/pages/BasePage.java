package com.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.constans.FrameworkConstants;
import com.tmb.driver.DriverManager;

public class BasePage {
	
	protected void click(By by) {
		explicityWaitForElementToBeClickable(by);
		DriverManager.getDriver().findElement(by).click();
	}
	
	protected void sendKeys(By by, String value) {
		explicityWaitForElementToBeClickable(by);
		DriverManager.getDriver().findElement(by).sendKeys(value);
	}
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
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
