package com.nopcommerce.pages;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.utility.ActionDriver;

public class Home_page { // 1st

	WebDriver driver;

	public Home_page(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//a[text()='Computers '])[1]")
	WebElement computers;

	@FindBy(xpath = "//a[contains(text(), 'Desktops')]")
	WebElement desktops;

	@FindBy(xpath = "//img[@alt='nopCommerce demo store']")
	WebElement logo;

	public boolean validatingLogo() throws Throwable {

		File source = logo.getScreenshotAs(OutputType.FILE);

		File dest = new File(".\\Screenshots\\Logo.jpg");

		FileUtils.copyFile(source, dest);

		return ActionDriver.isDisplayed(driver, logo);

	}


	public Desktops_page searchproduct() throws Throwable {

		ActionDriver.mouseHoverToElement(computers);
		
		ActionDriver.mouseHoverAndClickonElement(desktops);
		
		Thread.sleep(3000);
		

		return new Desktops_page(driver);
	}

}
