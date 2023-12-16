package day25;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_02 {

	public static void main(String[] args) {

		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("//input[@id='product_3186']")).click();	
		driver.findElement(By.xpath("//input[@id='travname']")).sendKeys("POOJA");
		driver.findElement(By.xpath("//input[@id='travlastname']")).sendKeys("KULKARNI");
		driver.findElement(By.xpath("//input[@name='dob']")).click();
	driver.findElement(By.xpath("//select[@data-handler='selectMonth']//option[6]")).click();
		driver.findElement(By.xpath("//select[@class='ui-datepicker-year']//option[@value='1997']")).click();
	driver.findElement(By.xpath("//a[normalize-space()='30']")).click();
		driver.findElement(By.xpath("//input[@id='sex_2']")).click();
		driver.findElement(By.xpath("//input[@id='traveltype_2']")).click();
		driver.findElement(By.xpath("//input[@id='fromcity']")).sendKeys("Pune");
		driver.findElement(By.xpath("//input[@name='tocity']")).sendKeys("Latur");
		driver.findElement(By.xpath("//input[@id='departon']")).click();
		driver.findElement(By.xpath("//a[text()='5']")).click();
		driver.findElement(By.xpath("//input[@name='returndate']")).click();
		driver.findElement(By.xpath("//a[text()='10']")).click();
		driver.findElement(By.xpath("//textarea[@id='notes']")).sendKeys(" Text dummy ");
		driver.findElement(By.xpath("//span[@id='select2-reasondummy-container']")).click();
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("Visa extension"+Keys.ENTER);
		driver.findElement(By.xpath("//label[normalize-space()='Email']")).click();
		driver.findElement(By.xpath("//input[@id='billname']")).sendKeys(" Pooja Kulkarni");
		driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys(" 12366666");
		driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("poojakulkarni352@gmail.com");
		driver.findElement(By.xpath("//span[@id='select2-billing_country-container']")).click();
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("India"+Keys.ENTER); 
		driver.findElement(By.name("billing_address_1")).sendKeys("13646 ABC");
		driver.findElement(By.name("billing_address_2")).sendKeys("ABC");
		driver.findElement(By.name("billing_city")).sendKeys("HYD");
		driver.findElement(By.xpath("//span[@id='select2-billing_state-container']")).click(); //Boostrap DropDown
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("Telangana"+Keys.ENTER); //state
				
		driver.findElement(By.id("billing_postcode")).sendKeys("500090"); //Pin
		driver.findElement(By.xpath("//button[@id='place_order']")).click();
		
		
		driver.quit();
		
	}

}
