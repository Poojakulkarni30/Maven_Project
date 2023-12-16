package day21;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XPath_Demo {

	public static void main(String[] args) throws InterruptedException {

		
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://devstg.tanayassessmentdev.com/");		
		driver.manage().window().maximize();
         // xpath 
		// syntax = //tagname[@attributename='attributevalue']
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("poojak@mundrisoft.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Root@123");
		driver.findElement(By.xpath("//*[@class='form-group']//div[2]")).click();
	    driver.quit();
	    
	    // xpath text method 
	    
	    driver.findElement(By.xpath("//span[text()='Users']")).click();
	    driver.findElement(By.xpath("//span[text()=' + New User']")).click();
	    driver.findElement(By.xpath("//div/span[2]/input[@formcontrolname='firstName']")).sendKeys("Meghan");
	    driver.findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys("Markle");
	    driver.findElement(By.xpath("//input[@formcontrolname='phone']")).sendKeys("123456");
	    driver.findElement(By.xpath("//input[@formcontrolname='emailId']")).sendKeys("meghan123@test.in");
	    driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Root@123");
	    driver.findElement(By.xpath("//button[@aria-label='Save']")).click();
	    
	
	
	
	
	}

}
