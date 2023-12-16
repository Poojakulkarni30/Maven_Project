package day29;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataintoexcel {

	public static void main(String[] args) throws IOException {

		//excel=workbook=sheet=row=cell
		
		
		
		FileOutputStream file= new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook();
		XSSFSheet sheet= workbook.createSheet("Sheet 1");
		
		XSSFRow row =sheet.createRow(0);
		
		XSSFCell cell= row.createCell(0);
		
	cell.setCellValue("Welcome");
	workbook.write(file);
	
	System.out.println("code executed");
		workbook.close();
		file.close();
		
		
		
		
		
	}

}
