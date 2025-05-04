package RandD;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.chrome.ChromeDriver;
//Write a script where you intentionally pass an incorrect or malformed URL like "www.google.com" to driver.get().
//Selenium expects a proper protocol (http:// or https://) and will throw an InvalidArgumentException if it's missing.
//Your task is to catch this exception and handle it gracefully, maybe log a helpful message or fallback URL.
public class ExceptionHandling_challange18
{

	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver driver = null;
		
		try {
		driver = new ChromeDriver();
		driver.get("the-internet.herokuapp.com/dynamic_loading/1");
		} catch (InvalidArgumentException e) 
			{
			System.out.println("Correct URL enetered");
			driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
			}
		
		
	}
}


