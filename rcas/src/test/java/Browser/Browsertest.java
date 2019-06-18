package Browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browsertest {
	 WebDriver driver;

		static String username = "rcas_mithun";
	    static String password = "Skytrac3#";
		
		    String baseUrl = "https://skyweb15.skytrac.ca";
		    
		//	String driverPath = System.getProperty("user.dir");
			
					//"C:\\Users\\User\\eclipse-workspace\\RCAS\\chromedriver.exe";

			@Test
			public void verifyHomepageTitle() throws InterruptedException {
				System.out.println("Launching chrome browser"); 
			  //  System.setProperty("webdriver.chrome.driver", driverPath+"\\Drivers\\chromedriver.exe");
				WebDriverManager.chromedriver().setup();
			    driver = new ChromeDriver();
				driver.manage().deleteAllCookies();
				driver.get(baseUrl);
				driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
				driver.manage().window().maximize();
				String actualTitle = driver.getTitle();
				String expectedTitle = "Login";
				Assert.assertEquals(actualTitle, expectedTitle);
	
				/*
				 * 
				 * 
				 */
			}

}
