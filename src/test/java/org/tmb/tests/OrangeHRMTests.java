package org.tmb.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tmb.pages.OrangeHRMLoginPage;
import com.tmb.reports.ExtentReport;

public final class OrangeHRMTests extends BaseTest{
	
	private OrangeHRMTests() {
		
	}
	
    @Test(dataProvider="LoginTestDataProvider")	
    public void loginLogoutTest(String username, String password) {
    	ExtentReport.createTest("LoginLogout");
    	
    	String title= new OrangeHRMLoginPage()
    			.enterUserName(username).enterPassword(password).clickLogin()
    			.clickDropDown().clickLogout()
    			.getTitle();
 
    	Assertions.assertThat(title)
    	.isEqualTo("OrangeHRM");
	}
    
    @DataProvider(name="LoginTestDataProvider", parallel = true)
    public Object[][] getData() {
    	return new Object[][] {
			{"Admin","admin123"},
			{"Admin","admin123"}
			/*{"Admin","admin123"},
			{"Admin123","admin1234"}*/
		};    	
    }
}
