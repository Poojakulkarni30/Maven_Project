package day23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe_demos {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement frame1= driver.findElement(By.xpath("/html[1]/frameset[1]/frame[1]"));
	System.out.println(driver.switchTo().frame(frame1).getTitle());
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Selenium");
		
		
		
		
		
	}

}
