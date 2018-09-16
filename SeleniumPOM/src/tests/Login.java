package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.DashboardPage;
import pages.LoginPage;

public class Login {
	
	@Test
	public void loginTestPOM()
	{
		// 1. Initialize driver
		WebDriver driver = utilities.DriverFactory.openBrowser("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		// 2. Enter login information
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName("tim@testemail.com");
		loginPage.setPassword("trpass");
		loginPage.clickSubmit();
		
		// 3. Get info
		DashboardPage dash = new DashboardPage(driver);
		String conf = dash.confirmationMessage();
		String pageTitle = dash.title();
		System.out.println(pageTitle);
		
		// 4. Assertions
		Assert.assertTrue(conf.contains("success"));
		Assert.assertTrue(pageTitle.contains("Account"));
		
		// 5. Close driver
		driver.quit();
	}
}
