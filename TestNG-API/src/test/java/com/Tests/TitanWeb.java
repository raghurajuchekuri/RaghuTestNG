package com.Tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TitanWeb extends Titan_Repository{
	
	//@Parameters("browser")	
	@BeforeClass	
	public void launchbrowser(){
		
		browserlaunch();
		System.out.println("Browser has launched succesfully before Test");
	}
	
	public void screenCapture() throws IOException{
		  
		  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  File screenshotName = new File ("\\test-output\\Screenshots\\"+System.currentTimeMillis()+"_"+".png");
		  FileUtils.copyFile(scrFile, screenshotName);
		  Reporter.log("<br><img src='"+screenshotName+"' height='400' width='700'/><br>");  
		  
		 } 
	
	@Test(priority=1, description = "Title Validation",enabled=true)
	public void navigatetoWebandvalidateTitle() throws InterruptedException, IOException{
		navigatetoSite();
		validateTitle();
		screenCapture();//Calling same method created in first class
		 Reporter.log("Screenshot Capture is done");
		 
		
	}
	
	
	@Test (priority = 2, description = "Login Sucessful",enabled=true)
	public void login() throws InterruptedException {			
		loginpage();
		
	
	}
		
	
	@AfterClass
	public void closebrowser() throws InterruptedException {
		browserclose();
		System.out.println("Browser Closed succesfully after Test");
	}
	
	
}
