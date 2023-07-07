package main;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BaseClass {
	public static WebDriver driver;
	private static boolean isInitialized = false;

	public WebDriver createDriver() {
		System.setProperty("webDriver.chrome.driver", "C:\\Java\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		isInitialized = true;
		return driver;
	}

	public WebDriver getDriver() {
		if (isInitialized != true) {
			driver = createDriver();
		}
		return driver;
	}



	public void waitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void switchWindow(String handle) {
		ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
		if (!availableWindows.isEmpty() && availableWindows.get(1) != handle) {
			driver.switchTo().window(availableWindows.get(1));
		}
	}

	public void switchTab(int tab_index) {
		ArrayList<String> tabs_windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs_windows.get(tab_index));
	}

	public void alertAccept() {
		waitForAlert(driver);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());

		alert.accept();
	}
	
	public String getAlertText(WebDriver driver) {
		
		String message = null;
		//waitForAlert(driver);
		Alert alert = driver.switchTo().alert();
		message=alert.getText();

		return message;

	}

	public void clickElement(WebElement element, WebDriver driver) {

		try {
			waitForElementClickable(driver, element);
			element.click();			
		} catch (ElementClickInterceptedException e) {
			Actions builder = new Actions(driver);
			builder.click(driver.findElement(By.id("submit")));
			builder.perform();
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(e.toString(), element);
		} catch (NoSuchElementException e) {
			System.out.println(e.toString());
		}
	}
	
	
	public void InputText(WebElement element, String input, WebDriver driver) {

		try {
			waitForElementClickable(driver, element);
			element.click();	
			element.clear();
			element.sendKeys(input);
		} catch (ElementClickInterceptedException e) {
			Actions builder = new Actions(driver);
			builder.click(element);
			builder.perform();
			element.clear();
			element.sendKeys(input);
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(e.toString(), element);
			element.clear();
			element.sendKeys(input);
		} catch (NoSuchElementException e) {
			System.out.println(e.toString());
		}
	}

}