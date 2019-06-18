package Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesireCapabilities {

	public static void main(String[] args) throws Exception {
		String driverPath = System.getProperty("user.dir");
		DesiredCapabilities caps = new  DesiredCapabilities();
		caps.setCapability("ignoreProtoctedModeSettin", true);
		caps.getBrowserName();
		
		System.setProperty("webdriver.chrome.driver", driverPath+"\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(caps);
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("dude");
		Thread.sleep(3000);
		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		driver.close();
		
		
		
	}
	

}
