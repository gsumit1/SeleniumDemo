package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavigation_01 {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/riyaanghosh/Downloads/chromedriver");		
		WebDriver driver= new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver", "/path/to/geckodriver");
		//WebDriver driver = new FirefoxDriver();
		
		
	
		
		driver.manage().window().maximize();	
		
		driver.get("https://www.google.co.in/");
		
		//driver.navigate().to("https://www.google.co.in/");
		

		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		
		//String pageSource=driver.getPageSource();
		//System.out.println(pageSource);
		
		
		
		//driver.navigate().forward();
		//driver.navigate().back();
		
		
		//driver.navigate().refresh();
	
		
		
		String title=driver.getTitle();
		System.out.println(title);
		
		driver.close(); 
		
		driver.quit();
		
		
	}
}
