package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page extends BasePage {

	public Login_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement emailAddress;

	@FindBy(xpath ="//input[@id='input-password']")
	WebElement password;

	@FindBy(xpath ="//input[@value='Login']")
	WebElement loginButton;

	public void enterEmailAddress(String eamil) {
		emailAddress.sendKeys(eamil);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}

}
