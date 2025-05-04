package RandD;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//Open this URL:
//👉 https://the-internet.herokuapp.com/dynamic_controls
//
//Click on the "Enable" button.
//
//Wait until the text box becomes enabled (i.e., editable).
//
//Once enabled, enter this text into the input box:
//📝 "Selenium Wait Master"



public class challange10 {

	public static void main(String[] args)
	{
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		
		driver.findElement(By.xpath("//form//button[contains(text(),'Enable')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		WebElement textbox = wait.until((ExpectedConditions.elementToBeClickable(By.xpath("//form//input[@type='text']"))));
		textbox.sendKeys("Selenium Wait Master");
		

	}

}
