package day21;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Locators_demo {

/*  	// locators 
 *    1. id 
 *    2. name
 *    3. classname
 *    4. link text
 *    5. partial link text
 *    6. tagname
 *    7. xpath - 
 *    8. css selector
 *        1. tag and ID ---->>  #id
 *        2. tag and classname --->  .classname
 *        3. tag & attribute  ---->  [attname=att value]
 *        4. tag,class and attribute --->  .class[attname = attvalue]
 *   */
	
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		// css selector 
		
		// 1. tag with class (tag.classvalue)
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector(".oxd-input")).sendKeys("Admin");
		driver.findElement(By.cssSelector(".oxd-input[type='password']")).sendKeys("admin123");
		driver.findElement(By.cssSelector(".oxd-button[type*='submit']")).click();
		
		
		
		
		
		// link text 
		
		driver.findElement(By.linkText("Forgot password?")).click();	
		
	}

}
