package RandD;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//🔥 Challenge 22: StaleElementReferenceException
//🧪 Hinglish Description:
//Open this page: https://the-internet.herokuapp.com/add_remove_elements/
//
//Click on "Add Element" button (ye ek "Delete" button add karega).
//
//Find the Delete button and store it as WebElement.
//
//Fir click karo Delete button ko — wo DOM se hat jayega.
//
//Ab dubara se usi stored WebElement pe click() try karo.
//
//Ye karega StaleElementReferenceException throw, kyunki element ab DOM me nahi hai.


public class ExceptionHandling_challange22
{

	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver driver = null;
		
		try {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		WebElement delbutton = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
		delbutton.click();
		delbutton.click();
		} catch(StaleElementReferenceException st) 
			{
			System.out.println("Element has been removed from DOM, Kindly update element directory ad script");
			}
		
		
		
}
}



