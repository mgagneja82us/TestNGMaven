package RandD;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

//✅ Task:
//Visit this site: https://the-internet.herokuapp.com/login
//
//Galat ID username_wrong se element dhoondo
//
//Use try-catch block mein handle karo
//
//Console mein print karo: "Element nahi mila, please locator check karo!"

public class ExceptionHandling_challange15 {

	public static void main(String[] args)
	{
		try {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.xpath("//input[@ame='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		} catch (NoSuchElementException ne)
			{
			
			System.out.println("Element is incorrectly mentioned or Depricated from DOM");
			}
	
		
	}
}

