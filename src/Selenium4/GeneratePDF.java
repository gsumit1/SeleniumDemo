package Selenium4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PrintOptions;

public class GeneratePDF {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/riyaanghosh/Downloads/chromedriver");		
		
		
		
		
		
		
		ChromeOptions options = new ChromeOptions();
		
		
		
		
		options.setHeadless(true);
		
		
		
		ChromeDriver driver = new ChromeDriver(options);
		
		
		
		
		driver.get("https://music.apple.com/us/album/pulsar-palace/1531556355");
		
		
		Path printPage = Paths.get(".//ScreenShots//" + "PrintPageFirefox.pdf");
		
		
		Pdf print = driver.print(new PrintOptions());
		
		
		
		Files.write(printPage, OutputType.BYTES.convertFromBase64Png(print.getContent()));
		
	}

}
