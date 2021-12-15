package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class AddToCartStep {
	public WebDriver driver;
//	@Given("browser is open")
//	public void browser_is_open() {
//
//		 System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe" );
//         driver=new ChromeDriver();
//	       driver.manage().window().maximize();
//	       driver.get("https://demo.nopcommerce.com/ ");
//}
////
//	@When("user clicks on shopping cart")
//	public void user_clicks_on_shopping_cart() {
//		driver.findElement(By.xpath("//a[@class='ico-cart']")).click();
//	}
//
//	@Then("user should be able to see your shopping cart is empty")
//	public void user_should_be_able_to_see_your_shopping_cart_is_empty() {
//	 driver.findElement(By.xpath("//div[@class='no-data']"));
//	}
		 
		@When("user adds the prodcuts")
		public void user_adds_the_prodcuts() {
			driver.findElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']")).click();
			driver.findElement(By.xpath("//option[@value='3']")).click();
			driver.findElement(By.xpath("//input[@id='product_attribute_3_6']")).click();
			driver.findElement(By.id("add-to-cart-button-1")).click();
			
		}

		@Then("user should be able to see the products in shopping cart")
		public void user_should_be_able_to_see_the_products_in_shopping_cart() {
			driver.findElement(By.cssSelector("#topcartlink")).click();
		}

		@When("user removes product from the cart")
		public void user_removes_product_from_the_cart() {
			driver.findElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own computer']")).click();
			driver.findElement(By.xpath("//option[@value='3']")).click();
			driver.findElement(By.xpath("//input[@id='product_attribute_3_6']")).click();
			driver.findElement(By.id("add-to-cart-button-1")).click();
			
			driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Books']")).click();
			driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[1]")).click();
			driver.findElement(By.id("add-to-cart-button-1")).click();
			driver.findElement(By.cssSelector("#topcartlink")).click();
			   driver.findElement(By.xpath("//td[@class='remove-from-cart']")).click();
		}

		@Then("user should be able to see the updated cart")
		public void user_should_be_able_to_see_the_upated_cart() {
		
			String emptyMsg=driver.findElement(By.xpath("//div[@class='no-data']")).getText();
			String expectedMsg="Your Shopping Cart is empty!";
			Assert.assertEquals(emptyMsg, expectedMsg);
		}
}
