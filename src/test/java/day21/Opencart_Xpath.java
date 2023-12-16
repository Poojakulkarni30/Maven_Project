package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Opencart_Xpath {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=product/product&language=en-gb&product_id=43");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		// text method 
		
		
		
		// find single attribute
		
		driver.findElement(By.xpath("//div[@class='rating']//following::span[2]")).click();
		
		
		
		
		
		
	}

}
