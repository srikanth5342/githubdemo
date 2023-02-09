package com.nopcommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.utility.ActionDriver;

public class OrderConfirmation_page {  //12th
	
	
	WebDriver driver;

	public OrderConfirmation_page(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[text()='Confirm']")
	WebElement confirmbtn;


	public Thankyou_page clickingconfirmation() throws Throwable {
		
		
		ActionDriver.waitForElement(confirmbtn, 10);
		
		ActionDriver.scrollByVisibilityofElement(driver, confirmbtn);
		
		ActionDriver.click(driver, confirmbtn);
		
		return new Thankyou_page(driver);
		
	}	
	
	
	
	
	
	
}
