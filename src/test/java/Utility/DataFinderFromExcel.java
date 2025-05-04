package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataFinderFromExcel  
{

public String[] HomeUserLoginExcelData() throws EncryptedDocumentException, IOException
{
configReader exfile = new configReader();
String ExcelFilePath = exfile.getproperties("ExcelPath");
FileInputStream fs = new FileInputStream(ExcelFilePath);

Workbook work = WorkbookFactory.create(fs);
Sheet sheet	= 	work.getSheet("Sheet1");


String UserName = sheet.getRow(1).getCell(0).getStringCellValue();


String UserPassword = sheet.getRow(1).getCell(1).getStringCellValue();

return new String[] {UserName,UserPassword};

}
}
