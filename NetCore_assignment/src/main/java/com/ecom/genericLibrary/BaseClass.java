package com.ecom.genericLibrary;
/**
 * 
 * @author amitRanjan
 *
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	WebDriverUtility webutl=new WebDriverUtility();
	FileUtility futility=new FileUtility();
	static{
   System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
	}
	public WebDriver driver;
	@BeforeSuite
	/**
	 * @author amitR
	 * this method will be used to connect to database
	 */
	public void getConnection(){

	}
	@BeforeClass
	/**
	 * this method will be used for opening the browser
	 * @author amitRanjan
	 */
	public void openBrowser(){
		/*	if(browser.equalsIgnoreCase("chrome")) {     //run time polymorphism
    		driver=new ChromeDriver();
    	 }
    	else if(browser.equalsIgnoreCase("firefox")) {
    		driver=new FirefoxDriver();
    	 }
    	else if(browser.equalsIgnoreCase("ie")) {
    		driver=new InternetExplorerDriver();
    	 }*/
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(IAutoConstant.implicitlyWiat,TimeUnit.SECONDS);
	}
	@BeforeMethod
	/**
	 * this method will be used for opening the application
	 * @author amitRanjan
	 */
	public void openApplication() throws Throwable{
		driver.get(futility.getPropertyValue("url"));
		driver.manage().window().maximize();
	}
	@AfterMethod
	/**
	 * this method will be used for closing the application
	 * @author amitRanjan
	 */
	public void closeApplication(){

	}
	@AfterClass
	/**
	 * this method will be used for closing the browser
	 * @author amitRanjan
	 */
	public void closeBrowser(){
		driver.close();
	}
	@AfterSuite
	public void closeConnection(){

	}

}
