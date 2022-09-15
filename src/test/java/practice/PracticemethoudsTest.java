package practice;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import vtiger_Generic_Library.ExcelFileUtility;
import vtiger_Generic_Library.JavaUtlity;

public class PracticemethoudsTest {
	
@Test
	public  void practicee() throws EncryptedDocumentException, IOException {
		JavaUtlity j=new JavaUtlity();
		String a=j.getSystemdateInFormate();
		System.out.println(a);
		ExcelFileUtility e=new ExcelFileUtility();
		String s=e.readDataFromExcel("sheet1", 1, 1);
		System.out.println(s);
		

	}

}
