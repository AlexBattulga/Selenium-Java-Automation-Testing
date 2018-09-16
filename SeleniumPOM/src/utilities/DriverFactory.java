package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public static WebDriver openBrowser(String browser) {
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "/Users/enkhbattulga/Documents/software/geckodriver");
			return new FirefoxDriver();
		}else {
			System.setProperty("webdriver.chrome.driver", "/Users/enkhbattulga/Documents/software/chromedriver");
			return new ChromeDriver();
		}
	}

}
