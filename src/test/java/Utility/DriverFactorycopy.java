package Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactorycopy
{
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();//Declare Thread and assigned Webdriver to it
	
	public static WebDriver getdriver() //return driver property
	{
		return driver.get();
	}
	
	public static void setdriver(String browser) throws IOException
	{
		
		configReader config = new configReader();
		boolean isHeadless = config.getproperties("headless").equalsIgnoreCase("true");
		
		switch(browser.toLowerCase())
		{
		case "chrome":
			
			ChromeOptions chromeoptions = new ChromeOptions();
			
			
			if(isHeadless)
			{
				chromeoptions.addArguments("--headless=new", "--window-size=1920,1080");
				
			}
			driver.set(new ChromeDriver(chromeoptions));//initialize Chrome Driver Instance and store in Driver
			break;
		case "edge":
			EdgeOptions edgeoptions = new EdgeOptions();
			if(isHeadless)
			{
				edgeoptions.addArguments("--headless=new", "--window-size=1920,1080");
				
			}
			
			driver.set(new EdgeDriver(edgeoptions));//initialize EdgeDriver Instance and store in Driver
			break;
			
		case "firefox":
			
			FirefoxOptions  firefoxoptions = new FirefoxOptions ();
			if(isHeadless)
			{
				firefoxoptions.addArguments("--headless=new", "--window-size=1920,1080");
				
			}
			
			driver.set(new FirefoxDriver(firefoxoptions));//initialize FirefoxDriver Instance and store in Driver
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
