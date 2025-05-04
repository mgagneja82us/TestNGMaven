package RandD;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.chrome.ChromeDriver;

//Problem 2: Exception hone par catch block execute hi nahi ho raha ya message print nahi ho raha
//Yeh kaafi baar is wajah se hota hai ki:
//
//Exception ElementClickInterceptedException nahi, kisi aur type ka ho raha ho (jaise NoSuchElementException, TimeoutException etc).
//
//XPath galat ho ya element truly DOM me hi na ho.
//
//Ya browser load nahi ho pa raha ho, aur exception before click aa rahi ho.

public class ExceptionHandling_challange16 {

	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver driver = null;
		
		try {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/entry_ad");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Selenium')]")).click();
		} catch(ElementNotInteractableException e) 
			{
			System.out.println("Button hide under other element");
			driver.findElement(By.xpath("//p[contains(text(),'Close')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Selenium')]")).click();
			
			//System.out.println("Exception is  :"+e);
			
           
			}
		
	
		
	}
}

