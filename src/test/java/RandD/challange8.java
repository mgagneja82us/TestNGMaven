package RandD;
//verify if rows are hidden in table or not
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class challange8 
{
	
@Test
	
	public void onetable() throws IOException, InterruptedException 
	{
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/Mohit/Desktop/uploadfile.html");
		
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("E:\\carear\\15+\\New Text Document.txt");
		
		
		
		//driver.quit();
		
	}

}
