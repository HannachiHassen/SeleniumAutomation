package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;
import com.tmb.utils.DecodeUtils;


public final class OrangeHRMLoginPage extends BasePage{
	/*
	 * Assertions should not be called in pages layers
	 * All your page method need to have some return type
	 */
	
	private final By textboxUsername=By.xpath("//input[@placeholder='Username']");
	private final By textboxPassword=By.xpath("//input[@name='password']");
	private final By buttonLogin =By.xpath("//button[@type='submit']");
	
	public OrangeHRMLoginPage enterUserName(String username) {
		sendKeys(textboxUsername, WaitStrategy.PRESENCE, username, "Username");
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String password) {
		sendKeys(textboxPassword, WaitStrategy.PRESENCE, DecodeUtils.getDecodedString(password), "Password");
		return this;
	}
	
	public OrangeHRMHomePage clickLogin() {
		click(buttonLogin, WaitStrategy.CLICKABLE, "Login Button");		
		return new OrangeHRMHomePage();
	}
	
	public String getTitle() {
		return getPageTitle();
	}
}
