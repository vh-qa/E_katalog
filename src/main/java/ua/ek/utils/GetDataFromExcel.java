package ua.ek.utils;

import com.sun.corba.se.impl.io.TypeMismatchException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class GetDataFromExcel {

    private static List<String> getTitlesFromExcelTable(String propertyFileName,
                                                        String propertyName,
                                                        String excelSheetName) throws IOException {

        String pathData = PropertyReader
                .from(propertyFileName, propertyName)
                .getProperty(propertyName);

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(pathData));
        XSSFSheet sheet = workbook.getSheet(excelSheetName);

        List<String> excelTabletitles = new ArrayList<>();
        XSSFRow titleRow = sheet.getRow(0);

        for (int i = 0; i < titleRow.getPhysicalNumberOfCells(); i++) {
            if (titleRow.getCell(i) != null) {
                if (!titleRow.getCell(i).getStringCellValue().equals("")) {
                    excelTabletitles.add(titleRow.getCell(i).getStringCellValue().trim().toLowerCase());
                }
            }
        }
        return excelTabletitles;
    }

    public static Object[][] getDataToObjectArray(String propertyFileName,
                                                  String propertyName,
                                                  String excelSheetName) throws IOException {

        String pathData = PropertyReader
                .from(propertyFileName, propertyName)
                .getProperty(propertyName);

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(pathData));

        XSSFSheet sheet = workbook.getSheet(excelSheetName);
        int rowNumbers = sheet.getLastRowNum();
//      int columnNumbers = sheet.getRow(0).getPhysicalNumberOfCells();
        List<String> titles = getTitlesFromExcelTable(propertyFileName, propertyName, excelSheetName);
        int columnNumbers = titles.size();

        Object[][] tabletsData = new Object[rowNumbers][columnNumbers];

        for (int i = sheet.getFirstRowNum() + 1; i <= rowNumbers; i++) {
            XSSFRow parRow = sheet.getRow(i);

            for (int j = parRow.getFirstCellNum(); j < parRow.getPhysicalNumberOfCells(); j++) {

                        CellType cellType = parRow.getCell(j).getCellType();

                        switch (cellType) {
                            case STRING:
                                tabletsData[i - 1][j] = (parRow.getCell(j) == null) ? "" : parRow.getCell(j).getStringCellValue();
                                break;
                            case NUMERIC:
                                tabletsData[i - 1][j] = (parRow.getCell(j) == null) ? 0.0 : parRow.getCell(j).getNumericCellValue();
                                break;
                            default:
                                break;
                        }
                    }
        }

        return tabletsData;
    }

    public static List<Object> getDataToList(String propertyFileName,
                                             String propertyName,
                                             String excelSheetName,
                                             String className) {

        List<String> titlesFromExcelTable = new ArrayList<>();

        try {
            titlesFromExcelTable = getTitlesFromExcelTable(propertyFileName, propertyName, excelSheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Object> objectListToReturnToTestMethod = new ArrayList<>();

        try {
            Class<?> c = Class.forName(className);
            Method[] declaredMethodsFromClass = c.getDeclaredMethods();

            List<Method> setMethodsFromClass = new ArrayList<>();
            Map<Integer, Method> setMethodsFromClassWithRightIndex = new HashMap<>();

            for (Method method : declaredMethodsFromClass) {
                if (method.getName().startsWith("set")) {
                    setMethodsFromClass.add(method);
                }
            }

            for (int i = 0; i < titlesFromExcelTable.size(); i++) {
                String title = titlesFromExcelTable.get(i);
                for (Method method : setMethodsFromClass) {

                    if (method.getName().trim().toLowerCase().contains(title)) {
                        setMethodsFromClassWithRightIndex.put(i, method);
                        break;
                    }
                }
            }

            Object[][] objectArrayFromExcelTable = getDataToObjectArray(propertyFileName, propertyName, excelSheetName);

            for (int j = 0; j < objectArrayFromExcelTable.length; j++) {
                Object t = c.newInstance();
                for (int k = 0; k < objectArrayFromExcelTable[j].length; k++) {
                    Method method = setMethodsFromClassWithRightIndex.get(k);
                    method.invoke(t, objectArrayFromExcelTable[j][k]);
                }

//              objectListToReturnToTestMethod.add(t.getClass());
                objectListToReturnToTestMethod.add(t);
            }
        } catch (ClassNotFoundException | IllegalAccessException |
                InstantiationException | InvocationTargetException |
                NullPointerException | TypeMismatchException | IOException e) {
            e.printStackTrace();
        }

        return objectListToReturnToTestMethod;
    }
}