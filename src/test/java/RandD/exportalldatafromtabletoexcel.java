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

public class exportalldatafromtabletoexcel 
{
	
	@Test
	
	public void firsttable() throws IOException
	{
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("C:\\Users\\Mohit\\OneDrive\\Desktop\\tables.html");
		
		
		int counttr = driver.findElements(By.xpath("//table//tr")).size();
		int countcell = driver.findElements(By.xpath("//table//tr//td")).size();
		
		List<WebElement> celldata = driver.findElements(By.xpath("//table//tr//td"));
		
		List<String> Celldata1 = new ArrayList<>();
		for(int i = 0;i<countcell;i++)
		{
			WebElement capturetabledata = celldata.get(i);
			Celldata1.add(capturetabledata.getText().trim());
		}
		
		
		System.out.println("Total Table Row are : "+counttr);
		System.out.println("Total Table cells are : "+countcell);
		System.out.println(Celldata1);
		
		
		XSSFWorkbook work = new XSSFWorkbook();
		XSSFSheet sheet = work.createSheet("MySheet");
		XSSFRow rw = sheet.createRow(0);
		XSSFCell cell = rw.createCell(0);
		
		cell.setCellValue("Data");
		int rownbr = 1;
		for(String celldataval:Celldata1)
		{
			sheet.createRow(rownbr).createCell(0).setCellValue(celldataval);
			rownbr++;
		}
		
		FileOutputStream  fileoutput = new FileOutputStream("D:\\Study\\Selenium\\ExcelDataforLogin\\TableData.xlsx");
		work.write(fileoutput);
		fileoutput.close();
		
		work.close();
		
		
		
		
		
		//driver.quit();
		
	}

}
