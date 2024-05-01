package Selenium;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MouseActions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\saisn\\eclipse-workspace\\Hello-Selenium\\src\\test\\resources\\drivers\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		chromeOptions.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/");
		Actions a = new Actions(driver);
		// Drop down mouse action
		/*
		 * WebElement dd = driver.findElement(By.xpath("//a[text()='Dropdown']"));
		 * dd.click();
		 * 
		 * WebElement dpdwn = driver.findElement(By.xpath("//select[@id='dropdown']"));
		 * dpdwn.click(); Select s = new Select(dpdwn); s.selectByIndex(2);
		 * a.moveToElement(dpdwn).click().build().perform();// mouse action
		 * //driver.navigate().back();
		 * 
		 * WebElement dpdn = driver.findElement(By.id("dropdown")); dpdn.click();
		 * List<WebElement> drpdown = driver.findElements(By.tagName("option"));
		 * for(WebElement e:drpdown) {
		 * //if(e.getAttribute("value").equalsIgnoreCase("Option 1"))
		 * if(e.getText().equalsIgnoreCase("Option 1")) {
		 * a.moveToElement(e).click().build().perform(); // e.click(); } }
		 * 
		 * 
		 * //frame
		 * 
		 * 
		 * driver.findElement(By.linkText("Frames")).click(); WebElement frame =
		 * driver.findElement(By.linkText("iFrame")); frame.click();
		 * driver.switchTo().frame("mce_0_ifr"); WebElement text =
		 * driver.findElement(By.id("tinymce")); //text.clear();
		 * a.keyDown(Keys.SHIFT).sendKeys(text, "hi" +
		 * Keys.ENTER).keyUp(Keys.SHIFT).perform();
		 * a.sendKeys(text,Keys.SPACE).perform(); a.sendKeys(text, "all" +
		 * Keys.ENTER).perform(); a.keyDown(Keys.CONTROL).sendKeys(text, "a").perform();
		 * 
		 * //Nested frames // driver.navigate().back(); Thread.sleep(2000);
		 * driver.findElement(By.linkText("Frames")).click(); WebElement nframe =
		 * driver.findElement(By.partialLinkText("Nested")); nframe.click(); WebElement
		 * nFrameL = driver.findElement(By.name("frame-top")); nFrameL.click();
		 * driver.switchTo().frame("frameset-middle");
		 * driver.switchTo().frame("frame-left");
		 * driver.switchTo().frame("frame-middle");
		 * 
		 * Thread.sleep(2000); //driver.close();
		 */
        //context alert box
		driver.findElement(By.linkText("Context Menu")).click();
		WebElement cntxtbx= driver.findElement(By.id("hot-spot"));
		a.contextClick(cntxtbx).perform();
		driver.switchTo().alert().accept();
		
		
		
		driver.findElements(By.linkText("File Upload"));
		
		
		
		
	}

}


