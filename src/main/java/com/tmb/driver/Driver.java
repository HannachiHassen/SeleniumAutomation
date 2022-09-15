package com.tmb.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;
import com.tmb.exceptions.BrowserInvocationFailedException;
import com.tmb.factories.DriverFactory;
import com.tmb.utils.PropertyUtlis;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

/**
 * 
 * Sep 10, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 * @see com.tmb.tests.BaseTest
 *
 * Driver class is responsible for invoking and closing the browsers.
 * 
 * <p>
 * It is also responsible for setting the driver variable to DriverManager which
 * handles the thread safety for the webdriver instance.
 * 
 * @see DriverManager
 * @see com.tmb.tests.BaseTest
 */
public final class Driver {

	/**
	 * private constructor to avoid external instantiation
	 */

	private Driver() {

	}

	/**
	 * 
	 * @author Hassen
	 * Sep 10, 2022
	 * @param browser value will be passed from {@link com.tmb.tests.BaseTest}. Values can be chrome, firefox and edge
	 * @param version value will be passed from {@link com.tmb.tests.BaseTest}. 
	 */
	public static void initDriver(String browser, String version) {
		if (Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser, version));
			} catch (MalformedURLException e) {
				throw new BrowserInvocationFailedException("Please check the capabilities of browser");
			}
			DriverManager.getDriver().get(PropertyUtlis.get(ConfigProperties.URL));
		}
	}

	/**
	 * Terminates the browser instance.
	 * Sets the Threadlocal to default value, i.e null.
	 * @author Hassen
	 * Sep 10, 2022
	 */
	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
