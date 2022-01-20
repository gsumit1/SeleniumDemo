package screenprint;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AshotScreenPrint {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/riyaanghosh/Downloads/chromedriver");
			WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://github.com/pazone/ashot");
		
		//Capturing the entire page
		Screenshot aShot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
			
		/*
		WebElement myWebElement = driver.findElement(By.xpath("//svg[@height='32']"));
		Screenshot aShot=new AShot()
		  .takeScreenshot(driver, myWebElement);
		*/
		
		BufferedImage image = aShot.getImage();
		ImageIO.write(image, "PNG", new File(".//ScreenShots//FullPageScreenshot.png"));
		driver.quit();

	}

}

//https://github.com/pazone/ashot
//https://github.com/assertthat/selenium-shutterbug