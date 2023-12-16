package day28;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Keyboard_actions {

	public static void main(String[] args) {

		//Action class for keybord action
		
		
		// KeyUp  KeyDown
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		 	driver.findElement(By.xpath("//input[@id='name']")).sendKeys("POOJA");
        WebElement email=	driver.findElement(By.xpath("//input[@id='email']"));		
		
        Actions act=new Actions(driver);
        
        // ctrl+A
        
        act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
        
        // ctrl + c
        
        act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
        
        act.moveToElement(email).click();
        
        // ctrl + V
        
        
        act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	}

}
