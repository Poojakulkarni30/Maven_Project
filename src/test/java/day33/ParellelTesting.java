package day33;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParellelTesting {

	WebDriver driver;

	@BeforeClass
	@Parameters({"browser","url"})
	void openApp(String br, String appurl ) {
 
		if(br.equals("chrome")) {
		driver = new ChromeDriver();
		}
		else if(br.equals("Edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test(priority = 1)
	void login() {

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Test(priority = 2)
	void GetTitle() {

		String title = driver.getTitle();
		AssertJUnit.assertEquals(title, "OrangeHRM");
	}

	@Test(priority = 3)
	void GetCurrentUrl() {

		String Url = driver.getCurrentUrl();
		AssertJUnit.assertEquals(Url, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
	}
	@Test(priority = 4)
	void logout() {
		
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
	}
	
	
	@AfterClass
	void TearDown() {
		
		driver.quit();
	}
	

	
}
