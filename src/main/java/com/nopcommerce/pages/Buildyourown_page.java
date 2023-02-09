package com.nopcommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.utility.ActionDriver;

public class Buildyourown_page {  //3rd
	
	
	WebDriver driver;

	public Buildyourown_page(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}


	@FindBy(id = "product_attribute_1")
	WebElement processor;


	@FindBy(id = "product_attribute_2")
	WebElement RAM;

	@FindBy(id = "product_attribute_3_7")
	WebElement HDD;
	
	@FindBy(id = "product_attribute_4_9")
	WebElement OS;
	
	@FindBy(id = "product_attribute_5_11")
	WebElement softwarecheckbox2;
	
	@FindBy(id = "product_attribute_5_12")
	WebElement softwarecheckbox3;
	
	@FindBy(id = "add-to-cart-button-1")
	WebElement addtocartbtn;
	
	@FindBy(xpath = "//span[text()='Shopping cart']")
	WebElement shoppingcartbtn;
	
	
	
	public ShoppingCart_page selectyourproductdetails() throws Throwable {
		
	ActionDriver.selectDropDown(processor, "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
	
	ActionDriver.selectDropDown(RAM, "8GB [+$60.00]");
	
	ActionDriver.click(driver, HDD);	
		
	ActionDriver.click(driver, OS);	
		
	ActionDriver.click(driver, softwarecheckbox2);		
		
	ActionDriver.click(driver, softwarecheckbox3);
	
	ActionDriver.click(driver, addtocartbtn);
	
	ActionDriver.waitForElement(shoppingcartbtn, 10);
	
	ActionDriver.scrollByVisibilityofElement(driver, shoppingcartbtn);
	
	ActionDriver.mouseHoverAndClickonElement(shoppingcartbtn);
	
	return new ShoppingCart_page(driver);
	
	}
	
	public String getcurrentURL() {
		
		String currenturl =	driver.getCurrentUrl();
		
		return currenturl;
			
			
			
		}
	
	
	
	
	
}
