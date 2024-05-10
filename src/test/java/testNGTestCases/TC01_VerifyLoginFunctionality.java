package testNGTestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.LogInPage;
import pageObjects.PepperFryHomePage;
import utilities.ExcelUtilities;
import utilities.InputDataValues;

public class TC01_VerifyLoginFunctionality {

	@Test(priority = 1)
	public void user_is_on_shoppers_stop_com_website() throws IOException {
		System.out.println(BaseClass.getDriver().getTitle());
		if(BaseClass.getDriver().getTitle().equals("Online Furniture Shopping Store: Shop Online in India for Furniture, Home Decor, Homeware Products @ Pepperfry")) {
			System.out.println("Correct website is Launched");
			BaseClass.getLogger().info("----Correct Website Launched Successfully----");
			ExcelUtilities.write("TestNG", 1, "Correct Website Launched Successfully");
		} else {
			System.out.println("Incorrect Website is Launched");
			BaseClass.getLogger().info("----incorrect website launched----");
			System.exit(0);
			BaseClass.getDriver().quit();
		}
	}
	
	@Test(priority = 2)
	public void verifying_the_logo_of_webpage() throws IOException {
		PepperFryHomePage PFHP = new PepperFryHomePage(BaseClass.getDriver());
		if(PFHP.pageLogo()==true) {
			System.out.println("Pepperfry Logo is Displayed");
			BaseClass.getLogger().info("----Pepperfry Logo is Displayed----");
			ExcelUtilities.write("TestNG", 2, "Pepperfry Logo is Displayed");
		} else {
			System.out.println("Pepperfry logo is not Displayed");
		}
	}
	
	@Test(priority = 3)
	public void navigating_to_login_page() throws InterruptedException, IOException {
		PepperFryHomePage PFHP = new PepperFryHomePage(BaseClass.getDriver());
		PFHP.signinoption();
		PFHP.OpenLoginPage();
		System.out.println("Login Page opened successfully");
		BaseClass.getLogger().info("----Login Page opened successfully----");
		ExcelUtilities.write("TestNG", 3, "Login Page opened successfully");
	}
	
	@Test(priority = 4)
	public void entering_mail_id_as_input() throws IOException {
		BaseClass.getDriver().switchTo().activeElement();
		LogInPage LP = new LogInPage(BaseClass.getDriver());
		InputDataValues IDV = new InputDataValues();
		LP.EnterUserDetail(IDV.getUsername());
		System.out.println("Username entered Successfully");
		BaseClass.getLogger().info("----Username entered Successfully----");
		ExcelUtilities.write("TestNG", 4, "Username entered Successfully");
	}
	
	@Test(priority = 5)
	public void click_on_continue_at_mailId_input_page() throws IOException {
		LogInPage LP = new LogInPage(BaseClass.getDriver());
		LP.Submit();
		System.out.println("Clicked on continue successfully");
		BaseClass.getLogger().info("----Clicked on continue successfully----");
		ExcelUtilities.write("TestNG", 5, "Clicked on continue successfully");
	}
	
	@Test(priority = 6)
	public void Entering_otp_received_at_mail() throws InterruptedException, IOException {
		LogInPage LP = new LogInPage(BaseClass.getDriver());
		Thread.sleep(30000);
		LP.Submit();
		System.out.println("OTP entered successfully");
		BaseClass.getLogger().info("----OTP entered successfully----");
		ExcelUtilities.write("TestNG", 6, "OTP entered successfully");
	}
	
	@Test(priority = 7)
	public void Verifying_Log_in() throws IOException {
		PepperFryHomePage PFHP = new PepperFryHomePage(BaseClass.getDriver());
		PFHP.VerifyLogin();
		System.out.println("Logged in to website successfully");
		BaseClass.getLogger().info("----Logged in to website successfully----");
		ExcelUtilities.write("TestNG", 7, "Logged in to website successfully");
	}
	
}
