package day22;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox_Demo {

	public static void main(String[] args) {
		
		
		WebDriver driver=new ChromeDriver();

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		// wait commands 
		
		// checking all boxes
		
	  /* List<WebElement> chk=driver.findElements(By.xpath("//input[@type='checkbox'and @class='form-check-input']"));
				
	        for(WebElement chkk:chk) {
					
	           chkk.click();
	   */
	           List<WebElement> chk=driver.findElements(By.xpath("//input[@type='checkbox'and @class='form-check-input']"));
	  
	           for(int i=0; i<chk.size();i++) {
	        	   
	        	   if(i<=2) {
	        	   
	        	 chk.get(i).click();
	        	   }
	           
	           
	}
				
		
	}
}
