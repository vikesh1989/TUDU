package com.Tudu.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.TestBase.TestBase;

public class readExcelData extends TestBase{
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public readExcelData(String excelPath) {
		
		File file=new File(excelPath);
		try {
			FileInputStream fis=new FileInputStream(file);
			try {
				wb=new XSSFWorkbook(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String getData(int Sheetnumber,int row,int column) {
		
		sheet=wb.getSheetAt(Sheetnumber);
		DataFormatter formatter = new DataFormatter(); 
		String data=formatter.formatCellValue(sheet.getRow(row).getCell(column));
		
		return data;
	}
	public int GetRowCount(int sheetIndex) {
		
		int row=wb.getSheetAt(sheetIndex).getLastRowNum();
		row=row+1;
		return row;
		
		
	}

}
