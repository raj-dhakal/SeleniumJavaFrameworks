
package com.ecommerce.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.abstractcomponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	
WebDriver driver;
	
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath ="//*[@class='cartSection']/h3")
	List<WebElement> cartListProducts;
	
	@FindBy(xpath="//*[text()='Checkout']")
	WebElement checkOutProduct1;
	
	public boolean checkItemsInCart(String name) {
		return cartListProducts.stream().anyMatch(name1 ->name1.getText().equalsIgnoreCase(name));
	
	}
	public CheckOutPage checkOutProduct() {
		checkOutProduct1.click();
		return new CheckOutPage(driver);
	}

}
