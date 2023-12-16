package day33;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	
WebDriver driver;
	
	
	
	@BeforeClass
	void openApp() {
		
		driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	
	@Test (priority=2, dataProvider="dp")
	void login(String email, String password) {

		driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	}
	
	
	@DataProvider(name="dp", indices= {0,4}) // if you want to enter some specific data then use indices with index
	Object logindata(){
		Object data [][]= {
				
				{"test@gmail.com","234"},
				{"jk@gmail.com","7225252"},
				{"pooja@gmail.com","355vcx"},
				{"test@gmail.com","2ccc34"},
				{"abc@gmail.com","123456"}
				
				
		};
		return data;
		
	}
	
	@AfterClass
	void TearDown() {
		
		driver.quit();
	}
	
	
	
	
	
	
	

}
