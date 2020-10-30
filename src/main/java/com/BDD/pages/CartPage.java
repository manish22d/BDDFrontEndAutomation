package com.BDD.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BDD.testBase.TestBase;

public class CartPage extends TestBase {

	@FindBy(xpath = "//*[@class='grid-x']//a/h3")
	List<WebElement> productList;

	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	public List<String> getListOfProductInCart() {
		return productList.stream().map(product -> product.getText()).collect(Collectors.toList());
	}
}
