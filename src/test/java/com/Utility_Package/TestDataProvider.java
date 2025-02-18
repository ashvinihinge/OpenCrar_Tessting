package com.Utility_Package;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	
	@DataProvider(name="LoginDataProvider")
	public String [][] LoginDataProvider() throws IOException{
		
		String fileName=System.getProperty("user.dir") +"\\TestData_Folder\\MyStoreTestData.xlsx";
		
		int totalnoRow=Read_Excel_File.getRowCount(fileName, "LoginTestData");
		int totalnoColumn=Read_Excel_File.getColCount(fileName, "LoginTestData");
		
		String data[][]=new String[totalnoRow-1][totalnoColumn];
		
		for(int i=1;i<totalnoRow;i++) {
			for(int j=0;j<totalnoColumn;j++) {
				
				data[i-1][j]=Read_Excel_File.getCellValue(fileName, "LoginTestData", i, j);
				
			}
			
		}
		return data;
	}
}
