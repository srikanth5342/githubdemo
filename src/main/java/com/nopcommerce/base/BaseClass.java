package com.nopcommerce.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static Properties prop;

	@BeforeTest
	public void loadconfig() {

		try {
			prop = new Properties();

			FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.file");

			prop.load(fs);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@BeforeTest
	public void openingBrowsers() {

		WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) {

			driver = new ChromeDriver();

		} else if (browserName.contains("firefox")) {

			driver = new FirefoxDriver();

		} else if (browserName.contains("edge")) {

			driver = new EdgeDriver();

		} else if (browserName.contains("ie")) {

			driver = new InternetExplorerDriver();

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));

		driver.get(prop.getProperty("url"));

	}

	@AfterTest
	public void tearDown() {

		driver.quit();

	}

}
