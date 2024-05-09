package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;

public class CartPage extends BasePage {
	WebDriver Driver;
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@data-test='productDel']/pf-button/button")
	WebElement removeFromCart;
	
	@FindBy(xpath = "//div[@class='ck-product-card-wrapper']/div[2]/div/a/h3")
	WebElement productName;
	
	@FindBy(id = "ck-card-remove-move-wishlist")
	WebElement removeconfirmation;
	
	public String productName() {
		return productName.getText();
	}
	
	public void removeProductFromCart() {
		removeFromCart.click();
		
	}
	
	public void removeConfirmation() {
		BaseClass.getDriver().switchTo().activeElement();
		removeconfirmation.click();
	}
}
