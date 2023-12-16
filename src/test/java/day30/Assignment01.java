package day30;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment01 {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();

		String filePath = System.getProperty("user.dir") + "\\testdata\\caldata2.xlsx";

		int rows = ExcelUtilityforCiti.getrowcount(filePath, "Sheet1");
		WebElement calbutton = driver.findElement(By.xpath("//button[@id='CIT-chart-submit']")); // 'Lets run the
																									// numbers' button

		for (int i = 1; i <= rows; i++) {
			// read row from excel
			String initialdeposit = Excel_UtilityFile.getCellData(filePath, "Sheet1", i, 0);
			String interestrate = Excel_UtilityFile.getCellData(filePath, "Sheet1", i, 1);
			String length = Excel_UtilityFile.getCellData(filePath, "Sheet1", i, 2);
			String compounding = Excel_UtilityFile.getCellData(filePath, "Sheet1", i, 3);
			String total = Excel_UtilityFile.getCellData(filePath, "Sheet1", i, 4);

			// pass the data to the app
			WebElement ID = driver.findElement(By.xpath("//input[@formcontrolname='cdAmount']"));
			ID.clear();
			ID.sendKeys(initialdeposit);

			WebElement lgth = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
			lgth.clear();
			lgth.sendKeys(length);

			WebElement IR = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
			IR.clear();
			IR.sendKeys(interestrate);

			driver.findElement(By.xpath("//div[@class='mat-select-arrow-wrapper ng-tns-c109-4']")).click();


			List<WebElement> options=driver.findElements(By.xpath("//div[@id='mat-select-0-panel']//mat-option"));
			
			for(WebElement option:options)
			{
				if(option.getText().equals(compounding))
					option.click();
			}

				calbutton.click(); /// click on button to calculate cd calculation based on xl cell data
				String acttotal = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();

				System.out.println("act total is: " + acttotal);
				System.out.println("exp total is: " + total);

				if (total.equals(acttotal)) { // if expected total = actual total then

					ExcelUtilityforCiti.setcelldata(filePath, "Sheet1", i, 6, "Passed"); // setting passed in 6th column
																							// (index start with zero)
					ExcelUtilityforCiti.fillGreenColor(filePath, "Sheet1", i, 6); // filling the color in 6th column if
																					// passed then greeen or faile then
																					// red.
				} else {
					ExcelUtilityforCiti.setcelldata(filePath, "Sheet1", i, 6, "Failed");
					ExcelUtilityforCiti.fillRedColor(filePath, "Sheet1", i, 6);
				}
			}
			System.out.println("calculation has been completed");
			driver.close();
		}
	}


