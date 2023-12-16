package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider_demo {

	public static void main(String[] args) {

		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		   
		// actions class  
		// 1. Right click // context click 
		
		WebElement Slider= driver.findElement(By.xpath("//span[1]"));
		
		
		System.out.println("get location of min slider:"+Slider.getLocation());
		Actions act =new Actions(driver);
		
		act.dragAndDropBy(Slider, 59, 100).perform();
		
		System.out.println("After location change:"+Slider.getLocation());
		
		
		
		
	}

}
