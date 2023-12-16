package day28;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Get_Screenshots {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		// full screenshot 
	/*	TakesScreenshot Ts = (TakesScreenshot) driver;
		File src = Ts.getScreenshotAs(OutputType.FILE);

		File target = new File(System.getProperty("user.dir") + "\\Screenshots\\fullpage.png");

		FileUtils.copyFile(src, target);     */
		
		// webelement screenshots
		
	/*	WebElement featuredproducts = driver.findElement(By.xpath("//img[@alt='iPhone 6']"));

		File srcfile= featuredproducts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\Screenshots\\featuredprods.png");
		
		
		FileUtils.copyFile(srcfile, targetfile);  
		
		*/
		
		
		// specific element screenshots
		
		
		WebElement logo = driver.findElement(By.xpath("//img[@title='Your Store']"));

		File srclogofile= logo.getScreenshotAs(OutputType.FILE);
		File targetsavefile=new File(System.getProperty("user.dir")+"\\Screenshots\\logo.png");
		
		
		FileUtils.copyFile(srclogofile, targetsavefile);  
		
		
		
		
		
		
	}

}
