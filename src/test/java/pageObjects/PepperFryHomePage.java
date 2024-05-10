package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PepperFryHomePage extends BasePage {
	WebDriver Driver;
	public PepperFryHomePage(WebDriver driver) {
		super(driver);
	}	
	
	//Elements
	@FindBy(xpath = "//a[@class='pf-logo']")
	WebElement PepperFryLogo;

	@FindBy(xpath = "//div[@class='wrap-text-icon']")
	WebElement Signin;
	
	@FindBy(id = "Button")
	WebElement login;
	
	@FindBy(id = "search")
	WebElement SearchInput;
	
	@FindBy(xpath = "//div[@class='hd-loggedIn-state']/div/div")
	WebElement username;
	
	public boolean pageLogo() {
		return PepperFryLogo.isDisplayed();
	}
	
	public void signinoption() {
		Signin.click();
	}
	
	public void OpenLoginPage() {
		login.click();
	}
	
	public void SearchInput(String SearchKeyword) {
		SearchInput.sendKeys(SearchKeyword);
	}
	
	public void searchproduct() {
		SearchInput.sendKeys(Keys.ENTER);
	}
	
	public void VerifyLogin() {
		String usernameText = username.getText();
		if(usernameText.contains("Hi,")) {
			System.out.println("Logged In Successfully");
		}
	}
}