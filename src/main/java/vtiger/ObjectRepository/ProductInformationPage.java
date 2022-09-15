package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement productheaderimg;
	public ProductInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getProductheaderimg() {
		return productheaderimg;
	}
	public String productheaderdetails(WebDriver driver)
	{
		return productheaderimg.getText();
		
	}
}
