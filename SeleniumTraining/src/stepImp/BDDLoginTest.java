package stepImp;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class BDDLoginTest {
	
	WebDriver driver;
	boolean result;
	
	//Given user is on the login page
	@Given("^user is on the login page$")
	public void user_is_on_the_login_pag()
	{
		System.out.println("User is on the login page");
		driver = utilities.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	//When user enters correct username and correct password
	@When("^user enters correct username and correct password$")
	public void user_enters_correct_username_and_password()
	{
		System.out.println("user enters correct username and correct password");
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass");
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	@When("^user enters email(.*)$")
	public void user_enters_username(String username)
	{
		System.out.println("Testing username: " + username);
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
	}
	@And("^user enters password(.*)$")
	public void user_enters_password(String password)
	{
		System.out.println("Testing username: " + password);
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
		click_login();
	}
	@And("^user clicks login btn$")
	public void click_login()
	{
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	// user gets confirmation
	@Then("^user gets confirmation$")
	public void user_gets_confirmatio()
	{
		System.out.println("user gets confirmation");
		result = Assert.assertTrue(driver.findElement(By.id("conf_message")).getText().contains("success"));
	}
	@After
	public void tearDown()
	{
		driver.quit();
	}
}
