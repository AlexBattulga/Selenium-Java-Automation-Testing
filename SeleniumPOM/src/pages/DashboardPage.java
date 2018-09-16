package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {
	WebDriver driver;
	
	@FindBy(id="conf_message")
	WebElement conf_message;
	
	@FindBy(linkText="Change Password")
	WebElement changePass;
	
	public String title()
	{
		return driver.getTitle();
	}
	
	public String confirmationMessage()
	{
		return conf_message.getText();
	}
	
	public void changePassword()
	{
		changePass.click();
	}
	
	public void action()
	{
		confirmationMessage();
	}
	
	public DashboardPage(WebDriver driver)
	{
		this.driver = driver;
	}
}
