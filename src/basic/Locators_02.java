package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators_02 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Training-PPT\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		/*
		driver.get("https://demoqa.com/links");
		//WebElement e = driver.findElement(By.linkText("Home"));
		//e.click();

		
		
		WebElement plnk = driver.findElement(By.partialLinkText("Request"));
		plnk.click();

		
		
		driver.get("https://demoqa.com/buttons");
		WebElement btn = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		btn.click();
		*/
		
		
		
		//TextBox
		driver.get("https://demoqa.com/text-box");
		driver.findElement(By.id("userEmail")).sendKeys("sumit@gmail.com");
		
	}

}
