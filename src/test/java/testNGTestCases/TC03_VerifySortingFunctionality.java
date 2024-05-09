package testNGTestCases;

import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.ProductPage;
import utilities.InputDataValues;

public class TC03_VerifySortingFunctionality {

	@Test(priority = 10)	
	public void Clicking_on_dropdown_menu_for_sorting() {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		PP.clickOnSort();
	}
	
	@Test(priority = 11)	
	public void Selecting_method_of_sort() {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		InputDataValues IDV = new InputDataValues();
		PP.sorting(IDV.getSortingMethod());
	}
	
}
