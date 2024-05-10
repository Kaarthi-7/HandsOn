package testNGTestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.ProductPage;
import pageObjects.WishListPage;
import utilities.ExcelUtilities;

public class TC04_VerifyWishListFunctionality {

	String nameInProductPage;
	String nameInWishListPage;
	
	@Test(priority = 14)
	public void Clicking_on_wishlist_icon_of_the_product() throws Exception {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		nameInProductPage = PP.productName();
		JavascriptExecutor JS = (JavascriptExecutor)BaseClass.getDriver();
		JS.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(500);
		PP.addtoWishList();
		System.out.println("product added to wishlist successfully");
		BaseClass.getLogger().info("----product added to wishlist successfully----");
		ExcelUtilities.write("TestNG", 14, "product added to wishlist successfully");
	}
	
	@Test(priority = 15)
	public void Clicking_on_wishlist_icon() throws InterruptedException, IOException {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		JavascriptExecutor JS = (JavascriptExecutor)BaseClass.getDriver();
		JS.executeScript("window.scrollBy(0,-250)", "");
		Thread.sleep(500);
		PP.navigateToWishlist();
		System.out.println("navigated to wishlist successfully");
		BaseClass.getLogger().info("----navigated to wishlist successfully----");
		ExcelUtilities.write("TestNG", 15, "navigated to wishlist successfully");
	}
	
	@Test(priority = 16)
	public void Verify_the_product_added_to_wishlist() throws IOException {
		WishListPage WP = new WishListPage(BaseClass.getDriver());
		nameInWishListPage = WP.productname();
		Assert.assertEquals("Correct product added to wishlist", nameInProductPage, nameInWishListPage);
		System.out.println("product added to wishlist verified successfully");
		BaseClass.getLogger().info("----product added to wishlist verified successfully----");
		ExcelUtilities.write("TestNG", 16, "product added to wishlist verified successfully");
	}
	
	@Test(priority = 17)
	public void remove_the_product_from_wishlist() throws IOException {
		WishListPage WP = new WishListPage(BaseClass.getDriver());
		WP.removeProductFromWishlist();
		BaseClass.getDriver().navigate().back();
		System.out.println("product removed from wishlist successfully");
		BaseClass.getLogger().info("----product removed from wishlist successfully----");
		ExcelUtilities.write("TestNG", 17, "product removed from wishlist successfully");
	}
	
	@Test(priority = 18)
	public void Verify_wishlist_remove() throws IOException {
		WishListPage WP = new WishListPage(BaseClass.getDriver());
		String message = WP.message();
		Assert.assertEquals("product removed from Wishlist", "Your wishlist is empty", message);
		System.out.println("verified the product removed from wishlist");
		BaseClass.getLogger().info("----verified the product removed from wishlist----");
		ExcelUtilities.write("TestNG", 18, "verified the product removed from wishlist");
	}
}
