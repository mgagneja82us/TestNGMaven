package RandD;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class fetchdatafrommiddlecolumnofexcel 
{

@Test
	
	public void onetable() throws IOException 
	{
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/Mohit/Desktop/tables.html");
		
		List<WebElement> header = driver.findElements(By.xpath("//table[caption[contains(text(),'Mixed Type Data Table')]]//th"));
		
		List<WebElement> rowval = driver.findElements(By.xpath("//table[caption[contains(text(),'Mixed Type Data Table')]]//tr"));
		
		int columnindex = -1;
		
		List<String> dataval = new ArrayList<>();
		
		for(int i = 1;i < header.size();i++)
		{
			if(header.get(i).getText().equals("Age"))
			{
				columnindex = i;
				break;
			}
			
		}
		
		for (int j = 1;j<rowval.size();j++)
		{
			
			
			List<WebElement> col = rowval.get(j).findElements(By.tagName("td"));		
			System.out.println(col.get(columnindex).getText().trim());
			
			
			
			
		}
		
		
		
		
		driver.quit();
		
		
	}

}
