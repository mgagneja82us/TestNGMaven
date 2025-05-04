package RandD;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class challange1 
{
	
@Test
	
	public void onetable() throws IOException 
	{
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/Mohit/Desktop/tables.html");
		
		
	List<WebElement> webtablerows = 	driver.findElements(By.xpath("//table[caption[contains(text(),'User Interaction Table')]]//tr"));
	List<WebElement> header = 	driver.findElements(By.xpath("//table[caption[contains(text(),'User Interaction Table')]]//th"));
	
	

	int indexvaluEid = -1;
	
	for(int i = 0; i<header.size();i++)
	{
		if(header.get(i).getText().trim().equals("Email ID"))
			{
				indexvaluEid = i;
			}
			
		
	}
	
	for(int y = 1; y<webtablerows.size();y++)
	{
		List <WebElement> testdata = webtablerows.get(y).findElements(By.tagName("td"));
		
		if(testdata.get(indexvaluEid).getText().trim().equals("anita.s@example.com"))
		{
			webtablerows.get(y).findElement(By.xpath(".//td//input[@type='radio']")).click();
			webtablerows.get(y).findElement(By.xpath(".//td//button")).click();
			
		}
	}
	

		
		
		
		
		driver.quit();
		
	}

}
