package day32;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_AssertDemo {
	
	
	//for soft assertion rest of code will execute user have to user variablename.assertall command everytime

	WebDriver driver;

	@Test(priority = 1)

	void openapp() {

		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

	}

	@Test(priority = 2)
	void login() {

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Test(priority = 3)
	void getTitle() {

		String actualTitle = driver.getTitle();
		SoftAssert sa = new SoftAssert();

		sa.assertEquals(actualTitle, "Soft Assert Fail");
		System.out.println("Soft assertion");
		driver.quit();
		sa.assertAll();
	}
}
