package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	private By usernameFiled= By.name("user-name");
	private By passwordField=By.name("password");
	private By loginButton=By.id("login-button");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	public void enterUsername(String username)
	{
		driver.findElement(usernameFiled).sendKeys(username);;
	}
	public void enterPasword(String password)
	{
		driver.findElement(passwordField).sendKeys(password);
	}
	public void clickLogin()
	{
		driver.findElement(loginButton).click();
	}

}
