package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageFactory {
	
	WebDriver driver;
		
	public String title()
	{
		return driver.getTitle();
	}
	
	public String confirmationMessage()
	{
		return driver.findElement(By.id("conf_message")).getText();
	}
	
	public void changePassword()
	{
		driver.findElement(By.linkText("Change Password")).click();
	}
	
	public DashboardPageFactory(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
