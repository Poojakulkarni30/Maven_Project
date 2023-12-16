package day28;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Broken_links {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	List<WebElement>links=	driver.findElements(By.tagName("a"));
		System.out.println(links.size());
 
		
int brokenlinks=0;
		
		for(WebElement linkset:links) {
			
			String hrefvalue= linkset.getAttribute("href");
			
		try {
			if(hrefvalue==null||hrefvalue=="") {
				System.out.println("Href value is empty or null");
				continue;
			}

				URL urlss= new URL(hrefvalue);
				HttpURLConnection conn=(HttpURLConnection)urlss.openConnection();
				conn.connect();
				
				if(conn.getResponseCode()>=400) {
					System.out.println(hrefvalue+" Broken links ");
					brokenlinks++;

			}
				else {
					
					System.out.println(hrefvalue+"Not broken link");
				}
				
		}
		catch(Exception e) {}
			
		}
		
		System.out.println("Total number of broken links:"+brokenlinks);

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
