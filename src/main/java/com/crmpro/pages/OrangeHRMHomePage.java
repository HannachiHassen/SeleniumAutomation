package com.crmpro.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;

public final class OrangeHRMHomePage extends BasePage{
		
	private final By linkDropDown=By.xpath("//p[@class='oxd-userdropdown-name']");
	private final By linkLogout=By.id("//a[text()='Logout']");
	
	public OrangeHRMHomePage clickDropDown() {
		click(linkDropDown, WaitStrategy.PRESENCE);
		return this;
	}
	
	public OrangeHRMLoginPage clickLogout() {		
		click(linkLogout, WaitStrategy.CLICKABLE);
		return new OrangeHRMLoginPage();
	}
	//Uninterruptibles.sleepUninterruptibly(3,  TimeUnit.SECONDS);
	// wait.until(d-> d.findElement(link_logout).isEnabled());     //Java 8 way
}
