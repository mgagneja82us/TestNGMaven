package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utility.DriverFactorycopy;
import Utility.WaitHelper;

public class UseWaitHelper {

	public static void main(String[] args) 
	{
		
		DriverFactorycopy driver1 = new DriverFactorycopy();
		DriverFactorycopy.setdriver("chrome");
		WebDriver driver = DriverFactorycopy.getdriver();
		
		WaitHelper helper = new WaitHelper(driver);
		
		
		
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click();
		WebElement msgpopup1 = helper.waitForElementToBeVisible(By.xpath("//p[contains(text(),'enabled')]"), 30);
		String msgpopup = msgpopup1.getText();
		String expectedtext = "It's enabled!";
		Assert.assertEquals(msgpopup,expectedtext);
		
		WebElement textbox = helper.waitForElementToBeClickable(By.xpath("//input[@type = 'text']"), 30);
		
		
		textbox.sendKeys("Reusable Wait Works!");
		
		Boolean resp = helper.waitForTextToAppear(By.xpath("//p[contains(text(),'enabled')]"), expectedtext, 30);
		
		Assert.assertTrue(true);
		
		
		
		
	
		// TODO Auto-generated method stub

	}

}
