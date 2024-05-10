package cucumberStepDefinition;

import java.io.IOException;

import org.junit.Assert;
import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProductPage;
import utilities.ExcelUtilities;

public class TC03_VerifySortingFunctionality {

	@When("Clicking on dropdown menu for sorting")
	public void Clicking_on_dropdown_menu_for_sorting() throws IOException {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		PP.clickOnSort();
		System.out.println("clicked on sort dropdown successfully");
		BaseClass.getLogger().info("----clicked on sort dropdown successfully----");
		ExcelUtilities.write("Cucumber", 11, "clicked on sort dropdown successfully");
	}
	
	@Then("Selecting method of sort")
	public void Selecting_method_of_sort() throws IOException {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		Hooks HS = new Hooks();
		PP.sorting(HS.getSortingMethod());
		System.out.println("Method of sort selected successfully");
		BaseClass.getLogger().info("----Method of sort selected successfully----");
		ExcelUtilities.write("Cucumber", 12, "Method of sort selected successfully");
	}
	
	@Then("Verify Sort Function")
	public void Verify_Sort_Function() throws IOException {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		int count = PP.prodprice();
		Assert.assertEquals("Sort Successful", "3" , count);
		System.out.println("sort function verified successfully");
		BaseClass.getLogger().info("----sort function verified successfully----");
		ExcelUtilities.write("Cucumber", 13, "sort function verified successfully");
	}
}
