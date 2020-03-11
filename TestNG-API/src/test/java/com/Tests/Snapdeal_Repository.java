package com.Tests;

import java.util.ArrayList;
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

public class Snapdeal_Repository {
	
	public  WebDriver driver;
	
	public void browserlaunch() {		
		 
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
	  } 
	  
	public void navigatetoSiteSnapdeal() throws InterruptedException {
					
		driver.get("http://snapdeal.com");
		driver.findElement(By.xpath("//*[contains(text(),'Mobile & Tablets')]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Smartphones')]")).click();
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys("10000");
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("20000");
		driver.findElement(By.xpath("(//*[contains(text(),'GO')])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[contains(@title,'Oppo')])[3]")).click();
		Thread.sleep(5000);
		
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());	    
	    driver.switchTo().window(newTab.get(1));
		driver.findElement(By.xpath("//*[contains(text(),'add to cart')]")).click();		
		driver.close();
		driver.switchTo().window(newTab.get(0));
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//*[contains(@title,'Redmi')])[3]")).click();		
		ArrayList<String> newTab1 = new ArrayList<String>(driver.getWindowHandles());	    
	    driver.switchTo().window(newTab1.get(1));		
	    driver.findElement(By.xpath("//*[contains(text(),'add to cart')]")).click();	
	    driver.close();
		driver.switchTo().window(newTab.get(0));
		Thread.sleep(5000);	
		
		driver.findElement(By.xpath("(//*[contains(@title,'Vivo')])[3]")).click();
				
		ArrayList<String> newTab2 = new ArrayList<String>(driver.getWindowHandles());	    
	    driver.switchTo().window(newTab2.get(1));		
	    driver.findElement(By.xpath("//*[contains(text(),'add to cart')]")).click();	
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("(//*[contains(text(),'View Cart')])[2]")).click();	
	    
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[@class='remove-item-shortlist'])[1]")).click();	
					
				
	}	
	
	
		
		   
     public void browserclose() {
    	 driver.close();
    	 driver.quit();
     }
}
