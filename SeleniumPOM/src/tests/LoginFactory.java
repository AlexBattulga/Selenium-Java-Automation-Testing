package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.DashboardPageFactory;
import pages.LoginPageFactory;

public class LoginFactory {
	
	String username = "tim@testemail.com";
	String password = "trpass"; 
	
	@Test
	public void loginTestPageFactory()
	{
		// 1. Initialize driver
		WebDriver driver = utilities.DriverFactory.openBrowser("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		// 2. Enter login
		LoginPageFactory loginPage = new LoginPageFactory(driver);
		loginPage.login(username, password);
		
		// 3. Get conf info
		DashboardPageFactory dashPage = new DashboardPageFactory(driver);
		System.out.println(dashPage.title());
		
		driver.close();
				
	}
}
