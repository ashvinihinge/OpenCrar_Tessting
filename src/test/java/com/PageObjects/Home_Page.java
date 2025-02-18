package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class Home_Page extends BasePage {

	public Home_Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	WebElement myAccountLink;

	@FindBy(xpath = "//a[(normalize-space()='Register')]")
	WebElement registerLink;

	@FindBy(xpath = "//a[(normalize-space()='Login')]")
	WebElement LoginLink;

	// Action On Web Element

	// Click on My Account link

	public void clickOnMyAccountLink() {
		myAccountLink.click();
	}

	public void clickOnRegisterLink() {
		registerLink.click();
		// Actions act=new Actions(driver);
		// act.moveToElement(registerLink).click().perform();
	}

	public void clickLoginLink() {
		LoginLink.click();
	}

}
