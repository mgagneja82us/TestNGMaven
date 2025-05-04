package RandD;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.chrome.ChromeDriver;
//Open: https://the-internet.herokuapp.com/javascript_alerts
//
//Do NOT click any button to trigger an alert.
//
//Directly try to switch to alert.
//
//Handle the NoAlertPresentException using try-catch.
//
//In the catch block, print a meaningful message like:
//
//"No alert present. Possibly forgot to trigger it."
public class ExceptionHandling_challange19
{

	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver driver = null;
		
		try {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		driver.findElement(By.xpath("//button[contains(text(),\"Alert\")]")).click();
		
		
		
	} catch (NoAlertPresentException e) 
		{
		driver.findElement(By.xpath("//button[contains(text(),\"Alert\")]")).click();
		Alert alert = driver.switchTo().alert();
				alert.accept();
		System.out.println("Make sure button should be clicked for Alert Message");
		}
		
		
}
}



