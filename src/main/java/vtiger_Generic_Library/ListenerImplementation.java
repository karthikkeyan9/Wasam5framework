package vtiger_Generic_Library;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class acts like a implementation class to override all the methods
 * in  the ITestListener
 * @author saikrishna
 *
 */

public class ListenerImplementation implements ITestListener {
	ExtentReports reports;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		String methoudname=result.getMethod().getMethodName();
		test=reports.createTest(methoudname);
		//Reporter.log(methoudname+"Started excution sucessfully", true);
	}

	public void onTestSuccess(ITestResult result) {
		String methoudname=result.getMethod().getMethodName();
		//Reporter.log(methoudname+"excution passed sucessfully", true);
		test.log(Status.PASS, methoudname+"excution passed sucessfully");
	}

	public void onTestFailure(ITestResult result) {
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtlity jutil=new JavaUtlity();
		
		String message=result.getThrowable().toString();
		String methoudname=result.getMethod().getMethodName();
		String screenshortname=methoudname+"-"+jutil.getSystemdateInFormate();
		//Reporter.log(methoudname+"excution failled because "+message, true);
		test.log(Status.FAIL, methoudname+"excution failled because ");
		test.log(Status.FAIL, result.getThrowable());
		try
		{
			String path = wutil.screenShot(BaseClass.sdriver, screenshortname);
			test.addScreenCaptureFromPath(path);
		}
		catch(IOException e)
		{
		e.printStackTrace();	
		}
		

	}

	public void onTestSkipped(ITestResult result) {
		String message=result.getThrowable().toString();
		String methoudname=result.getMethod().getMethodName();
		//Reporter.log(methoudname+"excution skipped because "+message, true);
		test.log(Status.SKIP, methoudname+"excution skipped because ");
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtlity().getSystemdateInFormate()+".html");
		htmlReport.config().setDocumentTitle("WASM-5-VTIGER Execution report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("VTIGER Execution report");
		reports=new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("base-Browser", "chrome");
		reports.setSystemInfo("Base-operating system", "windows");
		reports.setSystemInfo("Base-url", "http://localhost:8888");
		reports.setSystemInfo("reporter", "karthik");
		
		
		
	}

	public void onFinish(ITestContext context) {
		reports.flush();
		
	}
	

}
