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

public class fetchdatafromonetableinexcel 
{
	
	@Test
	
	public void onetable() throws IOException 
	{
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/Mohit/Desktop/tables.html");
		
		
		int cellsdata = driver.findElements(By.xpath("//table[caption[contains(text(),'Employee Details Table')]]//tr//td")).size();
		List<WebElement> alldata = driver.findElements(By.xpath("//table[caption[contains(text(),'Employee Details Table')]]//tr//td"));
			
		List<String> out = new ArrayList<>();
		
		for(int i = 0;i<cellsdata;i++) 
		{
		WebElement mydata = alldata.get(i);
		String readydata = mydata.getText().trim();
		out.add(readydata);
		
			
		}
		System.out.println(out);
		
		XSSFWorkbook work = new XSSFWorkbook();
		XSSFSheet sheet = work.createSheet("MySheet1");
		XSSFRow rw = sheet.createRow(0);
		XSSFCell cell = rw.createCell(0);
		
		cell.setCellValue("Employee Details Table");
		int j = 1;
		for(String sd:out)
		{
			sheet.createRow(j).createCell(0).setCellValue(sd);
			j++;
		}
		FileOutputStream  fileoutput = new FileOutputStream("D:\\Study\\Selenium\\ExcelDataforLogin\\TableData.xlsx");
		work.write(fileoutput);
		fileoutput.close();
		
		driver.quit();
		
	}

}
