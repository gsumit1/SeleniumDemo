package Basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Elements_03 {
	
	public static void main(String arg[]) {		
		System.setProperty("webdriver.chrome.driver", "/Users/riyaanghosh/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/text-box");
		List<WebElement> e=driver.findElements(By.tagName("input"));
		
		System.out.println(e.size());
		By.xpath("//input[@id='j_username']");
		
		e.get(0).sendKeys("Hello");
		e.get(1).sendKeys("My Name is Sumit");
		

		System.out.println(e.get(0).getAttribute("placeholder"));
		System.out.println(e.get(0).getTagName());

		
		System.out.println(e.get(0).getText());
		
		/*
		driver.findElement(By.id("")).getAttribute("");
		driver.findElement(By.id("")).getText();
		driver.findElement(By.id("")).getTagName();
		driver.findElement(By.id("")).submit();
		*/
				
	}

}
