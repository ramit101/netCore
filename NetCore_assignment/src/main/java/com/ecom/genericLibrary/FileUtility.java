package com.ecom.genericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	public String getPropertyValue(String key) throws Throwable  {
		  
		FileInputStream fis = new FileInputStream(IAutoConstant.commonDataFilePath);
		 Properties p = new Properties();
		 p.load(fis);
		 String value = p.getProperty(key);
	
	return value;
}
}
