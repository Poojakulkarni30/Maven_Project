package day25;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagination_table {

	public static void main(String[] args) throws InterruptedException {

		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		driver.findElement(By.xpath("//a[text()=' Customers']")).click();
		driver.findElement(By.xpath("//ul[@class='collapse show']//a[contains(text(),'Customers')]")).click();
       String text=driver.findElement(By.xpath("//div[contains(text(),'Showing')]")).getText();
		
		
		//capture total number of page
		int total_pages=Integer.parseInt(text.substring(text.indexOf("(")+ 1, text.indexOf("Pages")-1));
		System.out.println(total_pages);
		
		
		for(int p=1;p<=10;p++)   //for(int p=1;p<=total_pages;p++)
		{
			if(total_pages>1)
			{
				WebElement active_page=driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+p+"]"));
				System.out.println(active_page.getText());
				active_page.click();
				Thread.sleep(3000);
			}
			
			//reading data from table
			int noOfRows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			
			for(int r=1;r<=noOfRows;r++)
			{
				String customerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[2]")).getText();
				String email=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[3]")).getText();
				String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[5]")).getText();
				
				System.out.println(customerName+"\t"+email+"\t"+status);
			}
			driver.findElement(By.xpath("//div[@class='mat-select-arrow ng-tns-c128-8']")).click();
			driver.findElement(By.xpath("//span[normalize-space()='50']")).click();
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
