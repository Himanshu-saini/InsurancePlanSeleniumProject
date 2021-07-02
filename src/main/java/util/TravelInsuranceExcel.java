package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TravelInsuranceExcel {
	public static Object[][] readData(String workBookPath) {
		Object[][] data = null;

		try {
			File file = new File(workBookPath);
			FileInputStream fis = new FileInputStream(file);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			int rowCount = sheet.getLastRowNum()+1;
			int cellCount = sheet.getRow(0).getLastCellNum();
			System.out.println("Row Count: " + rowCount);
			System.out.println("Cell Count: " + cellCount);

			data = new Object[rowCount][cellCount];

			for (int i = 0; i < rowCount; i++) {
				XSSFRow currRow = sheet.getRow(i);
				for (int j = 0; j < cellCount; j++) {
					Cell currCell = currRow.getCell(j);
					switch (currCell.getCellType()) {
						case STRING:
							data[i][j] = currCell.getStringCellValue();
							break;
						case NUMERIC:
							data[i][j] = (long)currCell.getNumericCellValue()+"";
							break;
						default:
							break;
					}
					System.out.println("in Excel - Value: " + data[i][j]);
				}
			}

		} catch (FileNotFoundException fe) {
			System.out.println(" file not found: " + workBookPath);
		} catch (IOException io) {
			System.out.println(" Input/Output error");
		}
		return data;

	}
}
