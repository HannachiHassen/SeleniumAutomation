package com.tmb.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tmb.constans.FrameworkConstants;

public final class Driver {
	private static WebDriver driver;
	
	private Driver() {
		
	}

	public static void initDriver() {
		if(Objects.isNull(driver)) {
			System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverpath());
			driver= new ChromeDriver();	
			DriverManager.setDriver(driver);
			DriverManager.getDriver().get("https://google.com");
		}
	}

	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
