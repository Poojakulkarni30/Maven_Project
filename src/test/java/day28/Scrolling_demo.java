package day28;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrolling_demo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// total 3 methods

		// 1. move by pixel number

		js.executeScript("window.scrollBy(0,3000)", "");

		System.out.println(js.executeScript("return window.pageYOffset;")); // 300

		// 2. Move to particular element

		WebElement flag = driver.findElement(By.xpath("//img[@alt='Flag of Kenya']"));

		js.executeScript("arguments[0].scrollIntoView();", flag);
		System.out.println(js.executeScript("return window.pageYOffset;")); // 7567.7919921875

		// 3. move to the end
		
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		Thread.sleep(5000);
		
		//go back to initial point
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
		
		
		
		
		
		
		

	}


