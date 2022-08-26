package org.tmb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.tmb.driver.Driver;

public final class HomepageTests extends BaseTest{
	
	private HomepageTests() {
		
	}
	
	@Test
	public void test2() {
		Driver.initDriver();
		Driver.driver.findElement(By.name("q")).sendKeys("testing mini bytes", Keys.ENTER);
	}
}
