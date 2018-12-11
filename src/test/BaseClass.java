package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClass {
 
    //ThreadLocal will keep local copy of driver
    public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
 
    @BeforeClass
    //Parameter will get browser from testng.xml on which browser test to run
    @Parameters("myBrowser")
    public void beforeClass(String myBrowser) throws MalformedURLException{
 
        RemoteWebDriver driver = null;
 
        if(myBrowser.equals("chrome")){
            DesiredCapabilities capability =  DesiredCapabilities.chrome();
           // capability.setBrowserName("chrome");
           // capability.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(new URL("http://192.168.1.184:4444/wd/hub"), capability);
        }
        else if(myBrowser.equals("firefox")){
            DesiredCapabilities capability =  DesiredCapabilities.firefox();
            //capability.setBrowserName("firefox");
            //capability.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(new URL("http://192.168.1.184:4444/wd/hub"), capability);
        }
 
        //setting webdriver
        setWebDriver(driver);
 
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
    }
 
    public WebDriver getDriver() {
        return dr.get();
    }
 
    public void setWebDriver(RemoteWebDriver driver) {
        dr.set(driver);
    }
 
    @AfterClass
    public void afterClass(){
        getDriver().quit();
        dr.set(null);
 
    }
 
}