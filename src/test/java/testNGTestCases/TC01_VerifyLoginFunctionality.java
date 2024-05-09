package testNGTestCases;

import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.LogInPage;
import pageObjects.PepperFryHomePage;
import utilities.InputDataValues;

public class TC01_VerifyLoginFunctionality extends Setup {

	@Test(priority = 1)
	public void user_is_on_shoppers_stop_com_website() {
		System.out.println(BaseClass.getDriver().getTitle());
		if(BaseClass.getDriver().getTitle().equals("Online Furniture Shopping Store: Shop Online in India for Furniture, Home Decor, Homeware Products @ Pepperfry")) {
			System.out.println("Correct website is Launched");
			BaseClass.getLogger().info("----Correct Website Launched Successfully----");
		} else {
			System.out.println("Incorrect Website is Launched");
			BaseClass.getLogger().info("----incorrect website launched----");
			System.exit(0);
			BaseClass.getDriver().quit();
		}
	}
	
	@Test(priority = 2)
	public void verifying_the_logo_of_webpage() {
		PepperFryHomePage SSHP = new PepperFryHomePage(BaseClass.getDriver());
		if(SSHP.pageLogo()==true) {
			System.out.println("Pepperfry Logo is Displayed");
			BaseClass.getLogger().info("----Successfully clicked on the Page Logo----");
		} else {
			System.out.println("Pepperfry logo is not Displayed");
		}
	}
	
	@Test(priority = 3)
	public void navigating_to_login_page() throws InterruptedException {
		PepperFryHomePage SSHP = new PepperFryHomePage(BaseClass.getDriver());
		SSHP.signinoption();
		SSHP.OpenLoginPage();
		
	}
	
	@Test(priority = 4)
	public void entering_mail_id_as_input() {
		BaseClass.getDriver().switchTo().activeElement();
		LogInPage LP = new LogInPage(BaseClass.getDriver());
		InputDataValues IDV = new InputDataValues();
		LP.EnterUserDetail(IDV.getUsername());
	}
	
	@Test(priority = 5)
	public void click_on_continue_at_mailId_input_page() {
		LogInPage LP = new LogInPage(BaseClass.getDriver());
		LP.Submit();
	}
	
	@Test(priority = 6)
	public void Entering_otp_received_at_mail() throws InterruptedException {
		LogInPage LP = new LogInPage(BaseClass.getDriver());
		Thread.sleep(30000);
		LP.Submit();
	}
	
}
