package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterationPage extends BasePage {

	public AccountRegisterationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement fristNameTxt;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastNameTxt;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement emailTxt;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement passwordTxt;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confirmPasswordTxt;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement policy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement containsButton;
	
	@FindBy(xpath ="//h1[contains(text(),'Your Account Has Been Created!')]")
	WebElement confirmarationMsg;

	// Action To Perform
	// Enter First Name

	public void enterFristName(String fname) {
		fristNameTxt.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		lastNameTxt.sendKeys(lname);
	}

	public void enterEmail(String email) {
		emailTxt.sendKeys(email);
	}

	public void enterTelephone(String phone) {
		telephone.sendKeys(phone);
	}

	public void enterPassword(String password) {
		passwordTxt.sendKeys(password);
	}

	public void enterConfirmPassword(String confirmpassword) {
		confirmPasswordTxt.sendKeys(confirmpassword);
	}

	public void setPrivacyPoilcy() {
		policy.click();
	}

	public void clickOnContinueButton() {
		containsButton.click();
	}
	

	public String getCofrimartaionMsg(){
		
		return (confirmarationMsg.getText());
	}
	//  Your Account Has Been Created!
}
