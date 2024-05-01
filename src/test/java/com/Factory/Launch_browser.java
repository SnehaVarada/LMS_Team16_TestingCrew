package com.Factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.Utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch_browser {
	
	public static WebDriver driver;
	public static ChromeOptions options;
	
	private Launch_browser()
	{
		}
	
	public static WebDriver launch_browser()
	{
		if(driver==null)
		{
		
			if(ConfigReader.init_Reader().equalsIgnoreCase(ConfigReader.browser_key))
		
			{
				
				
				WebDriverManager.chromedriver().setup();
				options = new ChromeOptions();
				options.addArguments("--start-maximized");
				driver=new ChromeDriver(options);
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
			}
	
		
			if(ConfigReader.init_Reader().equalsIgnoreCase("firefox")) 
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			
		
		return driver;
		
		}
		else
			return driver;
		}
	
}
