package day32;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class BeforeMethodDemo {

	/*
	 * 1. before suite 2. before test 3. before class 4. before method 5. after
	 * method 6. after class 7. after test 8. after method
	 * 
	 */

	/*
	 * 
	 * 1. TC
	 * 
	 * 1. open app 2. login to app 3. search test 4. logout 5. login 6. adv search
	 * test 7. logout
	 */
	WebDriver driver;

	@BeforeMethod

	void openapp() {

		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	void login() {

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Test(priority = 2)
	void getcurrenturl() throws InterruptedException {

		Thread.sleep(3000);

		String currenturl = driver.getCurrentUrl();

		Thread.sleep(3000);
		try {

			Assert.assertEquals(currenturl, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

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

	@AfterMethod
	void TearDown() {
		driver.quit();
	}
}
