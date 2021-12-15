package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.pageObjects.CartPageObjects;
import com.qa.utils.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationStep extends TestBase{
	CartPageObjects pom;
	public WebDriver driver;
	
	@Given("user opens the browser")	
	public void user_opens_the_browser() throws IOException {
	driver = initializeDriver();
	pom = new CartPageObjects();
	pom.CartPageObjects();
	}

	@When("user clicks on register link")
	public void user_clicks_on_register_link() {
		pom.registerLink.click();
	}

	@When("user is on registration page")
	public void user_is_on_registration_page() {
		driver.manage().window().maximize();
	}
	

	@Then("clicks on {string} button")
	public void clicks_on_button(String registerBtn) {
	}
	@When("user enters valid user details {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}  in Registration form")
	public void user_enters_the_following_details_in_registration_form(String gender, String firstname, String lastname, String date, String month, String year, String emailaddress, String companyName, String password, String confirmPass) {
		if (gender.equals("female"))
			pom.radio1.click();
		
		if (gender.equals("male"))
			pom.radio2.click();
		
		pom.fname.sendKeys(firstname);
		pom.lname.sendKeys(lastname);
		pom.dob.sendKeys("14");
	    pom.dom.click();
		pom.month.click();
		pom.doy.click();
		pom.year.click();
		pom.registerEmail.sendKeys(emailaddress);
	    pom.company.sendKeys(companyName);
		pom.registerPass.sendKeys(password);
		pom.confirmPass.sendKeys(confirmPass);
	}
 

	
	@When("user leaves firstname  {string},{string} empty")
	public void user_leaves_firstname_empty(String password, String confirmPass) {
		pom.fname.sendKeys("");
		pom.lname.sendKeys("athani");
		pom.registerEmail.sendKeys("mahi2@gmail.com");
		pom.registerPass.sendKeys(password);
		pom.confirmPass.sendKeys(confirmPass);
	    pom.registerBtn.click();
	}

@Then("user should get error message as first name is required")
	public void user_should_get_error_message_as_please_enter_your_first_name() {
	    String expectedErrorMsg = "First name is required.";
	    Assert.assertEquals(driver.findElement(By.id("FirstName-error")).getText(), expectedErrorMsg);
	}
@When("user enters email already registered")
public void user_enters_already_registered() {
	driver.findElement(By.id("FirstName")).sendKeys("mahi");
	driver.findElement(By.id("LastName")).sendKeys("athani");
	driver.findElement(By.id("Email")).sendKeys("mahi2@gmail.com");
	driver.findElement(By.id("Password")).sendKeys("mahi123");
	driver.findElement(By.id("ConfirmPassword")).sendKeys("mahi123");

	
	driver.findElement(By.id("register-button")).click();
}

@Then("user should get The specified email already exists")
public void user_should_get_the_specified_email_already_exists() {
	String expectedErrorMsg = "The specified email already exists";
    Assert.assertEquals(driver.findElement(By.xpath("//li[normalize-space()='The specified email already exists']")).getText(), expectedErrorMsg);
}
@When("user enters invalid email")
public void user_enters_invalid_email() {
	driver.findElement(By.id("FirstName")).sendKeys("mahi");
	driver.findElement(By.id("LastName")).sendKeys("athani");
	driver.findElement(By.id("Password")).sendKeys("mahi123");
	driver.findElement(By.id("ConfirmPassword")).sendKeys("mahi123");
	driver.findElement(By.id("Email")).sendKeys("mahi2");
	driver.findElement(By.id("register-button")).click();
}

@Then("user should get wrong email error message")
public void user_should_get_wrong_email_error_message() {
	 String expectedErroremail = "Wrong email";
   Assert.assertEquals(driver.findElement(By.id("Email-error")).getText(), expectedErroremail);
}

@When("user enters invalid password while confirmation")
public void user_enters_invalid_password_while_confirmation() {
	driver.findElement(By.id("FirstName")).sendKeys("mahi");
	driver.findElement(By.id("LastName")).sendKeys("athani");
	driver.findElement(By.id("Password")).sendKeys("mahi123");
	driver.findElement(By.id("ConfirmPassword")).sendKeys("mahi1");
	driver.findElement(By.id("Email")).sendKeys("mahi2@gmail.com");
	driver.findElement(By.id("register-button")).click();
}

@Then("user should get password do not match error message")
public void user_should_get_password_do_not_match_error_message() {
	String PassError = driver.findElement(By.xpath("//*[@id=\"ConfirmPassword-error\"]")).getText();
	String ActualPassError = "The password and confirmation password do not match.";
	Assert.assertEquals(PassError,ActualPassError);
}
@When("user enters password less than {int} length")
public void user_enters_password_less_than_length(Integer int1) {
	driver.findElement(By.id("FirstName")).sendKeys("mahi");
	driver.findElement(By.id("LastName")).sendKeys("athani");
	driver.findElement(By.id("Password")).sendKeys("mahi12");
	
	driver.findElement(By.id("Email")).sendKeys("mahi2@gmail.com");
	driver.findElement(By.id("register-button")).click();
}

@Then("user should get must have at least {int} characters error message")
public void user_should_get_must_have_at_least_characters_error_message(Integer int1) {
	String PassError = driver.findElement(By.xpath("//*[@id=\"Password-error\"]/ul/li")).getText();
	String ActualPassError = "must have at least 6 characters";
	Assert.assertEquals(PassError,ActualPassError);
}


}
