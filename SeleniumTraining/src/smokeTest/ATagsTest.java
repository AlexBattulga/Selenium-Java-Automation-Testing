package smokeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ATagsTest {
	WebDriver driver;
	String browser = "chrome";
	
	@Test
	public void loginElementsPresentTest()
	{
		boolean createAccountPresent = false;
		System.out.println("Running test");
		// We want to test the presence of a Tags >> hyperlinks
		List <WebElement> aElements = driver.findElements(By.tagName("a"));
		for(WebElement aElement: aElements)
		{
			System.out.println(aElement.getText());
			if(aElement.getText().equals("CREATE ACCOUNT"))
			{
				createAccountPresent = true;
				break;
			}
		}
		Assert.assertTrue(createAccountPresent);
	}
	@BeforeTest
	public void setUp()
	{
		String URL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		driver = utilities.DriverFactory.open(browser);
		driver.get(URL);
		System.out.println("Before test");
	}
	@AfterTest
	public void tearDown()
	{
		System.out.println("After test");
		driver.close();
	}
}
