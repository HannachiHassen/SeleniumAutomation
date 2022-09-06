package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.utils.DynamicXpathUtils;

public final class AmazonHamburgerMenuPage extends BasePage {
	
	private String linkSubMenu= "//a[text()='%replaceable%']";
	
	public AmazonHamburgerMenuPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public void clickOnSubMenuItem(String menutext) {
		String newxpath=DynamicXpathUtils.getXpath(linkSubMenu, menutext);
		click(By.xpath(newxpath), WaitStrategy.CLICKABLE, menutext);
	}
}
