package day23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Iframe_Assignment {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement frame1 = driver.findElement(By.xpath("/html[1]/frameset[1]/frame[1]"));
		System.out.println(driver.switchTo().frame(frame1).getTitle());
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Selenium");
		driver.switchTo().defaultContent();
		WebElement frame2 = driver.findElement(By.xpath("//frameset//frameset//frame[1]"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Testing");
		driver.switchTo().defaultContent();

		WebElement frame3 = driver.findElement(By.xpath("//frameset//frameset//frame[2]"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("JAVA");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//span[text()=\"I am a human\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"Web Testing\"]")).click();
		driver.findElement(By.xpath("//span[text()='General Web Automation']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Choose']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option']//span[@class='vRMGwf oJeWuf'][normalize-space()='Yes']")));
		element.click();
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.xpath("//div[@jsname='XmnwAc'][1]")).sendKeys("cccfdd");


		driver.switchTo().defaultContent();

		WebElement frame4 = driver.findElement(By.xpath("//frameset//frameset//frame[3]"));
		driver.switchTo().frame(frame4);

		driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("Automation");
		driver.switchTo().defaultContent();
		driver.close();

	}

}
