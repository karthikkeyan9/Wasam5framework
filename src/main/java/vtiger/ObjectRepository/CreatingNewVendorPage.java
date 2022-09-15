package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewVendorPage {
	@FindBy(xpath = "//input[@name='vendorname']")
	private WebElement vendornameEdt;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']") 
	private WebElement saveBtn;
	public CreatingNewVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getVendornameEdt() {
		return vendornameEdt;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	//business librarie
	public void createnewvwndor(String vendorname) {
		vendornameEdt.sendKeys(vendorname);
		saveBtn.click();
	}

}
