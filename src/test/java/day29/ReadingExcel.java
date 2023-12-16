package day29;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

	public static void main(String[] args) throws IOException {

		//excel-workbook-sheet-row-cell
		
		// for reading data we have class FileInputstream
		// for writing data we have class Fileoutputstream
		
		
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\testdata\\OpenCart-TestCases.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet =workbook.getSheet("Login");
		
		// reading specific row and cell data
		
		XSSFRow row= sheet.getRow(0);
		
		XSSFCell cell= row.getCell(0);

		System.out.println(cell.toString());
		
		workbook.close();
		file.close();
		System.out.println("Operation is done!!!!!");
		
	}

}
