package Utility;

import java.io.*;
import org.apache.poi.xssf.usermodel.*;

public class CreateAndReadFile {
    public static void main(String[] args) throws IOException {
        String inputFile = "D:\\Study\\Cucumber\\Payment.dat";
        String outputFile = "D:\\Study\\Cucumber\\mysheet.xlsx";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("TestCases");

			// Create Header Row
			XSSFRow headerRow = sheet.createRow(0);
			headerRow.createCell(0).setCellValue("TestCase");
			headerRow.createCell(1).setCellValue("Action");
			headerRow.createCell(2).setCellValue("Expected Result");

			String line;
			int rownum = 1;

			while ((line = br.readLine()) != null) {
			    System.out.println("Reading Line: " + line); // Debugging line

			    // Trim and ignore empty lines
			    line = line.trim();
			    if (line.isEmpty()) {
			        System.out.println("Skipping empty line.");
			        continue;
			    }

			    // Try different delimiters if needed
			    String[] data = line.split("\\t"); // Try "\\s+" for spaces, "," for CSV

			    System.out.println("Split Data Length: " + data.length); // Debugging line

			    if (data.length >= 4) {
			        XSSFRow row = sheet.createRow(rownum++);
			        row.createCell(0).setCellValue(data[0]);
			        row.createCell(1).setCellValue(data[1]);
			        row.createCell(2).setCellValue(data[2]);
			    } else {
			        System.out.println("Skipping invalid line (not enough columns): " + line);
			    }
			}

			//br.close();

			// Write Data to Excel
			FileOutputStream fos = new FileOutputStream(outputFile);
			workbook.write(fos);
			fos.close();
			workbook.close();
		}
        System.out.println("Excel file created successfully!");
    }
}
