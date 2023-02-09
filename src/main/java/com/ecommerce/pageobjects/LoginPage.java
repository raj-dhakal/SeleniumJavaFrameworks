package com.ecommerce.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.abstractcomponents.AbstractComponents;

public class LoginPage extends AbstractComponents {
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail")    //driver.findElement(By.id("userEmail"));
	WebElement userEmail;
	
	@FindBy(id ="userPassword")  //driver.findElement(By.id("userPassword"));
	WebElement password;
	
	@FindBy(id = "login")    //driver.findElement(By.id("login"));
	WebElement login;
	
	@FindBy(css=".toast-error")
	WebElement errorMessage1;
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	
	public ProductPage loginApplication(String userEmail1, String userPassword) {
		userEmail.sendKeys(userEmail1);
		password.sendKeys(userPassword);
		login.click();
		return new ProductPage(driver);
		
		
	}
	
	public String errorMessage() {
		waitForWebElementToAppear(errorMessage1);
		return errorMessage1.getText();
	}

	

}
