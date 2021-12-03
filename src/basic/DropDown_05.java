package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown_05 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Training-PPT\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("http://demo.guru99.com/test/newtours/reservation.php");
		
		WebElement e=driver.findElement(By.xpath("//select[@name='fromPort']"));
		
		Select departDropDown =new Select(e);
		
		
		departDropDown.selectByVisibleText("London");
		
		
		
		
		driver.get("http://jsbin.com/osebed/2");
		Select fruits = new Select(driver.findElement(By.id("fruits")));
		System.out.println(fruits.isMultiple());
		
		/*
		fruits.selectByVisibleText("Banana");
		fruits.selectByIndex(1);
		
		Thread.sleep(3000);
		fruits.deselectAll();*/
	
	}

}
