package RandD;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//Open this page: https://the-internet.herokuapp.com/dynamic_loading/1
//
//Click on the "Start" button.
//
//Try to access the “Hello World!” text immediately, without any wait.
//
//This should throw a TimeoutException if you use WebDriverWait for a short time (like 2 seconds).
//
//Catch the exception using a try-catch block.
//
//In the catch, add proper wait using WebDriverWait for 10 seconds and then get the text.
public class ExceptionHandling_challange17
{

	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver driver = null;
		
		try {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Hello')]")));
		String val = ele.getText();

		if(val.equals("Hello World!"))
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Not Matched");
		}
		}catch(TimeoutException t) 
			{
			Thread.sleep(5000);
			String val = driver.findElement(By.xpath("//h4[contains(text(),'Hello')]")).getText();
			if(val.equals("Hello World!"))
			{
				System.out.println("Passed");
			}
			else
			{
				System.out.println("Not Matched");
			}
			
			}
		
		
	}
}


