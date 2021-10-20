package AssignmentProject.Qualicoach;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.base;

public class DeleteUser extends base {
	By users=By.xpath("//a[text()='Users']");
	By Browse=By.xpath("//li/a[contains(text(),'Browse list of users')]");
	By textbox=By.cssSelector("input[id='id_realname']");
	By filter=By.cssSelector("input[id='id_addfilter']");
	By delete=By.xpath("//*[@class='lastrow'] /td[6] /a[1]");
	By cnfmDelete=By.cssSelector("input[value='Delete']");
	

@Test
	public void getDeleteUser() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys("admin71");
		lp.getPassword().sendKeys("Admin@6100");
		lp.getLogin().click();
		driver.findElement(users).click();
		driver.findElement(Browse).click();
		driver.findElement(textbox).sendKeys("Admin User");
		driver.findElement(filter).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(delete).click();
		driver.findElement(cnfmDelete).click();
			
			
	 }

	@AfterTest
	public void teardown() {
		driver.close();
}
}
