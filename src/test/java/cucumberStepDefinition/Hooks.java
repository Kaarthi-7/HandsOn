package cucumberStepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import factory.BaseClass;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	public static WebDriver driver;
	private static String Username;
	private static String SearchKeyword;
	private static String SortingMethod;
	private static String VerifyKeyword;
	static Properties p;
	 
	@BeforeAll
   public static void setup() throws IOException, InterruptedException
   {
   	driver=BaseClass.initilizeBrowser();
   	p=BaseClass.getProperties();
   	driver.get(p.getProperty("appURL"));
   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   	driver.manage().window().maximize();
	}
	
	@BeforeStep
	public void data() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/ExcelInput.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet worksheet = workbook.getSheet("Input");
		XSSFRow row = worksheet.getRow(1);

		Username = row.getCell(0).toString();
		SearchKeyword = row.getCell(1).toString();
		SortingMethod = row.getCell(2).toString();
		VerifyKeyword = row.getCell(3).toString();
		workbook.close();
	}
	@AfterStep
    public void addScreenshot(Scenario scenario) {
    	// this is for cucumber junit report
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
    }

   @AfterAll
   public static void tearDown() {
      driver.quit();
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