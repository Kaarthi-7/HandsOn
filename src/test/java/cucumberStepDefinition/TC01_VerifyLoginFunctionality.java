package cucumberStepDefinition;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import pageObjects.LogInPage;
import pageObjects.PepperFryHomePage;

public class TC01_VerifyLoginFunctionality {

	@Given("user is on ShoppersStop.com website")
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
	
	@And("verifying the logo of webpage")
	public void verifying_the_logo_of_webpage() {
		PepperFryHomePage SSHP = new PepperFryHomePage(BaseClass.getDriver());
		if(SSHP.pageLogo()==true) {
			System.out.println("Pepperfry Logo is Displayed");
			BaseClass.getLogger().info("----Successfully clicked on the Page Logo----");
		} else {
			System.out.println("Pepperfry logo is not Displayed");
		}
	}
	
	@When("Navigating to login page")
	public void navigating_to_login_page() throws InterruptedException {
		PepperFryHomePage SSHP = new PepperFryHomePage(BaseClass.getDriver());
		SSHP.signinoption();
		SSHP.OpenLoginPage();
		
	}
	
	@When("Entering MailId as input")
	public void entering_mail_id_as_input() {
		BaseClass.getDriver().switchTo().activeElement();
		LogInPage LP = new LogInPage(BaseClass.getDriver());
		Hooks HS = new Hooks();
		LP.EnterUserDetail(HS.getUsername());
	}
	
	@Then("Clicking on continue at mailId input page")
	public void click_on_continue_at_mailId_input_page() {
		LogInPage LP = new LogInPage(BaseClass.getDriver());
		LP.Submit();
	}
	
	@Then("Entering otp received at mail")
	public void Entering_otp_received_at_mail() throws InterruptedException {
		LogInPage LP = new LogInPage(BaseClass.getDriver());
		Thread.sleep(30000);
		LP.Submit();
	}
	
}
