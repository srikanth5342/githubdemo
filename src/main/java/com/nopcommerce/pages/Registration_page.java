package com.nopcommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.utility.ActionDriver;

public class Registration_page { // 5th

	WebDriver driver;

	public Registration_page(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[text()='Register']")
	WebElement registrationbtn;

	@FindBy(xpath = "//a[text()='Log in']")
	WebElement loginbtn;

	@FindBy(id = "gender-male")
	WebElement genderbtn;

	@FindBy(id = "FirstName")
	WebElement firstname;

	@FindBy(id = "LastName")
	WebElement lastname;

	@FindBy(xpath = "//select[@name='DateOfBirthDay']")
	WebElement date;

	@FindBy(xpath = "//select[@name='DateOfBirthMonth']")
	WebElement month;

	@FindBy(xpath = "//select[@name='DateOfBirthYear']")
	WebElement year;

	@FindBy(id = "Email")
	WebElement emailfield;

	@FindBy(id = "Company")
	WebElement companyfield;

	@FindBy(id = "Password")
	WebElement passwordfield;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmpasswordfield;

	@FindBy(id = "register-button")
	WebElement submitregbtn;

	@FindBy(xpath = "//div[text()='Your registration completed']")
	WebElement succesfulmsg;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continuebtn;

	public boolean enterDetailsinRegistration(String name, String lname, String email, String company, String pass,
			String confpass) throws Throwable {

		ActionDriver.scrollByVisibilityofElement(driver, registrationbtn);

		ActionDriver.click(driver, registrationbtn);

		ActionDriver.waitForElement(genderbtn, 10);

		ActionDriver.click(driver, genderbtn);

		ActionDriver.type(firstname, name);

		ActionDriver.type(lastname, lname);

		ActionDriver.selectDropDown(date, "17");

		ActionDriver.selectDropDown(month, "August");

		ActionDriver.selectDropDown(year, "1994");

		ActionDriver.type(emailfield, email);

		ActionDriver.type(companyfield, company);

		ActionDriver.type(passwordfield, pass);

		ActionDriver.type(confirmpasswordfield, confpass);

		ActionDriver.click(driver, submitregbtn);

		ActionDriver.waitForElement(succesfulmsg, 15);

		return ActionDriver.isDisplayed(driver, succesfulmsg);

	}

	public void clickContinue() {

		ActionDriver.click(driver, continuebtn);

	}

	public Login_page clickonloginbutton() throws Throwable {

		//ActionDriver.waitForElement(loginbtn, 10);

		ActionDriver.scrollByVisibilityofElement(driver, loginbtn);

		ActionDriver.click(driver, loginbtn);

		return new Login_page(driver);

	}

	public String getcurrentURL() {

		String currenturl = driver.getCurrentUrl();

		return currenturl;
	}

}
