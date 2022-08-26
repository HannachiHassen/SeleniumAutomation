package org.tmb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.tmb.driver.DriverManager;

public final class HomepageTests extends BaseTest{
	
	private HomepageTests() {
		
	}
	
	@Test
	public void test2() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("testing mini bytes", Keys.ENTER);
	}
}
