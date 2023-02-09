package com.ecommerce.stepdefinitions;

import java.io.IOException;

import org.testng.Assert;

import com.ecommerce.pageobjects.CartPage;
import com.ecommerce.pageobjects.CheckOutPage;
import com.ecommerce.pageobjects.ConfirmationPage;
import com.ecommerce.pageobjects.LoginPage;
import com.ecommerce.pageobjects.ProductPage;
import com.ecommerce.testcomponents.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImp extends BaseTest {
	public LoginPage loginpage;
	public ProductPage productPage;
	public ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		loginpage = launchApplication();
		
	}
	
	@Given("^Logged in with useremail (.+) and password(.+)$")
	public void logged_in_username_and_password(String userEmail, String userPassword) {
		productPage = landingPage.loginApplication(userEmail,userPassword);
	}
	
	@When("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String productName) throws InterruptedException{
		productPage.addToCart(productName);
	}
	
	 @When("^Checkout (.+) and submit the order$")
	 public void checkout_and_submit_the_order(String productName) {
		 CartPage cartPage = productPage.goToCartPage();
			System.out.println(cartPage.checkItemsInCart(productName));
			Assert.assertTrue(cartPage.checkItemsInCart(productName));
			CheckOutPage checkOutPage = cartPage.checkOutProduct();
			checkOutPage.enterCountryName("India");
			confirmationPage = checkOutPage.placeOrder();
	 }
	 
	 @Then("{string}message is displayed on confirmationpage")
	 public void message_is_displayed_on_confirmationpage(String string) {
		 String confirmMessage = confirmationPage.confirmationMessage();
		 Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	 }

}
