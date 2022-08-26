package org.tmb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.tmb.driver.Driver;

public final class LoginpageTests extends BaseTest{	
	
	private LoginpageTests() {
		
	}
	
	@Test
	public void test1() {
		Driver.driver.findElement(By.name("q")).sendKeys("Automation", Keys.ENTER) ;	
	}	
}
