package day34;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeHrm {

	WebDriver driver;

	@BeforeClass
	void setup() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@Test(priority = 2)
	void login() {

		driver.findElement(By.xpath("//input[@placeholder='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

	}

	@Test(priority=1)
	void TestcurrentUrl() {

		String currentUrl=driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(priority=3)
	void TestGetTitle() {
		
	String title= driver.getTitle();
	
	Assert.assertEquals(title, "OrangeHRM");
	
	}
	@AfterClass
	
	void TearDown() {
		
		driver.quit();
	}
	
}
