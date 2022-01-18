package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Training-PPT\\Driver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		
		WebElement e = driver.findElement(By.xpath("//button[@id='promtButton']"));
		
		e.click();
		
		
		driver.switchTo().alert().dismiss();
		
		driver.switchTo().alert().accept();
		
		System.out.println(driver.switchTo().alert().getText());
		
		
		driver.switchTo().alert().sendKeys("Hello");
	
		
		
		/* sometimes shows intermittently*/


	}

}
