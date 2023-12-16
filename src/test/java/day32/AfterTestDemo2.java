package day32;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AfterTestDemo2 {
	
	
	
	WebDriver driver; 
	
	@Test	(priority = 4)
	void login() {

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}


	
	
	
	
	@Test(priority=5)
	void search() {
		
		driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).click();
		WebElement username= driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"));
	username.sendKeys("cheeku");
	username.click();
	
	}
	@AfterTest
	void TearDown() {
		
		
		driver.quit();
	}
	
	

}
