package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_01 {

	public static void main(String[] args) throws InterruptedException {

		
WebDriver driver= new ChromeDriver();
driver.get("https://makemytrip.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//WebElement frames1= driver.findElement(By.xpath("//iframe[@id='gsi_566439_318475']"));
//driver.switchTo().frame(frames1);
Thread.sleep(5000);
driver.findElement(By.xpath("//input[@id='username']")).sendKeys("poojakulkarni352@gmail.com");
JavascriptExecutor js= (JavascriptExecutor)driver;
WebElement contiue= driver.findElement(By.xpath("//span[normalize-space()='Continue']"));
js.executeScript("arguments[0].click()", contiue);
driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Harangulkd1040@");
driver.findElement(By.xpath("//button[@data-cy='login']")).click();
WebElement framee= driver.findElement(By.xpath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']"));
		
driver.switchTo().frame(framee);
driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']")).click();;
		
		
	}

}
