package day25;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Datepicker {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		String date = "30";
		String month = "June";
		String Year = "1997";

		while (true) {

			String mnth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

			if (month.equals(mnth) && (yr.equals(Year))) {

				break;
			}
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
		}

	 List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td"));

		for (WebElement dates : alldates) {

			if (dates.getText().equals(date)) {

				dates.click();
			}

		} 

	}

}
