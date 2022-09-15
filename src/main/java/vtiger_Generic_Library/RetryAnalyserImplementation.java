package vtiger_Generic_Library;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer{
	int count=0,retry=4;
	public boolean retry(ITestResult result) {
		
		while(count<retry)
		{
			count++;
			return true;
		}
		
		return false;
	}
	

}
