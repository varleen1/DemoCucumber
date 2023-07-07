package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import main.BaseClass;
import main.DatabaseConnection;

import org.junit.Assert;

public class LoginPage {


	@FindBy(id = "login2")
	WebElement login;
	@FindBy(id = "loginusername")
	WebElement uname;
	@FindBy(id = "loginpassword")
	WebElement pass;
	@FindBy(xpath = "//*[@id=\"logInModal\"]//button[@class=\"btn btn-primary\"]")
	WebElement loginButton;
	@FindBy(id = "nameofuser")
	WebElement nameofuser;

	/**
	 * This method is used to login in to Demo blaze applications
	 * @param driver # webdriver for the browser
	 * @param userName # UserName to login DemoBlaze
	 * @param password # password to login DemoBlaze
	 */
	public void loginToCRM(WebDriver driver, String userName, String password) {
		String name = null;
		try {
			login.click();
			uname.click();

		} catch (Exception e) {
			login.click();
			uname.click();
		}

		uname.clear();
		uname.sendKeys(userName);
		pass.clear();
		pass.sendKeys(password);
		loginButton.click();
		main.BaseClass base = new main.BaseClass();
		base.waitForElement(driver, nameofuser);
		System.out.println(nameofuser.getText() + userName);
		
		  DatabaseConnection dbConn = new DatabaseConnection(); 
		  
		  name = dbConn.getUser("1");
		  
		  Assert.assertEquals(name, "saf");
		  
		  
		 
	}

}