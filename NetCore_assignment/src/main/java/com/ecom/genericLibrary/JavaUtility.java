package com.ecom.genericLibrary;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.opencsv.CSVWriter;

public class JavaUtility {
public void printDetails(String devicelist,String pricelist,String ratinglist){

/*	String[] header = {"Device Details", "Price", "Ratings"};
	
	List<String[]> list = new ArrayList();
	list.add(0,header);
	
	//for(int i=0;i<devicelist.size();i++)
	{
		String[] row1 = {devicelist.get(i).getText(),pricelist.get(i).getText().substring(1),ratingslist.get(i).getText()};
		list.add(i, row1);
	}
	CSVWriter writecsv = new CSVWriter(new FileWriter("./TestOutputs/iphoneDatanetcore.csv"));
	writecsv.writeAll(list);
	writecsv.close();*/
	
	
	/**
	 * @author ramit
	 * @return
	 */
}
	public int  generateRandomNum() {
		Random random = new Random();
		 int randomInt = random.nextInt(1000);

		 return randomInt;
	}

}
