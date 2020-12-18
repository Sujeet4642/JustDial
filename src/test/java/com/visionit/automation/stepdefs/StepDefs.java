package com.visionit.automation.stepdefs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.visionit.automation.core.WebDriverFactory;
import com.visionit.automation.pageObjects.CustomerCarePageObjects;
import com.visionit.automation.pageObjects.LogInPageObjects;
import com.visionit.automation.pageObjects.MenuPageObjects;
import com.visionit.automation.pageObjects.SearchPageObjects;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {
	public static final Logger logger = LogManager.getLogger(StepDefs.class);
	
	WebDriver driver;
	String baseUrl =  "http://justdial.com";
	int implict_wait_timeout_in_sec = 20;
	Scenario scn;
	
	SearchPageObjects searchPageObjects;
	LogInPageObjects loginPageObjects;
	MenuPageObjects menuPageObjects;
	CustomerCarePageObjects customerPageObjects;
	
	
	@Before
	public void setUp(Scenario scn) throws Exception{
		this.scn = scn;
		String browserName = WebDriverFactory.getBrowserName();
		driver = WebDriverFactory.getWebDriverForBrowser(browserName);
		logger.info("Browser invoked.");
		
		searchPageObjects = new SearchPageObjects(driver);
		loginPageObjects = new LogInPageObjects(driver);
		menuPageObjects = new MenuPageObjects(driver);
		customerPageObjects = new CustomerCarePageObjects(driver);
	}
	
	@After(order=1)
	public void cleanUp() {
		WebDriverFactory.quitDriver();
		 scn.log("Browser Closed");
	}
	@After(order=2)
	public void takeScreenShot(Scenario s) {
		if (s.isFailed()) {
			TakesScreenshot srnsht = (TakesScreenshot)driver;
			byte[] data = srnsht.getScreenshotAs(OutputType.BYTES);
			 scn.attach(data, "image/png","Failed Step Name: " + s.getName());
        }else{
            scn.log("Test case is passed, no screen shot captured");
        }
		}
	
	
//search page steps
	
	@Given("User navigated to the home application url")
	public void user_navigated_to_the_home_application_url() {
	    WebDriverFactory.navigateToUrl(baseUrl);
	    scn.log("Browser navigated to URL: " + baseUrl);
	    
	    String expected = "Justdial - Local Search, Social, News, Videos, Shopping";
	    searchPageObjects.validatePageTitle(expected);
	}
	
	
	@When("User enters {string} in search textbox")
	public void user_enters_in_search_textbox(String text) {
	   searchPageObjects.SetSearchBox(text);
	  
	}

	@When("User clicks search button")
	public void user_clicks_search_button() {
		 searchPageObjects.ClickOnSearchButton();
	   	}

	@Then("User is able to see result realated to {string}")
	public void user_is_able_to_see_result_realated_to(String string) {
		//String ExpectedTitlesearch = "Best Restaurants in Mumbai - Top Veg & Non Veg Restaurants - Order Food Online - Justdial";
	    searchPageObjects.validateSearhResult();
	}

	@When("User enters {string} in search text box")
	public void user_enters_in_search_text_box(String txt) {
	   searchPageObjects.EnterFewChar(txt);
	}

	@Then("User is able to see the drop down under search text box with all the items with text {string}")
	public void user_is_able_to_see_the_drop_down_under_search_text_box_with_all_the_items_with_text(String string) {
	   searchPageObjects.SearchDropDown();
	}
	
	//Login page steps
	
	@When("User clicks on Sign up link of the application")
	public void user_clicks_on_sign_up_link_of_the_application() {
	   loginPageObjects.clickOnSignUp();
	}

	@When("User enters name as {string} and Phone number as {string} and clicks on Submit Button")
	public void user_enters_name_as_and_phone_number_as_and_clicks_on_submit_button(String name, String mob) {
	   loginPageObjects.setSignUpNameAndNumber(name, mob);
	   loginPageObjects.clickOnOtpButton();
	}

	@Then("User is displayed with the message as {string}")
	public void user_is_displayed_with_the_message_as(String msg) {
	  
	   loginPageObjects.messageDisplayed(msg);
	}

	@When("User clicks on Login-in link of the application")
	public void user_clicks_on_login_in_link_of_the_application() {
	    loginPageObjects.clickOnLoginButton();
	}
	
	 @When("User enters name as {string} and Phone number {string} and clicks on Submit Button")
	 public void user_enters_name_as_and_phone_number_and_clicks_on_submit_button(String userName, String userMob) {
		loginPageObjects.setLOgin(userName, userMob);
		loginPageObjects.clickOnLoginButton();
	 }
	@Then("User gets error message as {string}")
	public void user_gets_error_message_as(String msg) {
		loginPageObjects.clickOnOtpButton();
	   loginPageObjects.errormsgdisplayed(msg);
	}


	@Then("User is able to enter only {string} digits in the Mobile text field")
	public void user_is_able_to_enter_only_digits_in_the_mobile_text_field(String num) {
	   loginPageObjects.checkMobilelength(num);
	}

	//menu page steps
	

	@When("User clicks on {string}")
	
	public void user_clicks_on(String productname) throws Exception {
		menuPageObjects.selectionMenu(productname);
		
	    	}

	@Then("User is navigates to the corresponding link realted to {string}")
	public void user_is_navigates_to_the_corresponding_link_realted_to(String searchResult) {
	    menuPageObjects.validateMenuSearchPage();
	}

	//customer care page steps
	@Given("User navigates to Customer care page by clicking on Customer Care tab at the right-mid of the page")
	public void user_navigates_to_customer_care_page_by_clicking_on_customer_care_tab_at_the_right_mid_of_the_page() {
	   customerPageObjects.clickOnCustomerCareLink();
	}

	@When("User enter {string} in the Text box")
	public void user_enter_in_the_text_box(String text) {
	    customerPageObjects.setBusinessTypeBox(text);
	}

	@Then("User is able to see the drop down and all the items in the list must have text as {string}")
	public void user_is_able_to_see_the_drop_down_and_all_the_items_in_the_list_must_have_text_as(String string) {
	   customerPageObjects.fetchOnlineRelatedList();
	}
}
