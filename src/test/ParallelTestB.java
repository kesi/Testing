package test;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTestB {
	
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
public void testPageTitleInChrome() {
	driver.navigate().to("http://qa.xtbills.com/");
	String strPageTitle = driver.getTitle();
	System.out.println(strPageTitle);
}

@Test
public void testlogin() {
	
	
	//System.out.println(strPageTitle);
	driver.navigate().to(appURL);
	String Username="payerk@gmail.com";
	driver.findElement(By.id("TxtEmail")).sendKeys(Username);
	System.out.println("User name enterd");
	String Password="xeno@123";
	driver.findElement(By.id("TxtPassword")).sendKeys(Password);
	System.out.println(Password);
	System.out.println("Password enterd");
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