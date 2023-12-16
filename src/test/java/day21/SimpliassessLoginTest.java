package day21;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SimpliassessLoginTest {

	public static void main(String[] args) throws InterruptedException {

		// launch browser 
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://devstg.tanayassessmentdev.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("poojak@mundrisoft.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Root@123");	
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	String pagetitle=	driver.getTitle();
	String actualtitle= "Simpliassess";
	
	if(pagetitle.equalsIgnoreCase(actualtitle)) {
		
		System.out.println("Test Case Passed");
	}
	else {
		
		System.out.println("Test Case Failed ");
	}
	driver.quit();
		
	}

} 
