package com.BDD.testSteps;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BDD.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class ShopCluesSteps extends TestBase {

	@Given("^I want to navigate to \"([^\"]*)\"$")
	public void i_want_to_navigate_to(String url) throws Throwable {
		initialization();
		driver.get(url);
	}

	@When("^Close allow notification pop-up$")
	public void close_allow_notification_popup() {

		WebElement dontAllowNotification = driver.findElement(By.xpath("//div[@class='moe-button-wrapper']/button[1]"));
		new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(dontAllowNotification));
		dontAllowNotification.click();
	}

	@Given("^I navigate to \"([^\"]*)\" option$")
	public void i_navigate_to_option(String productCategory) throws Throwable {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(
				By.xpath("//div[@class='main_navigation']//a[contains(text(),'" + productCategory + "')]"))).build()
				.perform();
	}

	@Given("^clicked on \"([^\"]*)\" product$")
	public void clicked_on_product(String product) throws Throwable {

		new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.xpath("//div[@class='ul_menu_block']//a[contains(text(),'" + product + "')]"))));

		driver.findElement(By.xpath("//div[@class='ul_menu_block']//a[contains(text(),'" + product + "')]")).click();
	}

	@When("^i clicked on frist product$")
	public void i_click_on_frist_product() throws Throwable {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
		WebElement fristResult = driver
				.findElement(By.xpath("//div[@id='product_list']/div[@class='row'][1]/div[1]/a[2]"));
		new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(fristResult));
		fristResult.click();
	}

	@When("^Click on add to cart button$")
	public void click_on_add_to_cart_button() throws Throwable {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size() - 1));
		driver.findElement(By.id("add_cart")).click();
	}

	@Then("^verify that correct message is displayed$")
	public void verify_that_correct_message_is_displayed(List<String> msg) throws Throwable {
		WebElement notification = driver.findElement(By.xpath("//div[@id='snackbar']"));
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(notification));

		Assert.assertEquals(msg.get(0), notification.getText());
	}

}
