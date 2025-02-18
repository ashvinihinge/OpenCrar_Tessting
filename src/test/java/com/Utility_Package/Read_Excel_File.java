package com.Utility_Package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel_File {

	public static FileInputStream file;
	public static XSSFWorkbook workBook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public  static String getCellValue(String fileName,String sheetName ,int rowNo, int columnNo) throws IOException {
		
		try {
			file=new FileInputStream(fileName);
			workBook=new XSSFWorkbook(file);
			sheet=workBook.getSheet(sheetName);
			cell=workBook.getSheet(sheetName).getRow(rowNo).getCell(columnNo);
			
				workBook.close();
			return cell.getStringCellValue();
		} 
		catch (Exception e) {
			return " ";
		}
	}
	
	
	public static int getRowCount(String fileName,String sheetName ) {
		
		try {
			
			file=new FileInputStream(fileName);
			workBook=new XSSFWorkbook(file);
			sheet=workBook.getSheet(sheetName);
			
			// Get Total Number of Row
			int totalnoRow=sheet.getLastRowNum() +1;
			
			workBook.close();
			return totalnoRow;
		}
		catch (Exception e) {
			return 0;
		}
	}
	
	public static int getColCount(String fileName,String sheetName) {
		
		try {
			FileInputStream file=new FileInputStream(fileName);
			XSSFWorkbook workBook=new XSSFWorkbook(file);
			XSSFSheet sheet=workBook.getSheet(sheetName);
			
			// Get Total number of column:			
			int totalNoColumn=sheet.getRow(0).getLastCellNum();
			
			workBook.close();
			return totalNoColumn;
			
		} catch (Exception e) {
			
			return 0;
		}
	}
}

