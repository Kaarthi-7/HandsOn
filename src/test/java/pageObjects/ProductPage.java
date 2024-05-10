package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
	WebDriver Driver;
	public String ProductName;
	public int count = 0;
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='pf-col xs-6 sm-3 clip-product-card-wrapper marginBottom-12 ng-star-inserted']")
	WebElement product;
	
	@FindBy(xpath = "//div[@class='product-price']/span")
	List <WebElement> ProductPrice;
	
	@FindBy(xpath = "//div[@class='product-card-wishlist']")
	WebElement AddtoWishlist;
	
	@FindBy(xpath = "//div[@class='dropdown-btn']")
	WebElement dropdownmenu;
	
	@FindBy(xpath = "//ul[@class='dropdown-list']/li")
	List<WebElement> dropdownoptions;
	
	@FindBy(xpath = "//div[@class='hd-icon-wrapper']/div[3]")
	WebElement wishList;
	
	@FindBy(xpath = "//h3[@class='product-name color-tertiary text-md font-medium ng-star-inserted']")
	WebElement productName;
	
	public void clickOnSort() {
		dropdownmenu.click();
	}
	
	public void sorting(String typeOfSort) {
		for(WebElement sorting : dropdownoptions) {
			if(sorting.getText().equalsIgnoreCase(typeOfSort)) {
				sorting.click();
				break;
			}
		}
	}
	
	public void selectingProduct() {
		product.click();
	}
	
	public void addtoWishList() {
		AddtoWishlist.click();
	}
	
	public void navigateToWishlist() {
		wishList.click();
	}
	
	public String productName() {
		ProductName = productName.getText();
		return ProductName;
	}
	
	public int prodprice() {
		for(int i=0; i<3; i++) {
			String prod1priceString = ProductPrice.get(i).getText().replaceAll("[^0-9]", "");
			String prod2priceString = ProductPrice.get(i+1).getText().replaceAll("[^0-9]", "");
			int prod1price = Integer.parseInt(prod1priceString);
			int prod2price = Integer.parseInt(prod2priceString);
			if(prod1price > prod2price) {
				count++;
			}
		}
		return count;
	}
}
