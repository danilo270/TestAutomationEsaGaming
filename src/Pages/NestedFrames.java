package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NestedFrames extends Base {
	
	private WebDriver driver;
	By childParapgraph=By.xpath("/html/body/p");
	private WebDriverWait wait;
	public NestedFrames(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		wait=new WebDriverWait(driver,10);
	}
	public void SwitchChildFrame()
	{
		WebElement parent=driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(parent);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("iframe"))));
		//retryingFind(By.tagName("iframe"));
		WebElement child=driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(child);
	}
	public void ChangeChildElement()
	{
		WebElement element = driver.findElement(childParapgraph);
				((JavascriptExecutor)driver).executeScript(
				  "var ele=arguments[0]; ele.innerHTML = 'Danilo :D';", element);
				driver.switchTo().defaultContent();
	}
	public void CaptureScreenShot()
	{
		try {
			takeSnapShot("C:\\Users\\BRIX Classic\\Desktop\\desktop\\testData1.png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
