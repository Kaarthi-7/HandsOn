package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage{
	WebDriver Driver;
	public WishListPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h4[@class='item-name text-truncate']")
	WebElement productName;
	
	@FindBy(xpath = "//a[@class='ck-oc-slider-card-atw-link active']")
	WebElement RemoveFromWishList;
	
	@FindBy(xpath = "//div[@class='wishlistContainer']/div/div[2]/div/h4[2]")
	WebElement emptyMsg;
	
	public String productname() {
		return productName.getText();
	}
	
	public void removeProductFromWishlist() {
		RemoveFromWishList.click();
	}
	
	public String message() {
		return emptyMsg.getText();
	}
}
