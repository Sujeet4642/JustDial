package com.visionit.automation.pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.junit.Assert;



public class MenuPageObjects {
	private static final Logger logger = LogManager.getLogger(MenuPageObjects.class); 
	
	private WebDriver driver;
	
	private By menuList = By.xpath("//a[contains(@id,'ContextualHotkey')]");
	private By loginForValidation = By.id("h_login");
	
	public MenuPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectionMenu(String product) throws Exception {
		List<WebElement> listOfProducts = driver.findElements(menuList);
		logger.info("Number of product searhed: " + listOfProducts.size());
		
		for(int i=0;i<listOfProducts.size();i++) {
			try {
				if(listOfProducts.get(i).getText().contains(product)) {
					listOfProducts.get(i).click();
					logger.info("product is : " + listOfProducts.get(i).getText());
					
				}
			} catch (StaleElementReferenceException e) {
				listOfProducts = driver.findElements(menuList);
				if(listOfProducts.get(i).getText().contains(product)) {
					listOfProducts.get(i).click();
					logger.info("product is : " + listOfProducts.get(i).getText());
				}
			}
				
			
		}																								
		
	}
	
	public void validateMenuSearchPage() {
		if(driver.findElement(loginForValidation).isDisplayed()) {
			Assert.assertTrue(true);
			logger.info("menu search result displayed");
		}
		else {
			Assert.assertFalse(false);
			logger.info("menu search result not displayed");
		}
	}

}
