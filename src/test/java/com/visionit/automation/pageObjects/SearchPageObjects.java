package com.visionit.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class SearchPageObjects {
	private static final Logger logger = LogManager.getLogger(SearchPageObjects.class);

	private WebDriver driver;
	
	private By searchBox = By.id("srchbx");
	private By searchButton = By.id("srIconwpr");
	private By restasearch = By.xpath("//a[contains(@id,'-')]");
	private By loginForValidation = By.id("h_flist");
	
	public SearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void SetSearchBox(String text) {
		WebDriverWait webdriverWait = new WebDriverWait(driver,20);
		webdriverWait.until(ExpectedConditions.elementToBeClickable(searchBox));
		driver.findElement(searchBox).sendKeys(text);
	}
	
	public void ClickOnSearchButton() {
		driver.findElement(searchButton).click();
	}
	
	public void validatePageTitle(String ExpectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		boolean b = wait.until(ExpectedConditions.titleContains(ExpectedTitle));
		Assert.assertEquals("title validation", true, b);
	}
	
	public void validateSearhResult() {
		if(driver.findElement(loginForValidation).isDisplayed()) {
			Assert.assertTrue(true);
			logger.info("menu search result displayed");
		}
		else {
			Assert.assertFalse(false);
			logger.info("menu search result not displayed");
		}
	}
	
	public void EnterFewChar(String text) {
		driver.findElement(searchBox).sendKeys(text);
	}
	
	public void SearchDropDown() {
		List<WebElement> list = driver.findElements(restasearch);
		boolean b = driver.findElement(restasearch).isDisplayed();
		Assert.assertEquals("validate", true, b);
	}
}
