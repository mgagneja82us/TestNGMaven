package Utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper 
{
	private WebDriver driver;
	public WaitHelper(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement waitForElementToBeVisible(By locator,int TimeinSec)
	{

		
		//driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(TimeinSec));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		return element;
	
		
	}
	public WebElement waitForElementToBeClickable(By element,int TimeinSec)
	{
	
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(TimeinSec));
		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
		
		return element1;
	
		
	}
	
	public boolean waitForTextToAppear(By element,String text,int TimeinSec)
	{
	
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(TimeinSec));
		Boolean element1 = wait.until(ExpectedConditions.textToBePresentInElementLocated(element, text));
		
		return element1;
	
		
	}




}
