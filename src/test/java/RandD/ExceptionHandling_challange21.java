package RandD;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//
//Declare a WebElement reference but do not initialize it (i.e., don't assign any element using findElement()).
//
//Try to perform an action on it — like .click() or .getText().
//
//This will throw a NullPointerException.
//
//Catch the exception and print a meaningful message like:
//
//"WebElement is not initialized. Check if element is correctly located before using it."





public class ExceptionHandling_challange21
{

	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver driver = null;
		
		try {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		WebElement ele = null;
		ele.click();

		
	} catch (NullPointerException e) 
		{
		
			System.out.println("Handled");
		
		}
		
		
}
}



