package vtigwe.contactsTessts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger_Generic_Library.BaseClass;
import vtiger_Generic_Library.ExcelFileUtility;
import vtiger_Generic_Library.JavaUtlity;
import vtiger_Generic_Library.PropertyFileUtility;
import vtiger_Generic_Library.WebDriverUtility;

public class Contact_TestScript_With_orgTest extends BaseClass{
@Test(groups = {"smoketesting"})
	public  void Contact_TestScript_With_or()throws IOException, InterruptedException {
		/*WebDriver driver;
		// step 1: cerate objetct of utlites
		WebDriverUtility wutil=new WebDriverUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		
		JavaUtlity jutil=new JavaUtlity();
		//step2:read all necessary data
		String BROWSER=putil.readDataFromPropertyfile("browser");
		String URL=putil.readDataFromPropertyfile("url");
		String USERNAME=putil.readDataFromPropertyfile("username");
		String PASSWORD=putil.readDataFromPropertyfile("password");*/
		ExcelFileUtility eutil=new ExcelFileUtility();
		String LASTNAME=eutil.readDataFromExcel("contact", 1, 3);
		String org=eutil.readDataFromExcel("contact", 1, 2);
		//step 3: launch bowser
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
		//Step 2: Login to App
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();*/
		
		Reporter.log("browser launched and the login is completed for class Contact_TestScript_With_org ", true);
			
		//Step 3: Navigate to Organizations Link
			driver.findElement(By.linkText("Organizations")).click();
			
		//Step 4: click on create organization Look up image
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			Reporter.log("cliclked on create new org", true);
		//Step 5: Enter the mandatory fields
			String orgination=org+jutil.getRandumnuber();
			driver.findElement(By.name("accountname")).sendKeys(orgination);
			//to save orgination
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			Reporter.log("cliclked on save new org ", true);
			
			//wutil.waitForElementUntiltoclick(driver, driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")));
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
			Reporter.log("clicked on conatct link" , true);
			//step 6:click on create
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			//step 7:create contact to mandatory fileds
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME+jutil.getRandumnuber());
			//step 8:to click orgination
			driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
			//Step 9: switch to new window
			String partof="specific_contact_account_address";
			wutil.switchTOchildWIndow(driver, partof);
			
			driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgination);
			driver.findElement(By.xpath("//input[@name='search']")).click();
			driver.findElement(By.linkText(orgination)).click();
			String parentwin="http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
			wutil.switchTOchildWIndow(driver, parentwin);
			//step 8:sava
			driver.findElement(By.xpath("//input [@class='crmButton small save']")).click();
			String conatctname=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			Assert.assertEquals(conatctname.contains(LASTNAME), true);
			
			
			//step 9: logout
			WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wutil.mouseoveractionon(driver, element);
			WebElement element1=driver.findElement(By.xpath("//a[text()='Sign Out']"));
			wutil.mouseoveractionon(driver, element1);
			wutil.clickOnElement(driver, element1);
			driver.close();
	}

}
