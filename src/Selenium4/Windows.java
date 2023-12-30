package Selenium4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		// System.setProperty("webdriver.chrome.driver",
		// "/Users/riyaanghosh/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rally1.rallydev.com/slm/login.op");

		driver.switchTo().newWindow(WindowType.WINDOW);

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://rally1.rallydev.com/slm/login.op");
		// driver.manage().window().setPosition(new Point(100,400));
	}

}
