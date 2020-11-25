package genericMethods;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	static String Readpath = "src/test/resources/AxisBankTestData.xlsx";
	String sheetName = "sheet1";
	XSSFWorkbook ExcelWBook;
	XSSFSheet ExcelSheet;
	XSSFRow Row;
	XSSFCell Cell;
	String cellValue;

	public String ExcelRead_amount() {

		try {
			FileInputStream file = new FileInputStream(Readpath);
			ExcelWBook = new XSSFWorkbook(file);
			ExcelSheet = ExcelWBook.getSheet(sheetName);
			Row = ExcelSheet.getRow(1);
			Cell = Row.getCell(0);
			cellValue = Cell.getStringCellValue();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellValue;

	}
}
