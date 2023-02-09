package com.ecommerce.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.abstractcomponents.AbstractComponents;

public class ProductPage extends AbstractComponents {
	
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css = ".mb-3")
	List<WebElement> listOfProducts;   //driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css = ".ng-animating")
	WebElement blurring;
	
	
	By products = By.cssSelector(".mb-3");
	By productName1 = By.cssSelector("b");
	By addToCart1 = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	

	//(driver.findElement(By.cssSelector(".ng-animating"))
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(products);
		return listOfProducts;
	}
	/*
	
	public WebElement getProductName(String name) {
		WebElement prod = getProductList().stream().filter(product ->product.findElement(productName1)
				.getText().equals(name)).findFirst().orElse(null);
		return prod;
	}

	
	public void addProdToCart(String name) {
		WebElement prod = getProductName( name);
		prod.findElement(addToCart1).click();
	}
	*/
	
	public void addToCart(String name) throws InterruptedException {
		WebElement prod = getProductList().stream().filter(product ->product.findElement(productName1)
				.getText().equals(name)).findFirst().orElse(null);
		prod.findElement(addToCart1).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisAppear(blurring);
		
	}
	
	

}
