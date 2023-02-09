package com.ecommerce.testcases;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecommerce.pageobjects.CartPage;
import com.ecommerce.pageobjects.CheckOutPage;
import com.ecommerce.pageobjects.ConfirmationPage;
import com.ecommerce.pageobjects.OrderPage;
import com.ecommerce.pageobjects.ProductPage;
import com.ecommerce.testcomponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	static String email1 = "anshika@gmail.com";
	static String password1= "Iamking@000";
	static String productName1 = "ZARA COAT 3";
	
	
		@Test(dataProvider = "getData", groups = "Purchase")
		 public void submitOrder(HashMap<String,String> hashMap) throws InterruptedException, IOException {
			 	ProductPage productPage = landingPage.loginApplication(hashMap.get("email"), hashMap.get("password"));
				productPage.addToCart(hashMap.get("productName"));
				CartPage cartPage = productPage.goToCartPage();
				System.out.println(cartPage.checkItemsInCart(hashMap.get("productName")));
				Assert.assertTrue(cartPage.checkItemsInCart(hashMap.get("productName")));
				CheckOutPage checkOutPage = cartPage.checkOutProduct();
				checkOutPage.enterCountryName("India");
				ConfirmationPage confirmationPage = checkOutPage.placeOrder();
				System.out.println(confirmationPage.confirmationMessage());
				
		 }	
		
		
		@Test(dependsOnMethods= {"submitOrder"})
		public void orderHistory() {
			landingPage.loginApplication(email1, password1);
			OrderPage op = landingPage.goToOrderPage();
			boolean match = op.veryfyOrderInTheList(productName1);
			System.out.println("Order is in the order history list: " + match);
		
		}
		
		
		@DataProvider
		public Object[][] getData() throws IOException {
			String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\ecommerce\\data\\PurchaseOrder.json";
			List<HashMap<String,String>> data = getJsonDataToMap(path);
			
			 return new Object[][] {{data.get(0)},{data.get(1)}};
			
		}
		
		
		
		
		
		/*
		
		@DataProvider
		public Object[][] getData() {
			HashMap<String,String> map = new HashMap<String,String>();
			map.put("email", "anshika@gmail.com");
			map.put("password", "Iamking@000");
			map.put("productName", "ZARA COAT 3");
			
			HashMap<Object,Object> map1 = new HashMap<Object,Object>();
			map1.put("email", "anshika@gmail.com");
			map1.put("password", "Iamking@000");
			map1.put("productName", "ADIDAS ORIGINAL");
			
			
			Object[][] data = new Object[][] {{map},{map1}};
			return data;
		}
		*/
		
		
		/*@DataProvider             //not good choice
		public Object[][] getData() {
			Object[][] data = new Object[][] {{"anshika@gmail.com","Iamking@000","ZARA COAT 3"},
											  {"anshika@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
			return data;
		}
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
