package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount_Page extends BasePage {

	public MyAccount_Page(WebDriver driver) {
		super(driver);
	}

	// Web Element On My Account Page:

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement MsgHeading;

	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement logOut;

	// Method On My Account Page

	public boolean isMyAccountPageExists() {
		try {
			return (MsgHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnLogOut() {
		logOut.click();
	}

}
