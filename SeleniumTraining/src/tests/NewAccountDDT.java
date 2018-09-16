package tests;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {
	String name;
	String email;
	String phone;
	String gender;
	String password;
	String country;
	WebDriver driver;
	boolean weeklyEmail, monthlyEmail, occasionalEmail;
	WebElement nameElement,emailElement, numberElement, passwordElement, verifyPassElement, countryElement, maleRadioElement, femaleRadioElement, weeklyCheckBox, submit ;
	
	
	//This is our test method
	@Test
	public void newAccountTest()
	{
		System.out.println("New Record: " + " \t" + name + " \t" + email + " \t" + phone + " \t" + gender + " \t" + password + " \t" + country + " \t" + weeklyEmail + " \t" + monthlyEmail + " \t" + occasionalEmail );
		
		defineWebElements();
		
		//Fill the form
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		numberElement.sendKeys(phone);
		passwordElement.sendKeys(password);
		verifyPassElement.sendKeys(password);
		new Select(countryElement).selectByVisibleText(country);
		
		//Interacting with Radio button
		if(gender.equalsIgnoreCase("Male"))
		{
			maleRadioElement.click();
		}else {
			femaleRadioElement.click();
		}
		
		//Interacting with CheckBox
		if(weeklyEmail){ if(!weeklyCheckBox.isSelected()){ weeklyCheckBox.click(); }}
		else{ if(weeklyCheckBox.isSelected()) { weeklyCheckBox.click(); }}
		if(monthlyEmail){ if(!weeklyCheckBox.isSelected()){ weeklyCheckBox.click(); }}
		else{ if(weeklyCheckBox.isSelected()) { weeklyCheckBox.click(); }}
		if(occasionalEmail){ if(!weeklyCheckBox.isSelected()){ weeklyCheckBox.click(); }}
		else{ if(weeklyCheckBox.isSelected()) { weeklyCheckBox.click(); }}
		submit.click();
	}
	
	@Before
	public void setUp()
	{
		driver = utilities.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/a")).click();
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	public void defineWebElements()
	{
		//Define webElemnts
		nameElement = driver.findElement(By.id("MainContent_txtFirstName"));
		emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		numberElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
		passwordElement = driver.findElement(By.cssSelector("#MainContent_txtPassword"));
		verifyPassElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtVerifyPassword\"]"));
		countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		maleRadioElement = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender']"));
		femaleRadioElement = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']"));
		weeklyCheckBox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
		submit = driver.findElement(By.id("MainContent_btnSubmit"));
	}
	
	//This annotated method is designed to pass parameters into the class via constructor
	@Parameters
	public static List<String[]> getData()
	{
		return utilities.CSV.get("/Users/enkhbattulga/Documents/software/UserAccounts.csv");
	}
	//Constructor that passes parameters to the test method
	public NewAccountDDT(String name, String email, String phone, String gender, String password, String country, String weeklyEmail, String monthlyEmail, String occasionalEmail)
	{
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
		this.country = country;
		if(weeklyEmail.equals("TRUE")){ this.weeklyEmail = true; }
		else { this.weeklyEmail=false; }
		if(monthlyEmail.equals("TRUE")){ this.monthlyEmail = true; }
		else { this.monthlyEmail=false; }
		if(occasionalEmail.equals("TRUE")){ this.occasionalEmail = true; }
		else { this.occasionalEmail=false; }
	}
}
