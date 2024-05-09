package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage{
	WebDriver Driver;
	public LogInPage(WebDriver driver) {
		super(driver);
	}	
	
	@FindBy(xpath = "//input[@placeholder='Enter Mobile Number or Email Id']")
	WebElement EmailInput;

	
	@FindBy(xpath = "//error-message[@class='input-error-text']")
	WebElement credentialError;
	
	@FindBy(xpath = "(//button[@id='Button'])[2]")
	WebElement Submit;

	@FindBy(xpath = "//input[@placeholder='Enter OTP Received on Your Email ID']")
	WebElement OTP;
	
	public void EnterUserDetail(String Usermail) {
		EmailInput.sendKeys(Usermail);
	}

	public String credential() {
		return credentialError.getText();
	}
	
	public void Submit() {
		Submit.click();
	}
	
//	public void OTP() {
//		FluentWait wait = new FluentWait(BaseClass.getDriver());
//		wait.withTimeout(5, TimeUnit.MINUTES);
//		wait.pollingEvery(15, TimeUnit.SECONDS);
//		wait.
//	}
	
}
