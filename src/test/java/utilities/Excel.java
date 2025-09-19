package utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;

public class Excel {

    // Read Excel Values
    public static String getCellValue(String xl, String sheet, int row, int column) {
        try (FileInputStream file = new FileInputStream(xl);
             XSSFWorkbook wb = new XSSFWorkbook(file)) {

            XSSFCell cell = wb.getSheet(sheet).getRow(row).getCell(column);

            if (cell == null) {
                return ""; // return empty if cell is blank
            }

            if (cell.getCellType() == CellType.STRING) {
                return cell.getStringCellValue();
            } else {
                return cell.getRawValue(); // handles numeric/boolean
            }

        } catch (Exception e) {
            System.out.println("Error in reading Input Excel: " + e.getMessage());
            return ""; // must return something
        }
    }

    // Get row count
    public int getRowCount(String xl, String sheet) {
        try (FileInputStream file = new FileInputStream(xl);
             XSSFWorkbook wb = new XSSFWorkbook(file)) {

            return wb.getSheet(sheet).getLastRowNum();

        } catch (Exception e) {
            System.out.println("Error in Row Count Method: " + e.getMessage());
            return 0;
        }
    }

    // ✅ New: Return all data from sheet as 2D array (for DataProvider)
    public static Object[][] getData(String xl, String sheet) {
        try (FileInputStream file = new FileInputStream(xl);
             XSSFWorkbook wb = new XSSFWorkbook(file)) {

            XSSFSheet sh = wb.getSheet(sheet);
            int rowCount = sh.getLastRowNum(); // total rows
            int colCount = sh.getRow(0).getLastCellNum(); // total columns

            Object[][] data = new Object[rowCount][colCount];

            for (int i = 1; i <= rowCount; i++) { // start from 1 (skip header row)
                for (int j = 0; j < colCount; j++) {
                    XSSFCell cell = sh.getRow(i).getCell(j);
                    if (cell == null) {
                        data[i - 1][j] = "";
                    } else if (cell.getCellType() == CellType.STRING) {
                        data[i - 1][j] = cell.getStringCellValue();
                    } else {
                        data[i - 1][j] = cell.getRawValue();
                    }
                }
            }
            return data;

        } catch (Exception e) {
            System.out.println("Error in getData Method: " + e.getMessage());
            return new Object[0][0]; // return empty array if error
        }
    }
}
