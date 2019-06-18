package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.GoogleSearchPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchPageObjectsTest {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		googlesearchtest();
		
		
	}
	
	public static void googlesearchtest() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		GoogleSearchPageObjects searchobj = new  GoogleSearchPageObjects(driver);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://google.com");
		 searchobj.setTextInSearchBox("santosh");
		 searchobj.clickSearchButton();
		 driver.close();
		 
		
		// ("santosh");
		
	}

}
