package cucumberStepDefinition;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PepperFryHomePage;
import pageObjects.ProductPage;

public class TC02_VerifySearchFunctionality {
	
	@Then("Entering keyword in search textbox")
	public void Entering_keyword_in_search_textbox() {
		PepperFryHomePage PFHP = new PepperFryHomePage(BaseClass.getDriver());
		Hooks HS = new Hooks();
		PFHP.SearchInput(HS.getSearchKeyword());
	}
	
	@When("Clicking on search icon")
	public void Clicking_on_search_icon() {
		PepperFryHomePage PFHP = new PepperFryHomePage(BaseClass.getDriver());
		PFHP.searchproduct();
	}
	
	@Then("verifying the product")
	public void verifying_the_product() {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		PP.VerifySearch();
	}
}
