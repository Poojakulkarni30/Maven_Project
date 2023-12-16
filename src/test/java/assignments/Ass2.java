package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ass2 {
	WebDriver driver;

	@Test
	void setup() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@Test(priority = 2)
	void login() {
		
	

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("laksh@yahoo.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Lakshmi");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
 
		Assert.assertEquals("OrangeHRM", "OrangeHRM");
	}

}
