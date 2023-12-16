package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Double_click_demo {

	public static void main(String[] args) {

		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://seleniumbase.io/w3schools/double_click");
		   
		// actions class  
		// 1. Double click
		
		
		 WebElement framesid= driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		
		
		driver.switchTo().frame(framesid);
		
		
		WebElement doubleclick = driver.findElement(By.xpath("//p[@ondblclick='myFunction()']"));
		
		
		Actions act = new Actions(driver);
		
		
		act.doubleClick(doubleclick).build().perform();
		 
	}

}
