package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action_06 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Training-PPT\\Driver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoqa.com/buttons");
		
		WebElement e = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		
		
		Actions a = new Actions(driver);

		//Double click
		
		//a.doubleClick(e);
		//a.build().perform();
		
		//Right Click
		WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
		a.contextClick(rightClick).build().perform();
		
	}

}
