package AssignmentProject.Qualicoach;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.base;

public class Download extends base{
	//WebDriver driver = new ChromeDriver();
	
	@Test
	public void getDownload() throws IOException{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Qualicoach\\Driver\\ChromeDriver.exe");
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url2"));
		driver.get("https://test.qualicoach.org/my/");
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys("admin74");
		lp.getPassword().sendKeys("Admin@6155");
		lp.getLogin().click();
		 
		 	
		driver.findElement(By.xpath("//a[contains(text(),'Names of resources completed')]")).click();
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("//div[@class='centerpara'] /a /img[@alt='csv']")).click();
			
			
		}
	 	
	 @AfterTest
		public void teardown() {
			driver.close();
		}
	

}
