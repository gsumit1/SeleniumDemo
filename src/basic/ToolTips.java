package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTips {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Training-PPT\\Driver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
	
		driver.get("https://demoqa.com/tool-tips");
		WebElement e=driver.findElement(By.xpath("//button[@id='toolTipButton']"));
		
		Actions act=new Actions(driver);
		
		
		act.moveToElement(e).moveToElement(e).contextClick(e).build().perform();
		
		

	}

}
