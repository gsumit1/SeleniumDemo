package Basic.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTips {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/riyaanghosh/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/resources/demos/tooltip/default.html");

		WebElement ele = driver.findElement(By.id("age"));

		Actions action = new Actions(driver);

		action.moveToElement(ele).build().perform();

		WebElement toolTipElement = driver.findElement(By.xpath("//*[@role='tooltip']/div"));

		String toolTipTxt = toolTipElement.getText();

		System.out.println(toolTipTxt);

	}

}
