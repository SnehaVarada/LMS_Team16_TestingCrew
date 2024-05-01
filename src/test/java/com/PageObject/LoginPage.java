package com.PageObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Base.BaseClass;
import com.Utils.Excel;


public class LoginPage {
WebDriver driver ;

	Excel xl = new Excel();
	
	String xlpath = "C:\\Users\\saisn\\MyNewWorkSpace\\Team16_TesingCru\\src\\test\\resources\\DataFiles\\Team16_TesingCru.xlsx";
	
	String errorMsg;
	
	
	 public LoginPage(WebDriver driver) { 
		 this.driver = driver;
			 PageFactory.initElements(driver,this);
		  }
	 
		@FindBy(xpath="//input[@id='username']")
		WebElement username;
			@FindBy(xpath="//input[@id='password']")
			WebElement password;
			@FindBy(xpath="//button[@id='login']")
			WebElement LoginBtn;
			@FindBy(xpath="(//div[@class=\"box\"])[1]")
			WebElement dashboardtext;
			@FindBy(css="//div[@class='img']")
			WebElement logo;
		    @FindBy(xpath="//span[text()='User']")
			WebElement userLabel;
			@FindBy(xpath="//span[text()='Password']")
			WebElement passwordLabel;    
			@FindBy(xpath="//p[text()='Please login to LMS application']")
			WebElement CredHeader;
			@FindBy(xpath = "//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-0 ng-star-inserted']")
			WebElement UserAstrix;
			@FindBy(xpath = "//span[@class=\"mat-placeholder-required mat-form-field-required-marker ng-tns-c78-1 ng-star-inserted\"]")
			WebElement PasswordAstrix;
			@FindBy(css = "form[class = 'ng-dirty ng-touched ng-invalid']")
			WebElement InputFormData;
			@FindBy(xpath="//*[@id='errormessage']")
			WebElement invalidLoginError;
			@FindBy(xpath = "//span[text()=\"Logout\"]")
			WebElement logout;

			public void loginValidCredential(String usrnme,String pswd) 
			{
				username.sendKeys(usrnme);
				password.sendKeys(pswd);
				LoginBtn.click();
				} 
			
			public String managepgm() {
				String headtext = dashboardtext.getText();
				return headtext;
			}
			
			public void xlDataReader(String SheetName, Integer rowNumber) throws InvalidFormatException, IOException {
				
				List<Map<String,String>> testData= xl.getData(xlpath, SheetName);
				System.out.println("Value in testData" +testData);
				String user_name=testData.get(rowNumber).get("User");
				String password = testData.get(rowNumber).get("Password");

				loginValidCredential(user_name,password);
			}
			
			public String ActualPageTitle() throws IOException {
				driver = BaseClass.launchApp();
				return driver.getTitle();
			}
				
             public boolean Logo() {
					return logo.isDisplayed();
				}
         	public String BrokenURL(Integer statusCode) throws InterruptedException, IOException 
    		{
    			List <WebElement> links = driver.findElements(By.tagName("a"));
    			System.out.println(links.size());
    			
    			for(int i=1;i<links.size();i++)
    			{
    			WebElement element = links.get(i);
    			String Url = element.getAttribute("href");
    			URL urlLink = new URL(Url);
    			
    			HttpURLConnection httpConn =  (HttpURLConnection) urlLink.openConnection();
    			
    			Thread.sleep(3000);
    			httpConn.connect();
    			int rspnsecode = httpConn.getResponseCode();
    			if (rspnsecode >=400)
    			{
    			System.out.println(Url+ " is broken link");	
    			errorMsg="URL is broken link.";
    			}
    			else {
    				System.out.println(Url+ " is valid link");
    				errorMsg="URL is valid link.";
    			}
    			}			
    			
    			return errorMsg ;
    		}
         	
         	public String FieldLabels(String fieldName)
         	{
         		WebElement popup_labels=driver.findElement(By.xpath("//span[text()='"+fieldName+"']"));
         		return popup_labels.getText();
         	} 
         	
         	public void PageHeaderValidation(String headerName)
         	{
         		CredHeader.isDisplayed();
         	}
         	
         	public boolean userFieldValidation() 
         	{
         		return userLabel.isEnabled();
         	}
       
         	public boolean passwordFieldValidation() 
         	{
         		return passwordLabel.isEnabled();
         	}
         	
        	public boolean userAstrix() 
         	{
         		return UserAstrix.isDisplayed();
         	}
        	public boolean passwordAstrix()
        	{
        		return PasswordAstrix.isDisplayed();
        	}
        	public Point FormDataAlignment() {
        		Point formdata =  InputFormData.getLocation();
        		int formdataX =  formdata.getX();
				int formdataY = formdata.getY();
				return formdata; 
        	}
        	public boolean LoginBtnValidation() {
        		return LoginBtn.isDisplayed();
        	}
        	public boolean LoginBtnAlignment() {
        		/*Point Logindata =  LoginBtn.getLocation();
        		int LogindataX =  Logindata.getX();
				int LogindataY = Logindata.getY();
        		return null; */
        		
        		
        		String script = "arguments[0].style.textAlign='center';";
     	       boolean loginButtonAlignment = (boolean) ((JavascriptExecutor)driver).executeScript(script, LoginBtn);
     	       return loginButtonAlignment;
        		
        	}
        	
        	public String verifyUserColor()
        	{
        	      String userTextColor = username.getCssValue("color");
        	     String UserColor = Color.fromString(userTextColor).asHex();
        	     return UserColor;
        	}
        	
        	public String verifyPasswordColor()
        	{
        		//The color black with hexadecimal color code #000000 / #000 is a very dark shade of gray. 
        	      String passwordTextColor = password.getCssValue("color");
        	      String PasswordColor = Color.fromString(passwordTextColor).asHex();
        	      return PasswordColor;
        	}
        	
        	
			public String InvalidErrorMsg(String lgnErrMSG) {
				String Invalidmsg = invalidLoginError.getText();
				return Invalidmsg;
			}
			
			public void KeyBoardActions() {
				
				username.sendKeys("sdetorganizers@gmail.com"+ Keys.ENTER);
	            password.sendKeys("UIHackathon@02"+ Keys.ENTER);
	            LoginBtn.sendKeys( Keys.ENTER); // This simulates pressing the Enter key
			}
			
			public void Logout() {
				logout.click();
			}
		
               public void MouseActions() {
				
				username.sendKeys("sdetorganizers@gmail.com");
	            password.sendKeys("UIHackathon@02");
	            LoginBtn.click();; // This simulates pressing the Enter key
			}
               
               public void UserClearfields() {
            	   username.clear();
               }
               
               public void PasswordClearfields() {
            	   password.clear();
               }
}
