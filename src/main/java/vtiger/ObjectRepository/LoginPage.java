package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {// create class  same as page
	
	//rule 2: identify elementls by anatotaions
	@FindBy(name="user_name")
	private WebElement userNameedt;
	@FindBy(name="user_password")
	private WebElement passwordedt;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	//Steop 3:create a constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//step 4: create a getter methouds
	public WebElement getUserNameedt() {
		return userNameedt;
	}
	public WebElement getPasswordedt() {
		return passwordedt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//step 5:business libraries
	/**
	 * This methoud is used to login into vtigerapp
	 * @param username
	 * @param password
	 */
	public void logintoapp(String username,String password)
	{
		userNameedt.sendKeys(username);
		passwordedt.sendKeys(password);
		loginBtn.click();
	}
	
	
	
	
	
	

} 
