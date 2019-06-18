package Test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import Pages.GoogleSearchPage;
 
public class GoogleSearchPageTest {
	private static WebDriver driver= null;
	

	public static void main(String[] args) throws InterruptedException {
          Googlesearch();
	}

	public static void Googlesearch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		 driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		//driver.findElement(By.name("q")).sendKeys("dude");
		
		GoogleSearchPage.textbox_search(driver).sendKeys("dude");
		
	Thread.sleep(3000);
	
	//	driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER); 
	
		GoogleSearchPage.Button_search(driver).sendKeys(Keys.ENTER);
		System.out.println("Succesfull");
		driver.close();
	}
}
