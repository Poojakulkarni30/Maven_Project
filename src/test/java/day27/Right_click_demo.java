package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Right_click_demo {

	public static void main(String[] args) {

		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo/on-dom-element.html");
		   
		// actions class  
		// 1. Right click // context click 
		
		WebElement rightclick= driver.findElement(By.xpath("//span[normalize-space()='right click me 1']"));
		
		Actions act =new Actions(driver);
		act.contextClick(rightclick).build().perform();
		driver.findElement(By.xpath("//span[normalize-space()='Delete']")).click();
		driver.switchTo().alert().accept();
		
		
	}

}
