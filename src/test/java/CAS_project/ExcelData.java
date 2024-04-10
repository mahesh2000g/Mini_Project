package CAS_project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	public static void main(String[] args) throws IOException {
		
		
////		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\Excel.xlsx"); 
//		FileOutputStream file = new FileOutputStream(".\\testData\\Excel.xlsx");
//		
//		XSSFWorkbook worrkbook = new XSSFWorkbook();
//		XSSFSheet sheet =  worrkbook.createSheet();
//		
//		XSSFRow row1 =  sheet.createRow(0);
//		  row1.createCell(0).setCellValue("S/NO");
//		  row1.createCell(1).setCellValue("Data");
//		
//		XSSFRow row2 =  sheet.createRow(1);
//		  row2.createCell(0).setCellValue("1");
//		  row2.createCell(1).setCellValue("https://be.cognizant.com");
//		
//		Scanner scan= new Scanner(System.in);
//		
//		for(int r=0 ; r<2 ; r++)
//		{
//			XSSFRow row =  sheet.createRow(r);
//			
//			for(int c=0 ; c<2 ; c++)
//			{
//				XSSFCell cell = row.createCell(c);
//				System.out.println("Enter data");
//				cell.setCellValue(scan.next());
//			}
//			
//		}
//		worrkbook.write(file);
//		worrkbook.close();
//		file.close();
//		
		
		
		
		
		
		
//		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\Excel.xlsx"); 
		FileInputStream file = new FileInputStream("C:\\Users\\2318404\\eclipse-workspace\\mini_project\\testData\\Excel.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet =  workbook.getSheet("Sheet0");
		int roww = sheet.getLastRowNum();
		int cel= sheet.getRow(1).getLastCellNum(); 
		
		String [][]a= new String[roww][cel];
		
		for(int r=0 ; r<=roww ; r++)
		{
			XSSFRow row =  sheet.getRow(r);
			
			for(int c=0 ; c<cel ; c++)
			{
				XSSFCell cell =  row.getCell(c);
				a[r][c] =cell.toString();
				System.out.println(a[r][c]);
			}
		}
	

	}

}
