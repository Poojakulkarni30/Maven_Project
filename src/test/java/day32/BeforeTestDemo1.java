package day32;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeTestDemo1 {
	
	
	
	WebDriver driver;
	
	
	@BeforeTest
	void OpenApp() {
		
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test	(priority = 1)
	void login() {

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Test(priority = 2)
	void getcurrenturl() throws InterruptedException {

		Thread.sleep(3000);
		
	
	String currenturl= driver.getCurrentUrl();

		Thread.sleep(3000);
		try {

			Assert.assertEquals(currenturl, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

		} catch (Exception e) {

			System.out.println("url not matching");
		}
	}

	@Test(priority = 3)
	void getTitle() {

		String actualTitle = driver.getTitle();
		try {
			Assert.assertEquals(actualTitle, "OrangeHRM");
		} catch (Exception e) {

			System.out.println("logo is not displayed");
		}
	}













}
