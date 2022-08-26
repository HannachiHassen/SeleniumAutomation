package org.tmb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tmb.constans.FrameworkConstants;

public class LoginpageTests {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverpath());
		WebDriver driver= new ChromeDriver();		
		driver.get("https://google.com");
	}
	
	@Test
	public void test1() {
		driver.findElement(By.name("q")).sendKeys("Automation", Keys.ENTER) ;	}
	
	@Test
	public void test2() {
		driver.findElement(By.name("q")).sendKeys("testing mini bytes", Keys.ENTER);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();	
	}
}
