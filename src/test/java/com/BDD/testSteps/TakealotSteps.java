package com.BDD.testSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

import com.BDD.pages.CartPage;
import com.BDD.pages.HomePage;
import com.BDD.pages.RegisterPage;
import com.BDD.pages.SearchResultPage;
import com.BDD.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TakealotSteps extends TestBase {

	HomePage homePage;
	RegisterPage registerPage;
	SearchResultPage searchPage;
	CartPage cartPage;

	@Given("^I want to navigate to \"([^\"]*)\"$")
	public void i_want_to_navigate_to(String url) throws Throwable {
		initialization();
		driver.get(url);
		homePage = new HomePage();
	}

	@Given("^I navigate to registration page$")
	public void i_navigate_to_option() throws Throwable {
		registerPage = homePage.navigateToRegisterPage();
	}

	@When("^I filled user data to registration$")
	public void i_filled_user_data_to_registration(List<String> userData) {
		registerPage.fillRegistrationForm(userData);
	}

	@Then("^Verify user is registered$")
	public void clicked_on_product() {

	}

	@Given("^I want to search for \"([^\"]*)\"$")
	public void i_want_to_search_for(String searchKey) {
//		driver.findElement(By.linkText("TAKEALOT")).click();
		searchPage = homePage.search(searchKey);
	}

	@Given("^I want to select brand \"([^\"]*)\"$")
	public void i_want_to_select_brand(String brandName) {
		searchPage.selectBrand(brandName);
	}

	@When("^I add watches in my cart$")
	public void i_add_watches_in_my_cart(List<String> productName) {
		productName.forEach(product -> searchPage.addProductToCart(product));
	}

	@Then("^Verify given products added to my cart$")
	public void verify_given_products_added_to_my_cart(List<String> productName) {
		cartPage = searchPage.navigateToCartPage();
		assertThat(productName, is(equalTo(cartPage.getListOfProductInCart())));
	}

}
