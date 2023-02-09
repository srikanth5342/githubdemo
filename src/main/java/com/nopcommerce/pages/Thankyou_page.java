package com.nopcommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.utility.ActionDriver;

public class Thankyou_page { // 13th

	WebDriver driver;

	public Thankyou_page(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(tagName = "//h1")
	WebElement thankumsg;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continuebtn;

	public boolean thankyoupage() throws Throwable {

		return ActionDriver.isDisplayed(driver, thankumsg);

		
	}

	
}
