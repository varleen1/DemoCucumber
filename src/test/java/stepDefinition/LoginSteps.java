package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.BaseClass;
import pages.LoginPage;

public class LoginSteps extends BaseClass{
WebDriver ldriver;
	
	public LoginSteps() {
		ldriver = getDriver();
	}
	
	@Given("I want to open the application url {string}")
	public void i_want_to_open_the_application_url(String url) {
		ldriver.get(url);
		ldriver.manage().window().maximize();
	}

	@When("I login with {string} and {string} in step")
	public void i_login_with_and_in_step(String userName, String password) {
		pages.LoginPage login = PageFactory.initElements(ldriver, LoginPage.class);
		login.loginToCRM(ldriver, userName, password);
	}

	@Then("I verify the {string} in homepage")
	public void i_verify_the_in_homepage(String string) {
		//BrowserFactory.quitBrowser(driver);

	}
}
