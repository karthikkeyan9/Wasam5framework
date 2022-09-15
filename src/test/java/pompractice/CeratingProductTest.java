package pompractice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.CreatingNewProductPage;
import vtiger.ObjectRepository.CreatingNewVendorPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.ProductInformationPage;
import vtiger.ObjectRepository.ProductPage;
import vtiger.ObjectRepository.VendorInformationPage;
import vtiger.ObjectRepository.VendorsPage;
import vtiger_Generic_Library.BaseClass;
import vtiger_Generic_Library.ExcelFileUtility;
import vtiger_Generic_Library.JavaUtlity;
import vtiger_Generic_Library.PropertyFileUtility;
import vtiger_Generic_Library.WebDriverUtility;

public class CeratingProductTest extends BaseClass{

	@Test
	public void CreatingProduct() throws IOException{

	
		// creating objects
		ExcelFileUtility eutil=new ExcelFileUtility();
		/*JavaUtlity jutil=new JavaUtlity();
		WebDriverUtility wutil=new WebDriverUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		// reading data
		String BROWSER=putil.readDataFromPropertyfile("browser");
		String URL=putil.readDataFromPropertyfile("url");
		String USERNAME=putil.readDataFromPropertyfile("username");
		String PASSWORD=putil.readDataFromPropertyfile("password");*/
		
		String productname=eutil.readDataFromExcel("product", 1, 2)+jutil.getRandumnuber();
		String vendornam=eutil.readDataFromExcel("product", 1, 3)+jutil.getRandumnuber();
		// to launch browser
		/*if(BROWSER.equalsIgnoreCase("chrome"))
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
		// login into application
		LoginPage l=new LoginPage(driver);
		l.getUserNameedt().sendKeys(USERNAME);
		l.getPasswordedt().sendKeys(PASSWORD);
		l.getLoginBtn().click();*/
		//creating vendor
		HomePage h=new HomePage(driver);
		h.clickonvendor(driver);
		Reporter.log("clicked on vendor link", true);
		VendorsPage vp=new VendorsPage(driver);
		vp.clickonewvendor(driver);
		Reporter.log("clicked on new vendor", true);
		CreatingNewVendorPage cnvp=new CreatingNewVendorPage(driver);
		cnvp.createnewvwndor(vendornam);
		VendorInformationPage vip=new VendorInformationPage(driver);
		String vendordetails=vip.vendorinformation(driver);
		Assert.assertEquals(vendordetails.contains(vendornam),true);
		//product creation
		h.clickonProducts();
		Reporter.log("producet link clicked", true);
		ProductPage pp=new ProductPage(driver);
		pp.clickonnewproducts(driver);
		Reporter.log("create new product is clicked", true);
		CreatingNewProductPage cnp=new CreatingNewProductPage(driver);
		cnp.createproduct(driver, productname, vendornam);
		ProductInformationPage pip=new ProductInformationPage(driver);
		String productdetails=pip.productheaderdetails(driver);
		Assert.assertTrue(productdetails.contains(productname));
		
		


	}

}
