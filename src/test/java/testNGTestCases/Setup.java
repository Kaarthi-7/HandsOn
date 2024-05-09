package testNGTestCases;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import factory.BaseClass;

public class Setup extends BaseClass{

	public static WebDriver driver;
	static Properties p;

	@BeforeSuite(groups= {"regression","smoke"})
	public void siteLaunch() throws Exception{
		driver = BaseClass.initilizeBrowser();
		p = BaseClass.getProperties();
		driver.get(p.getProperty("appURL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().window().maximize();
		System.out.println("The user is on LimeRoad.com website. ");
	}

	@AfterSuite(groups= {"regression","smoke"})
	public void tearDown() {
		driver.quit();
	}
}
