package com.crmpro.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;

public final class OrangeHRMLoginPage {
	/*
	 * id
	 * name
	 * classname
	 * linktext
	 * partiallinktext
	 * css or xpath
	 * 
	 * Assertions should not be called in pages layers
	 * All your page method need to have some return type
	 */
	
	private final By textboxUsername=By.xpath("//input[@placeholder='Username']");
	private final By textboxPassword=By.xpath("//input[@name='password']");
	private final By buttonLogin =By.xpath("//button[@type='submit']");
	
	public OrangeHRMLoginPage enterUserName(String username) {
		DriverManager.getDriver().findElement(textboxUsername).sendKeys(username);
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String password) {
		DriverManager.getDriver().findElement(textboxPassword).sendKeys(password);
		return this;
	}
	public OrangeHRMHomePage clickLoginButton() {
		DriverManager.getDriver().findElement(buttonLogin).click();
		return new OrangeHRMHomePage();
	}
	
	public String getTitle() {
		return DriverManager.getDriver().getTitle();
	}
}
