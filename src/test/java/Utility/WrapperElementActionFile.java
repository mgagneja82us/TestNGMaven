package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WrapperElementActionFile 
{
	private WebDriver driver;
	
	public WrapperElementActionFile(WebDriver driver)
	{
		//DriverFactory.setdriver();
	this.driver = driver;
		
	}

//	public WrapperElementActionFile(WebDriver driver)
//	{
//		this.driver = driver;
//	}

	public void SetTextValstr(By element ,String value ) throws InterruptedException
	{
		WebElement elem = driver.findElement(element);
		elem.sendKeys(value);
		
		//driver.findElement(By.xpath(textFldEle1)).sendKeys(value);
	}
	

	
	
	public void ClickButton(By element1) throws InterruptedException
	{
		
		WebElement elem1 = driver.findElement(element1);
		elem1.click();

	}
}

