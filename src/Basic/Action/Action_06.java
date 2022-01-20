package Basic.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Action_06 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/riyaanghosh/Downloads/chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoqa.com/buttons");
		
		WebElement doubleClickBtn = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		
		
		Actions action = new Actions(driver);
		
		
		/*Double click */
		action.doubleClick(doubleClickBtn).perform();
		
		//Right Click
		WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
		Action a=action.contextClick(rightClick).build();
		a.perform();
		
		//action.contextClick(rightClick).perform();
		
	}

}
