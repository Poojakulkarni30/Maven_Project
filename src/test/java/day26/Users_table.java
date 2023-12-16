package day26;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Users_table {

	public static void main(String[] args) throws InterruptedException {


		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://devstg.tanayassessmentdev.com/#/login");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("poojak@mundrisoft.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("SouthAfrica@135");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Examinees']")).click();
		driver.findElement(By.xpath("//button[@role='menuitem']//span[contains(text(),'Examinees')]")).click();	
		
		int noOfRows=driver.findElements(By.xpath("//table[@role='table']//tbody//tr")).size();
		Thread.sleep(3000);
		for(int r=1;r<=noOfRows;r++)
		{
			String FirstName=driver.findElement(By.xpath("//table[@role='table']//tbody//tr["+r+"]/td[1]")).getText();
			String LastName=driver.findElement(By.xpath("//table[@role='table']//tbody//tr["+r+"]/td[2]")).getText();
			String Email=driver.findElement(By.xpath("//table[@role='table']//tbody//tr["+r+"]/td[3]")).getText();
			String Status=driver.findElement(By.xpath("//table[@role='table']//tbody//tr["+r+"]/td[4]")).getText();
			System.out.println(FirstName+"\t"+LastName+"\t"+Email+"\t"+Status);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
