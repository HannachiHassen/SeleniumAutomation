package org.tmb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tmb.constans.FrameworkConstants;

public class LoginpageTests {
	
	//1. Never Hardcode
	//2. keep right thing at right place
		
	// class or interface name ---> AmuthanSakthivel
	// final constant values --> AMUTHANSAKTHIVEL or AMUTHAN_SAKTHIVEL
	// method ---> amuthanSakthivel
	// package --> amuthansakathivel
	
	@Test
	public void test1() {
		System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverpath());
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation", Keys.ENTER) ;
		driver.close();		
	}
	
	@Test
	public void test2() {
		System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverpath());
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("testing mini bytes", Keys.ENTER);
		driver.close();	
	}
}
