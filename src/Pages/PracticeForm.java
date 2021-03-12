package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeForm extends Base {
	private WebDriver driver;
	private WebDriverWait wait;
	By firstName=By.xpath("//*[@id=\"firstName\"]");
	By lastName=By.xpath("//*[@id=\"lastName\"]");
	By email=By.xpath("//*[@id=\"userEmail\"]");
	By genders=By.xpath("//label[contains(@for,\"gender-radio-\")]");
	By mobile=By.xpath("//*[@id=\"userNumber\"]");
	By formDate=By.xpath("//*[@id=\"dateOfBirth\"]/div/div");
	By monthPicker=By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]");
	By monthOptions=By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select/option");
	By yearPicker=By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]");
	By yearOptions=By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select/option");
	By dayOptions=By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]//*");
	By subjects=By.xpath("//*[@id=\"subjectsWrapper\"]/div[2]");
	By subjectAutoCompl=By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]");
	By hobbies=By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]//label[contains(@for,'hobbies-checkbox')]");
	By uploadPicture=By.xpath("//*[@id=\"uploadPicture\"]");
	By currentAddress=By.xpath("//*[@id=\"currentAddress\"]");
	By selectState=By.xpath("//*[@id=\"state\"]/div/div[1]/div[1]");
	By searchState=By.xpath("//*[@id=\"state\"]/div");
	By selectCity=By.xpath("//*[@id=\"city\"]/div/div[1]/div[1]");
	By searchCity=By.xpath("//*[@id=\"city\"]/div");
	By submit=By.xpath("//*[@id=\"submit\"]");
	By closePopup=By.xpath("//*[@id=\"closeLargeModal\"]");
	public PracticeForm(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		wait=new WebDriverWait(driver,10);
	}
	
	public void FillFirstName(String Content)
	{
		SendKeys(firstName, Content);
	}
	public void SubmitForm()
	{
		ClickElement(submit);
	}
	public void ClosePopup()
	{
		ClickElement(closePopup);
	}
	public void FillLastName(String Content)
	{
		SendKeys(lastName, Content);
	}
	
	public void FillCurrentAddress(String address)
	{
		SendKeys(currentAddress, address);
	}
	
	public void FillNumber(String number)
	{
		SendKeys(mobile, number);
	}
	public void ClickDatePicker()
	{
		ClickElement(formDate);
	}
	
	public void ClickMonth(String month)
	{
		SearchAndClick(monthOptions, month);
	}
	public void UploadPicture()
	{
		SendKeys(uploadPicture, "C:\\Users\\BRIX Classic\\Desktop\\desktop\\picture.jpg");
	}
	public void SearchAndSelectState(String search)
	{
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(selectState))
		.click().sendKeys(search).build().perform();
		SearchAndClickCont(searchState,search);
	}
	public void SearchAndSelectCity(String search)
	{
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(selectCity))
		.click().sendKeys(search).build().perform();
		SearchAndClickCont(searchCity,search);
	}
	public void SearchSubjects(String search)
	{
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(subjects))
		.click().sendKeys(search).build().perform();
		SearchAndClickCont(subjectAutoCompl,search);
	}
	public void ClickYear(String year)
	{
		SearchAndClick(yearOptions, year);
	}
	
	public void ClickDay(String day)
	{
		SearchAndClick(dayOptions, day);
	}
	
	public void SelectHobbies()
	{
		SearchAndClickAll(hobbies);
	}
	public void FillEmail(String Content)
	{
		SendKeys(email, Content);
	}
	
	public void SelectGender(String gender)
	{
		SearchAndClick(genders, gender);
	}
}
