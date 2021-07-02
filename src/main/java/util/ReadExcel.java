package util;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public String readExcel(int row, int col, String filePath, String sheetName) throws IOException {
	
		//opening excel file
		
		//File file = new File(filePath);
		FileInputStream fis = new FileInputStream(filePath);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		//Get excel sheet
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		//getting cell value
		XSSFCell cell = sheet.getRow(row).getCell(col);
		return String.valueOf(cell);
		
	}
}