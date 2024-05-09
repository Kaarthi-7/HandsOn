package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;

public class InputDataValues {

	private static String Username;
	private static String SearchKeyword;
	private static String SortingMethod;
	private static String VerifyKeyword;

	@BeforeTest
	public void data() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/inputDatas/InputData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet worksheet = workbook.getSheet("Input");
		XSSFRow row = worksheet.getRow(1);

		Username = row.getCell(0).toString();
		SearchKeyword = row.getCell(1).toString();
		SortingMethod = row.getCell(1).toString();
		VerifyKeyword = row.getCell(3).toString();
		
		workbook.close();
	}

	public String getUsername() {
		return Username;
	}

	public String getSearchKeyword() {
		return SearchKeyword;
	}

	public String getSortingMethod() {
		return SortingMethod;
	}

	public String getVerifyKeyword() {
		return VerifyKeyword;
	}

}