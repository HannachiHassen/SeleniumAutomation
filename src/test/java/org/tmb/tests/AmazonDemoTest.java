package org.tmb.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.enums.CategoryType;
import com.tmb.enums.DeviceType;
import com.tmb.pages.AmazonHomePage;

public final class AmazonDemoTest extends BaseTest {

	private AmazonDemoTest() {

	}

	@FrameworkAnnotation(author = { "Amuthan", "Sachin" }, category = { CategoryType.REGRESSION,
			CategoryType.MINIREGRESSION }, device = { DeviceType.WINDOWS, DeviceType.MAC })
	@Test
	public void amazonTest(Map<String, String> data) {

		String title = new AmazonHomePage().clickHamburger()
				.clickComputer()
				.clickOnSubMenuItem(data.get("menutext"))
				.getTitle();
		Assertions.assertThat(title).isNotBlank().isNotNull();
	}
}
