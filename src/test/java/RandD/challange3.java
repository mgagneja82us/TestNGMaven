package RandD;
//Table with hidden rows and need to get status Pending and try to handle hidden row if status is pending and then click on review button on visible rows
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class challange3 
{
	
@Test
	
	public void onetable() throws IOException 
	{
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/Mohit/Desktop/table2.2.html");
		
		driver.switchTo().frame("employeeFrame");
		
		List<WebElement> header = driver.findElements(By.xpath("//table[@id = 'productTable']//th"));
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'productTable']//tr"));
		

		
		int indexStatus = -1;
		int indexProdName = -1;
		
		for(int i = 0;i<header.size();i++)
		{
			if(header.get(i).getText().trim().equals("Status"))
			{
				indexStatus = i;
			
			}
			if(header.get(i).getText().trim().equals("Product Name"))
			{
				indexProdName = i;
				
			}
		}
		
		for(int x = 1; x<rows.size();x++)
		{
		List<WebElement> data = rows.get(x).findElements(By.tagName("td"));
		
		
			if(data.get(indexStatus).getText().trim().equals("Pending"))
			{
			
						if(rows.get(x).isDisplayed())
						{
							
							System.out.println(data.get(indexStatus).getText().trim());
							System.out.println(data.get(indexProdName).getText().trim());
							rows.get(x).findElement(By.xpath(".//button")).click();
							
						}
						
						else
						{
							System.out.println("Rows Hidden and can not be clicked");
						}
					
			}
		}
		
		
		//driver.quit();
		
	}

}
