package day24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment01 {

	public static void main(String[] args) {

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://phppot.com/demo/country-state-city-example-cascading-jquery-dependent-dropdown/");
	
		
	driver.findElement(By.xpath("//select[@name='country']")).click();
	
	List <WebElement> options =  driver.findElements(By.xpath("//select[@id='country-list']//option"));

		
		System.out.println(options.size());
		
		for(int i=0; i<options.size();i++) {
			
		String text=	options.get(i).getText();
		
		if(text.equalsIgnoreCase("Brazil")) {
			
		options.get(i).click();
		}
		}
		
		driver.close();
		
	}

}
