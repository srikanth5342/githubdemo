package com.nopcommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.utility.ActionDriver;

public class ShoppingCart_page { // 4th and 7th

	WebDriver driver;

	public ShoppingCart_page(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "termsofservice")
	WebElement termscheckbox;

	@FindBy(id = "checkout")
	WebElement checkoutbtn;

	public Registration_page updatecart() throws Throwable {

		//ActionDriver.scrollByVisibilityofElement(driver, termscheckbox);

		ActionDriver.click(driver, termscheckbox);

		//ActionDriver.scrollByVisibilityofElement(driver, checkoutbtn);

		ActionDriver.click(driver, checkoutbtn);

		return new Registration_page(driver);

	}

	public Address_page afterloginshoppingpage() throws Throwable {

		ActionDriver.scrollByVisibilityofElement(driver, termscheckbox);

		ActionDriver.click(driver, termscheckbox);

		ActionDriver.scrollByVisibilityofElement(driver, checkoutbtn);

		ActionDriver.click(driver, checkoutbtn);

		return new Address_page(driver);

	}

	public String getcurrentURL() {
		
		String currenturl =	driver.getCurrentUrl();
		
		return currenturl;
	}

}
