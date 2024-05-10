package cucumberStepDefinition;

import java.io.IOException;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import pageObjects.LogInPage;
import pageObjects.PepperFryHomePage;
import utilities.ExcelUtilities;

public class TC01_VerifyLoginFunctionality {

	@Given("user is on ShoppersStop.com website")
	public void user_is_on_shoppers_stop_com_website() throws IOException {
		System.out.println(BaseClass.getDriver().getTitle());
		if(BaseClass.getDriver().getTitle().equals("Online Furniture Shopping Store: Shop Online in India for Furniture, Home Decor, Homeware Products @ Pepperfry")) {
			System.out.println("Correct website is Launched");
			BaseClass.getLogger().info("----Correct Website Launched Successfully----");
			ExcelUtilities.write("Cucumber", 1, "Correct Website Launched Successfully");
		} else {
			System.out.println("Incorrect Website is Launched");
			BaseClass.getLogger().info("----incorrect website launched----");
			System.exit(0);
			BaseClass.getDriver().quit();
		}
	}
	
	@And("verifying the logo of webpage")
	public void verifying_the_logo_of_webpage() throws IOException {
		PepperFryHomePage PFHP = new PepperFryHomePage(BaseClass.getDriver());
		if(PFHP.pageLogo()==true) {
			System.out.println("Pepperfry Logo is Displayed");
			BaseClass.getLogger().info("----Pepperfry Logo is Displayed----");
			ExcelUtilities.write("Cucumber", 2, "Pepperfry Logo is Displayed");
		} else {
			System.out.println("Pepperfry logo is not Displayed");
		}
	}
	
	@When("Navigating to login page")
	public void navigating_to_login_page() throws InterruptedException, IOException {
		PepperFryHomePage PFHP = new PepperFryHomePage(BaseClass.getDriver());
		PFHP.signinoption();
		PFHP.OpenLoginPage();
		System.out.println("Login Page opened successfully");
		BaseClass.getLogger().info("----Login Page opened successfully----");
		ExcelUtilities.write("Cucumber", 3, "Login Page opened successfully");
	}
	
	@When("Entering MailId as input")
	public void entering_mail_id_as_input() throws IOException {
		BaseClass.getDriver().switchTo().activeElement();
		LogInPage LP = new LogInPage(BaseClass.getDriver());
		Hooks HS = new Hooks();
		LP.EnterUserDetail(HS.getUsername());
		System.out.println("Username entered Successfully");
		BaseClass.getLogger().info("----Username entered Successfully----");
		ExcelUtilities.write("Cucumber", 4, "Username entered Successfully");
	}
	
	@Then("Clicking on continue at mailId input page")
	public void click_on_continue_at_mailId_input_page() throws IOException {
		LogInPage LP = new LogInPage(BaseClass.getDriver());
		LP.Submit();
		System.out.println("Clicked on continue successfully");
		BaseClass.getLogger().info("----Clicked on continue successfully----");
		ExcelUtilities.write("Cucumber", 5, "Clicked on continue successfully");
	}
	
	@Then("Entering otp received at mail")
	public void Entering_otp_received_at_mail() throws InterruptedException, IOException {
		LogInPage LP = new LogInPage(BaseClass.getDriver());
		Thread.sleep(30000);
		LP.Submit();
		System.out.println("OTP entered successfully");
		BaseClass.getLogger().info("----OTP entered successfully----");
		ExcelUtilities.write("Cucumber", 6, "OTP entered successfully");
	}
	
	@Then("Verifying Log In")
	public void Verifying_Log_in() throws IOException {
		PepperFryHomePage PFHP = new PepperFryHomePage(BaseClass.getDriver());
		PFHP.VerifyLogin();
		System.out.println("Logged in to website successfully");
		BaseClass.getLogger().info("----Logged in to website successfully----");
		ExcelUtilities.write("Cucumber", 7, "Logged in to website successfully");
	}
	
}
