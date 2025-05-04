package RandD;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class fetchdatafromonetableinexcelformated 
{
@Test
	
	public void onetable() throws IOException 
	{
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/Mohit/Desktop/tables.html");
		
		List<WebElement> tablerows = driver.findElements(By.xpath("//table[caption[contains(text(),'Single Column Mixed Values Table')]]//tr"));
		
		System.out.println(tablerows.size());
		
		FileInputStream file = new FileInputStream("D:\\Study\\Selenium\\ExcelDataforLogin\\TableData.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sh = wb.createSheet("NewSheet"+LocalTime.now().getSecond());
		
		for(int i = 0;i<tablerows.size();i++)
		{
			
			XSSFRow rw = sh.createRow(i);
			
			List<WebElement> tdata = tablerows.get(i).findElements(By.xpath("td"));
			
			for(int j = 0;j<tdata.size();j++)
			{
				rw.createCell(j).setCellValue(tdata.get(j).getText().trim());
			}
		}
		
		FileOutputStream  fileoutput = new FileOutputStream("D:\\Study\\Selenium\\ExcelDataforLogin\\TableData.xlsx");
		wb.write(fileoutput);
		fileoutput.close();
		
		driver.quit();
		
		
	}

}
