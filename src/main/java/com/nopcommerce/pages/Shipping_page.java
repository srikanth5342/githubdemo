package com.nopcommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.utility.ActionDriver;

public class Shipping_page { //9th
	
	
	WebDriver driver;

	public Shipping_page(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "shippingoption_1")
	WebElement nextdayradiobtn;

	@FindBy(xpath  = "(//button[text()='Continue'])[3]")
	WebElement continuebtn;

	
	public PaymentMode_page chooseShippingmode() {
		
		ActionDriver.click(driver, nextdayradiobtn);
		
		ActionDriver.click(driver, continuebtn);
		
		return new PaymentMode_page(driver);
		
	}
	
	
	
	
	
	
	

}
