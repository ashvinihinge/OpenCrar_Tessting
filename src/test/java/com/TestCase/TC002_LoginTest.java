package com.TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjects.Home_Page;
import com.PageObjects.Login_Page;
import com.PageObjects.MyAccount_Page;

public class TC002_LoginTest extends Base_Test_Cases_Class {

	@Test(groups = {"Sanity","Master"})
	public void verifyLoginOrNot() {

		logger.info("********* Strating TC002 Login Test ******** ");

		try {
			// Home Page
			logger.info("Go To Home Page");
			Home_Page homepage = new Home_Page(driver);
			homepage.clickOnMyAccountLink();
			homepage.clickLoginLink();
			logger.info("Click on login Link");

			// Login Page
			Login_Page loginpage = new Login_Page(driver);
			loginpage.enterEmailAddress(prop.getProperty("email"));
			logger.info("Enter Email Address ");

			loginpage.enterPassword(prop.getProperty("password"));
			logger.info("Enter Password");

			loginpage.clickOnLoginButton();
			logger.info("Click on login Button");

			// My Account Page
			MyAccount_Page myAccountPage = new MyAccount_Page(driver);
			boolean targetPage = myAccountPage.isMyAccountPageExists();

			// Assert.assertEquals(targetPage, true,"Login Failed");

			Assert.assertTrue(targetPage);

		} catch (Exception e) {
			Assert.fail();
		}
		/*
		//The Below Is One of Assertion To Get Title:
		String myAccountPageTitle=driver.getTitle();
		Assert.assertEquals(myAccountPageTitle, "My Account");
		}
		catch (Exception e) {
			Assert.fail();
		}
		*/
		
		
		logger.info("********* Finished  TC002 Login Test ******** ");
	}
	
}
