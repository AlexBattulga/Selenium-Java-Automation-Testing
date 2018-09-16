package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT {
	
	WebDriver driver;
	
	@Test(dataProvider = "getData")
	public void loginTest(String name, String email, String password)
	{
		 driver.findElement(By.xpath("//*[@id=\"MainContent_txtUserName\"]")).sendKeys(email);
		 driver.findElement(By.xpath("//*[@id=\"MainContent_txtPassword\"]")).sendKeys(password);
		 driver.findElement(By.xpath("//*[@id=\"MainContent_btnLogin\"]")).click();
		 String msg = driver.findElement(By.id("conf_message")).getText();
		 String pageTitle = driver.getTitle();
		 System.out.println(msg);
		 System.out.println(pageTitle);
	}
	@BeforeMethod
	public void setUp()
	{
		driver = utilities.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@DataProvider
	public String [][] getData()
	{
		return utilities.Excel.get("/Users/enkhbattulga/Documents/software/UserLogin.xls");
	}
}
