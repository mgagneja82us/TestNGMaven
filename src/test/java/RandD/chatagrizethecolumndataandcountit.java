package RandD;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class chatagrizethecolumndataandcountit
{

@Test
	
	public void onetable() throws IOException 
	{
	ChromeDriver driver = new ChromeDriver();
	
	driver.get("file:///C:/Users/Mohit/Desktop/tables.html");
	
	List<WebElement> header = driver.findElements(By.xpath("//table[caption[contains(text(),'Single Column Mixed Values Table')]]//th"));
	
	List<WebElement> rowval = driver.findElements(By.xpath("//table[caption[contains(text(),'Single Column Mixed Values Table')]]//tr"));
	
	int columnindex = -1;
	int number=0;
	int StringCount=0;
	int alphanum = 0;
	
	
	List<String> dataval = new ArrayList<>();
	
	for(int i = 0;i < header.size();i++)
	{
		if(header.get(i).getText().equals("Mixed Data"))
		{
			columnindex = i;
			break;
		}
		
	}
	
	for (int j = 1;j<rowval.size();j++)
	{
		
	
		
		
		List<WebElement> col = rowval.get(j).findElements(By.tagName("td"));		
		String data = col.get(columnindex).getText().trim();
		
		if(data.matches("^[0-9]+$"))
		{
			number++;
		}
		else if(data.matches("^[a-zA-Z]+$"))
		{
			StringCount++;
		}
		else if(data.matches("^[a-zA-Z0-9]+$"))
		{
			alphanum++;
		}
		
		
		
		
	}
	System.out.println("Numbers Count  :"+number);
	System.out.println("String Count  :"+StringCount);
	System.out.println("AlphaNumeric Count  :"+alphanum);
	
	
	
	
	driver.quit();
		
	}

}
