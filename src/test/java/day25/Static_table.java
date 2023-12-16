package day25;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Static_table {

	public static void main(String[] args) {

		/*
		 * 1. find row size 2. find column size 3. find table data
		 */

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// calculate the size or rows

		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();

		System.out.println("Row size: " + rows);

		// calculate the size of column

		int column = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();

		System.out.println("Column size: " + column);

		// read specific column data and row data
		
		String data =driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[2]")).getText();
		
		System.out.println("Specific data read: "+data);
		
		// read all column and row data 
		
		for (int r=2; r<=rows;r++) {
			
			for(int c=1;c<=column;c++) {
				

			String datas=	driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				
				System.out.println(datas+"\t");
				
			}
			System.out.println();
			
			
		} 
		
		
		    // print books whose author name is amit 
		
		     for(int r=2; r<=rows;r++) {
		    	 
		    	
		    	String authorname= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
		          
		     
		         if(authorname.equals("Animesh")) {
		        	 
		        	 String bookname=  driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
		        	 System.out.println(authorname + "     "+ bookname);
		        	 
		         }
		     
		     
		     
		     }
		// find prices of all books 
		     
		     int total=0;
		     
		     for(int r=2; r<=rows;r++) {
		    	 
			    	
			    	String Price= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			          
		total = total+Integer.parseInt(Price);
		

	}
		     System.out.println(total);
		     driver.close();
	}
}
