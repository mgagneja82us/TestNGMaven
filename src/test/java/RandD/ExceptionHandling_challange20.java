package RandD;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.chrome.ChromeDriver;
//Write a script where you intentionally trigger a JavaScript alert, but do not handle it (i.e., don’t accept or dismiss it).
public class ExceptionHandling_challange20
{

	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver driver = null;
		
		try {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[contains(text(),\"Alert\")]")).click();
		
			
		driver.findElement(By.xpath("//button[contains(text(),\"Confirm\")]")).click();
		
		
		
	} catch (UnhandledAlertException e) 
		{
		try {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.findElement(By.xpath("//button[contains(text(),\"Confirm\")]")).click();
		
		System.out.println("Handle Alert Message");
		}catch(NoAlertPresentException ee)
		{
			System.out.println("Other Exception handled");
		}
		}
		
		
}
}



