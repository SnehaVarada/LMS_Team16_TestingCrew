 package com.Base;
  

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass{
    public static WebDriver driver;

    public static FileInputStream  fr ;
	public static Properties prop = new Properties();
	public static String key;
 
    public static WebDriver launchApp() throws IOException {
    	
    	if (driver ==null)
    	{
    	fr = new FileInputStream("src/test/resources/DataFiles/Config.properties");
    	prop.load(fr);
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
       driver.get(prop.getProperty("url"));
      // System.out.println(Config.key);
       // driver.get("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
      //  driver.get(prop.getProperty("URL"));
        System.out.println(driver);
        return driver;
    	}
		return driver;
    	
    }
    
    public static WebDriver InvalidUrl() throws IOException {
    	
    	if (driver ==null)
    	{
    	fr = new FileInputStream("src/test/resources/DataFiles/Config.properties");
    	prop.load(fr);
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
       driver.get(prop.getProperty("invalidurl"));
      // System.out.println(Config.key);
       // driver.get("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
      //  driver.get(prop.getProperty("URL"));
        System.out.println(driver);
        return driver;
    	}
		return driver;
    	
    }
    
    public static String getwrongUrl() {
		// TODO Auto-generated method stub
		return null;
	}

    
    
}
 