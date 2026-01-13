package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilis.Log;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	@Test
	public void testValidLogin() {
		Log.info("Strating LoginTest...");
		LoginPage logingPage = new LoginPage(driver);
		Log.info("Adding Creds....");
		logingPage.enterUsername("standard_user");
		logingPage.enterPasword("secret_sauce");
		logingPage.clickLogin();
		Log.info("Verifying Page title...");
		System.out.println("Name of the Page Title is :" + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Swag Labs");

	}

}
