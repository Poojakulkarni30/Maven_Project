package day31;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNG_FrstTC {

	WebDriver driver;

	@Test (priority=1)
	void openapp() {

		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	@Test (priority=2)
	void Testlogo() {

		boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		System.out.println("Logo is displayed" + status);

	}
	@Test (priority=3)
	void login() {

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

	}
	@Test (priority=4)
	void getTitle() {
		
		if (driver.getTitle().equals("OrangeHRM")){
			
			System.out.println("Test Case Passed");
			
		}
		else {
			
			System.out.println("Test Case Failed");
		}
		
	}
	@Test (priority=5)
	void closeapp() {
		driver.quit();
	}

}
