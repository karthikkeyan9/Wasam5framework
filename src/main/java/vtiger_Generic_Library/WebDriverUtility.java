package vtiger_Generic_Library;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contain all the WebDriver actions
 * @author saikrishna
 *
 */
public class WebDriverUtility {
	/**
	 * This methoud is used to maxmise the window
	 * @param driver
	 */
	public void maximisewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This methoud used to wait for given time to load the dom structurte
	 * @param driver
	 * @param time
	 */
	public void waitForElementsToLoadIndom(WebDriver driver,int time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	/**
	 * This methoud will wait untli particular element is visiable
	 * @param driver
	 * @param element
	 */
	public void waitForElemnttoload(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This methoud will used to wait until the given element is clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementUntiltoclick(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This methoud will wait for the particular element to click
	 * if the element is not visibli to click it will wait for 1 second
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWaitAndClickable(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<10)
		{
			try
			{
				element.click();
				break;
			}
			catch(Exception e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * This methoud is used to handledropdown by select class indexvalue
	 * @param element
	 * @param indexnum
	 */
	public void handelingDropDown(WebElement element,int indexnum)
	{
		Select s=new Select(element);
		s.selectByIndex(indexnum);
	}
	/**
	 * This methoud is used to handledrop down by select class visibletext
	 * @param element
	 * @param visibletext
	 */
	public void handelingDropDown(WebElement element,String visibletext)
	
	{
		Select s=new Select(element);
		s.selectByVisibleText(visibletext);
	}
	/**
	 * This methoud is used to handledrop down by select class value methoud
	 * @param element
	 * @param visibletext
	 */
	public void handelingDropDown(String value,WebElement element)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This methoud is used to double clicking
	 * @param driver
	 */
	public void doubleClick0n(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().build().perform();
	}
	/**
	 * This methoud is used to click on any particular webelemnt
	 * @param driver
	 * @param element
	 */
	public void doubleclickon(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).build().perform();;
	}
	/**
	 * This methoud is used to perform mouseoveraction on a particular web element
	 * @param driver
	 * @param element
	 */
	public void mouseoveractionon(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();;
	}
	/**
	 * This metoud is used to perform mouse over action by using x and y axis values
	 * @param driver
	 * @param x
	 * @param y
	 * @author saikrishna
	 */
	public void mouseoveractionbyoffset(WebDriver driver,int x,int y)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).perform();;
		
	}

	/**
	 * This methoud is used to perform rightclick 
	 * @param driver
	 * @param element
	 * @author saikrishna
	 */
	public void rightClickon(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().build().perform();
	}
	/**
	 * This methoud is used to perform rightclick on particular webelement which is passed in args
	 * @param driver
	 * @param element
	 * @author saikrishna
	 */
	public void rightCLickonPar(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).build().perform();
	}
	/**
	 * This methoud is used to click on particular webelement
	 * @param driver
	 * @param element
	 */
	public void clickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.click(element).perform();
	}
	/**
	 * This methoud is used to perfom drag and drop option
	 * @param driver
	 * @param element
	 * @param element1
	 */
	public void draganddrop(WebDriver driver,WebElement element,WebElement element1)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(element, element1).build().perform();;
	}
	/**
	 * This methoud is used to accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This methoud is used to dismiss the alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) 
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This methoud will help gettext of message in alert popup
	 * @param driver
	 * @return  atring message
	 */
	public String gettextAlert(WebDriver driver)
	{
		String title = driver.switchTo().alert().getText();
		return title;
	}
	/**
	 * This methoud is used to shift to any window we require by passing the partial title
	 * @param driver
	 * @param partoftile
	 */
	public void switchTOchildWIndow(WebDriver driver,String partoftile)
	{
		// to get all the window titles
		Set<String> winhandle = driver.getWindowHandles();
		//to iterator
		Iterator<String>id=winhandle.iterator();
		//navigate into each window
		while(id.hasNext())
		{
			//capture all windows
			String windid = id.next();
			//switch to window to get title
			String currenttitle = driver.switchTo().window(windid).getTitle();
			// to chech the cuurent title with required
			if(currenttitle.contains(partoftile))
			{
				break;
			}
		
		}
	}
	/**
	 * This methoud is used to shift to the frame using the string id
	 * @param driver
	 * @param idorname
	 */	
	public void switchTOFrame(WebDriver driver,String idorname)
	{
		driver.switchTo().frame(idorname);
	}
	/**
	 * This methoud is used to shift back to farame of particular element
	 * @param driver
	 * @param elemnt
	 */
	public void switchTOFrameby(WebDriver driver,WebElement elemnt)
	{
		driver.switchTo().frame(elemnt);
	}
	/**
	 * This methoud is used to take screeen shot at an point
	 * @param driver
	 * @param screenshotname
	 * @return
	 * @throws IOException
	 */
	public String screenShot(WebDriver driver,String screenshotname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path=".\\screenshorts\\"+screenshotname+".png";
		 File dst = new File(path);
		 FileUtils.copyFile(src, dst);
		 return dst.getAbsolutePath();
	}
	/**
	 * This methoud is used to scroll down to a radom point in y axis
	 * @param driver
	 * @param y
	 * @author saikrishna
	 */
	public void randomScrollbyyaxix(WebDriver driver,int y)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+y+")","");
	}
	/**
	 * This methoud is used to scroll down to a particular element
	 * @param driver
	 * @param element
	 * @author saikrishna
	 */
	public void scrollbyTOelement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("\"window.scrollBy(0,"+y+")", element);
	}
	/**
	 * This methoud is used to scroll in x axis to randpoint passed
	 * @param driver
	 * @param x
	 */
	public void scrollBYxaxicx(WebDriver driver,int x)
	{ 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+"0)","");
		
	}
	
	
}
