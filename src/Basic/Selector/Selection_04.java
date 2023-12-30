package Basic.Selector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selection_04 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/riyaanghosh/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.guru99.com/test/newtours/reservation.php");
		driver.manage().window().maximize();
		// Thread.sleep(5000);
		WebElement roundTrip = driver.findElement(By.xpath("//input[@value='roundtrip']"));
		
		//Element is not present in DOM
		WebElement roundTrip1 = driver.findElement(By.xpath("//*[@id=\"static-ad-1\"]"));
		
		System.out.println(roundTrip1.isDisplayed());
		
		
		//System.out.println(driver.findElement(By.xpath("//input[@value='roundtrip1']")).isDisplayed());
		
		/*
		 * isSelected() Determine whether or not this element is selected or not.
		 * isDisplayed()Is this element displayed or not? isEnabled() True if the
		 * element is enabled, false otherwise.
		 */

		boolean flag = roundTrip.isSelected();
		
		
		if (!flag) {
			roundTrip.click();
		}

		//WebElement oneWay = driver.findElement(By.xpath("//input[@value='oneway']"));
		//oneWay.click();
	}

}
