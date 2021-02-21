package com.ecom.genericLibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	FileUtility futility=new FileUtility();
	/**
	 * this method will be used for performing mouse related actions
	 * @param driver
	 */

	public void performAction(WebDriver driver){
		Actions act = new Actions(driver);
		act.click().build().perform();
	}
	/**
	 * this method will be used for selecting dropdown by value
	 * @author amitR
	 * @param dropElement 
	 */
	public void selectdropDown(WebElement dropElement){
		Select selElement = new Select(dropElement);
		try {
			selElement.selectByValue(futility.getPropertyValue("value"));
		} catch (Throwable e) {			
			e.printStackTrace();
		}
	}
	/**this method waits for element to be clickable
	 * @author amitR
	 */
	public void explicitWait(WebDriver driver,  WebElement element ){
		WebDriverWait wait=new WebDriverWait(driver,IAutoConstant.explicitlyWait);
		wait.until(ExpectedConditions.elementToBeClickable( element ));
	}

	/**this method waits for all elements to be visible
	 * @author amitR
	 */
	public void explicitWait(WebDriver driver,  List<WebElement> elements ){
		WebDriverWait wait=new WebDriverWait(driver,IAutoConstant.explicitlyWait);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

}
