package com.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.driver.DriverManager;

public class OrangeHRMHomePage {
	//link
	//button or btnSubmit
	//drpdwnCountry
	
	private final By linkDropDown=By.xpath("//p[@class='oxd-userdropdown-name']");
	private final By linkLogout=By.id("//a[text()='Logout']");
	
	public OrangeHRMHomePage clickDropDown() {
		DriverManager.getDriver().findElement(linkDropDown).click();
		return this;
	}
	
	public OrangeHRMLoginPage clickLogout() {
		//Uninterruptibles.sleepUninterruptibly(3,  TimeUnit.SECONDS);
		
	     new WebDriverWait(DriverManager.getDriver(), 10)
		   .until(ExpectedConditions.elementToBeClickable(linkLogout));  // old fashion way
		
		DriverManager.getDriver().findElement(linkLogout).click();	
		return new OrangeHRMLoginPage();
	}
	// wait.until(d-> d.findElement(link_logout).isEnabled());     //Java 8 way
}
