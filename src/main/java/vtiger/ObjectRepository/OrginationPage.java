package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrginationPage {
	//to declar the webelement
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createorginationbtn;
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement serfororgedt;
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchbtn;
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deletbtn;
	@FindBy(xpath="//input[@name='selectall']")
	private WebElement selectallCH;
	
	//instilaztion
	public OrginationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getCreateorginationbtn() {
		return createorginationbtn;
	}
	public WebElement getSerfororgedt() {
		return serfororgedt;
	}
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	public WebElement getDeletbtn() {
		return deletbtn;
	}
	public WebElement getselectallCh()
	{
		return selectallCH;
	}
	//business methouds
	/**
	 * This methoud is used to click on create new organization link
	 */
	public void clickonneworg()
	{
		createorginationbtn.click();
	}
	/**
	 * This methoud is used to search for a particular organization by send the name all arugements
	 * @param orgname
	 */
	public void searchfororg(String orgname)
	{
		serfororgedt.sendKeys(orgname);
		searchbtn.click();
	}
	/**
	 * This methoud is used to delete all the organization present in the vtiger list
	 */
	public void deleteallorg()
	{
		selectallCH.click();
		deletbtn.click();
	}
	

}
