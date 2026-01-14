package base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilis.ExtentReportManager;
import utilis.Log;


public class BaseTest {
	protected WebDriver driver;
	protected ChromeOptions options;
	protected static ExtentReports extent;
	
	@BeforeSuite
	public void setUPReport()
	{
		extent=ExtentReportManager.getReportInstance();
	}
	
	@AfterSuite
	public void tearDownReport() {
		extent.flush();
	}

	@BeforeMethod
	public void setUp() {
		Log.info("Starting WebDriver...");
		options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<>();

		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.password_manager_leak_detection", false);

		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		Log.info("Navitaging to URL...");
		driver.get("https://www.saucedemo.com/");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			Log.info("Closing the Browser....");
			driver.quit();
		}
	}

}
