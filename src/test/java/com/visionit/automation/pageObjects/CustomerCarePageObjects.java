package com.visionit.automation.pageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;

public class CustomerCarePageObjects {
	
	private WebDriver driver;
	
	private By customerCareLink = By.xpath("//a[@class='cscare ']");
	private By businessType = By.id("what");
	private By onlineRelatedSearch = By.xpath("//a[@class='tcon']");
	
	public CustomerCarePageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnCustomerCareLink() {
		driver.findElement(customerCareLink).click();
	}
	
	public void setBusinessTypeBox(String text) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(businessType));
		driver.findElement(businessType).sendKeys(text);
	}
	
	public void fetchOnlineRelatedList() {
		List<WebElement> onlineList = driver.findElements(onlineRelatedSearch);
		boolean b = driver.findElement(onlineRelatedSearch).isDisplayed();
		Assert.assertEquals("validation", true, b);
	}

}
