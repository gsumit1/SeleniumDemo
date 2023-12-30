package Basic.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop_07 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/riyaanghosh/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable/");

		Thread.sleep(3000);
		driver.manage().window().maximize();
		Actions builder = new Actions(driver);

		WebElement from = driver.findElement(By.id("draggable"));

		WebElement to = driver.findElement(By.id("droppable"));

		builder.dragAndDrop(from, to).perform();

	}

}
