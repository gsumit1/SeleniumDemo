package Selenium4;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Relative_Locator {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/riyaanghosh/Downloads/chromedriver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
		String s = getLeft().getAttribute("id");
		System.out.println(s);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("window.scrollBy(0,250)");

		jse.executeScript("arguments[0].style.filter='blur(8px)'", getLeft());

		// Different Example
//		driver.get("https://rally1.rallydev.com/slm/login.op");
//		driver.findElement(with(By.xpath("//input")).above(By.id("login-button"))).sendKeys("Hello");
//		Thread.sleep(10000);

	}

	public static WebElement getBelow() {

		return driver.findElement(with(By.tagName("li")).below(By.id("london")));
	}

	public static WebElement getAbove() {
		return driver.findElement(with(By.tagName("li")).above(By.id("london")));
	}

	public static WebElement getLeft() {
		return driver.findElement(with(By.tagName("li")).toLeftOf(By.id("berlin")));
	}

	public static WebElement getRight() {
		return driver.findElement(with(By.tagName("li")).toRightOf(By.id("berlin")));
	}

	public static WebElement getNearBy() {
		return driver.findElement(with(By.tagName("li")).near(By.id("berlin")));
	}

	public static WebElement getChainingLocators() {
		return driver.findElement(with(By.tagName("li")).toLeftOf(By.id("berlin")).below(By.id("nyc")));
	}

}
