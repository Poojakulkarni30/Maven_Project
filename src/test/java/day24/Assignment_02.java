package day24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_02 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		
		driver.findElement(By.xpath("//div[@class='oxd-table-filter']//div[3]//div[1]//div[2]//div[1]//div[1]//div[1]")).click();
		
		List <WebElement> empstatus = driver.findElements(By.xpath("//div[@role='option']//span"));
		
		System.out.println(empstatus.size());
		
		for (int i=0;i<empstatus.size();i++) {
			
			String status=empstatus.get(i).getText();
			
			if(status.equalsIgnoreCase("Full-Time Contract")) {
				
				empstatus.get(i).click();
				break;
			}
			
			
		}
		
		driver.quit();
		
	}

}
