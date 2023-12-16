package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_drop_actionclass {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement Banks = driver.findElement(By.xpath("//a[normalize-space()='BANK']"));

		WebElement account = driver.findElement(By.xpath("//ol[@id='bank']//li[@class='placeholder']"));

		Actions act = new Actions(driver);
		act.dragAndDrop(Banks, account).perform();

		WebElement Note = driver.findElement(By.xpath("//a[text()=' 5000 ']"));

		WebElement amount = driver.findElement(By.xpath("//ol[@id='amt7']"));

		
		act.dragAndDrop(Note, amount).perform();
		
	
		WebElement saless = driver.findElement(By.xpath("//a[normalize-space()='SALES']"));

		WebElement creditacc = driver.findElement(By.xpath("//ol[@id='loan']//li[@class='placeholder']"));

		act.dragAndDrop(saless, creditacc).perform();
		
		
		WebElement minusmoney = driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));

		WebElement creditacc2 = driver.findElement(By.xpath("//*[@id=\"amt8\"]"));

		
		act.dragAndDrop(minusmoney, creditacc2).perform();
		
		
		
		
		
		

	}

}
