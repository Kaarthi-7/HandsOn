package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDescriptionPage extends BasePage{
		WebDriver Driver;
		public ProductDescriptionPage(WebDriver driver) {
			super(driver);
		}
	
	@FindBy(xpath = "(//pf-button[@class='addtocat-btn']/button)[2]")
	WebElement AddtoCart;

	@FindBy(xpath = "//div[@class='hd-cart-wrap hd-icon-cta active-cta']")
	WebElement cart;
	
	@FindBy(xpath = "//div[@class='vip-product-info-container ng-star-inserted']/div/div/h1")
	WebElement productName;
	
	public void AddingtoCart() {
		AddtoCart.click();
	}
	
	public void NavigateToCart() {
		cart.click();
	}
	
	public String productName() {
		return productName.getText();
	}
}
