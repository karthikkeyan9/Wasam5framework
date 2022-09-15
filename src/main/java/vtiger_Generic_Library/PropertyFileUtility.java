package vtiger_Generic_Library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class PropertyFileUtility {
	/**
	 * This methoud gives the value as return for the key passed from the propertyfile
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyfile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.propertyfilepath);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

}
