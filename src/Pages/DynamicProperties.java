package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicProperties extends Base{
	
	WebDriver driver;
	By btnEnableAfter=By.xpath("//*[@id=\"enableAfter\"]");
	By btnVisibleAfter=By.xpath("//*[@id=\"visibleAfter\"]");
	By btnColorChange=By.xpath("//*[@id=\"colorChange\"]");
	WebDriverWait wait;
	public DynamicProperties(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		wait=new WebDriverWait(driver,10);
	}
	
	public void ClickWhenEnabled()
	{
		WebElement btnEnable=driver.findElement(btnEnableAfter);
		wait.until(ExpectedConditions.elementToBeClickable(btnEnable));
		if(btnEnable.isDisplayed())
		{
			btnEnable.click();
			System.out.println("Dugme za enablovanje kliknuto!");
		}
	}
	
	public void WaitUntilVisible()
	{
		WebElement btnVisible=driver.findElement(btnVisibleAfter);
		wait.until(ExpectedConditions.visibilityOf(btnVisible));
		if(btnVisible.isDisplayed())
		{
			System.out.println("Dugme za prikaz prikazano!");
		}
	}
	
}
