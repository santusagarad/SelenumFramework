package Test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.GoogleSearchPage;
import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchPageTest_TestNG {
	public static WebDriver driver;
	public static String  browsername = null;

	@BeforeTest() 

	public  void SetUp() {

		PropertiesFile.getProperties();
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if(browsername.equalsIgnoreCase("firefox")) {
			String driverPath = System.getProperty("user.dir");
			System.setProperty("webdriver.gecko.driver", driverPath+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	} 

	@Test()
	public void GoogleSearch() throws InterruptedException {
		driver.get("https://www.google.com");
		//driver.findElement(By.name("q")).sendKeys("dude");
		GoogleSearchPage.textbox_search(driver).sendKeys("dude");
		Thread.sleep(3000);
		//	driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER); 
		GoogleSearchPage.Button_search(driver).sendKeys(Keys.ENTER);
	}

	@AfterTest()

	public void tear_down() {
		driver.close();
		System.out.println("Succesfull");
		PropertiesFile.SetProperty();
	}
}
