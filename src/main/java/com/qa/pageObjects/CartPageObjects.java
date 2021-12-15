package com.qa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.TestBase;

//Inheriting the TestBase class (Parent class), CartPageObjects is child of TestBase
public class CartPageObjects extends TestBase {

	/* WebElements for Cart Page */

/* By using CacheLookup we are creating one cache memory and this element will be stored in that memory, 
 it will help in improving script's performance, As it will not go to the browser and look for this element, 
 it will fetch the details from Cache memory only. 
*/
	@FindBy(xpath = "//a[normalize-space()='Log in']")
	@CacheLookup
	public WebElement loginLink;
	
	@FindBy(id="Email")
	public WebElement email;
	
	@FindBy(id="Password")
	public WebElement pass;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	public WebElement loginButton;

	@FindBy(xpath="//span[@class='field-validation-error']")
	public WebElement wrongEmail;
	
	@FindBy(id="Password")
	public WebElement invalidPass;

	@FindBy(xpath="//div[@class='message-error validation-summary-errors']")
	public WebElement unsuccessLogin;
	
	
	@FindBy(id="Email-error")
	public WebElement emptyEmail;
	
	@FindBy(xpath="//li[normalize-space()='No customer account found']")
	public WebElement noCustomer;
	
	@FindBy(id="register-button")
	public WebElement registerLink;
	

	@FindBy(className="female")
	public WebElement radio1;
	

	@FindBy(className="male")
	public WebElement radio2;
	
	@FindBy(id="FirstName")
	public WebElement fname;
	
	@FindBy(id="LastName")
	public WebElement lname;
	
	
	@FindBy(name="DateOfBirthDay")
	public WebElement dob;
	
	@FindBy(name="DateOfBirthMonth")
	public WebElement dom;
	
	@FindBy(xpath="//option[text()='August']")
	public WebElement month;
	
	@FindBy(name="DateOfBirthYear")
	public WebElement doy;
	
	@FindBy(xpath="//option[text()='1999']")
	public WebElement year;
	
	@FindBy(id="Email")
	public WebElement registerEmail;
	
	@FindBy(id="Company")
	public WebElement company;
	
	@FindBy(id="Password")
	public WebElement registerPass;
	
	@FindBy(id="ConfirmPassword")
	public WebElement confirmPass;
	
	@FindBy(id="register-button")
	public WebElement registerBtn;
	

	
	
// To initialize the Page objects WebElements in defined in this Cart Page class, create the constructor of Cart Page

	public void CartPageObjects() {           
	        PageFactory.initElements(driver, this);
	}

}
