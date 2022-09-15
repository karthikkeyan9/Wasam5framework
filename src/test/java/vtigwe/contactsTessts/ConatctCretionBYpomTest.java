package vtigwe.contactsTessts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.ContactInformationPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreatingNewContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger_Generic_Library.BaseClass;
import vtiger_Generic_Library.ExcelFileUtility;
import vtiger_Generic_Library.JavaUtlity;
import vtiger_Generic_Library.PropertyFileUtility;
import vtiger_Generic_Library.WebDriverUtility;
@Listeners(vtiger_Generic_Library.ListenerImplementation.class)
public class ConatctCretionBYpomTest extends BaseClass {
	
@Test(groups = {"smoketesting","regression testing"})
	public void  ConatctCretionBYpo()throws IOException {
		/*WebDriver driver;
		// create all objects require
		JavaUtlity jutil=new JavaUtlity();
		PropertyFileUtility putil=new PropertyFileUtility();*/
		ExcelFileUtility eutil=new ExcelFileUtility();
		/*WebDriverUtility wutil=new WebDriverUtility();
		
		//read all the data require
		String BROWSER=putil.readDataFromPropertyfile("browser");
		String URL=putil.readDataFromPropertyfile("url");
		String USERNAME=putil.readDataFromPropertyfile("username");
		String PASSWORD=putil.readDataFromPropertyfile("password");
		
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("chrome is launched");
		}
		else
		{
			System.out.println("drive not launched");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("firefox driver launched is launched");
		}
		wutil.maximisewindow(driver);
		wutil.waitForElementsToLoadIndom(driver, 10);
		driver.get(URL);
		LoginPage lPage=new LoginPage(driver);
		lPage.logintoapp(USERNAME, PASSWORD);*/
		String LASTNAME=eutil.readDataFromExcel("contact", 1, 3);
		HomePage hp=new HomePage(driver);
		hp.clickonContact();
		Reporter.log("clicked on conatct link" , true);
		ContactsPage cp=new ContactsPage(driver);
		cp.clickonnewcon();
		Reporter.log("cliclked on create new con", true);
		CreatingNewContactPage cnp=new CreatingNewContactPage(driver);
		cnp.createcon(LASTNAME);
		
		//validation
		ContactInformationPage cip=new ContactInformationPage(driver);
		String conatctheader=cip.getcontactinfo();
		
		Assert.assertFalse(conatctheader.contains(LASTNAME));
	
	}

}
