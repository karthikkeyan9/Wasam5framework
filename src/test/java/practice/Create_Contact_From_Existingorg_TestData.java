package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
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
import org.testng.annotations.Test;

public class Create_Contact_From_Existingorg_TestData {
@Test
	public  void create_Contatct() throws InterruptedException, IOException {
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
		
		// cerate fileinputsteam
			FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		// cereat a work book
			Workbook wb=WorkbookFactory.create(fis1);
		// to navigate data into sheet
			Sheet s=wb.getSheet("contact");
		//to navigate to row
			Row r=s.getRow(1);
		// to naviagte to cell
			Cell lastname=r.getCell(3);
			System.out.println(lastname);
			String Lastname=lastname.getStringCellValue();
		//Step 1: Launch the browser
				if(BROWER.equalsIgnoreCase("chrome"))
				{
				driver = new ChromeDriver();
				}
				else if(BROWER.equalsIgnoreCase("firefox"))
				{
					driver=new FirefoxDriver();
				}
				else 
				{
					driver = new ChromeDriver();
				}
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						driver.get(URL);
						
		//Step 1: Login to App
						driver.findElement(By.name("user_name")).sendKeys(USRENAME);
						driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
						driver.findElement(By.id("submitButton")).click();
		//step2:navigate to contact page
						driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		// step 3: click on new 
						driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//step 4 :fill all mandatory detailss
						driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(Lastname);
		//step 5 : select the existing orgination
						//driver.findElement(By.xpath("(//img [@src='themes/softed/images/select.gif'])[1]")).click();
						
						
		//step 6 :to save
						driver.findElement(By.xpath("//input [@class='crmButton small save']")).click();
						Thread.sleep(3000);
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
