package day24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown_demo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		WebElement ele= driver.findElement(By.xpath("//select[@id='country-list']"));
		Select seldropdown = new Select(ele);
		/* seldropdown.selectByValue("1");
		seldropdown.selectByIndex(2);
		seldropdown.selectByVisibleText("France");
		driver.close();  */
		
		// find total number of options present in dropdown
		
		
		List <WebElement>size=seldropdown.getOptions();
		
		System.out.println("Size of options"+size.size());
		
		for (int i=0; i<size.size();i++) {
			
			String titles= size.get(i).getText();
			System.out.println(titles);
		}
		driver.quit();
		
	}

}
