package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selection_04 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Training-PPT\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.guru99.com/test/newtours/reservation.php");
		driver.manage().window().maximize();
		// Thread.sleep(5000);

		WebElement roundTrip = driver.findElement(By.xpath("//input[@value='roundtrip']"));

		boolean flag = roundTrip.isSelected();
		
		

		if (!flag) {
			roundTrip.click();
		}

		WebElement oneWay = driver.findElement(By.xpath("//input[@value='oneway']"));
		oneWay.click();
		boolean flag1 = oneWay.isSelected();

		

	}

}
