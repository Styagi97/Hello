/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.readexcel;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author admin
 */
public class ReadExcelInJSON {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        JsonParser jp = new JsonParser();
        FileInputStream fis = null;

        fis = new FileInputStream(new File("C:\\Users\\admin\\Downloads\\SampleData.xls"));
        try {
            JsonObject jo = getExcelDataAsJsonObject(fis);
            System.out.println(jo);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(ReadExcelInJSON.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static JsonObject getExcelDataAsJsonObject(FileInputStream excelFile) throws InvalidFormatException, IOException {

        JsonObject sheetsJsonObject = new JsonObject();
        Workbook workbook = null;

        HSSFWorkbook wb = new HSSFWorkbook(excelFile);

        for (int i = 0; i < wb.getNumberOfSheets(); i++) {

            JsonArray sheetArray = new JsonArray();
            ArrayList<String> columnNames = new ArrayList<>();
            Sheet sheet = wb.getSheetAt(i);
            Iterator<Row> sheetIterator = sheet.iterator();
            while (sheetIterator.hasNext()) {

                Row currentRow = sheetIterator.next();
                JsonObject jsonObject = new JsonObject();

                if (currentRow.getRowNum() != 0) {

                    for (int j = 0; j < columnNames.size(); j++) {

                        if (currentRow.getCell(j) != null) {
                            if (null != currentRow.getCell(j).getCellType()) {
                                switch (currentRow.getCell(j).getCellType()) {
                                    case STRING ->
                                        jsonObject.addProperty(columnNames.get(j), currentRow.getCell(j).getStringCellValue());
                                    case NUMERIC ->
                                        jsonObject.addProperty(columnNames.get(j), currentRow.getCell(j).getNumericCellValue());
                                    case BOOLEAN ->
                                        jsonObject.addProperty(columnNames.get(j), currentRow.getCell(j).getBooleanCellValue());
                                    case BLANK ->
                                        jsonObject.addProperty(columnNames.get(j), "");
                                    default -> {
                                    }
                                }
                            }
                        } else {
                            jsonObject.addProperty(columnNames.get(j), "");
                        }

                    }

                    sheetArray.add(jsonObject);

                } else {
                    // store column names
                    for (int k = 0; k < currentRow.getPhysicalNumberOfCells(); k++) {
                        columnNames.add(currentRow.getCell(k).getStringCellValue());
                    }
                }

            }

            sheetsJsonObject.add(wb.getSheetName(i), sheetArray);

        }

        return sheetsJsonObject;
    }
}
