package AssignmentProject.Qualicoach;
import java.io.IOException;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;
public class HomePage extends base {
	
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username,String Password) throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
		//creating object of LandinPage class and invoking methods of it
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.getLogin().click();
		System.out.println("login details entered succesfully");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
	
	
	//Parameterization and Data driving can be achieved by DataProvider annotaion of Testng
	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many different data types test should run
		//coloumn stands for how many values per test
		Object[][] data = new Object[4][2];
		//0th row
		//username and password both are correct
		data[0][0]="admin55";
		data[0][1]="Admin@6155";
		
		//1st row
		//correct username, but wrong password
		data[1][0]="admin99";
		data[1][1]="Admin@123";
		
		
		//3rd row
		//wrong username, but correct password
		data[2][0]="admin";
		data[2][1]="Admin@6102";
		
		//4th row
		//leave both fields empty
		data[3][0]=" ";
		data[3][1]=" ";
		
		return data;
		
	}
	
	
}
