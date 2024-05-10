package cucumberStepDefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProductPage;
import pageObjects.WishListPage;
import utilities.ExcelUtilities;

public class TC04_VerifyWishListFunctionality {

	String nameInProductPage;
	String nameInWishListPage;
	
	@When("Clicking on wishlist icon of the product")
	public void Clicking_on_wishlist_icon_of_the_product() throws Exception {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		nameInProductPage = PP.productName();
		JavascriptExecutor JS = (JavascriptExecutor)BaseClass.getDriver();
		JS.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(500);
		PP.addtoWishList();
		System.out.println("product added to wishlist successfully");
		BaseClass.getLogger().info("----product added to wishlist successfully----");
		ExcelUtilities.write("Cucumber", 14, "product added to wishlist successfully");
	}
	
	@When("Clicking on wishlist icon")
	public void Clicking_on_wishlist_icon() throws InterruptedException, IOException {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		JavascriptExecutor JS = (JavascriptExecutor)BaseClass.getDriver();
		JS.executeScript("window.scrollBy(0,-250)", "");
		Thread.sleep(500);
		PP.navigateToWishlist();
		System.out.println("navigated to wishlist successfully");
		BaseClass.getLogger().info("----navigated to wishlist successfully----");
		ExcelUtilities.write("Cucumber", 15, "navigated to wishlist successfully");
	}
	
	@Then("Verify the product added to wishlist")
	public void Verify_the_product_added_to_wishlist() throws IOException {
		WishListPage WP = new WishListPage(BaseClass.getDriver());
		nameInWishListPage = WP.productname();
		Assert.assertEquals("Correct product added to wishlist", nameInProductPage, nameInWishListPage);
		System.out.println("product added to wishlist verified successfully");
		BaseClass.getLogger().info("----product added to wishlist verified successfully----");
		ExcelUtilities.write("Cucumber", 16, "product added to wishlist verified successfully");
	}
	
	@Then("remove the product from wishlist")
	public void remove_the_product_from_wishlist() throws IOException {
		WishListPage WP = new WishListPage(BaseClass.getDriver());
		WP.removeProductFromWishlist();
		BaseClass.getDriver().navigate().back();
		System.out.println("product removed from wishlist successfully");
		BaseClass.getLogger().info("----product removed from wishlist successfully----");
		ExcelUtilities.write("Cucumber", 17, "product removed from wishlist successfully");
	}
	
	@Then("Verify wishlist remove")
	public void Verify_wishlist_remove() throws IOException {
		WishListPage WP = new WishListPage(BaseClass.getDriver());
		String message = WP.message();
		Assert.assertEquals("product removed from Wishlist", "Your wishlist is empty", message);
		System.out.println("verified the product removed from wishlist");
		BaseClass.getLogger().info("----verified the product removed from wishlist----");
		ExcelUtilities.write("Cucumber", 18, "verified the product removed from wishlist");
	}
}
