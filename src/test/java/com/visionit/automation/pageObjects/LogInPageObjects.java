package com.visionit.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class LogInPageObjects {
	private static final Logger logger = LogManager.getLogger(LogInPageObjects.class);
	
	private WebDriver driver;
	
	private By signUp = By.id("h_sin_up");
	private By nameBox = By.id("lgn_name");
	private By mobileNoBox = By.id("lgn_mob");
	private By sendOTPButton = By.id("lgn_smtn");
	private By OtpSentMsg = By.xpath("//div[@class='otp-text wrapper pb-10']");
	private By Error_msg = By.xpath("//div[@class='error dn wrapper']");
	
	private By login = By.id("h_login");
	
	public LogInPageObjects(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void clickOnSignUp() {
		driver.findElement(signUp).click();
		logger.info("clicked on sign up button");
	}
	
	public void setSignUpNameAndNumber(String name,String mob) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(nameBox));
		driver.findElement(nameBox).sendKeys(name);
		driver.findElement(mobileNoBox).sendKeys(mob);
	}
	
	
	public void clickOnOtpButton() {
		driver.findElement(sendOTPButton).click();
	}
	
	public void messageDisplayed(String msg) {
		String b = driver.findElement(OtpSentMsg).getText();
		String expected ="OTP is sent on number";
		Assert.assertEquals("message", expected, b);
		
	}
	
	public void clickOnLoginButton() {
		driver.findElement(login).click();
	}
	
	public void setLOgin(String userName,String UserMob) {
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		wait1.until(ExpectedConditions.elementToBeClickable(nameBox));
		driver.findElement(nameBox).sendKeys(userName);
		driver.findElement(mobileNoBox).sendKeys(UserMob);
	}
		
	
	public void errormsgdisplayed(String msg) {
		String b =  driver.findElement(Error_msg).getText();
		String expected ="Please Enter valid Mobile number!";
		Assert.assertEquals("popup", expected, b);
	}
	
	
public void checkMobilelength(String num) {
	String attribute = driver.findElement(mobileNoBox).getAttribute("maxlength");
	if(attribute.equals(num)) {
		Assert.assertTrue(true);
		logger.info("Maximum lenght of mobile number is 10");
	}
	else {
		Assert.fail("not match max digit");
		logger.fatal("Maximum lenght of mobile number is not set to 10");
	}
	
}
}
