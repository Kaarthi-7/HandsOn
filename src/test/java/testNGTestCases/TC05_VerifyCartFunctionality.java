package testNGTestCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.CartPage;
import pageObjects.ProductDescriptionPage;
import pageObjects.ProductPage;
import utilities.ExcelUtilities;
import utilities.WindowHandle;

public class TC05_VerifyCartFunctionality {

	public String productNameInProductPage;
	public String productNameInCartPage;
	
	@Test(priority = 19)
	public void Clicking_on_the_product() throws IOException {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		productNameInProductPage = PP.productName();
		PP.selectingProduct();
		System.out.println("clicked on the product successfully");
		BaseClass.getLogger().info("----clicked on the product successfully----");
		ExcelUtilities.write("TestNG", 19, "clicked on the product successfully");
	}
	
	@Test(priority = 20)
	public void add_product_to_cart() throws InterruptedException, IOException {
		WindowHandle WH = new WindowHandle();
		ProductDescriptionPage PDP = new ProductDescriptionPage(BaseClass.getDriver());
		WH.windowHandling();
		Thread.sleep(5000);
		PDP.AddingtoCart();
		System.out.println("product added to cart successfully");
		BaseClass.getLogger().info("----product added to cart successfully----");
		ExcelUtilities.write("TestNG", 20, "product added to cart successfully");
	}
	
	@Test(priority = 21)
	public void Clicking_on_cart_icon() throws IOException {
		ProductDescriptionPage PDP = new ProductDescriptionPage(BaseClass.getDriver());
		PDP.NavigateToCart();
		System.out.println("navigated to cart successfully");
		BaseClass.getLogger().info("----navigated to cart successfully----");
		ExcelUtilities.write("TestNG", 21, "navigated to cart successfully");
	}
	
	@Test(priority = 22)
	public void verify_the_product_added_to_cart() throws IOException {
		CartPage CP = new CartPage(BaseClass.getDriver());
		productNameInCartPage = CP.productName();
		Assert.assertEquals("Correct product added to cart", productNameInProductPage, productNameInCartPage);
		System.out.println("verified the product added to cart successfully");
		BaseClass.getLogger().info("----verified the product added to cart successfully----");
		ExcelUtilities.write("TestNG", 22, "verified the product added to cart successfully");
	}
	
	@Test(priority = 23)
	public void remove_the_product_from_cart() throws IOException {
		CartPage CP = new CartPage(BaseClass.getDriver());
		CP.removeProductFromCart();
		CP.removeConfirmation();
		System.out.println("product removed from the cart successfully");
		BaseClass.getLogger().info("----product removed from the cart successfully----");
		ExcelUtilities.write("TestNG", 23, "product removed from the cart successfully");
	}
	
	@Test(priority = 24)
	public void Verify_product_remove() throws IOException {
		CartPage CP = new CartPage(BaseClass.getDriver());
		String message = CP.empty();
		Assert.assertEquals("product removed from cart", "Your Cart is Empty", message);
		System.out.println("verified the product removed from the cart");
		BaseClass.getLogger().info("----verified the product removed from the cart----");
		ExcelUtilities.write("TestNG", 24, "verified the product removed from the cart");
	}
}
