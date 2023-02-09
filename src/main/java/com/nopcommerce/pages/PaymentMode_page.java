package com.nopcommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.utility.ActionDriver;

public class PaymentMode_page {  //10th
	
	
	WebDriver driver;

	public PaymentMode_page(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "paymentmethod_0")
	WebElement checkoption;
	
	@FindBy(xpath  = "(//button[text()='Continue'])[4]")
	WebElement continuebtn;


	public PaymentInformation_page choosepaymentMode() {
		
		ActionDriver.click(driver, checkoption);
		
		ActionDriver.click(driver, continuebtn);
		
		return new PaymentInformation_page(driver);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
