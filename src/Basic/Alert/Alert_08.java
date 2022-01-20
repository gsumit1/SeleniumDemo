package Basic.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_08 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/riyaanghosh/Downloads/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		
		
		Thread.sleep(5000);
		WebElement e = driver.findElement(By.xpath("//button[@id='promtButton']"));
		e.click();	
		
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
		
		
		
		//driver.switchTo().alert().accept();
		//System.out.println(driver.switchTo().alert().getText());
		//driver.switchTo().alert().sendKeys("Hello");
		/* sometimes shows intermittently*/
		
	
	}

}
