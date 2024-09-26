/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.readexcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author admin
 */
public class ExcelReader2 {
    public static void main(String[] args) throws IOException {
        
        ExcelReader2 er=new ExcelReader2();
  
        er.getExcelAsMap(); 
    }
    private String filePath;

    private HSSFSheet getSheet() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\\\Users\\\\admin\\\\Downloads\\\\SampleData.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        HSSFSheet sheet = workbook.getSheetAt(0);
        return sheet;
    }

    public Map<String, Map<String, String>> getExcelAsMap() throws IOException {
        HSSFSheet sheet = getSheet();
        Map<String, Map<String, String>> completeSheetData = new HashMap<>();
        List<String> columnHeader = new ArrayList<>();
        Row row = sheet.getRow(0);
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
            columnHeader.add(cellIterator.next().getStringCellValue());
        }
        int rowCount = row.getLastCellNum();
        int columnCount = row.getLastCellNum();
        for (int i = 1; i <= rowCount; i++) {
            Map<String, String> singleRowData = new HashMap<>();
            Row row1 = sheet.getRow(i);
            for (int j = 0; j < columnCount; j++) {
                Cell cell = row1.getCell(j);
                singleRowData.put(columnHeader.get(j), getCellValueAsString(cell));
            }
            completeSheetData.put(String.valueOf(i), singleRowData);
        }
        return completeSheetData;
        
    }

    public String getCellValueAsString(Cell cell) {
        String cellValue = null;
        switch (cell.getCellType()) {
            case NUMERIC:
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                cellValue = cell.getCellFormula();
            case BLANK:
                cellValue = "BLANK";
            default:
                cellValue = "DEFAULT";
        }
        return cellValue;
    }
}
