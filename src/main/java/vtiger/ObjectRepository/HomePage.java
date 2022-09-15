package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger_Generic_Library.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	
		@FindBy(linkText="Organizations")
		private WebElement orginatiolnk;
		@FindBy(linkText="Contacts")
		private WebElement ContactsLnk;
		@FindBy(linkText="Opportunities")
		private WebElement Opportunitieslnk;
		@FindBy(linkText="Products")
		private WebElement ProductsLnk;
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement administratorImg;
		@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']") 
		private WebElement moredropdown;
		@FindBy(xpath = "//a[@name='Vendors']")
		private WebElement vendorLnk;
		@FindAll({@FindBy(xpath="//a[text()='Sign Out']"),@FindBy(linkText = "Sign Out")})
		private WebElement SignOutbtn;
		
		// create a construcor
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		// create getter methouds
		public WebElement getOrginatiolnk() {
			return orginatiolnk;
		}

		public WebElement getContactsLnk() {
			return ContactsLnk;
		}

		public WebElement getOpportunitieslnk() {
			return Opportunitieslnk;
		}

		public WebElement getProductsLnk() {
			return ProductsLnk;
		}

		public WebElement getAdministratorImg() {
			return administratorImg;
		}
		
		public WebElement getMoredropdown() {
			return moredropdown;
		}
		
		public WebElement getVendorLnk() {
			return vendorLnk;
		}
		public WebElement getSignOutbtn() {
			return SignOutbtn;
		}
		
		// bussiness class
		/**
		 * This methoud is used to click on orginationlink
		 */
		public void cliclkonOrgination()
		{
			orginatiolnk.click();
		}
		/**
		 * This methoud is used to click on products link
		 */
		public void clickonProducts() 
		{
			ProductsLnk.click();
		}
		/**
		 * This methoud is used to click on Contacts link
		 */
		public void clickonContact()
		{
			ContactsLnk.click();
		}
		/**
		 * This methoud is used to click on Opportunities
		 */
		public void clickonOpportunities()
		{
			Opportunitieslnk.click();
		}
		/**
		 * This methoud is used to move mouse to administrator
		 * @param driver
		 */
		public void movetoadministrator(WebDriver driver)
		{
			mouseoveractionon( driver,administratorImg);
		}
		/** 
		 * This methoud is used to move mouse to the more option
		 * @param driver
		 */
		public void movetomore(WebDriver driver)
		{
			mouseoveractionon(driver, moredropdown);
		}
		/**
		 * This methoud is used to clcik on vendor under more options
		 * @param driver
		 */
		public void clickonvendor(WebDriver driver)
		{
			mouseoveractionon(driver, moredropdown);
			vendorLnk.click();
		}
		/**
		 * This methoud is used to move mouse and to click on signout
		 * @param driver
		 */
		public void signoutOFapp(WebDriver driver)
		{
			mouseoveractionon( driver,administratorImg);
			SignOutbtn.click();
		}
		
		
		
	

}
