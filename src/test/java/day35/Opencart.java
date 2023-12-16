package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class Opencart {
	
	WebDriver driver;

	@Test
	void setup() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");

	}

	@Test(priority = 2)
	void login() {
		
	

		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("laksh@yahoo.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Lakshmi");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

	}



	
}



