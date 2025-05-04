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
	
	driver.get("file:///C:/Users/Mohit/Desktop/tables.html");
	
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
			
			strarray.add(myval);
			System.out.println(strarray);
			break;
		}
		
		
	}
	
	if(strarray.get(0).matches("^[a-zA-z0-9]+$"))
	{
		System.out.println("Alphanumeric");
	}
	
	driver.quit();
		
	}

}
