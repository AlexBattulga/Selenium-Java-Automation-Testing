package smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPresentTestNG {
	
	WebDriver driver;
	String browser = "chrome";
	
	@Test
	public void loginElementsPresentTest()
	{
		System.out.println("Running test");
		boolean emailBox = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
		boolean passwordBox = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();
		
		Assert.assertTrue(emailBox, "Email textbox present");
		Assert.assertTrue(passwordBox, "Password textbox present");
	}
	@BeforeTest
	public void setUp()
	{
		String URL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		driver = utilities.DriverFactory.open(browser);
		driver.get(URL);
		System.out.println("Before test");
	}
	@AfterTest
	public void tearDown()
	{
		System.out.println("After test");
		driver.close();
	}
}
