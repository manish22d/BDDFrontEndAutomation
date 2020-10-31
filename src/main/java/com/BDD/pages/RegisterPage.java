package com.BDD.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BDD.Constant.Constants;
import com.BDD.testBase.TestBase;

public class RegisterPage extends TestBase {

	@FindBy(id = "firstname")
	WebElement fristName;

	@FindBy(id = "surname")
	WebElement surname;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "email2")
	WebElement retypeEmail;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "password2")
	WebElement retypePassword;

	@FindBy(id = "telno1")
	WebElement mobileNumber;

	@FindBy(name = "registerButton")
	WebElement registerButton;
	
	@FindBy(xpath="//*[@id='welcome']/h3")
	WebElement welcomeMsg;

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public void fillRegistrationForm(List<String> userData) {
		new WebDriverWait(driver, Constants.EXPLICIT_WAIT).until(ExpectedConditions.elementToBeClickable(fristName));

		fristName.sendKeys(userData.get(0));
		surname.sendKeys(userData.get(1));
		email.sendKeys(userData.get(2));
		retypeEmail.sendKeys(userData.get(2));
		password.sendKeys(userData.get(3));
		retypePassword.sendKeys(userData.get(3));
		mobileNumber.sendKeys(userData.get(4));
		registerButton.click();
	}

	public String getSuccessMsg() {
		return welcomeMsg.getText();
	}
}
