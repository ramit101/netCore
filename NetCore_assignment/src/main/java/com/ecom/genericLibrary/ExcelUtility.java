package com.ecom.genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;

import com.opencsv.CSVWriter;
/**
 * 
 * @author amit
 *
 */
public class ExcelUtility {   

	/**
	 * @author amitR
	 * @param filePath
	 * @param shettName
	 * @param rowNum
	 * @param colNum
	 * @return
	 * @throws Throwable
	 */

	public String getExcelData(String filePath, String shettName , int rowNum , int colNum) throws Throwable {
		FileInputStream fis = new FileInputStream(IAutoConstant.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(shettName);
		Row row = sh.getRow(rowNum);
		wb.close();
		return row.getCell(colNum).getStringCellValue();				
	}

	/**
	 * used to set data in to excel based on parameter
	 * @param shettName
	 * @param rowNum
	 * @param colNum
	 * @param data
	 * @throws Throwable
	 */

	public void setExcelData(String sheet,int rowno,int cellno,String data) throws Throwable {

		Workbook wb = WorkbookFactory.create(new FileInputStream(IAutoConstant.excelFilePath));
		Sheet sh = wb.getSheet(sheet);
		Row row = sh.getRow(rowno);
		Cell cel = row.createCell(cellno);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IAutoConstant.excelFilePath);
		wb.write(fos);
		wb.close();
	}	
	/**this method will print details of  all the products
	 * @author amitR
	 * @param devicemodel 
	 * @throws IOException
	 */
	public void printDetails(List<WebElement> devicemodel, List<WebElement> price,List<WebElement> rating) {

		String[] header = {"Device Details", "Price", "Ratings"};

		List<String[]> list = new ArrayList();
		list.add(0,header);

		for(int i=0;i<devicemodel.size();i++)
		{
			String[] row1 = {devicemodel.get(i).getText(), price.get(i).getText().substring(1), rating.get(i).getText()};

			list.add(i, row1);
		}


		try {
			CSVWriter	writecsv = new CSVWriter(new FileWriter(IAutoConstant.csvFilePath));
			writecsv.writeAll(list);
			writecsv.close();
		} catch (IOException e) {

			e.printStackTrace();
		}


	}

}









