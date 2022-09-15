package pompractice;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger_Generic_Library.ExcelFileUtility;

public class testNgpracticeTest {
	@Test(dataProvider = "getdata")
	public void nn(String name, String model, int price, String feature, int quantity) {
		System.out.println(name + "-" + model + "-" + price + "-" + feature + "-" + quantity);
	}

	@DataProvider
	public Object[][] getdata() {
		Object[][] d = new Object[4][5];
		d[0][0] = "redmi";
		d[0][1] = "note 7 pro";
		d[0][2] = 8000;
		d[0][3] = "nothing";
		d[0][4] = 1;
		return d;
	}

	/*@DataProvider(name = "excel data")
	public Object[][] readdatafrom() throws IOException {
		ExcelFileUtility eutil = new ExcelFileUtility();
		return eutil.readMultipledata(null);*/
	
}
