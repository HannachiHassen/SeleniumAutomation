package com.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.driver.DriverManager;

public final class OrangeHRMHomePage extends BasePage{
	//link
	//button or btnSubmit
	//drpdwnCountry
	
	private final By linkDropDown=By.xpath("//p[@class='oxd-userdropdown-name']");
	private final By linkLogout=By.id("//a[text()='Logout']");
	
	public OrangeHRMHomePage clickDropDown() {
		click(linkDropDown);
		return this;
	}
	
	public OrangeHRMLoginPage clickLogout() {
		//Uninterruptibles.sleepUninterruptibly(3,  TimeUnit.SECONDS);
		
		click(linkLogout);
		return new OrangeHRMLoginPage();
	}
	// wait.until(d-> d.findElement(link_logout).isEnabled());     //Java 8 way
}
