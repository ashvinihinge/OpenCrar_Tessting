package com.TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjects.AccountRegisterationPage;
import com.PageObjects.Home_Page;

public class TC001_Account_RegistrationTest extends Base_Test_Cases_Class {

	/*@Test(groups ={"Regression","Master"})
	public void verify_Account_Registraion() {

		Home_Page homepage = new Home_Page(driver);
		homepage.clickOnMyAccountLink();
		homepage.clickOnRegisterLink();

		AccountRegisterationPage accRegisterPage = new AccountRegisterationPage(driver);
		accRegisterPage.enterFristName("Ashwini");
		accRegisterPage.enterLastName("Hinge");
		accRegisterPage.enterEmail("ash123@gmail.com");
		accRegisterPage.enterTelephone("1245678");
		accRegisterPage.enterPassword("abc@123");
		accRegisterPage.enterConfirmPassword("abc@123");
		accRegisterPage.setPrivacyPoilcy();
		accRegisterPage.clickOnContinueButton();

		// Confirmation message Store in
		String confMsg = accRegisterPage.getCofrimartaionMsg();

		Assert.assertEquals(confMsg, "Your Account Has Been Created!");

	}
	*/

	@Test

	public void verify_Account_RegistraionUsingRandomData() {

		logger.info("********* Strating TC001_Account_RegistrationTest ******** ");
		
		Home_Page homepage = new Home_Page(driver);
		homepage.clickOnMyAccountLink();
		logger.info("Clicked On My Account Link");
		
		homepage.clickOnRegisterLink();
		logger.info("Clicked On My Account Link");
		
		AccountRegisterationPage accRegisterPage = new AccountRegisterationPage(driver);
		
		logger.info("Providing Customer Details");
		accRegisterPage.enterFristName(randomString().toUpperCase());
		accRegisterPage.enterLastName(randomString().toUpperCase());
		accRegisterPage.enterEmail(randomString().toLowerCase()+"@gmail.com");
		accRegisterPage.enterTelephone(randomNumber());
		
		String password=randomAlphaNumberic();
		
		accRegisterPage.enterPassword(password);
		accRegisterPage.enterConfirmPassword(password);
		accRegisterPage.setPrivacyPoilcy();
		
		
		accRegisterPage.clickOnContinueButton();
		logger.info("Clicked On Continue Button");
		
		logger.info("Validating expected message Details");
		// Confirmation message Store in
		String confMsg = accRegisterPage.getCofrimartaionMsg();

		Assert.assertEquals(confMsg, "Your Account Has Been Created!");

		logger.info("********* Finished TC001_Account_RegistrationTest ******** ");
	}

	

}
