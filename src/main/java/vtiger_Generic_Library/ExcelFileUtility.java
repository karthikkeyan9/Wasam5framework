package vtiger_Generic_Library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class contains all excel sheet methouds
 * @author saikrishna
 *
 */

public class ExcelFileUtility {
/**
 * This methoud gives the value present in the cellnum passed
 * @param sheet
 * @param rownum
 * @param cellnum
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String readDataFromExcel(String sheet,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);
		Row row = s.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value=cell.getStringCellValue();
		wb.close();
		return value;
	}
	/**
	 * This metoud return the number of rows present in given input sheet
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getnumberofrow(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);
		int num = s.getLastRowNum();
		return num;
		
	}
	/**
	 * This methoud is used to set a value in any give cell number and value by passing to arguments
	 * @param sheet
	 * @param rownum
	 * @param cellnum
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setcellvalue(String sheet,int rownum,int cellnum,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);
		Row row = s.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(value);
			
	}
	/**
	 * This methoud is used to return multiple set of data since it will return two dimensional array 
	 * so that it will directly used in @Dataprovider
	 * @param sheet
	 * @return
	 * @throws IOException
	 */
	public Object[][] readMultipledata(String sheet) throws IOException {
		FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);
		int lastrow=s.getLastRowNum();
		int lastcell=s.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				data[i][j]=s.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
	
}
