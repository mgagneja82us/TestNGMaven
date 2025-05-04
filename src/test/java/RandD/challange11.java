package RandD;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//Go to:
//👉 https://the-internet.herokuapp.com/dynamic_controls
//
//Click on "Remove" button.
//
//Wait until the checkbox disappears (use ExpectedConditions.invisibilityOfElementLocated).
//
//Once checkbox is gone, validate that it's not displayed using an assertion.



public class challange11 {

	public static void main(String[] args)
	{
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.findElement(By.xpath("//form//button[contains(text(),'Remove')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		Boolean chbox = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@type = 'checkbox']")));
	
		
		Assert.assertTrue(chbox);


	}

}
