package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class Create_Org_With_IndustryTest {
@Test
	public void Create_org() throws IOException {
		WebDriver driver;
		//to load file into file inputStream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		//create properties class object
		Properties p=new Properties();
		//load file in properties object
		p.load(fis);
		//to get data
		String BROWER=p.getProperty("browser");
		String USRENAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		String URL=p.getProperty("url");
		
		Random r1=new Random();
		int randomnum=r1.nextInt(1000);
		System.out.println(randomnum);
		// cerate fileinputsteam
					FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
				// cereat a work book
					Workbook wb=WorkbookFactory.create(fis1);
				// to navigate data into sheet
					Sheet s=wb.getSheet("Sheet1");
				//to navigate to row
					Row r=s.getRow(4);
				// to naviagte to cell
					Cell orgination=r.getCell(2);
					System.out.println(orgination);
					String org=orgination.getStringCellValue();
		//Step 1: Launch the browser
		if(BROWER.equalsIgnoreCase("chrome"))
		{
		driver = new ChromeDriver();
		}
		else if(BROWER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(URL);
				
				//Step 2: Login to App
				driver.findElement(By.name("user_name")).sendKeys(USRENAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//Step 3: Navigate to Organizations Link
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step 4: click on create organization Look up image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//Step 5: Enter the mandatory fields
				driver.findElement(By.name("accountname")).sendKeys(org+randomnum);
				
				//step 6:select the idustry
				WebElement elements=driver.findElement(By.xpath("//select[@name='industry']"));
				
				Select objSelect = new Select(elements);
				objSelect.selectByVisibleText("Healthcare");
				
					
				//Step 6: Save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//step 7: move to administration
				Actions act=new Actions(driver);
				WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				act.moveToElement(element).build().perform();
				
				//click on signout
				WebElement element1=driver.findElement(By.xpath("//a[text()='Sign Out']"));
				act.moveToElement(element1);
				act.click();
				act.perform();
				driver.close();

	}

}
