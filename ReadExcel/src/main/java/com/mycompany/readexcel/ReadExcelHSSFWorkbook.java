
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author admin
 */
public class ReadExcelHSSFWorkbook {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File("C:\\Users\\admin\\Downloads\\SampleData.xls"));
            //creating workbook instance that refers to .xls file
            HSSFWorkbook wb = new HSSFWorkbook(fis);
            //creating a Sheet object to retrieve the object
            HSSFSheet sheet = wb.getSheetAt(0);
            //evaluating cell type
            FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {

                        case STRING ->
                            System.out.println(cell.getStringCellValue());
                        case NUMERIC ->
                            System.out.println(cell.getNumericCellValue());
                    }
                }
                System.out.println();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadExcelHSSFWorkbook.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadExcelHSSFWorkbook.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
