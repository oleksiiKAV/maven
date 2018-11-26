package com.telesens.academy.loginform;

import com.telesens.academy.lesson17.PropertyDemo;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ReadFromFileXLS {
    //return array of rows from start to end rows (if only one row then this is equal) with test data from all cells (Count)
    public static String[][] readFromXLX (int startRowNumber, int endRowNumber, int cellsCount) {
        XSSFCell cell;

        File file = new File(PropertyDemo.readProperty("loginfile"));
        String[][] objarray = new String[endRowNumber - startRowNumber + 1][cellsCount];

        try (XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file))) {
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            int objindex=0;
            for (int r = startRowNumber - 1; r < endRowNumber; r++) {
                XSSFRow row = sheet.getRow(r);
                if (row != null) {
                    for (int c = 0; c < cellsCount; c++) {
                        cell = row.getCell(c);
                        if (cell != null) {
                            switch (cell.getCellType()) {
                                case XSSFCell.CELL_TYPE_FORMULA:
                                    objarray[objindex][c] = cell.getCellFormula();
                                    break;
                                case XSSFCell.CELL_TYPE_NUMERIC:
                                    objarray[objindex][c] = ""
                                            + cell.getNumericCellValue();
                                    break;
                                case XSSFCell.CELL_TYPE_STRING:
                                    objarray[objindex][c] = ""
                                            + cell.getStringCellValue();
                                    break;
                                case XSSFCell.CELL_TYPE_BLANK:
                                    objarray[objindex][c] = "[BLANK]";
                                    break;
                                case XSSFCell.CELL_TYPE_ERROR:
                                    objarray[objindex][c] = "" + cell.getErrorCellValue();
                                    break;
                                default:
                            }
                            //System.out.print(objarray[r][c]);
                        } else {
                            objarray[objindex][c] = "";
                        }
                    } // for(c)
                }// if row!=null
                objindex++;
            }

            return objarray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
