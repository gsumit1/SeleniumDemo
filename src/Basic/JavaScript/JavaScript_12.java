package Basic.JavaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript_12 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/riyaanghosh/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.guru99.com/test/newtours/register.php");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");

		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		WebElement element = driver.findElement(By.xpath("//input[@name='submit']"));
		jse.executeScript("arguments[0].click();", element);

		// String url = jse.executeScript("return document.URL;").toString();
		// String TitleName = js.executeScript("return document.title;").toString();

		int noOfTimes = 0;
		boolean flag = true;
		while (!flag && noOfTimes > 10) {

			try {
				WebElement element1 = driver.findElement(By.xpath("//input[@name='submit']"));
				element1.click();
				flag = false;

			} catch (Exception e) {

				jse.executeScript("window.scrollBy(0,250)");
				noOfTimes++;
			}

		}

	}

}
