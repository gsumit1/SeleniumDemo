package screenprint;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class Shutterbug1 {

	public static void main(String arg[]) {
		System.setProperty("webdriver.chrome.driver", "C:\\Training-PPT\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://github.com/pazone/ashot");

		// Shutterbug.shootPage(driver).save();
		Shutterbug.shootPage(driver, Capture.FULL_SCROLL).save();

	}

}
