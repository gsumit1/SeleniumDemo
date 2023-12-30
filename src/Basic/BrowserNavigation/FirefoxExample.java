package Basic.BrowserNavigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxExample {
	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		// System.setProperty("webdriver.gecko.driver", "/Users/riyaanghosh/Downloads/geckodriver");

		WebDriver driver = new FirefoxDriver();

		try {
			driver.get("http://www.google.com");
			driver.findElement(By.name("q")).sendKeys("Firefox Driver for Selenium");
			driver.findElement(By.name("q")).submit();
		} finally {
			 driver.quit();
		}
	}
}
