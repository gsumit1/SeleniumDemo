package Selenium4;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/riyaanghosh/Downloads/chromedriver");		
		driver= new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/login?from=%2F");
		
		//driver.switchTo().newWindow(WindowType.WINDOW);
		//driver.switchTo().newWindow(WindowType.TAB);
		driver.manage().window().setPosition(new Point(100,400));
	}

}
