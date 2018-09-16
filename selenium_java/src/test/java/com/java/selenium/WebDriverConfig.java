package com.java.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfig {
	public WebDriver getChrome()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/enkhbattulga/Documents/software/chromedriver");
		WebDriver driver = new ChromeDriver();
		return driver;
		
	}
	public WebDriver getFirefox()
	{
		System.setProperty("webdriver.gecko.driver", "/Users/enkhbattulga/Documents/software/geckodriver");
		WebDriver driver = new FirefoxDriver();
		return driver;
		
	}
}
