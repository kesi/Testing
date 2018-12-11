package test;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestParallel extends BaseClass {
 
    @Test
    public void test_01() throws InterruptedException, MalformedURLException{
        try{
        	System.out.println("Test Method");
            getDriver().get("http://qa.xtbills.com/");
            
 
            //getDriver().findElement(By.xpath("html/body/div[2]/div/a[4]")).click();
            String Username="payerk@gmail.com";
            getDriver().findElement(By.id("TxtEmail")).sendKeys(Username);
        	System.out.println("User name enterd");
        	String Password="xeno@123";
        	getDriver().findElement(By.id("TxtPassword")).sendKeys(Password);
        	System.out.println(Password);
        	System.out.println("Password enterd");
        	getDriver().findElement(By.id("BtnLogin")).click();
            //Wait intentially added to show parallelism execution
           
            //getDriver().findElement(By.xpath("//*[@id='gsc-i-id1']")).sendKeys("test");
        	System.out.println("Test Method completed");
 
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}