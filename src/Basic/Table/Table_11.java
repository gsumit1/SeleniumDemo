package Basic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table_11 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Training-PPT\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		WebElement htmltable = driver.findElement(By.xpath("//*[@id='customers']/tbody"));
		List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
		
		/*
		for (int rnum = 1; rnum < rows.size(); rnum++) {
			
			List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
			for (int cnum = 0; cnum < columns.size(); cnum++) {
				System.out.print(columns.get(cnum).getText());
				System.out.print(" ");
			}
			System.out.print("\n");
		}*/

		
		
		List<WebElement> columns1 = rows.get(0).findElements(By.tagName("th"));
		
		List<String> headers = new ArrayList<String>();
		
		for (WebElement a : columns1) {
			headers.add(a.getText());
		}
		
		int index = headers.indexOf("Contact");
		
		System.out.println(index);

		for (int rnum = 1; rnum < rows.size(); rnum++) {
			List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
			System.out.print(columns.get(index).getText());
			System.out.print("\n");
		}
		
	}

}
