//You have an HTML table with the caption "Status Table" containing multiple rows. The table has a "Name" column and a "Status" column (values can be "Active" or "Inactive").
//
//Write a Selenium + TestNG + Apache POI program that:
//
//Dynamically finds the index of "Name" and "Status" columns
//
//Iterates over each table row and extracts only rows where status is "Active"
//
//Writes all the cell values of matching rows into a new Excel sheet
//
//Each run should create a new sheet in the same Excel file with the name NewSheetXX (where XX is current second)
//

package RandD;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class getdataperstatusandpastinexcel
{

@Test
	
	public void onetable() throws IOException 
	{
	ChromeDriver driver = new ChromeDriver();
	
	driver.get("file:///C:/Users/Mohit/Desktop/tables.html");
	
	List<WebElement> header = driver.findElements(By.xpath("//table[caption[contains(text(),'Status Table')]]//th"));
	
	int indexnumberStatus = -1;
	int indexnumberName = -1;
	
	for(int i = 0;i<header.size();i++)
	{
		
		if(header.get(i).getText().trim().equals("Status"))
		{
			indexnumberStatus = i;
		}
		
		if(header.get(i).getText().trim().equals("Name"))
		{
			indexnumberName = i;
		}
		
	}
	
	
	FileInputStream file = new FileInputStream("D:\\Study\\Selenium\\ExcelDataforLogin\\TableData.xlsx");
	
	XSSFWorkbook wb = new XSSFWorkbook(file);
	XSSFSheet sh = wb.createSheet("NewSheet"+LocalTime.now().getSecond());
	
	List<WebElement> rows = driver.findElements(By.xpath("//table[caption[contains(text(),'Status Table')]]//tr"));
	
	int excelrow = 0;
	int myrow = 0;
	for(int j = 1;j<rows.size();j++)
		
	{
		String rowval = rows.get(j).findElements(By.tagName("td")).get(indexnumberStatus).getText().trim();
		
		if(rowval.equals("Active"))
		{
			List<WebElement> lis = rows.get(j).findElements(By.tagName("td"));
			
			//System.out.println (rows.get(j).getText());
			 XSSFRow row = sh.createRow(myrow++);
			for(int x = 0;x<lis.size();x++)
			{
				row.createCell(x).setCellValue(lis.get(x).getText());
			
			}
			//sh.createRow(excelrow++).createCell(0).setCellValue(rows.get(j).getText());

			
					
		}
	}
	
FileOutputStream  fileoutput = new FileOutputStream("D:\\Study\\Selenium\\ExcelDataforLogin\\TableData.xlsx");
wb.write(fileoutput);
fileoutput.close();
	
	driver.quit();
		
	}

}
