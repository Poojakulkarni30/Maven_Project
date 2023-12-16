	package day28;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutor_Demo {

	public static void main(String[] args) {

		
		/* Js is an interface  when user create 
		 
		 webdriver driver = new chromedriver ();
		 JavascriptExecutor js = driver;
		 it will give error because both interfaces are not at all related to each other
		 
		 but when u do 
		  chromedriver driver = new chromedriver ();
		 JavascriptExecutor js = driver;
		 
		 it will accept u can store child into parent 
		 
		 */
		
		WebDriver driver =new ChromeDriver();
		
	   driver.get("https://testautomationpractice.blogspot.com/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	   
	     JavascriptExecutor js = (JavascriptExecutor)driver;
		

	      WebElement name= driver.findElement(By.xpath("//input[@id='name']"));
	                                 
	    js.executeScript("arguments[0].setAttribute('value','Pooja')",name);
		
		
	    WebElement email= driver.findElement(By.xpath("//input[@id='email']"));
	    js.executeScript("arguments[0].setAttribute('value','Pk@321.in')",email);
		
	    WebElement phone= driver.findElement(By.xpath("//input[@id='phone']"));

		js.executeScript("arguments[0].setAttribute('value','123456')", phone);
		
		// how to handle radio button
		
		WebElement	radiobtn=driver.findElement(By.xpath("//label[normalize-space()='Female']"));
		js.executeScript("arguments[0].click()",radiobtn);
		
		
		// how to handle checkbox
		
		
		WebElement	checkbox=driver.findElement(By.xpath("//label[normalize-space()='Sunday']"));

		js.executeScript("arguments[0].click()", checkbox);
		
		// how to handle button
		
	
		WebElement	btn=driver.findElement(By.xpath("//button[normalize-space()='New Browser Window']"));

		js.executeScript("arguments[0].click()", btn);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
