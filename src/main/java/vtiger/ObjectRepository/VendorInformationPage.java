package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInformationPage {
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private  WebElement vendorinformationImg;
	public VendorInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getVendorinformationImg() {
		return vendorinformationImg;
	}
	//busoness library
	public String vendorinformation(WebDriver driver)
	{
		return vendorinformationImg.getText();
		
	}
}
