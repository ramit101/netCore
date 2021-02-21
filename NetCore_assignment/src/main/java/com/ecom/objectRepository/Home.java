package com.ecom.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	@FindBy(xpath="//input[@type='text']")
	private WebElement searchField;

	@FindBy(xpath="//div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[2]/form/div[1]/button")
	private WebElement searchButton;

	public Home(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public void getSearchField() {
		searchField.sendKeys("iphone less than 40000");
	}

	public void getSearchButton() {
		searchButton.click();
	}

}
