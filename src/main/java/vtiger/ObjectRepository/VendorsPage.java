package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger_Generic_Library.WebDriverUtility;

public class VendorsPage extends WebDriverUtility{
	@FindBy(xpath = "//img[@alt='Create Vendor...']")
	private WebElement createnewvendorImg;
	public VendorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getCreatenewvendorImg() {
		return createnewvendorImg;
	}
	public void clickonewvendor(WebDriver driver)
	{
		createnewvendorImg.click();
	}

}
