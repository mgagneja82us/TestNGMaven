package RandD;
//verify if rows are hidden in table or not
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class challange6 
{
	
@Test
	
	public void onetable() throws IOException 
	{
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/Mohit/Desktop/table2.2.html");
		
		driver.switchTo().frame("employeeFrame");
		
		List<WebElement> header = driver.findElements(By.xpath("//table[@id = 'productTable']//th"));
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'productTable']//tr"));
		
		
		
		int rowcount = 0;
		for(int i = 1; i<rows.size();i++)
		{
			if(!rows.get(i).isDisplayed())
			{
				rowcount++;
				
				System.out.println("Rows not visible" + i);
			}
		}
		
		System.out.println(rowcount);
		
		
		
		
		
		
		
		
		
		
		driver.quit();
		
	}

}
