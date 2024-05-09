package cucumberStepDefinition;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProductPage;
import pageObjects.WishListPage;

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
	}
	
	@When("Clicking on wishlist icon")
	public void Clicking_on_wishlist_icon() throws InterruptedException {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		JavascriptExecutor JS = (JavascriptExecutor)BaseClass.getDriver();
		JS.executeScript("window.scrollBy(0,-250)", "");
		Thread.sleep(500);
		PP.navigateToWishlist();
	}
	
	@Then("Verify the product added to wishlist")
	public void Verify_the_product_added_to_wishlist() {
		WishListPage WP = new WishListPage(BaseClass.getDriver());
		nameInWishListPage = WP.productname();
		Assert.assertEquals("Correct product added to wishlist", nameInProductPage, nameInWishListPage);
	}
	
	@Then("remove the product from wishlist")
	public void remove_the_product_from_wishlist() {
		WishListPage WP = new WishListPage(BaseClass.getDriver());
		WP.removeProductFromWishlist();
		BaseClass.getDriver().navigate().back();
	}
}
