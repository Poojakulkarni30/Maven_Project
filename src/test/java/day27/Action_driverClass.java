package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action_driverClass {

	public static void main(String[] args) {

		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/");
		   
		// actions class  
		// 1. move to the element
		
		WebElement desktop= driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		
		WebElement PC= driver.findElement(By.xpath("//a[normalize-space()='PC (0)']"));
		
		WebElement Mac=	 driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(desktop).moveToElement(PC).moveToElement(Mac).click().build().perform();
		driver.findElement(By.xpath("//a[normalize-space()='iMac']")).click();
		
	}

}
