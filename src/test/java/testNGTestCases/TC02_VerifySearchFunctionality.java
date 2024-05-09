package testNGTestCases;

import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.PepperFryHomePage;
import pageObjects.ProductPage;
import utilities.InputDataValues;

public class TC02_VerifySearchFunctionality {
	
	@Test(priority = 7)
	public void Entering_keyword_in_search_textbox() {
		PepperFryHomePage PFHP = new PepperFryHomePage(BaseClass.getDriver());
		InputDataValues IDV = new InputDataValues();
		PFHP.SearchInput(IDV.getSearchKeyword());
	}
	
	@Test(priority = 8)
	public void Clicking_on_search_icon() {
		PepperFryHomePage PFHP = new PepperFryHomePage(BaseClass.getDriver());
		PFHP.searchproduct();
	}
	@Test(priority = 9)	
	public void verifying_the_product() {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		PP.VerifySearch();
	}
}
