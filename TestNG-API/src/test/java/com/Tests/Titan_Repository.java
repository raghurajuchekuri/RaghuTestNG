package com.Tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.Locators_Testdata.Testdata;
import com.Tests.*;
import com.Locators.LocatorsLogin;

public class Titan_Repository {
	
	public  WebDriver driver;
	
	public void browserlaunch() {
		
		//System.setProperty("webdriver.chrome.driver", "\\src\\main\\java\\drivers\\chromedriver.exe"); 
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
	  } 
	  
	public void navigatetoSite() throws InterruptedException {
					
		driver.get("http://ec2-3-83-172-70.compute-1.amazonaws.com/login");
				
	}	
	
	public void validateTitle() throws InterruptedException {				
		
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Titan Lien Services – Lien Processing");
						
	}	
	
	public void loginpage() throws InterruptedException {	
		
		driver.findElement(LocatorsLogin.userid).sendKeys(Testdata.userid);
		driver.findElement(LocatorsLogin.password).sendKeys(Testdata.pasword);
		driver.findElement(LocatorsLogin.btn_login).click();
		driver.findElement(LocatorsLogin.dashboard_link).isDisplayed();	
		System.out.println(driver.findElement(LocatorsLogin.dashboard_link).isDisplayed());
		Assert.assertEquals(driver.findElement(LocatorsLogin.dashboard_link).isDisplayed(),true);
						
	}	
	
	
		   
     public void browserclose() {
    	 driver.close();
    	 driver.quit();
     }
}
