package com.htc.filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void main(String[] args) {

		String fileName = "Sample.xls";

		Workbook workbook = null;
		if (fileName.endsWith("xls"))
			workbook = new HSSFWorkbook();

		else if (fileName.endsWith("xlsx"))
			workbook = new XSSFWorkbook();
		else
			try {
				throw new FileNotFoundException("Excepted file format xls or xlsx is not found");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		Sheet sheet= workbook.createSheet("Sample");
		Row row=sheet.createRow(0);
		Cell cell=row.createCell(0,CellType.NUMERIC);
		cell.setCellValue(123);
		row.createCell(1,CellType.STRING).setCellValue("Gopi");
		row.createCell(2,CellType.STRING).setCellValue("Trainer");
		row.createCell(3,CellType.NUMERIC).setCellValue(2000.00);
		
		
		Row row1=sheet.createRow(1);
		row1.createCell(0,CellType.NUMERIC).setCellValue(124);
		row1.createCell(1,CellType.STRING).setCellValue("Charles");
		row1.createCell(2,CellType.STRING).setCellValue("Big data");
		row1.createCell(3,CellType.NUMERIC).setCellValue(200000.00);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
