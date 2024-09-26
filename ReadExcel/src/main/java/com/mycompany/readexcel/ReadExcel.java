/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author admin
 */
public class ReadExcel {

    public static void main(String[] args) throws IOException {
        try {
            //creating workbook instance that refers to .xls file
            try (FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\admin\\Downloads\\SampleData.xls"))) {
                //creating workbook instance that refers to .xls file
                HSSFWorkbook wb = new HSSFWorkbook(fileInputStream);
                HSSFSheet sheet = wb.getSheetAt(0);
                System.out.println(wb.getNumberOfSheets());
                // Iterate through each rows one by one
                Iterator<Row> rowIterator = sheet.iterator();
                // Till there is an element condition holds true
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    
                    // For each row, iterate through all the columns
                    Iterator<Cell> cellIterator = row.cellIterator();
                    
                    while (cellIterator.hasNext()) {
                        
                        Cell cell = cellIterator.next();
                        
                        // Checking the cell type and format
                        // accordingly
                        switch (cell.getCellType()) {
                            case NUMERIC ->
                                System.out.println(cell.getNumericCellValue());
                                
                            case STRING ->
                                System.out.println(cell.getStringCellValue());
                        }
                       
                    }
                     System.out.println();
 
                }
                // Closing file output streams
            }

            System.out.println();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public static void printCellValue(Cell cell) {
//        CellType cellType = cell.getCellType().equals(CellType.FORMULA)
//                ? cell.getCachedFormulaResultType() : cell.getCellType();
//        if (cellType.equals(CellType.STRING)) {
//            System.out.print(cell.getStringCellValue() + " | ");
//        }
//        if (cellType.equals(CellType.NUMERIC)) {
//            if (DateUtil.isCellDateFormatted(cell)) {
//                System.out.print(cell.getDateCellValue() + " | ");
//            } else {
//                System.out.print(cell.getNumericCellValue() + " | ");
//            }
//        }
//        if (cellType.equals(CellType.BOOLEAN)) {
//            System.out.print(cell.getBooleanCellValue() + " | ");
//        }
//    }
}
