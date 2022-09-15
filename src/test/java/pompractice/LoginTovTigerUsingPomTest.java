package pompractice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.LoginPage;
import vtiger_Generic_Library.BaseClass;
import vtiger_Generic_Library.PropertyFileUtility;

public class LoginTovTigerUsingPomTest extends BaseClass {
@Test
	public void login() throws IOException {
		/*WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		PropertyFileUtility putil=new PropertyFileUtility();
		String URL=putil.readDataFromPropertyfile("url");
		String USERNAME=putil.readDataFromPropertyfile("username");
		String PASSWORD=putil.readDataFromPropertyfile("password");
		
		driver.get(URL);
		LoginPage l=new LoginPage(driver);
		l.getUserNameedt().sendKeys(USERNAME);
		l.getPasswordedt().sendKeys(PASSWORD);
		l.getLoginBtn().click();*/
		//Reporter.log("login sucessfull",true);

	}

}
