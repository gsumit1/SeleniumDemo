package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators_02 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Training-PPT\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		//ID
		By id=By.id("userName");
		driver.get("https://demoqa.com/text-box");
		driver.findElement(id).sendKeys("Hello");
		
		
		//Name
		By name=By.name("j_username");
		driver.get("https://rally1.rallydev.com/slm/login.op");
		driver.findElement(name).sendKeys("Hello");
		
		
		//LinkText
		driver.get("https://demoqa.com/links");
		WebElement e = driver.findElement(By.linkText("Home"));
		e.click();

		
		//Partial Link Text
		WebElement plnk = driver.findElement(By.partialLinkText("Request"));
		plnk.click();

		
		//XPath
		driver.get("https://demoqa.com/buttons");
		WebElement btn = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		btn.click();
		
		
	}

}
