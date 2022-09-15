package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createnewproductImg;
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getCreatenewproductImg(WebDriver driver) {
		return createnewproductImg;
	}
	public  void clickonnewproducts(WebDriver driver) {
		createnewproductImg.click();
	}
}
