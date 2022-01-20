package Selenium4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.HasFullPageScreenshot;
import org.openqa.selenium.remote.Augmenter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FullScreenPrint {
	public static void main(String[] args) throws IOException {

		WebDriverManager.firefoxdriver().setup();

		// WebDriverManager.chromedriver().driverVersion("81.0.4044.138").setup();
		// WebDriverManager.firefoxdriver().browserVersion("75").setup();

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");

		WebDriver augmentedDriver = new Augmenter().augment(driver);
		File file = ((HasFullPageScreenshot) augmentedDriver).getFullPageScreenshotAs(OutputType.FILE);
		Path fullPageScreenshot = Paths.get(".//ScreenShots//ScreenTest1.png");
		Files.move(file.toPath(), fullPageScreenshot);

		driver.close();
		driver.quit();

	}

}
