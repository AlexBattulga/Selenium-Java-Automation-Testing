package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		
		//1. Create Webdriver
		System.setProperty("webdriver.gecko.driver", "/Users/enkhbattulga/Documents/software/geckodriver");
		WebDriver driver = new FirefoxDriver();
		//2. Navigate to Account managemant Page >>> Click
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/a")).click();
		//3. Fill out the form
		driver.findElement(By.id("MainContent_txtFirstName")).sendKeys("Alex");
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys("test@yahoo.com");
		driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]")).sendKeys("2022228888");
		driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Male']")).click();
		driver.findElement(By.cssSelector("#MainContent_txtPassword")).sendKeys("1234");
		driver.findElement(By.xpath("//*[@id=\"MainContent_txtVerifyPassword\"]")).sendKeys("1234");
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Germany");
		driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		//4. Get Information
		String info = driver.findElement(By.xpath("//*[@id=\"MainContent_lblTransactionResult\"]")).getText();
		System.out.println(info);
		//5. Close the browser
		driver.close();
	}

}
