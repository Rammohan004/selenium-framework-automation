package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilis.Log;

public class LoginPage {
	
	private WebDriver driver;
	@FindBy(name="user-name")
	WebElement usernameFiled;
	@FindBy(name="password")
	WebElement passwordField;
	@FindBy(id="login-button")
	WebElement loginButton;
	//private By usernameFiled= By.name("user-name");
	//private By passwordField=By.name("password");
	//private By loginButton=By.id("login-button");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void enterUsername(String username)
	{
		usernameFiled.sendKeys(username);
		//driver.findElement(usernameFiled).sendKeys(username);;
	}
	public void enterPasword(String password)
	{
		passwordField.sendKeys(password);
		//driver.findElement(passwordField).sendKeys(password);
	}
	public void clickLogin()
	
	{
		loginButton.click();
		Log.info("Clicking Login Button..");
		//driver.findElement(loginButton).click();
	}

}
