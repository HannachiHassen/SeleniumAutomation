/**
 * 
 */
package com.tmb.selenoid.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

/**
 * Sep 21, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public final class RunChromeTestsInSelenoid {
	
	private RunChromeTestsInSelenoid() {}
	
	/**
	 * we can use both DesiredCapabilities and Chromeoptions class via merge method
	 * 
	 * DesiredCapabilities cap = new DesiredCapabilities();   // instantiate DC Class
	 * ChromeOptions options = new ChromeOptions();          // instantiate CO Class
	 * options.merge(cap);                               // passing DC class object to CO Class
	 * driver = new ChromeDriver(options);
	 */

	@Test
	public void test1() throws MalformedURLException {		
		ChromeOptions options = new ChromeOptions();
		options.setCapability("browserVersion", "83.0");
		options.setCapability("enableVNC", true);
		options.setCapability("enableVideo",true);
		options.setCapability("enableName", "test1_video.mp4");
		
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		driver.get("https://www.google.com");
		
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Testing mini bytes", Keys.ENTER);
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		driver.quit();		
	}
	
	@Test
	public void test2() throws MalformedURLException {		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(BrowserType.CHROME);
		cap.setCapability("browserVersion", "83.0");
		cap.setCapability("enableVNC", true);
		cap.setCapability("enableVideo",true);
		cap.setCapability("enableName", "test1_video.mp4");
		
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.get("https://www.google.com");
		
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Testing mini bytes", Keys.ENTER);
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		driver.quit();		
	}
}
