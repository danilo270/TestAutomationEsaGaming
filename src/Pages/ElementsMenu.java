package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsMenu extends Base {
	
	WebDriver driver;
	By FormBtn=By.cssSelector("#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(2) > span > div");
	By ElementMenu=By.xpath("//*[@id='app']/div/div/div[2]/div[1]/div/div/div[1]/span/div");
	By DynamicProp=By.xpath("//*[@id=\"item-8\"]");
	By practiceForm=By.xpath("//*[@id=\"item-0\"]");
	By framesWindows=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[3]/span/div");
	By nestedFrames=By.xpath("//*[@id=\"item-3\"]");
	By interactions=By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[5]/span/div");
	By sortable=By.xpath("//*[@id=\"item-0\"]");
	WebDriverWait wait;
	public ElementsMenu(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		wait=new WebDriverWait(driver,10);
	}
	public void ClickInteraction()
	{
		ScrollAndClick(interactions);
	}
	public void ClickSortable()
	{
		ClickElement(driver.findElements(sortable).get(4));
	}
	
	public void ClickMenu()
	{
		ClickElement(ElementMenu);
		//Po defaultu je otvoreno pa sam kliknuo 2 put.
		ClickElement(ElementMenu);
	}
	public void ClickForms()
	{
		ScrollAndClick(FormBtn);
	}
	
	public void ClickFramesAndWindows()
	{
		ClickElement(framesWindows);
	}
	
	public void ClickNestedFrames()
	{
		ClickElement(driver.findElements(nestedFrames).get(1));
	}
	public void OpenPracticeForm()
	{
		ClickElement(driver.findElements(practiceForm).get(1));
	}
	public void OpenDynamicProperties()
	{
		wait.until(ExpectedConditions.elementToBeClickable(DynamicProp));
		ScrollAndClick(DynamicProp);
	}
}
