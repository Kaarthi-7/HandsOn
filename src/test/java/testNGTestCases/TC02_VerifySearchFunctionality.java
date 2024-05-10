package testNGTestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.PepperFryHomePage;
import pageObjects.ProductPage;
import utilities.ExcelUtilities;
import utilities.InputDataValues;

public class TC02_VerifySearchFunctionality {
	
	@Test(priority = 8)
	public void Entering_keyword_in_search_textbox() throws IOException {
		PepperFryHomePage PFHP = new PepperFryHomePage(BaseClass.getDriver());
		InputDataValues IDV = new InputDataValues();
		PFHP.SearchInput(IDV.getSearchKeyword());
		System.out.println("Search keyword entered successfully");
		BaseClass.getLogger().info("----Search keyword entered successfully----");
		ExcelUtilities.write("TestNG", 8, "Search keyword entered successfully");
	}
	
	@Test(priority = 9)
	public void Clicking_on_search_icon() throws IOException {
		PepperFryHomePage PFHP = new PepperFryHomePage(BaseClass.getDriver());
		PFHP.searchproduct();
		System.out.println("Search icon clicked successfully");
		BaseClass.getLogger().info("----Search icon clicked successfully----");
		ExcelUtilities.write("TestNG", 9, "Search icon clicked successfully");
	}
	
	@Test(priority = 10)
	public void verifying_the_product() throws IOException {
		ProductPage PP = new ProductPage(BaseClass.getDriver());
		String prodName = PP.productName();
		if(prodName.contains("Chair")) {
			System.out.println("Search Verified Successfully");
			BaseClass.getLogger().info("----Search Verified Successfully----");
			ExcelUtilities.write("TestNG", 10, "Search Verified Successfully");
		}
	}
}
