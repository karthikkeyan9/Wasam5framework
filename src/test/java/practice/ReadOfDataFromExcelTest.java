package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReadOfDataFromExcelTest {
@Test
	public  void readData() throws EncryptedDocumentException, IOException {
		//load file into input STREAM
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		// create a workbook using workbook factory
		Workbook wb = WorkbookFactory.create(fis);
		//navigate to sheet
		Sheet sh = wb.getSheet("Sheet1");
		//navigate to row
		Row row = sh.getRow(1);
		//navigate to cell
		Cell cell=row.getCell(2);
		String a=cell.getStringCellValue();
		System.out.println(cell);
		System.out.println(a);
		Reporter.log("data has been read from the excel", true);
		

	}

}
