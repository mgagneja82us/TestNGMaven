package RandD;
//In employee table search Seemarani from IT department and get her employee id and print it, also check check box and clike on detail button
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class challange2 
{
	
@Test
	
	public void onetable() throws IOException, InterruptedException 
	{
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/Mohit/Desktop/tables.html");
		
		driver.manage().window().maximize();
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[caption[contains(text(),'Employee Table')]]//tr"));
		List<WebElement> header = driver.findElements(By.xpath("//table[caption[contains(text(),'Employee Table')]]//th"));
		
		int indexDepart = -1;
		int indexName = -1;
		int indexEmpId = -1;
		
		for(int i = 0;i<header.size();i++)
		{
			if(header.get(i).getText().trim().equals("Department"))
			{
				indexDepart = i;
				
			}
			if(header.get(i).getText().trim().equals("Name"))
			{
				indexName = i;
				
			}
			if(header.get(i).getText().trim().equals("Employee ID"))
			{
				indexEmpId = i;
				
			}
		}
	
		for(int x = 1;x<rows.size();x++)
		{
			List<WebElement> data = rows.get(x).findElements(By.tagName("td"));
			
			if(data.get(indexDepart).getText().trim().equals("IT"))
			{
				if(data.get(indexName).getText().trim().equals("Seema Rani"))
				{
					System.out.println(data.get(indexEmpId).getText().trim());
					
				if (rows.get(x).findElement(By.xpath(".//td//input")).isSelected())
					{
						System.out.println("I am unchecking check box");
					}
					
						System.out.println("check box uncheck so we check it now");
					rows.get(x).findElement(By.xpath(".//td//input")).click();
					//rows.get(x).findElement(By.xpath(".//td//button")).click();
					
					
				}
				

		}
		
		
		
		driver.quit();
		
		}
	}
}


