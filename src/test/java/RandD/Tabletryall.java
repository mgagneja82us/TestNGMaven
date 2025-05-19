package RandD;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Tabletryall 
{
	
	@Test
	
	public void firsttable() throws IOException
	{
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("C:\\Users\\Mohit\\OneDrive\\Desktop\\tables.html");
		
//		cellcount
		int cellcount = driver.findElements(By.xpath("//table//tr//td")).size();
		List<WebElement> dataval = driver.findElements(By.xpath("//table//tr//td"));
		
		List<String> storeddata = new ArrayList<>();
		for(int i = 0;i<cellcount;i++)
		{
			storeddata.add(dataval.get(i).getText().trim());
			
			
		}
		
		System.out.println(storeddata);
		
		XSSFWorkbook workbook =  new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("MySheet");
		XSSFRow rw = sheet.createRow(0);
		XSSFCell cell = rw.createCell(0);
		
		cell.setCellValue("Data");
		
		int rownum = 1;
		for(String st:storeddata)
		{
			sheet.createRow(rownum).createCell(0).setCellValue(st);
			rownum++;
		}
		
		FileOutputStream  fileoutput = new FileOutputStream("D:\\Study\\Selenium\\ExcelDataforLogin\\TableData.xlsx");
		
		workbook.write(fileoutput);
		
		fileoutput.close();
		workbook.close();
	}

}
