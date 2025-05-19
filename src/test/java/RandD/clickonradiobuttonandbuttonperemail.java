package RandD;

//Find all the rows where status ="InStock". get the product name and price, print them on screen only and click on Buy now button

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class clickonradiobuttonandbuttonperemail 
{
	
@Test
	
	public void onetable() throws IOException 
	{
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("C:\\Users\\Mohit\\OneDrive\\Desktop\\tables.html");
		
		List<WebElement>tablerows =  driver.findElements(By.xpath("//table[caption[contains(text(),'Product Table')]]//tr"));
		
	
		
				
				
				List<WebElement>header =  driver.findElements(By.xpath("//table[caption[contains(text(),'Product Table')]]//th"));
				
				
				int indexforStatus = -1;
				int indexforprice = -1;
				int indexforproductname = -1;
				
				for(int i = 0; i<header.size();i++)
				{
					if(header.get(i).getText().trim().equals("Status"))
					{
						
						indexforStatus = i;
					
						
					}
					else if(header.get(i).getText().trim().equals("Product Name"))
					{
						indexforproductname = i;
					
						
					}
					else if(header.get(i).getText().trim().equals("Price"))
					{
						indexforprice = i;
						
						
					}
				}
				
				
				for(int x = 1;x<tablerows.size();x++)
				{
					List<WebElement> testdata = tablerows.get(x).findElements(By.tagName("td"));
					
					if(testdata.get(indexforStatus).getText().trim().equals("In Stock"))
					{
						System.out.println(testdata.get(indexforproductname).getText().trim());
						System.out.println(testdata.get(indexforprice).getText().trim());
						
						tablerows.get(x).findElement(By.xpath("./button")).click();
					}
					
				}
				
				//driver.quit();
	}

}
