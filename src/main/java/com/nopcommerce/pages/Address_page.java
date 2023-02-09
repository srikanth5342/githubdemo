package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.nopcommerce.utility.ActionDriver;

public class Address_page {  //8th

	WebDriver driver;

	public Address_page(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "BillingNewAddress.CountryId")
	WebElement countryselection;

	@FindBy(xpath =   "(//button[text()='Continue'])[1]")
	WebElement continuebtn;

	@FindBy(id = "BillingNewAddress_City")
	WebElement city;
	
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement address1;
	

	@FindBy(id = "BillingNewAddress_Address2")
	WebElement address2;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zipcode;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phnum;
	
	
	
	public Shipping_page enteringdetailsinAddresspage(String ucity,String add1,String add2,String zcode,String phn) throws Throwable {
		
		//ActionDriver.waitForElement(countryselection, 10);
		
		//ActionDriver.selectDropDown(countryselection, "india");
		
		 WebElement dropBox =  countryselection;
			
			
		 Select dropdown = new  Select(dropBox);     

	        dropdown.selectByVisibleText("India");
		
		ActionDriver.waitForElement(city, 10);
		
		ActionDriver.type(city, ucity);
		
		ActionDriver.type(address1, add1);
		
		ActionDriver.type(address2, add2);
		
		ActionDriver.type(zipcode, zcode);
		
		ActionDriver.type(phnum, phn);
		
		ActionDriver.click(driver, continuebtn);
		
		
		return new Shipping_page(driver);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
