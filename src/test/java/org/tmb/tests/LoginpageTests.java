package org.tmb.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import com.tmb.pages.OrangeHRMLoginPage;

public final class LoginpageTests extends BaseTest {

	private LoginpageTests() {

	}

	@Test
	public void loginLogoutTest(Map<String, String> data) {

		String title = new OrangeHRMLoginPage()
				.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin()
				.clickDropDown().clickLogout()
				.getTitle();

		Assertions.assertThat(title).isEqualTo("OrangeHRM");
	}

	@Test
	public void newTest(Map<String, String> data) {

		String title = new OrangeHRMLoginPage()
				.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin()
				.clickDropDown().clickLogout()
				.getTitle();

		Assertions.assertThat(title).isEqualTo("OrangeHRM");
	}
}
