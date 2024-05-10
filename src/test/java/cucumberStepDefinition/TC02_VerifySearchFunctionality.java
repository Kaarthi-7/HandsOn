package cucumberStepDefinition;

import java.io.IOException;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PepperFryHomePage;
import pageObjects.ProductPage;
import utilities.ExcelUtilities;

public class TC02_VerifySearchFunctionality {
	
	@Then("Entering keyword in search textbox")
	public void Entering_keyword_in_search_textbox() throws IOException {
		PepperFryHomePage PFHP = new PepperFryHomePage(BaseClass.getDriver());
		Hooks HS = new Hooks();
		PFHP.SearchInput(HS.getSearchKeyword());
		System.out.println("Search keyword entered successfully");
		BaseClass.getLogger().info("----Search keyword entered successfully----");
		ExcelUtilities.write("Cucumber", 8, "Search keyword entered successfully");
	}
	
	@When("Clicking on search icon")
	public void Clicking_on_search_icon() throws IOException {
		PepperFryHomePage PFHP = new PepperFryHomePage(BaseClass.getDriver());
		PFHP.searchproduct();
		System.out.println("Search icon clicked successfully");
		BaseClass.getLogger().info("----Search icon clicked successfully----");
		ExcelUtilities.write("Cucumber", 9, "Search icon clicked successfully");
	}
	
	@Then("verifying the product")
	public void verifying_the_product() throws IOException {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		String prodName = PP.productName();
		if(prodName.contains("Chair")) {
			System.out.println("Search Verified Successfully");
			BaseClass.getLogger().info("----Search Verified Successfully----");
			ExcelUtilities.write("Cucumber", 10, "Search Verified Successfully");
		}
	}
}
