package RandD;
//In Frame select check box, select value from dropdown and then click on button where employee Name is....
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class challange4 
{
	
@Test
	
	public void onetable() throws IOException 
	{
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/Mohit/Desktop/table2.2.html");
		
		WebElement ele = driver.findElement(By.xpath("//iFrame[@id='employeeFrame']"));
		
		//driver.switchTo().frame("employeeFrame");
		
		driver.switchTo().frame(ele);
		
		List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));
		List<WebElement> header = driver.findElements(By.xpath("//table//th"));
		
		int indexdepart = -1;
		int indexdemp = -1;
		int indexstatus = -1;
		
		for(int i = 0;i<header.size();i++)
		{
			if(header.get(i).getText().trim().equals("Department"))
			{
				indexdepart = i;
				
			}
			
			if(header.get(i).getText().trim().equals("Employee Name"))
			{
				indexdemp = i;
				
			}
			if(header.get(i).getText().trim().equals("Status"))
			{
				indexstatus = i;
				
			}
			
		}

		for(int x = 1; x<rows.size();x++)
		{
			List<WebElement> data  = rows.get(x).findElements(By.tagName("td"));
			
			if(data.get(indexdepart).getText().trim().equals("HR"))
			{
				data.get(indexdemp).findElement(By.xpath(".//input[@type='checkbox']")).click();
				String EmpName = data.get(indexdemp).getText();
				System.out.println("------------------------" + EmpName);
				WebElement status = data.get(indexstatus).findElement(By.xpath(".//select"));
				
				Select sel = new Select(status);
				
				sel.selectByVisibleText("Active");
				
				
				
			}
			
		
		
		}
		
		
		
		
		//driver.quit();
		
	}

}
