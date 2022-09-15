package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement contactnameedt;
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getContactnameedt() {
		return contactnameedt;
	}

	public String getcontactinfo()
	{
		String contatctheader=contactnameedt.getText();
		return contatctheader;
	}
}
