package testNGTestCases;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.ProductPage;
import pageObjects.WishListPage;

public class TC04_VerifyWishListFunctionality {

	String nameInProductPage;
	String nameInWishListPage;
	
	@Test(priority = 12)
	public void Clicking_on_wishlist_icon_of_the_product() throws Exception {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		nameInProductPage = PP.productName();
		JavascriptExecutor JS = (JavascriptExecutor)BaseClass.getDriver();
		JS.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(500);
		PP.addtoWishList();
	}
	
	@Test(priority = 13)
	public void Clicking_on_wishlist_icon() throws InterruptedException {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		JavascriptExecutor JS = (JavascriptExecutor)BaseClass.getDriver();
		JS.executeScript("window.scrollBy(0,-250)", "");
		Thread.sleep(500);
		PP.navigateToWishlist();
	}
	
	@Test(priority = 14)
	public void Verify_the_product_added_to_wishlist() {
		WishListPage WP = new WishListPage(BaseClass.getDriver());
		nameInWishListPage = WP.productname();
		Assert.assertEquals("Correct product added to wishlist", nameInProductPage, nameInWishListPage);
	}
	
	@Test(priority = 15)
	public void remove_the_product_from_wishlist() {
		WishListPage WP = new WishListPage(BaseClass.getDriver());
		WP.removeProductFromWishlist();
		BaseClass.getDriver().navigate().back();
	}
}
