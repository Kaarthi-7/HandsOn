package cucumberStepDefinition;

import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.ProductDescriptionPage;
import pageObjects.ProductPage;
import utilities.WindowHandle;

public class TC05_VerifyCartFunctionality {

	public String productNameInProductPage;
	public String productNameInCartPage;
	
	@When("Clicking on the product")
	public void Clicking_on_the_product() {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		productNameInProductPage = PP.productName();
		PP.selectingProduct();
	}
	
	@Then("add product to cart")
	public void add_product_to_cart() throws InterruptedException {
		WindowHandle WH = new WindowHandle();
		ProductDescriptionPage PDP = new ProductDescriptionPage(BaseClass.getDriver());
		WH.windowHandling();
		Thread.sleep(5000);
		PDP.AddingtoCart();
	}
	
	@When("Clicking on cart icon")
	public void Clicking_on_cart_icon() {
		ProductDescriptionPage PDP = new ProductDescriptionPage(BaseClass.getDriver());
		PDP.NavigateToCart();
	}
	
	@Then("verify the product added to cart")
	public void verify_the_product_added_to_cart() {
		CartPage CP = new CartPage(BaseClass.getDriver());
		productNameInCartPage = CP.productName();
		Assert.assertEquals("Correct product added to cart", productNameInProductPage, productNameInCartPage);
	}
	
	@Then("remove the product from cart")
	public void remove_the_product_from_cart() {
		CartPage CP = new CartPage(BaseClass.getDriver());
		CP.removeProductFromCart();
		CP.removeConfirmation();
	}
}
