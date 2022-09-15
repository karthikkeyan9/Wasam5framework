package vtigwe.contactsTessts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger_Generic_Library.ExcelFileUtility;
import vtiger_Generic_Library.JavaUtlity;
import vtiger_Generic_Library.PropertyFileUtility;
import vtiger_Generic_Library.WebDriverUtility;

public class  CreateContactTest {
@Test(groups = {"smoketesting"})
	public  void  CreateContactTes() throws IOException, InterruptedException {
		WebDriver driver;
		// step 1: cerate objetct of utlites
		WebDriverUtility wutil=new WebDriverUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		JavaUtlity jutil=new JavaUtlity();
		//step2:read all necessary data
		String BROWSER=putil.readDataFromPropertyfile("browser");
		String URL=putil.readDataFromPropertyfile("url");
		String USERNAME=putil.readDataFromPropertyfile("username");
		String PASSWORD=putil.readDataFromPropertyfile("password");
		
		String LASTNAME=eutil.readDataFromExcel("contact", 1, 3);
		
		//step 3: launch bowser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("chrome is launched");
		}
		else {
			System.out.println("drive not launched");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("chrome is launched");
		}
		//step 4:login to app
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//step 5:navigate to contact
		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		//step 6:click on create
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//step 7:create contact to mandatory fileds
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME+jutil.getRandumnuber());
		//step 8:sava
		driver.findElement(By.xpath("//input [@class='crmButton small save']")).click();
		Thread.sleep(4000);
		//step p:logout
		WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutil.mouseoveractionon(driver, element);
		
		WebElement element1=driver.findElement(By.xpath("//a[text()='Sign Out']"));
		wutil.mouseoveractionon(driver, element1);
		wutil.clickOnElement(driver, element1);
	}

}
