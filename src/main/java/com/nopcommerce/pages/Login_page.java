package com.nopcommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.utility.ActionDriver;

public class Login_page {  //6th

	WebDriver driver;

	public Login_page(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "Email")
	WebElement username;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(id = "RememberMe")
	WebElement checkbox;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginbtn;

	
	
	public ShoppingCart_page login(String usermail,String userpass) throws Throwable {
		
		ActionDriver.type(username, usermail);
		
		ActionDriver.type(password, userpass);
		
		ActionDriver.click(driver, checkbox);
		
		ActionDriver.click(driver, loginbtn);
		
		return new ShoppingCart_page(driver);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
