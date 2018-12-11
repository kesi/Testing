package common;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class DriverInitializer  {

	public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
	@Parameters({"browser","appUrl"})
	@BeforeTest
	public void  openBrowser(String browser, String appUrl) throws Exception {

		//  launch the specified browser 
		RemoteWebDriver driver = null;
		try{
			if(browser.equalsIgnoreCase("firefox")){
				System.out.println("Firefox"+browser+" "+appUrl);
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				driver = new RemoteWebDriver(new URL("http://192.168.1.184:4444/wd/hub"), capabilities);      

			}else if(browser.equalsIgnoreCase("chrome")){
				System.out.println("chrome method"+browser+" "+appUrl);
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();				
				driver = new RemoteWebDriver(new URL("http://192.168.1.184:4444/wd/hub"), capabilities);

			}else if(browser.equalsIgnoreCase("IE")){

				System.out.println("IE method"+browser+" "+appUrl);
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				driver = new RemoteWebDriver(new URL("http://192.168.1.184:4444/wd/hub"), capabilities);
			}
			setDriver(driver);
			getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			getDriver().manage().window().maximize();
			getDriver().get(appUrl);
		} 
		catch(Exception e){
			throw new Exception(e);
		}

	}


	public static WebDriver getDriver(){
		return dr.get();
	}

	public void setDriver(RemoteWebDriver driver){
		dr.set(driver);
	}









}