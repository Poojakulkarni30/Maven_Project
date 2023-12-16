package day25;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_01 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//select[@name='fromPort']//option[3]")).click();
		driver.findElement(By.xpath("//select[@name='toPort']//option[2]")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.findElement(By.xpath("//tbody//tr//input")).click();

		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys(" Pooja Kulkarni");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Kulkarni house");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Latur");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Maharashtra");
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("413531");
		driver.findElement(By.xpath("//select[@id='cardType']//option[2]")).click();
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("12546665");
		driver.findElement(By.xpath("//input[@id='creditCardMonth']")).clear();
		driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("06");
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Pooja Kulkarni");
        driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
        driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
        
      String tc1=  driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).getText();
		
		if(tc1.equals("Thank you for your purchasee today!")) {
			System.out.println("Test Case Passed");
		}
		else {
			System.out.println("Test Case Failed");
		}
		driver.close();
	}

}
