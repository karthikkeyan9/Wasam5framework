package vtiger_Generic_Library;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass {
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	public DatabaseUtility dutil=new DatabaseUtility();
	public ExcelFileUtility eutil=new ExcelFileUtility();
	public JavaUtlity jutil=new JavaUtlity();
	public WebDriverUtility wutil=new WebDriverUtility();
	public PropertyFileUtility putil=new PropertyFileUtility();
	@BeforeSuite(groups = {"smoketesting","regression testing"})
	public void bdconfig() throws SQLException
	{
		//dutil.toCreateCOnnection();
		Reporter.log("-----data base connection", true);
	}
	//@Parameters("BROWSER")
	//@BeforeTest
	@BeforeClass(groups = {"smoketesting","regression testing"})
	public void bsconfig() throws IOException
	{
		
		String BROWSER=putil.readDataFromPropertyfile("browser");
		String URL=putil.readDataFromPropertyfile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			Reporter.log("browser"+BROWSER+"launched sucessfully", true);
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			Reporter.log("browser"+BROWSER+"launched sucessfully", true);
		}
		else
		{
			System.out.println("invalid broswer");
		}
		sdriver=driver;
		
		wutil.maximisewindow(driver);
		wutil.waitForElementsToLoadIndom(driver, 10);
		driver.get(URL);
	}
	@BeforeMethod(groups = {"smoketesting","regression testing"})
	public void bmconfig() throws IOException
	{
		String USERNAME=putil.readDataFromPropertyfile("username");
		String PASSWORD=putil.readDataFromPropertyfile("password");
		LoginPage lp=new LoginPage(driver);
		lp.logintoapp(USERNAME, PASSWORD);
		Reporter.log("----login sucessfully----", true);
	}
	@AfterMethod(groups = {"smoketesting","regression testing"})
	public void amconfig()
	{
		HomePage hp=new HomePage(driver);
		hp.signoutOFapp(driver);
		Reporter.log("Signout sucessfully", true);
	}
	//@AfterTest
	@AfterClass(groups = {"smoketesting","regression testing"})
	public void acconfig()
	{
	driver.close();
	Reporter.log("driver closed", true);
	}
	@AfterSuite(groups = {"smoketesting","regression testing"})
	public void asconfig() throws SQLException
	{
		//dutil.closeDb();
		Reporter.log("db closed", true);
	}
	
}