package smokeTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJUnit {
	
	WebDriver driver;
	String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
	
	@Test
	public void pageTitleTest()
	{
		driver.get(webURL);
		String actualTitle = driver.getTitle();
		String expectedTitle = "SDET Training | Account Management";
		Assert.assertEquals(expectedTitle, actualTitle);
      //Assert.fail("We intentionally failed this test");
	}
	
	@Before
	public void setUp()
	{
		System.out.println("Setting up the test");
		System.out.println("Initializing the driver");
		driver = utilities.DriverFactory.open("chrome");
	}
	
	@After
	public void tearDown()
	{
		System.out.println("Closing the test");
		driver.close();
	}
}
