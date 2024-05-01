/*package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {
		//Drop downs
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\saisn\\webDrivers\\chromedriver-win64.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com");//in built synchronization wait mechanism, will help to wait the page until its fully loaded
		driver.navigate().to("https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/");//once page it loaded it will continue like basic image is loaded
		WebElement usr = driver.findElement(By.id("username"));
        usr.sendKeys("sdetorganizers@gmail.com");
        WebElement pswd= driver.findElement(By.id("password"));
        pswd.sendKeys("UIHackathon@02");
        WebElement logn = driver.findElement(By.id("login"));
        logn.click();
       
         
	}

}*/
