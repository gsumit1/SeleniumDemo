package Basic.DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown_05 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/riyaanghosh/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/reservation.php");
		
		WebElement dropdown=driver.findElement(By.xpath("//select[@name='fromPort']"));
		/* UnexpectedTagNameException - when element is not a SELECT */
	
		Select departDropDown =new Select(dropdown);
		departDropDown.selectByVisibleText("London");
		//departDropDown.selectByIndex(0);
		//departDropDown.selectByValue("");
		//departDropDown.deselectAll();

		/*
		driver.get("http://jsbin.com/osebed/2");
		Select fruits = new Select(driver.findElement(By.id("fruits")));
			
		System.out.println(fruits.isMultiple());
		
		fruits.selectByVisibleText("Banana");
		fruits.selectByIndex(1);
		
		Thread.sleep(3000);
		fruits.deselectAll();
		*/
	}

}
