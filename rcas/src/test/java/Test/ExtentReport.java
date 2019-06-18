package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	static WebDriver driver;
	ExtentHtmlReporter htmlreport;
	ExtentReports extent;




	public static void main(String[] args)  
	{
		
		GoogleSeacrh();
	}
	
	public static void GoogleSeacrh(){
		try {
		ExtentHtmlReporter htmlreport = new ExtentHtmlReporter("extent_report.html");
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(htmlreport);
		String driverPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", driverPath+"\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		ExtentTest test = extent.createTest("GoogleSearch test one ");	
		driver.get("https://www.google.com");
		test.pass("navigate");
		driver.findElement(By.name("q")).sendKeys("dude");
		test.pass("FindElements");
		//	Thread.sleep(3000);
		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		test.pass("click on Buttuon");
		System.out.println("Succesfull");
		driver.close();
		extent.flush();
		}
		finally {
			System.out.println("done ");
		}
	}

}



