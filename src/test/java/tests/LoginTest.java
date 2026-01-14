package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilis.ExtentReportManager;
import utilis.Log;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	@Test
	public void testValidLogin() {
		Log.info("Strating LoginTest...");
		test=ExtentReportManager.createTest("Login Test");
		test.info("Navigating to URL..");
		LoginPage logingPage = new LoginPage(driver);
		Log.info("Adding Creds....");
	    test.info("Adding Creds....");
		logingPage.enterUsername("standard_user");
		logingPage.enterPasword("secret_sauce");
		test.info("Clicking on login Button");
		logingPage.clickLogin();
		Log.info("Verifying Page title...");
		test.info("Verifying Page title...");
		System.out.println("Name of the Page Title is :" + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		test.pass("Login Successful");

	}

}
