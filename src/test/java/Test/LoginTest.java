package Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.AddtoCartPageObjects;
import PageObjects.LoginPageObjects;
import Utility.DataFinderFromExcel;
import Utility.DriverFactory;
import Utility.configReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners(io.qameta.allure.testng.AllureTestNg.class)



public class LoginTest
{
	
	private WebDriver driver;
//	@BeforeSuite//only use one we open onStart Listner
//	public void driverforsuiteonly()
//	{
//		DriverFactory.setdriver();
//
//	}

	@BeforeMethod
	@Parameters({"browser","nodeTag"})
			public void inialsetup(String browser,String nodeTag) throws MalformedURLException, URISyntaxException
			{
				
				//DriverFactory.quitdriver();
				DriverFactory.setdriver(browser,nodeTag);
				driver = DriverFactory.getdriver();	
				Allure.step("Launch Application");
			
			}
	
	@Test(priority = 0,testName = "SCRUM-32", enabled = false)
    @Description("Verifies user login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Valid Login")
    @Step("Executing Login Test")
	public void LoginPage() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
			
		
		DataFinderFromExcel utilexcel = new DataFinderFromExcel();
		LoginPageObjects logHomePage = new LoginPageObjects(driver);
		configReader config = new configReader();
		
		String BaseUrl = config.getproperties("url");
		//WrapperElementActionFile element = new WrapperElementActionFile();
	
		driver.get(BaseUrl);
		//driver.get("https://www.saucedemo.com/v1/index.html");
		
		String[] utilloginval = utilexcel.HomeUserLoginExcelData();
		
		String HomePageLoginUserId = utilloginval[0];
		String HomePageLoginUserPassword = utilloginval[1];
		
		
		logHomePage.UseNameLogin(HomePageLoginUserId);
		logHomePage.UserPasswordLogin(HomePageLoginUserPassword);
		logHomePage.ButtonUserLoginHomePage();
		
	
		
		
	}
	@Test(priority = 0,testName = "SCRUM-32")
    @Description("Verifies user login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Valid Login")
    @Step("Executing Login Test")
	public void AddtocartPage() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
			
		DataFinderFromExcel utilexcel = new DataFinderFromExcel();
		LoginPageObjects logHomePage = new LoginPageObjects(driver);
		configReader config = new configReader();
		
		String BaseUrl = config.getproperties("url");
		//WrapperElementActionFile element = new WrapperElementActionFile();
	
		driver.get(BaseUrl);
		//driver.get("https://www.saucedemo.com/v1/index.html");
		
		String[] utilloginval = utilexcel.HomeUserLoginExcelData();
		
		String HomePageLoginUserId = utilloginval[0];
		String HomePageLoginUserPassword = utilloginval[1];
		
		
		logHomePage.UseNameLogin(HomePageLoginUserId);
		logHomePage.UserPasswordLogin(HomePageLoginUserPassword);
		logHomePage.ButtonUserLoginHomePage();
		
		AddtoCartPageObjects addtocart = new AddtoCartPageObjects(driver);
		
	
		driver.findElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Apparel & Shoes']")).click();
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//img[@title='Show details for Blue Jeans'])[1]")).click();
		
		addtocart.addtocart();
		driver.findElement(By.id("addtocart_36_EnteredQuantity")).sendKeys(" ");
		
		addtocart.addtocart("10");
	
		Thread.sleep(6000);
		
	
	
	
		
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		
		DriverFactory.quitdriver();
	}

		
	

}
