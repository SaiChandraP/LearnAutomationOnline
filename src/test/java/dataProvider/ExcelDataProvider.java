package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	//Global Variables
	//wb object will help us to read the Xlsx files
	XSSFWorkbook wb;
	
	//creating a constructor
	public ExcelDataProvider(){
		
		//this load the workbook/file
		File src = new File("./ApplicationTestData/AppData.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	//this method getData will take 3 values i.e. sheetIndex, row number, column number & gives us the cell value
	public String getData(int sheetIndex, int row, int column){
		
		String data = wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	//this method getData will take 3 values i.e. sheetName, row number, column number & gives us the cell value
	public String getData(String sheetName, int row, int column){
			
		String data = wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	

}
