/**
 * 
 */
package com.tmb.factories;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.internal.PropertyUtils;

import com.tmb.driver.DriverManager;
import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtlis;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Sep 10, 2022
 * 
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public final class DriverFactory {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private DriverFactory() {
	}

	public static WebDriver getDriver(String browser, String version) throws MalformedURLException {
		/*
		 * WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
		 * WebDriverManager.firefoxdriver().proxy("http://username:password@mycompanyproxy.com:port").setup();
		 */

		WebDriver driver = null;
		String runmode = PropertyUtlis.get(ConfigProperties.RUNMODE);
		if (browser.equalsIgnoreCase("chrome")) {
			if (runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.CHROME);
				cap.setVersion(version);
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		} else if (browser.equalsIgnoreCase("firefox")) {
			if (runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.FIREFOX);
				cap.setVersion(version);
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		} else if (browser.equalsIgnoreCase("edge")) {
			if (runmode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.EDGE);
				cap.setVersion(version);
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			} else {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		}
		return driver;
	}
}
