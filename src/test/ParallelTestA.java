package test;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTestA {
	
	public static RemoteWebDriver driver;
	public static String appURL = "http://qa.xtbills.com/";
	
	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(String browser) throws MalformedURLException {
		System.out.println("*******************");
		driver = Browser.getDriver(browser);
		driver.manage().window().maximize();
	}
	
	@Test
	public void testGooglePageTitleInFirefox() {
		driver.navigate().to(appURL);
		String strPageTitle = driver.getTitle();
		Assert.assertTrue(strPageTitle.contains("XTBills - Login"));
	}
	
	@Test
	public void testlogin() {
		
		
		//System.out.println(strPageTitle);
		driver.navigate().to(appURL);
		driver.findElement(By.id("TxtEmail")).sendKeys("admink@gmail.com");
		System.out.println("admink@gmail.com");
		driver.findElement(By.id("TxtPassword")).sendKeys("xeno@123");
		System.out.println("xeno@123");
		driver.findElement(By.id("BtnLogin")).click();
		
		//driver.findElement(By.name("q")).sendKeys("Selenium Easy Grid Tutorials");
		//driver.findElement(By.name("btnG")).click();
	}

	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Closing browser");
			driver.quit();
		}
	}
	
}