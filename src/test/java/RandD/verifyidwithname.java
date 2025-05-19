//Suppose you have an HTML table with a caption "Mixed Type Data Table" containing multiple rows and columns.
//Write a Selenium TestNG script to:
//
//Dynamically locate the column index of the "ID" header
//
//Traverse through the table rows to find a cell where the first column's value is "Simran"
//
//Once found, fetch the ID value from the same row (based on column index)
//
//Validate whether the extracted ID is alphanumeric
//
package RandD;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class verifyidwithname
{

@Test
	
	public void onetable() throws IOException 
	{
	ChromeDriver driver = new ChromeDriver();
	
	driver.get("C:\\Users\\Mohit\\OneDrive\\Desktop\\tables.html");
	
	List<WebElement> header = driver.findElements(By.xpath("//table[caption[contains(text(),'Mixed Type Data Table')]]//th"));
	
	int columnindex = -1;
	
	List<String> strarray = new ArrayList<>();
	
	for(int i = 0;i<header.size();i++)
	{
		if (header.get(i).getText().equals("ID"))
		{
			columnindex = i;
			System.out.println("Matched");
		}
	}
	
	List<WebElement> tablerow = driver.findElements(By.xpath("//table[caption[contains(text(),'Mixed Type Data Table')]]//tr"));
	
	for(int j = 1; j<tablerow.size();j++)
	{
		String rowval = tablerow.get(j).findElement(By.tagName("td")).getText().trim();
		
		if(rowval.equals("Simran"))
		{
			String myval = tablerow.get(j).findElements(By.tagName("td")).get(columnindex).getText().trim();
			
			if(myval.matches("^[a-zA-z0-9]+$"))
			{
				System.out.println("Alphanumeric");
			}
			
			
			strarray.add(myval);
			System.out.println(strarray);
			break;
		}
		
		
	}
	
//	if(strarray.get(0).matches("^[a-zA-z0-9]+$"))
//	{
//		System.out.println("Alphanumeric");
//	}
	
	//driver.quit();
		
	}

}
