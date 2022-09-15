package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger_Generic_Library.WebDriverUtility;

public class CreatingNewProductPage extends WebDriverUtility{
	@FindBy(xpath = "//input[@name='productname']") 
	private WebElement productnameEdt;
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']") 
	private WebElement vendorImg;
	@FindBy(xpath ="//input[@name='search_text']") 
	private WebElement searchEdt;
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBtn;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	public CreatingNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getProductnameEdt() {
		return productnameEdt;
	}
	public WebElement getVendorImg() {
		return vendorImg;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	//business libraries
	public void  createproduct(WebDriver drvier,String productname)
	{
		productnameEdt.sendKeys(productname);
		saveBtn.click();
	}
	public void createproduct(WebDriver driver,String productname,String vendorname)
	{
		productnameEdt.sendKeys(productname);
		vendorImg.click();
		switchTOchildWIndow(driver, "Vendors");
		searchEdt.sendKeys(vendorname);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.='"+vendorname+"']")).click();
		switchTOchildWIndow(driver, "Products");
		saveBtn.click();
	}

}
