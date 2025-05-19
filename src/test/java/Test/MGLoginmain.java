package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.MGLogin;
import Utility.DriverFactorycopy;

public class MGLoginmain
{
	WebDriver driver;
	@BeforeMethod
	@Parameters("browser")
	public void driverfile(String browser) throws IOException
		{
		DriverFactorycopy.setdriver(browser);
		driver = DriverFactorycopy.getdriver();
	}
	@Test(invocationCount = 25)
	
	public void mainLoginPage()
	{
		driver.get("E://MG-Cart.html");
		
		MGLogin mg = new MGLogin(driver);
		
		mg.enterusername("admin");
		mg.enterpassword("password123");
		mg.loginbutton();
	}
	
	

}
