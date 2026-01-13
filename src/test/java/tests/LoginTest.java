package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	@Test
	public void testValidLogin() {
		LoginPage logingPage=new LoginPage(driver);
		logingPage.enterUsername("standard_user");;
		logingPage.enterPasword("secret_sauce");
		logingPage.clickLogin();
		System.out.println("Name of the Page Title is :"+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		
	}

}
