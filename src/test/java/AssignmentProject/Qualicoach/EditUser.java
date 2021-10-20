package AssignmentProject.Qualicoach;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.base;

public class EditUser extends base{
	
	By users=By.xpath("//a[text()='Users']");
	By Browse=By.xpath("//li/a[contains(text(),'Browse list of users')]");
	By textbox=By.cssSelector("input[id='id_realname']");
	By filter=By.cssSelector("input[id='id_addfilter']");
	By settingLogo=By.xpath("//*[@class='lastrow'] /td[6] /a[3]");
	By updateBtn=By.cssSelector("input[value='Update profile']");
	
@Test
	public void getEditUser() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys("admin60");
		lp.getPassword().sendKeys("Admin@4801");
		lp.getLogin().click();
		driver.findElement(users).click();
		driver.findElement(Browse).click();
		driver.findElement(textbox).sendKeys("Demo User");
		driver.findElement(filter).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(settingLogo).click();
		js.executeScript("window.scrollBy(0,1000)");
		WebElement drop=driver.findElement(By.id("id_country"));
		Select dropdown = new Select(drop);
		dropdown.selectByValue("IN");
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(updateBtn).click();

	
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}

}
