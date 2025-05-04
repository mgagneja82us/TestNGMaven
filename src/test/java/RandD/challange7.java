package RandD;
//verify if rows are hidden in table or not
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class challange7 
{
	
@Test
	
	public void onetable() throws IOException, InterruptedException 
	{
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/Mohit/Desktop/table4sorting.html");
		
		
		List<WebElement>header = driver.findElements(By.xpath("//table//th"));
		
		
		int indexName = -1;
		
		for(int i = 0;i<header.size();i++)
		{
			if(header.get(i).getText().trim().equals("Name"))
			{
				indexName = i;
				break;
			}
		}
		
		driver.findElement(By.xpath("//table//th[contains(text(),'Name')]")).click();
		
		List<WebElement>rows = driver.findElements(By.xpath("//table//tr"));
		
		List<String> Assendingarr = new ArrayList<>();
		
		for(int x = 1;x<rows.size();x++)
		{
			
			Assendingarr.add(rows.get(x).findElements(By.tagName("td")).get(indexName).getText().trim());
				
		}
		
		System.out.println(Assendingarr);

driver.findElement(By.xpath("//table//th[contains(text(),'Name')]")).click();
		
		List<WebElement>updatedrows = driver.findElements(By.xpath("//table//tr"));
		
List<String> desendingarr = new ArrayList<>();
		
		for(int x = 1;x<updatedrows.size();x++)
		{
			
			desendingarr.add(updatedrows.get(x).findElements(By.tagName("td")).get(indexName).getText().trim());
				
		}
		System.out.println(desendingarr);
		
		Collections.sort(desendingarr);
		System.out.println(desendingarr);
		
//		Collections.sort(desendingarr,Comparator.reverseOrder());///only use for desending order
//		System.out.println(desendingarr);
		
		if(Assendingarr.equals(desendingarr))
			{
			System.out.println("SORTING SucessFull");
			
			}
			else
			{
				System.out.println("SORTING UNSucessFull");
			}
		
		
		
		
		
		
		
		
		
		
		//driver.quit();
		
	}

}
