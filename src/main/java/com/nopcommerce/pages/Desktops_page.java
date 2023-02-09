package com.nopcommerce.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.utility.ActionDriver;

public class Desktops_page { // 2nd

	WebDriver driver;

	public Desktops_page(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//button[text()='Add to cart'])[1]")
	WebElement additemtocartbtn1;

	@FindBy(xpath = "(//button[@type='button'])[4]")
	WebElement additemtocartbtn2;
	
	@FindBy(xpath = "//span[@class='close']")
	WebElement msgbtn;
	

	public Buildyourown_page addProductstocart() throws Throwable {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scroll(0,1000);");
		

	

		ActionDriver.click(driver, additemtocartbtn2);
		
		Thread.sleep(4000);
		
		ActionDriver.waitForElement(msgbtn, 10);
		
		ActionDriver.scrollByVisibilityofElement(driver, msgbtn);
		
		ActionDriver.click(driver, msgbtn);
		
		ActionDriver.waitForElement(additemtocartbtn1, 10);
		
		WebElement view=additemtocartbtn1;

		js.executeScript("arguments[0].scrollIntoView",  view );

		ActionDriver.click(driver, additemtocartbtn1);
		
		

		return new Buildyourown_page(driver);

	}
	
	public String getcurrentURL() {
		
	String currenturl =	driver.getCurrentUrl();
	
	return currenturl;
		
		
		
	}

}
