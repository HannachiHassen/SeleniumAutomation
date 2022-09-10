package com.tmb.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtlis;

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
	 * @param browser value will be passed from {@link com.tmb.tests.BaseTest}. Values can be chrome and firefox
	 */

	public static void initDriver(String browser) {
		if (Objects.isNull(DriverManager.getDriver())) {
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckoDriverPath());
				DriverManager.setDriver(new FirefoxDriver());
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
				DriverManager.setDriver(new ChromeDriver());
			} else if (browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", FrameworkConstants.getChromeDriverPath());
				DriverManager.setDriver(new EdgeDriver());
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
