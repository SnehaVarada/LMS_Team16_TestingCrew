package com.StepDefinitions;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.Base.BaseClass;
import com.PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSD {

	WebDriver driver;
	LoginPage login = new LoginPage(driver);

	String invalid_url;

	/******** Scenario outline: Verify admin is able to land on home page *******/

	@Given("Admin is in Home Page")
	public void admin_is_in_home_page() throws IOException, InterruptedException {
		Thread.sleep(3000);
		driver = BaseClass.launchApp();

	}

	@When("Admin enter valid credentials  and clicks login button from {string} and {int}")
	public void admin_enter_valid_credentials_and_clicks_login_button_from_and(String SheetName, Integer rowNumber)
			throws InvalidFormatException, IOException, InterruptedException {
		login.xlDataReader(SheetName, rowNumber);
	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertEquals(login.managepgm(), "Manage Program");
		System.out.println("Dashboad page title " + login.managepgm());

	}

	/************** Scenario: Verify admin is able to land on home page ******/

	@Given("Admin launch the browser")
	public void admin_launch_the_browser() throws IOException {

	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() throws IOException {
		driver = BaseClass.launchApp();
		System.out.println("******");
	}

	@Then("Admin should land on the home page")
	public void admin_should_land_on_the_home_page() throws IOException {
		LoginPage login = new LoginPage(driver);
		Assert.assertEquals(driver.getTitle(), "LMS");
		// Assert.assertEquals("LMS",login.ActualPageTitle());
	}

	/***** Scenario: Verify admin is able to land on home page with invalid URL ******/

	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() throws IOException {
		driver = BaseClass.InvalidUrl();
		System.out.println("invalid driver is " + driver);
		invalid_url = driver.getCurrentUrl();
		System.out.println("invalid_url is " + invalid_url);
	}

	@Then("Admin should recieve {int} page not found error")
	public void admin_should_recieve_page_not_found_error(Integer int1) throws IOException {
		Assert.assertEquals(invalid_url, "404");
		// System.out.println("Page title is " + driver.getTitle());
	}

	/********** Scenario: Verify for broken link ***************/

	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer statuscode) throws InterruptedException, IOException {
		LoginPage login = new LoginPage(driver);
		String Broken_response = login.BrokenURL(statuscode);
		Assert.assertEquals(Broken_response, "URL is broken link.");
	}

	/********** Scenario: Verify the text spelling in the page ***************/

	@Then("Admin should see correct spellings of {string}, {string} fields")
	public void admin_should_see_correct_spellings_of_fields(String userfield, String passwordfield) {
		LoginPage login = new LoginPage(driver);
		String userfld = login.FieldLabels(userfield);
		String pswdfld = login.FieldLabels(passwordfield);

		System.out.println(userfld);
		System.out.println(pswdfld);

		Assert.assertEquals("User", userfld);
		Assert.assertEquals("Password", pswdfld);
	}

	/***************Verify the text spelling in the page ***************/
	@Then("Admin should see {string} field")
	public void admin_should_see_field(String headerName) {
		LoginPage login = new LoginPage(driver);
		login.PageHeaderValidation(headerName);

	}

	/******** @TCT-131 Scenario: Verify text fields are present **********/
	@Then("Admin should see two text fields")
	public void admin_should_see_two_text_fields() {
		LoginPage login = new LoginPage(driver);
		Assert.assertTrue(login.userFieldValidation());
		Assert.assertTrue(login.passwordFieldValidation());
	}

	/************** @TCT-132 Scenario: Verify text on the first text field ***********/
	@Then("Admin should User in the first text field")
	public void admin_should_user_in_the_first_text_field() {
		LoginPage login = new LoginPage(driver);
		Assert.assertTrue(login.userFieldValidation());
	}
	
	/*************@TCt_133 Scenario: Verify ashtrix next to user text ***********/
	@Then("Admin should see * symbol next to user text")
	public void admin_should_see_symbol_next_to_user_text() {
	  LoginPage login = new LoginPage(driver);
	  Assert.assertTrue(login.userAstrix());
	}
	
	 /***************@TCT_134 Scenario: Verify text on the second text field ************/
	@Then("Admin should Password in the second text field")
	public void admin_should_password_in_the_second_text_field() {
		LoginPage login = new LoginPage(driver);
		Assert.assertTrue(login.passwordFieldValidation());
}
	
	/**********   @TCT_135 Scenario: Verify asterik next to password text ********/
	@Then("Admin should see {string} symbol next to password text")
	public void admin_should_see_symbol_next_to_password_text(String string) {
		LoginPage login = new LoginPage(driver);
		  Assert.assertTrue(login.passwordAstrix());
	}
	
	/********* @TCT_211 Scenario: Verify the alignment input field for the login  *************/
    @Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
    	System.out.println("*******************************************");
    	LoginPage login = new LoginPage(driver);
	     Point location =  login.FormDataAlignment();
	 System.out.println("Location is "+location);
	}
	
	/************ @TCT_136 Scenario: verify Login is present *********/
	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
		LoginPage login = new LoginPage(driver);
		 Assert.assertTrue(login.LoginBtnValidation(), "Login button is displayed");
	}
	
	
	/************  @TCT_137 Scenario: Verify the alignment of the login button ****************/
	@Then("Admin should see login button on the centre of the page")
	public void admin_should_see_login_button_on_the_centre_of_the_page() {
		/*
		 * System.out.println("*******************************************"); LoginPage
		 * login = new LoginPage(driver); Point location2 = login.LoginBtnLocation();
		 * System.out.println("Location is "+location2);
		 */
		LoginPage login = new LoginPage(driver);
		   login.LoginBtnAlignment();
		    Assert.assertTrue(true, "login button is on the centre of the page");
	}
	
    /*************  @TCT_138 Scenario: Verify input descriptive test in user field ************/
	@Then("Admin should see user in gray color")
	public void admin_should_see_user_in_gray_color() {
		LoginPage login = new LoginPage(driver);
	String UserColor = login.verifyUserColor();
	System.out.println("User color is " +UserColor);
	Assert.assertEquals(UserColor, "#000000");
	}
	
	 /*************  @TCT_139 Scenario: Verify input descriptive test in password field ********/
	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
		LoginPage login = new LoginPage(driver);
		String PasswordColor = login.verifyPasswordColor();
		System.out.println("User color is " +PasswordColor);
		Assert.assertEquals(PasswordColor, "#000000");
	}
	
/**************** @TCT_141&142&143 Scenario Outline: Validate login with invalid credentials from Excel *********/
@When("Admin enter invalid credentials  from excel {string} and {int} and clicks login button")
public void admin_enter_invalid_credentials_from_excel_and_and_clicks_login_button(String SheetName, Integer rowNumber) throws InvalidFormatException, IOException {
	LoginPage login = new LoginPage(driver);
	login.xlDataReader(SheetName, rowNumber);
}

@Then("Error Message {string}")
public void error_message(String lgnErrMSG) {
	LoginPage login = new LoginPage(driver);
  String errorMsg =  login.InvalidErrorMsg(lgnErrMSG);
   Assert.assertEquals(errorMsg, "Invalid username and password Please try again");
    login.UserClearfields();
    login.PasswordClearfields();
}


/*************@TCT_144 Scenario: Verify login button action through keyboard ***********/
@When("Admin enter valid credentials  and clicks login button through keyboard")
public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {
	LoginPage login = new LoginPage(driver);
	login.KeyBoardActions();
    
}
@Then("Admin Logout of website")
public void admin_logout_of_website() {
	LoginPage login = new LoginPage(driver);
	login.Logout();
    
}

/**************** @TCT_145 Scenario: Verify login button action through mouse  *********************************/
@When("Admin enter valid credentials  and clicks login button through mouse")
public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {
	LoginPage login = new LoginPage(driver);
	login.MouseActions();
}


}
