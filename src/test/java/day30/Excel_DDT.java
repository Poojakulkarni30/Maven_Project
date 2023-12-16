package day30;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Excel_DDT {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		String filePath=System.getProperty("user.dir")+"\\testdata\\caldata.xlsx";
		
		int rows=Excel_UtilityFile.getRowCount(filePath, "Sheet1");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		for(int i=1;i<=rows;i++)
		{
			//read row from excel
			String princ=Excel_UtilityFile.getCellData(filePath,"Sheet1",i,0);
			String rateofinterest=Excel_UtilityFile.getCellData(filePath,"Sheet1",i,1);
			String per1=Excel_UtilityFile.getCellData(filePath,"Sheet1",i,2);
			String per2=Excel_UtilityFile.getCellData(filePath,"Sheet1",i,3);
			String fre=Excel_UtilityFile.getCellData(filePath,"Sheet1",i,4);
			String exp_mvalue=Excel_UtilityFile.getCellData(filePath,"Sheet1",i,5);
			
			//pass the data to the app
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(princ);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateofinterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);
			
			Select perdrp=new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			perdrp.selectByVisibleText(per2);
			
			Select fredrp=new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			fredrp.selectByVisibleText(fre);
			
			js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")));////calculate button
			
						
			
			//validation
			String act_mvalue=driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			
			if(Double.parseDouble(exp_mvalue)==Double.parseDouble(act_mvalue))
			{
				System.out.println("Test passed");
				Excel_UtilityFile.setCellData(filePath, "Sheet1",i,7,"Passed");
				Excel_UtilityFile.fillGreenColor(filePath, "Sheet1",i,7);
			}
			else
			{
				System.out.println("Test failed");
				Excel_UtilityFile.setCellData(filePath, "Sheet1",i,7,"Failed");
				Excel_UtilityFile.fillRedColor(filePath, "Sheet1",i,7);
			}
			
			js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[@class='cal_div']//a[2]"))); //clear button
		}
		
		Thread.sleep(3000);

	}

}