package TimeOut;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeOut {

	public static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/riyaanghosh/Downloads/chromedriver");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://somedomain/slow_loading_url");
		WebElement dynamicElement = driver.findElement(By.id("dynamicElement"));
		
		
		

		driver.get("http://somedomain/someurl");
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
		
		
		wait.until(ExpectedConditions.visibilityOf(dynamicElement)).click();
		
		WebElement dynamicElement1 = wait
	.until(ExpectedConditions.presenceOfElementLocated(By.id("dynamicElement")));

	}

}
