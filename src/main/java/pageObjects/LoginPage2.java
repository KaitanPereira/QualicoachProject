package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage2 {
	
	public WebDriver driver;
	
	By email=By.id("username");
	By password=By.id("password");
	By login=By.cssSelector("[value='Log in']");
	
	public LoginPage2(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	

}
