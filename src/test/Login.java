package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class Login {
	WebDriver d;
	@BeforeClass
	public void beforeClass() {
		d= new FirefoxDriver();
		d.get("https://www.google.com/");

	}

	@Test
	public void pageTitle() {
		String title=d.getTitle();
		System.out.println("Page title is: "+title);
	}
	@AfterClass
	public void close() {
		d.close();
		System.out.println("Frie fox closed");
	}

}
