package org.tmb.tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


import com.tmb.constans.FrameworkConstants;
import com.tmb.driver.DriverManager;
import com.tmb.utils.ReadPropertyFile;


public class SimpleTest {
	public WebDriver driver;
	
	private final By textbox_username=By.xpath("//input[@placeholder='Username']");
	private final By textbox_password=By.xpath("//input[@name='password']");
	private final By button_login =By.xpath("//button[@type='submit']");
	
	@Test
	public void verifyTest() throws Exception {

		System.setProperty("webdriver.gecko.driver", FrameworkConstants.getFirefoxdriverpath());
		
		DriverManager.setDriver(new FirefoxDriver());
		DriverManager.getDriver().get(ReadPropertyFile.get("url"));
		
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().deleteAllCookies();
		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
		String title=DriverManager.getDriver().getTitle();
		System.out.println(title);		
	
		DriverManager.getDriver().findElement(textbox_username).sendKeys("Admin");
	
		DriverManager.getDriver().findElement(textbox_password).sendKeys("admin123");	

		DriverManager.getDriver().findElement(button_login).click();		
	}
}
