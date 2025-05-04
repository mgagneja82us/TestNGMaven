package RandD;
//Paginated table and scenario is click on next button till dont find perticular person click on checkbox
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class challange5 
{
	
@Test
	
	public void onetable() throws IOException, InterruptedException 
	{
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/Mohit/Desktop/table3.html");
		
		
		//WebElement buttoncheck = driver.findElement(By.xpath("//button[contains(text(),'Previous')]"));
		
		
		while(true)
		{
			WebElement prebuttoncheck = driver.findElement(By.xpath("//button[contains(text(),'Previous')]"));
			
			if(prebuttoncheck.isEnabled()) 
			{
				prebuttoncheck.click();
			}
			else
			{
				break;
			}
			
			
		}
	
		
		int indexName = -1;
		
		while(true)
		{
			WebElement nextbuttoncheck = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
			
			
			if(nextbuttoncheck.isEnabled())
			{
				
				List <WebElement> header = driver.findElements(By.xpath("//table//th"));
				
				for(int i = 0; i<header.size();i++)
				{
					
					if(header.get(i).getText().trim().equals("Name"))
					{
						indexName = i;
					}
					
				}
				List <WebElement> rows = driver.findElements(By.xpath("//table//tr"));
				for(int x = 1; x<rows.size();x++)
				{
					
					List <WebElement> data = rows.get(x).findElements(By.tagName("td"));
					
					if(data.get(indexName).getText().trim().equals("Seema Rani"))
					{
						rows.get(x).findElement(By.tagName("input")).click();
						
						System.out.println("CheckBox Clicked");
						
						Thread.sleep(5000);
					}
				}
				
				nextbuttoncheck.click();
			}
			else
			{
				break;
			}
			
			
		}
		
		

		
		
		
		
		
		
		
		
		
		
driver.quit();
		
	}
}

