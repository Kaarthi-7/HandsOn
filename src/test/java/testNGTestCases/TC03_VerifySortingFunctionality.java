package testNGTestCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.ProductPage;
import utilities.ExcelUtilities;
import utilities.InputDataValues;

public class TC03_VerifySortingFunctionality {

	@Test(priority = 11)
	public void Clicking_on_dropdown_menu_for_sorting() throws IOException {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		PP.clickOnSort();
		System.out.println("clicked on sort dropdown successfully");
		BaseClass.getLogger().info("----clicked on sort dropdown successfully----");
		ExcelUtilities.write("TestNG", 11, "clicked on sort dropdown successfully");
	}
	
	@Test(priority = 12)
	public void Selecting_method_of_sort() throws IOException {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		InputDataValues IDV = new InputDataValues();
		PP.sorting(IDV.getSortingMethod());
		System.out.println("Method of sort selected successfully");
		BaseClass.getLogger().info("----Method of sort selected successfully----");
		ExcelUtilities.write("TestNG", 12, "Method of sort selected successfully");
	}
	
	@Test(priority = 13)
	public void Verify_Sort_Function() throws IOException {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		int count = PP.prodprice();
		Assert.assertEquals("Sort Successful", "3" , count);
		System.out.println("sort function verified successfully");
		BaseClass.getLogger().info("----sort function verified successfully----");
		ExcelUtilities.write("TestNG", 13, "sort function verified successfully");
	}
}
