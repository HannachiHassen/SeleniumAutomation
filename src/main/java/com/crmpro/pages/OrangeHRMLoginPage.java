package com.crmpro.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;

public final class OrangeHRMLoginPage extends BasePage{
	/*
	 * Assertions should not be called in pages layers
	 * All your page method need to have some return type
	 */
	
	private final By textboxUsername=By.xpath("//input[@placeholder='Username']");
	private final By textboxPassword=By.xpath("//input[@name='password']");
	private final By buttonLogin =By.xpath("//button[@type='submit']");
	
	public OrangeHRMLoginPage enterUserName(String username) {
		sendKeys(textboxUsername,username);
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String password) {
		sendKeys(textboxPassword, password);
		return this;
	}
	public OrangeHRMHomePage clickLogin() {
		click(buttonLogin);
		return new OrangeHRMHomePage();
	}
	
	public String getTitle() {
		return getPageTitle();
	}
}
