
package com.ecommerce.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecommerce.pageobjects.CartPage;
import com.ecommerce.pageobjects.OrderPage;

public class AbstractComponents {
	
	WebDriver driver;
	
	
	
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css="[routerlink*='cart']")
	WebElement goToCartPage1;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader1;
	
	public void waitForElementToAppear(By locator) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDisAppear(WebElement element) throws InterruptedException {
		Thread.sleep(2000);
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public CartPage goToCartPage() {
		goToCartPage1.click();
		return new CartPage(driver);
	}
	
	
	public OrderPage goToOrderPage() {
		orderHeader1.click();
		return new OrderPage(driver);
	}
	
	

}
