package RandD;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//Use Explicit Wait for an Element to Be Clickable
//Browser me ye URL open karo:
//👉 https://the-internet.herokuapp.com/dynamic_controls
//
//Wahan ek "Remove" button hoga — usko click karo.
//
//Jab tak neeche "It's gone!" wala message nahi dikh jaata, tab tak explicit wait ka use karke wait karo.
//
//Fir "Add" button click karo.
//
//Uske baad "It's back!" message ke aane ka wait karo — again using explicit wait.


public class challange9 {

	public static void main(String[] args)
	{
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.findElement(By.xpath("//form//button[contains(text(),'Remove')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form//p[contains(text(),'gone')]")));
		//driver.findElement(By.xpath("//form//button[contains(text(),'Add')]")).click();
		
		
		
		
		if(button.getText().equals("It's gone!"))
		{
			driver.findElement(By.xpath("//form//button[contains(text(),'Add')]")).click();
		}
		else
		{
			Assert.assertFalse(false);
		}
		

	}

}
