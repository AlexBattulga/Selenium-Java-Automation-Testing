package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {
	
	WebDriver driver;
	String browserType = "chrome";
	String city = "New York, NY";
	String checkIn = "09/22/2018";
	String checkOut = "09/29/2018";
	String searchResult = "3";
	WebElement waitTillAppears;
	WebDriverWait wait;
	
	@Test
	public void hotelReservation() throws InterruptedException
	{
		// 1. Search
		driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);
		driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/button ")).click();
		driver.findElement(By.xpath("//body[contains(@class,'wrap cf')]/section[@id='WizardHero']/div[@id='hero-banner']/div[@class='hero-banner-gradient']/div[@class='cols-row hero-banner-inner']/section[@id='wizardSection']/div[contains(@class,'hero-banner-box siteId-1 cf')]/div[@id='wizard-tabs']/div[@class='tabs-container col']/section[@id='section-hotel-tab-hp']/form[@id='gcw-hotel-form-hp-hotel']/div[@class='cols-nested ab25184-dates-travelers']/div[@id='traveler-selector-hp-hotel']/div[@class='menu-bar gcw-travel-selector-wrapper']/ul[@class='menu-bar-inner']/li[@class='open']/div[@class='menu sticky gcw-menu']/div[@class='menu-main']/div[@class='traveler-selector-room-data']/div[@class='uitk-grid step-input-outside gcw-component gcw-component-step-input gcw-step-input gcw-component-initialized']/div[4]/button[1]/span[1]/*[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[9]/label/button")).click();
		
		// Print city name
		String actualCity = driver.findElement(By.cssSelector("#hotelResultTitle > h1")).getText();
		System.out.println(actualCity);
		
		// 2. Modify the search results page, give criteria
		driver.findElement(By.cssSelector("input[name='star'][id='star4']")).click();
		// 3. Analyze the results and make our selection
		waitTillAppears = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"resultsContainer\"]/section/article[" + searchResult + "]/div[2]/div/a")));
		waitTillAppears.click();
		
		//Switch window to the top
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		//Print hotel name and rating
		String hotelName = driver.findElement(By.id("hotel-name")).getText();
		System.out.println("Hotel Name: " + hotelName);
		// 4. Book reservation
		
		driver.findElement(By.cssSelector("button[class='btn-primary btn-sub-action book-button btn-pwa'][data-automation='launchETPModal']")).click();
		waitTillAppears = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pay-later-button")));
		waitTillAppears.click();
		String price = driver.findElement(By.cssSelector("span[class='amount-value'][data-price-update='total']")).getText();
		System.out.println("Hotel price per day: " + price);
		// 5. Fill out contact / billing
		
		// 6. Get confirmation
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("Payment"));
	}
	
	@BeforeMethod
	public void setUp()
	{
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.expedia.com");
		wait = new WebDriverWait(driver, 10);
	}
	
	@AfterMethod
	public void tearDown()
	{
//		driver.quit();
	}
}
