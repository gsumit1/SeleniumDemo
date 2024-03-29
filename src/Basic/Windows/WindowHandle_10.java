package Basic.Windows;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle_10 {

	public static void main(String arg[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",  "/Users/riyaanghosh/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/browser-windows");
		
		Thread.sleep(10000);
		String s = driver.getWindowHandle();
		
		System.out.println(s);
		
		
		WebElement e = driver.findElement(By.xpath("//button[@id='windowButton']"));
		e.click();

		Set<String> handles = driver.getWindowHandles();
		
		
		System.out.println(handles);
		
		
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String p = it.next();
			if (!p.equalsIgnoreCase(s)) {
				System.out.println(p);
				driver.switchTo().window(p);
				System.out.println(driver.getCurrentUrl());
				driver.close();
			}
		}
		driver.switchTo().window(s);
		System.out.println(driver.getCurrentUrl());
		
	}

}
