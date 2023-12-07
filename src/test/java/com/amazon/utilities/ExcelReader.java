package com.amazon.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public String filePath;
	public String sheetName;

	public ExcelReader(String filePath, String shettName) {
		super();
		this.filePath = filePath;
		this.sheetName = shettName;
	}

	public String getStringCellValue(int rowNum, int columnNum) {
		String celldata = null; // flag
		try {
			FileInputStream fis = new FileInputStream(filePath);
			Workbook registrationBook = new XSSFWorkbook(fis);
			Sheet sheet = registrationBook.getSheet(sheetName);
			Row row = sheet.getRow(rowNum);
			Cell column = row.getCell(columnNum);
			celldata = column.getStringCellValue();
			System.out.println(celldata);
			registrationBook.close();
			fis.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return celldata;

	}

	public static void main(String[] args) {
		String file = "src/test/resources/RegistrationData.xlsx";
		ExcelReader er = new ExcelReader(file, "Sheet1");

		er.getStringCellValue(1, 2);
		er.getStringCellValue(1, 3);

	}
}
