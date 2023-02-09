package com.ecommerce.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pageobjects.CartPage;
import com.ecommerce.pageobjects.ProductPage;
import com.ecommerce.testcomponents.BaseTest;

public class ErrorValidationTest extends BaseTest {
	
	static String wrongEmail = "Wronganshika@gmail.com";
	static String WrongPassword= "WrongIamking@000";
	static String WrongProductName = "WrongZARA COAT 3";
	
	static String email = "anshika@gmail.com";
	static String password= "Iamking@000";
	static String productName = "ZARA COAT 3";
	
	
	@Test(groups = {"ErrorHandling"})
	public void submitWrongLogin() {
		 landingPage.loginApplication(wrongEmail,WrongPassword); 
		 System.out.println(landingPage.errorMessage());
	}
	
	@Test
	public void errorProductValidation() throws InterruptedException{
		ProductPage productPage = landingPage.loginApplication(email, password);
		productPage.addToCart(productName);
		CartPage cartPage = productPage.goToCartPage();
		System.out.println(cartPage.checkItemsInCart(productName));
		Assert.assertTrue(cartPage.checkItemsInCart(WrongProductName));
		System.out.println(cartPage.checkItemsInCart(productName));
		
		
	}

}
