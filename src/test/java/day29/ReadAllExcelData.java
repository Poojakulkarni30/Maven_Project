package day29;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAllExcelData {

	// excel=workbook=sheet=row=cell

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\testdata\\Test Cases_Practice.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("HOME PAGE");
		int totalrow = sheet.getLastRowNum();
		System.out.println("total number of rows:" + totalrow);

		int totalcell = sheet.getRow(0).getLastCellNum();
		System.out.println("total number of cells:" + totalcell);
		for (int r = 0; r <= totalrow; r++) {

			XSSFRow rows = sheet.getRow(r);

			for (int c = 0; c < 3; c++) {

				XSSFCell cells = rows.getCell(c);
				System.out.print(cells.toString()+"\t");

			}

			System.out.println();

		}

		workbook.close();
		file.close();

		System.out.println("Done.........");

	}

}
