package Test;

	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

	public class General {

		public String baseUrl = "https://skyweb9.skytrac.ca";
		String driverPath = System.getProperty("user.dir");
		public static WebDriver driver;
	
		
		ExtentReports extent;
		ExtentTest logger;
		ExtentHtmlReporter htmlReporter;

		@BeforeClass
		public void setup(){
			htmlReporter = new ExtentHtmlReporter("LoginTestCases.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			
		}
		
		@BeforeTest
		public void Browser() {
			System.setProperty("webdriver.chrome.driver", driverPath+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		@Test(priority = 0)
		public void verifyHomepageTitle() {
		//	System.out.println("launching chrome browser"); 
		//  logger.log(Status.INFO,"gjkg");
			logger = extent.createTest("teszt", "fkf");
			driver.get(baseUrl);
			logger.log(Status.PASS,"gjkg");
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			String expectedTitle = "Logi";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
			logger.log(Status.PASS,"gjkg");
		}

		//Test case 1491-Valid Login using Super user, add super user username and password
		@Test(priority = 1)
		public void valid() throws InterruptedException  {
			driver.findElement(By.name("ctl00$MainContentPlaceHolder$skyWebLogin$UserName")).sendKeys("RCAS_PM");
			driver.findElement(By.name("ctl00$MainContentPlaceHolder$skyWebLogin$Password")).sendKeys("Skytrac3#");
			driver.findElement(By.name("ctl00$MainContentPlaceHolder$skyWebLogin$LoginButton")).click();
			Thread.sleep(2000);
			String expectedTitle = "Home";
			String actualTitle = driver.getTitle();
			if (expectedTitle.matches(actualTitle)){
				System.out.println("Logged in sucessfully with Super user");
			}
			else{
				Assert.fail("Login failed");

				Thread.sleep(3000);
			}
			driver.findElement(By.partialLinkText("FLIGHT FOLLOWING")).click();

			Thread.sleep(25000);
			driver.switchTo().frame("SkyTrac_Controls_Window_InnerFrame_52");

			driver.findElement(By.id("Ok")).click();
			Thread.sleep(3000);
			driver.navigate().back();
			Thread.sleep(2000); 
			driver.findElement(By.partialLinkText("[LOG OUT]")).click();
			Thread.sleep(2000); 
		}
		@AfterMethod(alwaysRun=true)
		public void getResult(ITestResult result)  {
			if (result.getStatus() == ITestResult.FAILURE)
			{
				logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
				logger.fail(result.getThrowable());

			}
			else if (result.getStatus() == ITestResult.SUCCESS)
			{
				logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
			}
			else if (result.getStatus() == ITestResult.SKIP)
			{
				logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.BLUE));
			}
		}

		
		@AfterSuite(alwaysRun=true)
		public void tearDown()  {
			extent.flush();
			driver.quit();
		}
}
