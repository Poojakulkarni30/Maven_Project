package day22;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment01 {

	public static void main(String[] args) {

		
		WebDriver driver=new ChromeDriver();

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@class='wikipedia-search-input']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@class='wikipedia-search-button']")).click();
		//driver.findElement(By.xpath("//a[text()='Selenium']")).click();
		
		List<WebElement> searchlinks=driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//div/a"));
		
		  System.out.println(searchlinks.size());
		  
		  for(int i=0;i<searchlinks.size();i++) {
			  
			  searchlinks.get(i).click();
	
		  }
		  
		Set <String> winids=  driver.getWindowHandles();

		System.out.println("Switching to each browser window and getting the titles........"); 
		
		for(String winid:winids) {
			
		String title=	driver.switchTo().window(winid).getTitle();
			if(title.contains("Selenium (software) ") || title.contains("Selenium disulfide")) {
				driver.close();
			}
		}

	}
	}
