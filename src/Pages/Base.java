package Pages;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Base {
	
	WebDriver driver;
	public Base(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void ScrollAndClick(By path)
	{
		WebElement elem=driver.findElement(path);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
		if(elem.isDisplayed())
		{
			elem.click();
		}
	}
	public void ClickElement(WebElement elem)
	{
		if(elem.isDisplayed())
		{
			elem.click();
		}
	}
	public void ClickElement(By path)
	{
		WebElement elem=driver.findElement(path);
		if(elem.isDisplayed())
		{
			elem.click();
		}
	}
	public void SendKeys(By path,String Content)
	{
		WebElement elem=driver.findElement(path);
		if(elem.isDisplayed())
		{
			elem.sendKeys(Content);
		}
	}
	
	public void SearchAndClickCont(By path,String searchString)
	{
		List<WebElement>elements=driver.findElements(path);
		for(WebElement elem:elements)
		{
			if(elem.getText().toLowerCase().contains(searchString.toLowerCase()))
			{
				elem.click();
				break;
			}
		}
	}
	public void takeSnapShot(String fileWithPath) throws Exception{

        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }
	public boolean retryingFind(By by) {
	    boolean result = false;
	    int attempts = 0;
	    while(attempts < 2) {
	        try {
	            driver.findElement(by);
	            result = true;
	            break;
	        } catch(StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    return result;
	}
	public void SearchAndClickAll(By path)
	{
		List<WebElement>elements=driver.findElements(path);
		for(WebElement elem:elements)
		{
				elem.click();
		}
	}
	public void SearchAndClick(By path,String searchString)
	{
		List<WebElement>elements=driver.findElements(path);
		for(WebElement elem:elements)
		{
			if(elem.getText().toLowerCase().equals(searchString.toLowerCase()))
			{
				elem.click();
				break;
			}
		}
	}
}
