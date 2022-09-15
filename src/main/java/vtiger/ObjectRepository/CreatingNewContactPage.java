package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger_Generic_Library.WebDriverUtility;

public class CreatingNewContactPage extends WebDriverUtility
{
	@FindBy(xpath="//input[@name='lastname']") private WebElement lastnameedt;
	@FindBy(xpath = "//input[@name='account_name']") private WebElement orgname;
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']") private WebElement selectorgIMG;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement savebtn;
	@FindBy(xpath = "//input[@name='search_text']") private WebElement searchorginatioedt;
	@FindBy(xpath="//input[@name='search']") private WebElement serchbtn;
	
	public CreatingNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastnameedt() {
		return lastnameedt;
	}

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getSelectorgbtn() {
		return selectorgIMG;
	}
	
	public WebElement getSavebtn() {
		return savebtn;
	}
	/** 
	 * This metoud is used to create a contact with mandatory field
	 * @param name
	 */
	public void createcon(String name)
	{
		lastnameedt.sendKeys(name);
		savebtn.click();
	}
	//not completed
	/**
	 * this methoud is used to click on orgniation and select any orgination send by the user  and create contact
	 */
	public void createconwithorg(String name,WebDriver driver,String orgname)
	{
		lastnameedt.sendKeys(name);
		selectorgIMG.click();
		switchTOchildWIndow(driver,"specific_contact_account_address");
		searchorginatioedt.sendKeys(orgname);
		serchbtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		switchTOchildWIndow(driver, "Contacts");
		savebtn.click();
	}
	

}
