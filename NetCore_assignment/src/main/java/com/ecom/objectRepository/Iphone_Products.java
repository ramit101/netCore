package com.ecom.objectRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.ecom.genericLibrary.ExcelUtility;
import com.ecom.genericLibrary.IAutoConstant;
import com.ecom.genericLibrary.JavaUtility;
import com.ecom.genericLibrary.WebDriverUtility;
import com.opencsv.CSVWriter;

public class Iphone_Products {	
   ExcelUtility  exlutil=new ExcelUtility();
   WebDriverUtility webutl=new WebDriverUtility();

	@FindBy(xpath="(//select[@class='_2YxCDZ'])[2]")
	private WebElement dropElement;

	@FindBy(xpath="//div[@class='_4rR01T']")
	private List<WebElement> devicemodel;


	@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']")
	private List<WebElement> price;

	@FindBy(xpath="//div[@class='_4rR01T']/../div[3]/ul[*]/li[1]")
	private List<WebElement> storagecapacity;
	@FindBy(xpath="//div[@class='_4rR01T']/../div[2]/span[1]")
	private List<WebElement> rating;


	public Iphone_Products(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public void getDevicemodel(WebDriver driver)  {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webutl.explicitWait(driver, devicemodel);
		for(WebElement webEle1:devicemodel){
			String txte = webEle1.getText();
			System.out.println(txte);	
		}
	}

	public void getPrice() {
		for(WebElement webEle2:price){		   
			System.out.println(" "+webEle2.getText());
		}
	}

	public void getStoragecapacity() {
		for(WebElement webEle3:storagecapacity){
			System.out.println(" "+ webEle3.getText());
		}
	}

	public void getRating() {
		for(WebElement webEle4:rating){
			System.out.println(" "+ webEle4.getText()+"  ");

		}
	}
	public void getDropElement(WebDriver driver){
		webutl.explicitWait(driver, dropElement);
		webutl.selectdropDown(dropElement);
	}
	
	
public void getDetails(){
	exlutil.printDetails(devicemodel, price, rating);
}
	/*public void printDetails() throws IOException{

		String[] header = {"Device Details", "Price", "Ratings"};

		List<String[]> list = new ArrayList();
		list.add(0,header);

		for(int i=0;i<devicemodel.size();i++)
		{
			String[] row1 = {devicemodel.get(i).getText(), price.get(i).getText().substring(1), rating.get(i).getText()};
			list.add(i, row1);
		}


		CSVWriter writecsv = new CSVWriter(new FileWriter(IAutoConstant.csvFilePath));
		writecsv.writeAll(list);
		writecsv.close();

	}*/

}
