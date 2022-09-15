package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrginationInfoemationpage {
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orginazationinfoedt;
	//create constructor
	public OrginationInfoemationpage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrginazationinfoedt() {
		return orginazationinfoedt;
	}
	public String orginazationname()
	{
		String orginazationheader = orginazationinfoedt.getText();
		return orginazationheader;
	}

}
