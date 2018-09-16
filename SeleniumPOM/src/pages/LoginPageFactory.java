package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	WebDriver driver;
	
	@FindBy(id="MainContent_txtUserName")
	WebElement userName;
	
	@FindBy(id="MainContent_txtPassword")
	WebElement passWord;
	
	
	@FindBy(id="MainContent_btnLogin")
	WebElement loginButton;
	
	// Steps
	public void setUserName(String username)
	{
		userName.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		passWord.sendKeys(password);
	}
	
	public void clickSubmit()
	{
		loginButton.click();
	}
	
	// Actions
	public void login(String userName, String password)
	{
		setUserName(userName);
		setPassword(password);
		clickSubmit();
	}
	
	// Constructor initializes the state of the driver
	public LoginPageFactory(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
