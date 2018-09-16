package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		
		 //1. Open the web browser
		  System.setProperty("webdriver.chrome.driver", "/Users/enkhbattulga/Documents/software/chromedriver");
		  WebDriver driver = new ChromeDriver();
		 // 2. Navigate to web application http://sdettraining.com/trguitransactions/AccountManagement.aspx
		 driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		 // 3. Enter email address
		 driver.findElement(By.xpath("//*[@id=\"MainContent_txtUserName\"]")).sendKeys("tim@testemail.com");
		 //4. Enter password
		 driver.findElement(By.xpath("//*[@id=\"MainContent_txtPassword\"]")).sendKeys("trpass");
		 // 5. Click login
		 driver.findElement(By.xpath("//*[@id=\"MainContent_btnLogin\"]")).click();
		 // 6. Get confirmation
		 String msg = driver.findElement(By.id("conf_message")).getText();
		 String pageTitle = driver.getTitle();
		 System.out.println(msg);
		 System.out.println(pageTitle);
		 // 7. Close the browser
		 driver.quit();
	}

}
