package WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ManageDriver {
	
	public static void main(String[] args) {
			
		WebDriverManager.chromedriver().setup();
		
		//WebDriverManager.chromedriver().driverVersion("81.0.4044.138").setup();
		//WebDriverManager.firefoxdriver().browserVersion("75").setup();

		
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://www.google.co.in/");
		String url=driver.getCurrentUrl();
		System.out.println(url);
			
		String title=driver.getTitle();
		System.out.println(title);
		
		driver.close(); 
		driver.quit();
		
		
	}
}
