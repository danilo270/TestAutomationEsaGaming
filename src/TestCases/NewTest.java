package TestCases;

import org.testng.annotations.Test;

import Pages.DynamicProperties;
import Pages.ElementsMenu;
import Pages.NestedFrames;
import Pages.PracticeForm;
import Pages.Sortable;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class NewTest {
	public String baseUrl="https://demoqa.com/elements";
	public String chromeDriverPath="C:\\Users\\BRIX Classic\\Desktop\\TestAutomationSetup\\ChromeDriver\\chromedriver.exe";
	ChromeDriver driver;
  @BeforeClass
  public void beforeClass() 
  {
	  //System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(baseUrl);
  }
  @Test
  public void FirstTest()
  {
	  ElementsMenu menu=new ElementsMenu(driver);
	  menu.ClickMenu();
	  menu.OpenDynamicProperties();
	  DynamicProperties dProps=new DynamicProperties(driver);
	  dProps.ClickWhenEnabled();
	  dProps.WaitUntilVisible();
	  menu.ClickMenu();
	  menu.ClickForms();
	  menu.OpenPracticeForm();
	  PracticeForm pForm=new PracticeForm(driver);
	  pForm.FillFirstName("Danilo");
	  pForm.FillLastName("Radulovic");
	  pForm.FillEmail("danilordlvc@gmail.com");
	  pForm.SelectGender("male");
	  pForm.FillNumber("1231231231");
	  pForm.ClickDatePicker();
	  pForm.ClickMonth("march");
	  pForm.ClickYear("2020");
	  pForm.ClickDay("11");
	  pForm.SearchSubjects("Com");
	  pForm.SelectHobbies();
	  pForm.UploadPicture();
	  pForm.FillCurrentAddress("Kragujevacka 5");
	  pForm.SearchAndSelectState("ncr");
	  pForm.SearchAndSelectCity("delhi");
	  pForm.SubmitForm();
	  pForm.ClosePopup();
	  org.testng.Assert.assertEquals(true, pForm.CheckIfValid());
	  menu.ClickFramesAndWindows();
	  menu.ClickNestedFrames();
	  NestedFrames nestedFrame=new NestedFrames(driver);
	  nestedFrame.SwitchChildFrame();
	  nestedFrame.ChangeChildElement();
	  nestedFrame.CaptureScreenShot();
	  menu.ClickFramesAndWindows();
	  menu.ClickInteraction();
	  menu.ClickSortable();
	  Sortable sort=new Sortable(driver);
	  sort.SelectGrid();
	  sort.SortElementsDesc();
	  //driver.close(); 
  }
	  @Test
	  public void SecondTest() 
	{ 
	  driver.get(baseUrl); 
	  ElementsMenu menu=new ElementsMenu(driver);
	  menu.ClickMenu();
	  menu.ClickForms();
	  menu.OpenPracticeForm();
	  PracticeForm pForm=new PracticeForm(driver);
	  pForm.FillFirstName("Danilo");
	  pForm.FillLastName("Radulovic");
	  pForm.FillEmail("danilordlvcgmail.com"); 
	  pForm.SelectGender("male");
	  pForm.FillNumber("231231231"); 
	  pForm.ClickDatePicker();
	  pForm.ClickMonth("march"); 
	  pForm.ClickYear("2022");
	  pForm.ClickDay("11");
	  pForm.SearchSubjects("Com"); 
	  pForm.SelectHobbies(); 
	  pForm.UploadPicture();
	  pForm.FillCurrentAddress("Kragujevacka 5");
	  pForm.SearchAndSelectState("ncr"); 
	  pForm.SearchAndSelectCity("delhi");
	  pForm.SubmitForm();
	  org.testng.Assert.assertEquals(true, pForm.CheckIfValid());
	  try {
		Thread.sleep(10000);
	  		} catch (InterruptedException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
		}
	  }
	 
  @AfterClass
  public void afterClass() 
  {
	  driver.close();
  }

}
