package screenprint;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class screenprint_12 {
	public static void main(String arg[]) throws IOException, HeadlessException, AWTException {
		WebDriverManager.chromedriver().setup();

		System.setProperty("webdriver.chrome.driver", "/Users/riyaanghosh/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		// driver.findElement(By.xpath("//a[@href='/'][contains(.,'Demo
		// Home')]")).click();

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(".//ScreenShots//Test1.png");
		FileUtils.copyFile(SrcFile, DestFile);

		/*
		 * BufferedImage image = new Robot().createScreenCapture(new
		 * Rectangle(Toolkit.getDefaultToolkit().getScreenSize())); ImageIO.write(image,
		 * "png", new File(".\\ScreenShots\\Test.png"));
		 * driver.switchTo().alert().accept();
		 */

	}

}
