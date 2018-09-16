package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) {
		String name = "Alex";
		String email = "test@yahoo.com";
		String password = "1234";
		String country = "Germany";
		String phoneNumber = "2022228888";
		String webBrowser = "chrome";
		String gender = "Male";
		boolean weeklyEmail = true;
		boolean mounthlyEmail = false; 
		boolean occassionalEmail = false;
		
		//Define webDriver
		WebDriver driver;
		driver = utilities.DriverFactory.open(webBrowser);
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/a")).click();
		
		//Define webElemnts
		WebElement nameElement = driver.findElement(By.id("MainContent_txtFirstName"));
		WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		WebElement numberElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
		WebElement passwordElement = driver.findElement(By.cssSelector("#MainContent_txtPassword"));
		WebElement verifyPassElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtVerifyPassword\"]"));
		WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		WebElement maleRadioElement = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender']"));
		WebElement femaleRadioElement = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']"));
		WebElement weeklyCheckBox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
		WebElement submit = driver.findElement(By.id("MainContent_btnSubmit"));
		
		//Fill the form
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		numberElement.sendKeys(phoneNumber);
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
		if(weeklyEmail)
		{
			if(!weeklyCheckBox.isSelected())
			{
				weeklyCheckBox.click();
			}
		}else {
			if(weeklyCheckBox.isSelected())
			{
				weeklyCheckBox.click();
			}
		}
		submit.click();
		String info = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		String expected = "Customer information added successfully";
		if(info.equals(expected))
		{
			System.out.println(info);
		}else {
			System.out.println("Test Failed!!!");
		}
		driver.close();

	}

}
