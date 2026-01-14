package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import lombok.Data;
import utilis.ExcelUtils;
import utilis.ExtentReportManager;
import utilis.Log;
import pages.LoginPage;


public class LoginTest extends BaseTest {
	@DataProvider(name="LoginData")
	public Object[][] getLoginData() throws IOException {
		String filePath = System.getProperty("user.dir") + "/testdata/TestData.xlsx";
		ExcelUtils.loadExcel(filePath, "sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount - 1][2];
		for (int i = 1; i < rowCount; i++) {
data[i-1][0]=ExcelUtils.getCellData(i, 0);
data[i-1][1]=ExcelUtils.getCellData(i, 1);

	

		}
		ExcelUtils.closeExcel();
		return data;
	}

	@Test(dataProvider="LoginData")
	public void testValidLogin(String username,String password) {
		Log.info("Strating LoginTest...");
		test = ExtentReportManager.createTest("Login Test with valid creds");
		test.info("Navigating to URL..");
		LoginPage logingPage = new LoginPage(driver);
		Log.info("Adding Creds....");
		test.info("Adding Creds....");
		//logingPage.enterUsername("standard_user");
		//logingPage.enterPasword("secret_sauce");
		logingPage.enterUsername(username);
		logingPage.enterPasword(password);
		test.info("Clicking on login Button");
		logingPage.clickLogin();
		Log.info("Verifying Page title...");
		test.info("Verifying Page title...");
		System.out.println("Name of the Page Title is :" + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		test.pass("Login Successful");

	}

/*	@Test
	public void testInValidLogin() {
		Log.info("Strating LoginTest...");
		test = ExtentReportManager.createTest("Login Test invaild creds");
		test.info("Navigating to URL..");
		LoginPage logingPage = new LoginPage(driver);
		Log.info("Adding Creds....");
		test.info("Adding Creds....");
		logingPage.enterUsername("standard_user23");
		logingPage.enterPasword("secret_sauce12");
		test.info("Clicking on login Button");
		logingPage.clickLogin();
		Log.info("Verifying Page title...");
		test.info("Verifying Page title...");
		System.out.println("Name of the Page Title is :" + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Swag Labs--123");
		test.pass("Login Successful");

	}*/

}
