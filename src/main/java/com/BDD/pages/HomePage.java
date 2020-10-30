package com.BDD.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BDD.Constant.Constants;
import com.BDD.testBase.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(partialLinkText = "Register")
	WebElement registerLink;
	
	@FindBy(name = "search")
	WebElement searchBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButton;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public RegisterPage navigateToRegisterPage() {
		new WebDriverWait(driver, Constants.EXPLICIT_WAIT).until(ExpectedConditions.elementToBeClickable(registerLink));
		registerLink.click();
		return new RegisterPage();
	}

	public SearchResultPage search(String searchKey) {
		new WebDriverWait(driver, Constants.EXPLICIT_WAIT).until(ExpectedConditions.elementToBeClickable(searchBox));
		searchBox.sendKeys(searchKey);
		searchButton.click();
		return new SearchResultPage();
	}

}
