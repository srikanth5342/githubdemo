package com.nopcommerce.utility;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nopcommerce.base.BaseClass;



public class ActionDriver extends BaseClass {

	// for click action
	public static void click(WebDriver ldriver, WebElement locatorName) {

		Actions act = new Actions(ldriver);

		act.moveToElement(locatorName).click().build().perform();

	}

	public static boolean findElement(WebDriver ldriver, WebElement ele) {

		boolean flag = false;

		try {

			ele.isDisplayed();

			flag = true;

		} catch (Exception e) {

			flag = false;

		} finally {

			if (flag) {

				System.out.println("successfully found element at");
			} else {

				System.out.println("unable to locate element at");
			}
		}
		return flag;
	}

	public static boolean isselected(WebDriver ldriver, WebElement ele) {

		boolean flag = false;

		flag = findElement(ldriver, ele);

		if (flag) {

			flag = ele.isSelected();

			if (flag) {

				System.out.println("element is selected");
			} else {

				System.out.println("element is not selected");

			}

		} else {
			System.out.println("not selected");

		}

		return flag;
	}

	public static boolean isDisplayed(WebDriver ldriver, WebElement ele) throws Throwable {

		boolean flag = false;

		flag = findElement(ldriver, ele);

		if (flag) {

			flag = ele.isDisplayed();

			if (flag) {

				System.out.println("element is displayed");
			} else {

				System.out.println("element is not displayed");
			}

		} else {
			System.out.println("not displayed");

		}

		return flag;
	}

	public static boolean isenabled(WebDriver ldriver, WebElement ele) throws Throwable {

		boolean flag = false;

		flag = findElement(ldriver, ele);

		if (flag) {

			flag = ele.isEnabled();

			if (flag) {

				System.out.println("element is Enabled");
			} else {

				System.out.println("element is not Enabled");

			}

		} else {
			System.out.println("not Enabled");

		}

		return flag;
	}

	public static boolean type(WebElement ele, String text) throws Throwable {

		boolean flag = false;

		try {

			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			flag = true;
		} catch (Exception e) {
			System.out.println("location not found");
			e.printStackTrace();
			flag = false;
		} finally {

			if (flag) {

				System.out.println("successfully entered value");
			} else {

				System.out.println("unable to enter value");
			}
		}

		return flag;

	}

	// for sendkeys action
	public static void sendKeysWebElement(WebElement element, String text) throws Throwable {

		waitForElement(element, 20);

		element.click();

		element.clear();

		element.sendKeys(text);

	}

	public static  WebElement waitForElement(WebElement elementName, long WaitTimeSeconds) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitTimeSeconds));

		WebElement Element = wait.until(ExpectedConditions.elementToBeClickable(elementName));

		return Element;

	}

	// for dropDowns
	public static void selectDropDown(WebElement element, String text)throws Throwable {

		try {
			Select select = new Select(element);

			select.selectByVisibleText(text);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void sendkeysJavaScript(WebElement element, String text)throws Throwable {

		try {
			WebElement ele = waitForElement(element, 20);

			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].value='" + text + "';", ele);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void acceptAlert(WebDriver driver)throws Throwable {

		driver.switchTo().alert().accept();

	}

	public static void mouseHoverAndClickonElement(WebElement element) throws Throwable {

		Actions action = new Actions(driver);

		action.moveToElement(element).click().build().perform();

	}
	
	public static void mouseHoverToElement(WebElement element) throws Throwable {

		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();

	}

	public static void scrollByVisibilityofElement(WebDriver driver, WebElement ele) throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", ele);

	}

}
