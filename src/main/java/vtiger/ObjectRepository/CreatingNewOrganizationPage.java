package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger_Generic_Library.WebDriverUtility;

public class CreatingNewOrganizationPage extends WebDriverUtility {
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orginazationnameedt;
	@FindBy(xpath="//select[@name='industry']")
	private WebElement insdustryDropdown;
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement typrdropdown;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	// create constructor
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrginazationnameedt() {
		return orginazationnameedt;
	}
	public WebElement getInsdustryDropdown() {
		return insdustryDropdown;
	}
	public WebElement getTyprdropdown() {
		return typrdropdown;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	// business library
	/**
	 * This methoud is used to create a organization
	 * @param orgname
	 */
	public void Organizationname(String orgname)
	{
		orginazationnameedt.sendKeys(orgname);
		savebtn.click();
	}
	/**
	 * This methoud is used to create a organization with insudtry name
	 * @param orgname
	 * @param industrytype
	 */
	public void orgwithindustry(String orgname,String industrytype) 
	{
	orginazationnameedt.sendKeys(orgname);	
	handelingDropDown(industrytype, insdustryDropdown);
	savebtn.click();
	}
	/**
	 * This methoud is used to create organization with type
	 * @param orgname
	 * @param type
	 */
	public void orgwithtypr(String orgname,String type)
	{
		orginazationnameedt.sendKeys(orgname);
		handelingDropDown(type, insdustryDropdown);
		savebtn.click();
	}
	/**
	 * This methoud is used to create a organization with industruy name and type 
	 * @param orgname
	 * @param industrytype
	 * @param type
	 */
	public void orgwithindustryandtype(String orgname,String industrytype,String type)
	{
		orginazationnameedt.sendKeys(orgname);
		handelingDropDown(industrytype, insdustryDropdown);
		handelingDropDown(type, typrdropdown);
		savebtn.click();
	}

}
