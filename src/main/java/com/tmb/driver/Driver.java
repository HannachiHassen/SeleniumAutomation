package com.tmb.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tmb.constans.FrameworkConstants;

public class Driver {
	public static WebDriver driver;

	public static void initDriver() {
		if(Objects.isNull(driver)) {
			System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverpath());
			driver= new ChromeDriver();		
			driver.get("https://google.com");
		}
	}

	public static void quitDriver() {
		if(Objects.nonNull(driver)) {
		driver.quit();
		driver=null;
		}
	}
}
