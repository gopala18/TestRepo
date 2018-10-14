package com.htc.filehandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String fileName = "Sample.xlsx";

		Workbook workbook = null;
		if (fileName.endsWith("xls"))
			workbook = new HSSFWorkbook(new FileInputStream("Sample.xls"));

		else if (fileName.endsWith("xlsx"))
			workbook = new XSSFWorkbook(new FileInputStream("Sample.xlsx"));
		else
			try {
				throw new FileNotFoundException("Excepted file format xls or xlsx is not found");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Sheet sheet=workbook.getSheet("Sample" );
		Iterator<Row> rows=sheet.rowIterator();
		int i=-1;
		while(rows.hasNext()) {
			Row row=rows.next();
			Iterator<Cell> cells=row.cellIterator();
			while(cells.hasNext()) {
				Cell cell=cells.next();
				CellType type=cell.getCellTypeEnum();
				if(type==CellType.NUMERIC)
					System.out.println(cell.getNumericCellValue());
				else if(type==CellType.STRING)
					System.out.println(cell.getStringCellValue());
				else if(type==CellType.BOOLEAN)
					System.out.println(cell.getBooleanCellValue());
				else if(type==CellType.BLANK)
					System.out.println(" ");
			}
			
		}
	}
}
