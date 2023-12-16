package day24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrap_Multiselect_dropdown {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
	driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[1]/div[1]/div[1]")).click();
	
		List <WebElement>test= driver.findElements(By.xpath("//div[@role='listbox']//span"));
		
		 System.out.println(test.size());
		
		 for(int i=0; i<test.size();i++) {
			 
			String getext = test.get(i).getText();
			System.out.println(getext);
			
			if(getext.equalsIgnoreCase("Content Specialist")){
				
				test.get(i).click();
			}
		 }
		
		
		
		
		
		
		
		
		
		
		
	}

}
