package cucumberStepDefinition;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProductPage;

public class TC03_VerifySortingFunctionality {

	@When("Clicking on dropdown menu for sorting")
	public void Clicking_on_dropdown_menu_for_sorting() {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		PP.clickOnSort();
	}
	
	@Then("Selecting method of sort")
	public void Selecting_method_of_sort() {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		Hooks HS = new Hooks();
		PP.sorting(HS.getSortingMethod());
	}
	
}
