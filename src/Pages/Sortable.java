package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Sortable extends Base {
	
	private WebDriver driver;
	By gridPath=By.xpath("//*[@id=\"demo-tab-grid\"]");
	By sortableElementsPath=By.xpath("//*[@id=\"demo-tabpane-grid\"]/div/div/div");
	public Sortable(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void SelectGrid()
	{
		ClickElement(gridPath);
	}
	
	public void SortElementsDesc()
	{
		Actions action=new Actions(driver);
		List<WebElement>list=driver.findElements(sortableElementsPath);
		Integer i=0,j=list.size()-1;
		while(i!=j)
		{
			action.dragAndDrop(list.get(j), list.get(i)).build().perform();
			i++;
			action.dragAndDrop(list.get(i), list.get(j)).build().perform();
			j--;
		}
		try {
			takeSnapShot("C:\\Users\\BRIX Classic\\Desktop\\desktop\\testData2.png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
