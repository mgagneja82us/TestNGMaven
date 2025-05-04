package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactorycopy
{
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();//Declare Thread and assigned Webdriver to it
	
	public static WebDriver getdriver() //return driver property
	{
		return driver.get();
	}
	
	public static void setdriver(String browser)
	{
		switch(browser.toLowerCase())
		{
		case "chrome":
			driver.set(new ChromeDriver());//initialize Chrome Driver Instance and store in Driver
			break;
		case "edge":
			
			driver.set(new EdgeDriver());//initialize EdgeDriver Instance and store in Driver
			break;
			
		case "firefox":
			
			driver.set(new FirefoxDriver());//initialize FirefoxDriver Instance and store in Driver
			break;
			
		default:
			throw new IllegalArgumentException("Invalid Browser"+browser);
		}
		//driver.set(new ChromeDriver());//initialize Chrome Driver Instance and store in Driver
		getdriver().manage().window().maximize();
		
	}
	
	public static void quitdriver()
	{
		if (getdriver()!= null)
		{
			getdriver().quit();
			driver.remove();
		}
			
	}
	

}
