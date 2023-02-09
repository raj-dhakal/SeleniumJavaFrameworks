package com.ecommerce.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.abstractcomponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents {
	
WebDriver driver;
	
	
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".form-group input")
	WebElement selectCountry1;
	
	@FindBy(xpath="//*[@type='button']/span")
	List<WebElement> listOfCountries;
	
	@FindBy(xpath="//*[@class='actions']/a")
	WebElement placeOrderButton1;
	
	By elementToAppear1 = By.cssSelector(".ta-results");
	
	public void enterCountryName(String name) {
		selectCountry1.sendKeys(name);
		waitForElementToAppear(elementToAppear1);
		for(int i = 0; i <listOfCountries.size(); i++) {
			if(listOfCountries.get(i).getText().equalsIgnoreCase("India")) {
				listOfCountries.get(i).click();
			}
		}
	}
	
	public ConfirmationPage placeOrder() {
		placeOrderButton1.click();
		return new ConfirmationPage(driver);
	}
	
	

}
