package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	@FindBy(xpath="//img[@alt='Create Contact...']") private WebElement createnewcontLnk;
	@FindBy(xpath="//input[@name='search_text']") private WebElement searchforconedt;
	@FindBy(xpath = "//input[@name='submit']") private WebElement serchbtn;
	// to instilazation or constructor
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	// getter methods
	public WebElement getCreatenewcontLnk() {
		return createnewcontLnk;
	}
	public WebElement getSearchforconedt() {
		return searchforconedt;
	}
	public WebElement getSerchbtn() {
		return serchbtn;
	}
	//business libraries
	/**
	 * This methoud is used to click on new contact link
	 */
	public void clickonnewcon()
	{
		createnewcontLnk.click();
	}

}
