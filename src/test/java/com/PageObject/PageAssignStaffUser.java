package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.Excel;

public class PageAssignStaffUser {
	WebDriver driver ;

	Excel xl = new Excel();
	
	String xlpath = "C:\\Users\\saisn\\MyNewWorkSpace\\Team16_TesingCru\\src\\test\\resources\\DataFiles\\Team16_TesingCru.xlsx";


	 public PageAssignStaffUser(WebDriver driver) { 
		 this.driver = driver;
			 PageFactory.initElements(driver,this);
		  }
	 
	 @FindBy(xpath="(//button[@id='Assign'])[2]") WebElement assignStaffBtn;
	 @FindBy(xpath="//input[@id='roleId']") WebElement userRoleTxt;
	 @FindBy(xpath="//input[@id='skillName']") WebElement skillTxt ;
	 @FindBy(xpath="//span[text()='Select Email Id']") WebElement emailId ;
	 @FindBy(xpath="//span[text()='urmila.rao1625@gmail.com']") WebElement emailurmila ;
	 @FindBy(xpath="//span[text()='saranya@gmail.com']") WebElement emailsaranya ;
	 @FindBy(xpath="//span[text()='arunasel@gmail.com']") WebElement emailarunsel ;
	 @FindBy(xpath="//span[text()='DelWQa20240430162433073']") WebElement prgmDel ;
	 @FindBy(xpath="(//span[text()='Seleniumte95'])[2]") WebElement prgmSelenium ;
	 @FindBy(xpath="//span[text()=\"Select a Program name \"]") WebElement selectPgmName;
	 @FindBy(xpath="(//div[@class='p-radiobutton-box'])[1]") WebElement radioActive ;
	 @FindBy(xpath="(//div[@class='p-radiobutton-box'])[2]") WebElement radioInactive;
	 @FindBy(xpath="//div[text()= \"Select Batch Name\"]") WebElement batchName ;
	 @FindBy(xpath="") WebElement ;
	 
	 
}
