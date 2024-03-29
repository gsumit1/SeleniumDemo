package Basic.Frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFRame_09 {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * By Index By Name or Id By Web Element
		 */

		System.setProperty("webdriver.chrome.driver", "/Users/riyaanghosh/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/nestedframes");

		Thread.sleep(10000);

		driver.switchTo().frame(driver.findElement(By.id("frame1")));
		System.out.println(driver.findElement(By.tagName("body")).getText());

		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		System.out.println(driver.findElement(By.tagName("body")).getText());

		// driver.switchTo().parentFrame();
		// System.out.println(driver.findElement(By.tagName("body")).getText());

		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.tagName("body")).getText());

	}

}
