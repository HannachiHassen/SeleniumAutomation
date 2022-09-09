package com.tmb.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tmb.constans.FrameworkConstants;
import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtlis;

public final class Driver {

	private Driver() {

	}

	public static void initDriver(String browser) {
		if(Objects.isNull(DriverManager.getDriver())) {
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckoDriverPath());
				DriverManager.setDriver(new FirefoxDriver());
			}
			else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
				DriverManager.setDriver(new ChromeDriver());
			}
		    else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", FrameworkConstants.getChromeDriverPath());
			DriverManager.setDriver(new EdgeDriver());
		    }
			DriverManager.getDriver().get(PropertyUtlis.get(ConfigProperties.URL));
		}
	}

	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
