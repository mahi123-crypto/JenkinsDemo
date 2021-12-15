package StepDefinitions;

import java.io.IOException;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.qa.pageObjects.CartPageObjects;
import com.qa.utils.TestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep extends TestBase {
	CartPageObjects pom;
	public WebDriver driver;
	
	
	@Given("browser is open")
	public void browser_is_open() throws IOException {
		driver = initializeDriver();
		pom = new CartPageObjects();
		pom.CartPageObjects();
		
		
	}
//
	@And("user clicks on login link")
	public void user_clicks_on_login_button() {
		pom.loginLink.click(); 
	}
//
	@Then("user is on login page")
	public void user_is_on_login_page() {
		driver.manage().window().maximize();
	}

	@When("user enters valid email and valid password")
	public void user_enters_valid_email_and_valid_password() {
		pom.email.sendKeys("mahi2@gmail.com");
		pom.pass.sendKeys("123456");
	}
	

	@Then("user login should be successful")
	public void user_login_should_be_successful() {
		pom.loginButton.click();
		
	}
//2
	@When("user enters invalid email and valid password")
	public void user_enters_invalid_email_and_valid_password() {
		pom.email.sendKeys("mahi2@gmail.com");
		pom.pass.sendKeys("123456");
	}

	@Then("it should display wrong email")
	public void it_should_display_wrong_email() {
       pom.wrongEmail.sendKeys("mahi@gmail.com");
	}
//3
	@When("user enters valid email and invalid password")
	public void user_enters_valid_email_and_invalid_password() {
		pom.email.sendKeys("mahi2@gmail.com");
		pom.invalidPass.sendKeys("mahi123");
		pom.loginButton.click();
	  
	}

	@Then("it should display credentials are incorrect")
	public void it_should_display_credentials_are_incorrect() {
        pom.unsuccessLogin.click();
  
	}
//4
	@When("user leave fields empty")
	public void user_leave_fields_empty() {
		pom.loginButton.click();
		
	}

	@Then("it should display please enter your email")
	public void it_should_display_please_enter_your_email() {
		pom.emptyEmail.click();
	}
//5
	@When("user enters invalid email and invalid password")
	public void user_enters_invalid_email_and_invalid_password() {
		pom.wrongEmail.sendKeys("mahi@gmail.com");
		pom.invalidPass.sendKeys("mahi123");
		pom.loginButton.click();
	    
	}
	@Then("No customer account found")
	public void no_customer_account_found() {
	pom.noCustomer.click();
    	
	}
}
