
package com.TestCase;

//import java.io.IOException;

import org.testng.Assert;

//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.Utility_Package.Read_Excel_File;
import com.PageObjects.Home_Page;
import com.PageObjects.Login_Page;
import com.PageObjects.MyAccount_Page;
import com.Utility_Package.TestDataProvider;;

public class TC003_LoginTestDataDrivenTest extends Base_Test_Cases_Class {

	@Test(dataProvider = "LoginDataProvider",dataProviderClass = TestDataProvider.class,groups = "DataDrivenGroups")

	public void verifyLoginOrNotDataDrivenTest(String email, String pwd, String exp) {

		logger.info("********* Strating TC003 Login Test Data Driven Test ******** ");

		// Home Page
		logger.info("Go To Home Page");
		Home_Page homepage = new Home_Page(driver);
		homepage.clickOnMyAccountLink();
		homepage.clickLoginLink();
		logger.info("Click on login Link");

		// Login Page
		Login_Page loginpage = new Login_Page(driver);

		loginpage.enterEmailAddress(email);
		logger.info("Enter Email Address ");

		loginpage.enterPassword(pwd);
		logger.info("Enter Password");

		loginpage.clickOnLoginButton();
		logger.info("Click on login Button");

		// My Account Page
		MyAccount_Page myAccountPage = new MyAccount_Page(driver);
		boolean targetPage = myAccountPage.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetPage==true) {
				myAccountPage.clickOnLogOut();
				Assert.assertTrue(true);
				}
			else {
				Assert.assertTrue(false);
			}
			
			if(exp.equalsIgnoreCase("InValid")) {
				if(targetPage==true) {
					myAccountPage.clickOnLogOut();
					Assert.assertTrue(false);
					
				}
				else {
					Assert.assertTrue(true);
				}
			
		}
	}
	}
	
	/*
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
	*/
	}
