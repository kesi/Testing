package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Tesing extends DriverInitializer  {
 	
@Test
  public void f() {
		
    	getDriver().findElement(By.id("TxtEmail")).sendKeys("admin2@gmail.com");
		getDriver().findElement(By.id("TxtPassword")).sendKeys("xeno@123");
		getDriver().findElement(By.id("BtnLogin")).click();
		getDriver().findElement(By.id("cpBody_gvParentGrid_lnk_0")).click();
		System.out.println("github");
		System.out.println("github1");
		System.out.println("github2");
  }
	
	@AfterClass
	public void close(){
		getDriver().quit();
		dr.set(null);
	}
	
}
