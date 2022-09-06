package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.utils.DynamicXpathUtils;

public final class AmazonHamburgerMenuPage extends BasePage {

	@FindBy(xpath = "//div[text()='Mobiles, Computers']/parent::a")
	private WebElement linkMobileAndComputers;
	
	@FindBy(xpath = "//a[text()='laptops']")
	private WebElement linkLaptops;
	
	@FindBy(xpath = "//a[text()='Drivers & Storage']")
	private WebElement linkDriversAndStorage;
	
	@FindBy(xpath = "//a[text()='Printer & Ink']")
	private WebElement linkPrinterAndInk;
	
	private String linkSubMenu= "//a[text()='%replaceable%']";
	
	public AmazonHamburgerMenuPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public void clickOnSubMenuItem(String menutext) {
		String newxpath=DynamicXpathUtils.getXpath(linkSubMenu, menutext);
		click(By.xpath(newxpath), WaitStrategy.CLICKABLE, menutext);
	}

	public AmazonHamburgerMenuPage clickMobileAndComputers() {
		linkMobileAndComputers.click();
		return this;
	}

	public AmazonLaptopPage clickLinkLaptops() {
		linkLaptops.click();
		return new AmazonLaptopPage();
	}

	public AmazonHamburgerMenuPage clickDriversAndStorage() {
		linkDriversAndStorage.click();
		return this;
	}

	public AmazonHamburgerMenuPage clickPrinterAndInk() {
		linkPrinterAndInk.click();
		return this;
	}
}
