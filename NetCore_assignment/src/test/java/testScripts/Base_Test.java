package testScripts;
import java.io.IOException;

import org.testng.annotations.Test;

import com.ecom.genericLibrary.BaseClass;
import com.ecom.genericLibrary.ExcelUtility;
import com.ecom.genericLibrary.WebDriverUtility;
import com.ecom.objectRepository.Home;
import com.ecom.objectRepository.Iphone_Products;

public class Base_Test extends BaseClass{
@Test
public void tc_01() {	
	WebDriverUtility webutl=new WebDriverUtility();
	
	webutl.performAction(driver);
	
	Home home = new Home(driver);
	home.getSearchField();
	home.getSearchButton();
	
	Iphone_Products iphone = new Iphone_Products(driver);
	
	iphone.getDevicemodel(driver);	
	iphone.getPrice();
	iphone.getStoragecapacity();
	iphone.getRating();
	
	iphone.getDetails();
	
	
}
}
