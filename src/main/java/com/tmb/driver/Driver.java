package com.tmb.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tmb.constans.FrameworkConstants;
import com.tmb.utils.ReadPropertyFile;

public final class Driver {
		
	private Driver() {
		
	}

	public static void initDriver() throws Exception {
		if(Objects.isNull(DriverManager.getDriver())) {
			System.setProperty("webdriver.gecko.driver", FrameworkConstants.getFirefoxdriverpath());
		
			DriverManager.setDriver(new FirefoxDriver());
			DriverManager.getDriver().get(ReadPropertyFile.get("url"));
		}
	}

	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
