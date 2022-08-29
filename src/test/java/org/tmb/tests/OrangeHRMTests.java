package org.tmb.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.crmpro.pages.OrangeHRMLoginPage;

public final class OrangeHRMTests extends BaseTest{
	
	private OrangeHRMTests() {
		
	}
	
    @Test	
    public void loginLogoutTest() {
    	String title= new OrangeHRMLoginPage()
    			.enterUserName("Admin").enterPassword("admin123").clickLogin()
    			.clickDropDown().clickLogout()
    			.getTitle();
 
    	Assertions.assertThat(title)
    	.isEqualTo("OrangeHRM");
	}
}
