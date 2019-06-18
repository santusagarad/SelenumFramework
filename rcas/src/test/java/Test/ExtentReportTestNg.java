package Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportTestNg {
    WebDriver driver;
 
    ExtentReports extent;
    ExtentTest logger;
    ExtentHtmlReporter htmlReporter;
  //  String htmlReportPath = "C:\\Screenshots/MyOwnReport.html"; //Path for the HTML report to be saved
 
    @BeforeTest
    public void setup(){
        htmlReporter = new ExtentHtmlReporter("htmlRepor.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
 
        String driverPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", driverPath+"\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
 
    }
 
    @Test
    public void test1(){
        logger = extent.createTest("Google Test", "Test to launch google site");
        driver.get("http://www.google.com/");
        logger.log(Status.INFO, "Opened site google.com");
        assertEquals(driver.getTitle(), "Google");
        logger.log(Status.PASS, "Google site loaded");
        driver.findElement(By.name("q")).sendKeys("dude");
		logger.log(Status.PASS, "FindElements");
		//logger.pass("FindElements");
	//	Thread.sleep(3000);
		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		logger.log(Status.PASS, "click on Buttons");
		//log
    }
 
  /*  @AfterMethod
    public void getResult(ITestResult result) throws Exception {
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
     }*/
 
    @AfterTest
    public void testend()  {
    	System.out.println("successfull");
        extent.flush();
    }
 
    @AfterClass
    public void tearDown() {
        driver.close();
    }
}