package Test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class baseextent {
	WebDriver driver;

	ExtentReports extent;
	ExtentTest logger;
	ExtentHtmlReporter htmlReporter;
	static String username = "rcas_mithun";
	static String password = "Skytrac3#";

	String baseUrl = "https://skyweb15.skytrac.ca";
	String driverPath = System.getProperty("user.dir");

	//  String htmlReportPath = "C:\\Screenshots/MyOwnReport.html"; //Path for the HTML report to be saved

	@BeforeClass
	public void setup(){
		htmlReporter = new ExtentHtmlReporter("htmlRepor.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	
	}
	@BeforeTest
	public void Browser() throws InterruptedException {
		String driverPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", driverPath+"\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
		@Test(priority=1)
		public void verifyHomepageTitle() throws InterruptedException {
		logger = extent.createTest("HomepageTest", "Test to launch home page");
		driver.get(baseUrl);
		logger.pass("Navigate to url");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		logger.info("wait info");
		assertEquals(driver.getTitle(), "Login");
		logger.log(Status.PASS, "Page Loaded");

		driver.findElement(By.xpath("//input[@id='ctl00_MainContentPlaceHolder_skyWebLogin_UserName']")).sendKeys(username);
		logger.pass("FindElement");
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContentPlaceHolder_skyWebLogin_Password\"]")).sendKeys(password);
		logger.pass("pass the password");
		driver.findElement(By.id("ctl00_MainContentPlaceHolder_skyWebLogin_LoginButton")).click();
		logger.pass("click");


	}

	@Test(priority=2)
	public void VerifyLoadDataWindow() throws InterruptedException {
		logger = extent.createTest("Load  Data window", "Test to load data window site");
		driver.findElement(By.xpath("//span[contains(text(),\"FLIGHT FOLLOWING\")]")).click();
		logger.log(Status.INFO, "clocked on LogIn");
		driver.switchTo().frame("LoadDataWindow");
		logger.log(Status.PASS, "Switching Frame");
		driver.findElement(By.xpath("//input[@id='Ok']")).click();
		logger.log(Status.PASS, "Click Ok");
		//logger.pass("FindElements");
		assertEquals(driver.getTitle(), "SkyWeb v5.05.00");
		logger.log(Status.PASS, "Home Page Opened");
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		//log
	}

	@AfterMethod
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

	@AfterTest
	public void VerifyLogOut() throws InterruptedException {
		driver.switchTo().defaultContent();
		logger.log(Status.PASS,"swittch to default");
		driver.findElement(By.xpath("//*[@id=\"LogoutImage\"]/img")).click(); 
		logger.log(Status.PASS,"click on LogOut Button");
		assertEquals(driver.getTitle(),"Login");
		Thread.sleep(5000);
		System.out.println("successfull");

	}

	@AfterClass
	public void tearDown() {
	 	extent.flush();
		driver.close();
	}
}