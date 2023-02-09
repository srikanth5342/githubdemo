package com.nopcommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.utility.ActionDriver;

public class PaymentInformation_page { // 11th

	WebDriver driver;

	public PaymentInformation_page(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//button[text()='Continue'])[5]")
	WebElement continuebtn;

	public OrderConfirmation_page clickContinuebtn() throws Throwable {

		ActionDriver.waitForElement(continuebtn, 10);

		ActionDriver.scrollByVisibilityofElement(driver, continuebtn);

		ActionDriver.click(driver, continuebtn);

		return new OrderConfirmation_page(driver);

	}

}
