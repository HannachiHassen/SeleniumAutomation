package org.tmb.tests;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tmb.driver.DriverManager;

public final class HomepageTests extends BaseTest{
	
	private HomepageTests() {
		
	}
	/* 
	 * validate whether the title is containing Google Search og google serach
	 * validate wether the title is not null and the length of title is greater than 15 and less than 100
	 * check for the links in the pages --> Testing mini bytes - Youtube
	 * number of links displayed is exactly 10 or 15
	 * 
	 */
	// 
	@Test
	public void test2() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - Youtube", Keys.ENTER);
		String title=DriverManager.getDriver().getTitle();
		
		assertThat(title)
		  .isNotNull()
		  .as("Objects is actullay null").containsIgnoringCase("google search")
		  .as("It does not contains expected text").matches("\\w.*"+"Google Search")
		  .hasSizeBetween(15, 100);
		 
		/*
		Assert.assertTrue(Objects.nonNull(title), "Title is null");
		Assert.assertTrue(title.toLowerCase().contains("google search"));
		Assert.assertTrue(title.toLowerCase().matches("\\w.*"+"google search"));  // [a-zA-Z0-9]
		Assert.assertTrue(title.length()>15);
		Assert.assertTrue(title.length()<100);
		*/
		
		List<WebElement> elements=DriverManager.getDriver().findElements(By.xpath("//h3[contains (text(), 'Testing Mini Bytes - YouTube')]"));
		
		assertThat(elements)
		 .hasSize(1)
		 .extracting(e -> e.getText())
		 .contains("Testing Mini bytes - Youtube");		
	
		/*
		Assert.assertEquals(elements.size(), 1);
		
		boolean isElementPresent=false;
		for (WebElement element: elements) {
			if (element.getText().equals("Testing Mini bytes - Youtube")) {
				isElementPresent=true;
				break;				
			}	
		}
		Assert.assertTrue(isElementPresent, "Testing mini bytes not found");
		 */
	}
}
