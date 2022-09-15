package practice;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReadDataFromPropertiesFileTest {
	@Test	
	public void readDatafopop() throws IOException {
		
			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
			
			//create object of properties of java
			Properties p =new Properties();
			
			//load the file to propertiesobj
			p.load(fis);
			
			//read data through the key
			String BROWSER =p.getProperty("browser");
			System.out.println(BROWSER);
			String URL=p.getProperty("url");
			System.out.println(URL);
			String USERNAME=p.getProperty("username");
			String password =p.getProperty("password");
			
			Reporter.log("keys send with"+USERNAME+password+URL, true);

			
		

	}


}
