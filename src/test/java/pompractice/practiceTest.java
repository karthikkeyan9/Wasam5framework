package pompractice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.LoginPage;
import vtiger_Generic_Library.PropertyFileUtility;

public class practiceTest{

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		PropertyFileUtility putil=new PropertyFileUtility();
		String URL=putil.readDataFromPropertyfile("url");
		String USERNAME=putil.readDataFromPropertyfile("username");
		String PASSWORD=putil.readDataFromPropertyfile("password");
		
		driver.get(URL);
		LoginPage l=new LoginPage(driver);
		l.getUserNameedt().sendKeys(USERNAME);
		l.getPasswordedt().sendKeys(PASSWORD);
		l.getLoginBtn().click();
		
		//bussiness
		l.logintoapp(USERNAME, PASSWORD);

	}

}
