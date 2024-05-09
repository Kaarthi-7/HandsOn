package testNGTestCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.CartPage;
import pageObjects.ProductDescriptionPage;
import pageObjects.ProductPage;
import utilities.WindowHandle;

public class TC05_VerifyCartFunctionality {

	public String productNameInProductPage;
	public String productNameInCartPage;
	
	@Test(priority = 16)
	public void Clicking_on_the_product() {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		productNameInProductPage = PP.productName();
		PP.selectingProduct();
	}
	
	@Test(priority = 17)
	public void add_product_to_cart() throws InterruptedException {
		WindowHandle WH = new WindowHandle();
		ProductDescriptionPage PDP = new ProductDescriptionPage(BaseClass.getDriver());
		WH.windowHandling();
		Thread.sleep(5000);
		PDP.AddingtoCart();
	}
	
	@Test(priority = 18)
	public void Clicking_on_cart_icon() {
		ProductDescriptionPage PDP = new ProductDescriptionPage(BaseClass.getDriver());
		PDP.NavigateToCart();
	}
	
	@Test(priority = 19)
	public void verify_the_product_added_to_cart() {
		CartPage CP = new CartPage(BaseClass.getDriver());
		productNameInCartPage = CP.productName();
		Assert.assertEquals("Correct product added to cart", productNameInProductPage, productNameInCartPage);
	}
	
	@Test(priority = 20)
	public void remove_the_product_from_cart() {
		CartPage CP = new CartPage(BaseClass.getDriver());
		CP.removeProductFromCart();
		CP.removeConfirmation();
	}
}
