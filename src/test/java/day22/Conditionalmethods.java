package day22;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Conditionalmethods {

	public static void main(String[] args) {

		

		WebDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		System.out.println(driver.findElement(By.xpath("//input[@id='female']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//input[@id='female']")).isEnabled()) ;
		System.out.println(driver.findElement(By.xpath("//input[@id='female']")).isSelected());
		driver.quit();
		
		
		
		
	}

}
