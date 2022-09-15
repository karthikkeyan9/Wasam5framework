package practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class REtryAnalysierPracticeTest {
@Test(retryAnalyzer = vtiger_Generic_Library.RetryAnalyserImplementation.class)
public void run()
{
	System.out.println("rum");
	//Assert.fail();
}
}
