package day30;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilityforCiti {

	// excel=workbook=sheet=row=cell
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow Rows;
	public static XSSFCell Cells;
	public static CellStyle style;


	// get row count
	// get count
	// enter data into cell
	
	public static int getrowcount(String xlfile, String xlsheet) throws IOException {
		
		fi=new FileInputStream(xlfile);
		workbook= new XSSFWorkbook(fi);
		sheet =workbook.getSheet(xlsheet);
		int rowcount =sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return  rowcount;
	}
		
		
		public static int getcellcount(String xlfile, String xlsheet, int rownum) throws IOException {
			fi=new FileInputStream(xlfile);
			workbook= new XSSFWorkbook(fi);
			sheet =workbook.getSheet(xlsheet);
			Rows=sheet.getRow(rownum);
			int cellcount = Rows.getLastCellNum();
			workbook.close();
			fi.close();
			return cellcount;
		}
	 
	public static String getcelldata(String xlfile, String xlsheet,int rownum, int cellnum ) throws IOException {
		
		fi=new FileInputStream(xlfile);
		workbook= new XSSFWorkbook(fi);
		sheet =workbook.getSheet(xlsheet);
		Rows=sheet.getRow(rownum);
		Cells = Rows.getCell(cellnum);
		String data;
		try 
		{
			//data=cell.toString();
			
			DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(Cells);
            return data;
		}
		catch (Exception e) 
		{
			data="";
		}
		
		
		workbook.close();
		fi.close();
		return data;
	}
	public static void setcelldata(String xlfile, String xlsheet,int rownum, int cellnum,String data) throws IOException {
		
		
		fi=new FileInputStream(xlfile);
		workbook= new XSSFWorkbook(fi);
		sheet =workbook.getSheet(xlsheet);
		Rows=sheet.getRow(rownum);
		Cells = Rows.createCell(cellnum);

		Cells.setCellValue(data);
	    fo= new FileOutputStream(xlfile);
	    workbook.write(fo);
	    workbook.close();
	    fi.close();
	    fo.close();
	}	
	    public static void fillGreenColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
		{
			fi=new FileInputStream(xlfile);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(xlsheet);
			Rows=sheet.getRow(rownum);
			Cells=Rows.getCell(colnum);
			
			style=workbook.createCellStyle();
			
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
					
			Cells.setCellStyle(style);
			fo=new FileOutputStream(xlfile);
			workbook.write(fo);
			workbook.close();
			fi.close();
			fo.close();
		}
		
		
		public static void fillRedColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
		{
			fi=new FileInputStream(xlfile);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(xlsheet);
			Rows=sheet.getRow(rownum);
			Cells=Rows.getCell(colnum);
			
			style=workbook.createCellStyle();
			
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
			
			Cells.setCellStyle(style);		
			fo=new FileOutputStream(xlfile);
			workbook.write(fo);
			workbook.close();
			fi.close();
			fo.close();
	
	
	
	
	
	
	
	
	
	
	
	}
}
