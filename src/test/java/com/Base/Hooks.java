package com.Base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {

	public static WebDriver driver;
	
	 @AfterStep
	    public void addScreenShot(Scenario scenario)
	    {
	    	
	    	if(scenario.isFailed())
	    	{
	    		//LOG.error("Scenario failed");
	    		String ScreenShotName = scenario.getName().replaceAll(" ", "_");
	    		byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    		scenario.attach(sourcePath, "image/png", ScreenShotName);
	    		
	    	}
	    }
	    
	 
	 public static WebDriver getDriver() {
	        return driver;
	    }

//	    @AfterAll
//	    public static void closeBrowser() {
//	        if (driver != null) {
//	            driver.quit();
//	            LOG.info("Browser session closed.");
//	        }
//	    }

}
