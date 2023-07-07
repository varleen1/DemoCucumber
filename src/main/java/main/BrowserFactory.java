package main;


import org.openqa.selenium.WebDriver.Timeouts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
}