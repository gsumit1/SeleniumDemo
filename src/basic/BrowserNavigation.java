package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavigation {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Training-PPT\\Driver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		
		//System.setProperty("webdriver.gecko.driver", "/path/to/geckodriver");
		//WebDriver driver = new FirefoxDriver();
		
		
		
		
		driver.manage().window().maximize();
		
		
		driver.get("https://www.google.co.in/");
		driver.navigate().forward();
		
		
		
		driver.getCurrentUrl();
		
		
		
		driver.navigate().to("");
		driver.navigate().refresh();
		driver.navigate().forward();
		driver.navigate().back();
		
		driver.getTitle();
		
		driver.close();
		driver.quit();
		
	}
}
