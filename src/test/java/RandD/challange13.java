package RandD;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

//Open 👉 https://the-internet.herokuapp.com/dynamic_loading/2
//
//Click on Start button.
//
//Wait until "Hello World!" text appears.
//
//Then validate that:
//
//The page title still contains "The Internet" ✔️
//
//The text is exactly "Hello World!"




public class challange13 {

	public static void main(String[] args)
	{
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
	
		driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
		
		Wait<ChromeDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//h4[contains(text(),'Hello')]")));
		
		String MyMessage = msg.getText();
		
		System.out.println(MyMessage);
		
		Assert.assertEquals(MyMessage, "Hello World!");
		
		String title = driver.getTitle();
		if(title.contains("The Internet"))
		{
			System.out.println("Correct title The Internet");
		}
			else
			{
				System.out.println("Incorrect Title");
			}
		}
				

	}


