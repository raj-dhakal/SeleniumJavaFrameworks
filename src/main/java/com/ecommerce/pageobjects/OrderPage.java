package com.ecommerce.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.abstractcomponents.AbstractComponents;

public class OrderPage extends AbstractComponents {
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> listOfOrderItems;
	
	public boolean veryfyOrderInTheList(String name) {
		return listOfOrderItems.stream().anyMatch(name1->name1.getText().equalsIgnoreCase(name));	
		
	}

}
