package com.BDD.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BDD.Constant.Constants;
import com.BDD.testBase.TestBase;

public class SearchResultPage extends TestBase {

	@FindBy(xpath = "//*[@class='cell small-3']//a/h4/span/span[1]")
	List<WebElement> productList;

	@FindBy(xpath = "//*[@class='filter-facet-module_filter-item_3bvm8']//span")
	List<WebElement> brandList;

	@FindBy(xpath = "//*[@id='idProduct']/../following-sibling::button")
	WebElement addToCard;

	@FindBy(xpath = "//*[@class='mini-cart mini-cart-module_mini-cart_3_CNC']")
	WebElement cartButton;

	@FindBy(xpath = "//button[contains(text(),'Load More')]")
	WebElement loadMoreButton;

	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}

	public void selectBrand(String brand) {
		new WebDriverWait(driver, Constants.EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(brandList.get(0)));
		driver.findElement(By.id("_undefined")).sendKeys(brand);
		for (int i = 0; i < productList.size(); i++) {
			System.out.println(brandList.get(i).getText());
			if (brandList.get(i).getText().equals(brand)) {
				brandList.get(i).click();
				break;
			}
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addProductToCart(String productName) {
		new WebDriverWait(driver, Constants.EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(productList.get(0)));
		for (int i = 0; i < productList.size(); i++) {
			System.out.println(productList.get(i).getText() + " " + productName);
			if (productList.get(i).getText().equals(productName)) {
				Actions act = new Actions(driver);
				act.moveToElement(productList.get(i)).click().build().perform();
				break;
			}
		}
		new WebDriverWait(driver, Constants.EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(addToCard));
		addToCard.click();
		driver.navigate().back();
	}

	public CartPage navigateToCartPage() {
		cartButton.click();
		return new CartPage();
	}

	public void loadMoreProducts() {
		new WebDriverWait(driver, Constants.EXPLICIT_WAIT)
				.until(ExpectedConditions.elementToBeClickable(loadMoreButton));
		loadMoreButton.click();
	}
}
