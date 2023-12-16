package day35;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login_Test {

	
	WebDriver driver;
	
	@BeforeClass
	void setup() {
		
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@Test(priority=1)
	
	void login() {
		
		LoginPage lp=new LoginPage(driver);
		lp.Setusername("Admin");
		lp.setpassword("admin123");
		lp.loginbtn();
	}
	
	
	@Test(priority=2)
	
	void GetTitle() {
		
	Assert.assertEquals(driver.getTitle(), "OrangeHRM");	
		
	}
	
	
	@Test(priority=3)
	void GetCurrentUrl() {
		


	Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/");
	
	
	}
	
	
	@AfterClass
	void tearDown() {
		
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
