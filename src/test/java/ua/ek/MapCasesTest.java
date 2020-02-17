package ua.ek;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.ek.base.BasePage;
import ua.ek.base.BaseTest;
import ua.ek.page.MapCasesPage;
import ua.ek.page.PageManager;
import ua.ek.utils.Manufacturers;
import ua.ek.utils.PropertyReader;

import java.io.FileInputStream;
import java.io.IOException;

public class MapCasesTest extends BaseTest {
    private final static Logger LOG = LogManager.getLogger(BasePage.class);
    private PageManager pageManager = new PageManager();

    @Test(testName = "MapCases tests", dataProvider = "testMapCasesDataProvider")
    public void MapCasesPageTests(String manufacturerName, String bodyColor,
                                  Double displayDiagonal, String operatingSystem,
                                  Double internalMemory) {

        pageManager.goMapCasesPage(driver)
                   .clickManufacturer(manufacturerName);


    }

    @DataProvider(name = "testMapCasesDataProvider")
    private Object[][] testAuthDataProvider() throws IOException {

        String pathData = PropertyReader
                .from("/common.properties", "map.cases.test.data.file")
                .getProperty("map.cases.test.data.file");

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(pathData));

        XSSFSheet sheet = workbook.getSheet("Data-1");
        Object[][] authData = new Object[sheet.getLastRowNum()][5];

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow parRow = sheet.getRow(i);
            authData[i - 1][0] = (parRow.getCell(0) == null) ? "" : parRow.getCell(0).getStringCellValue();
            authData[i - 1][1] = (parRow.getCell(1) == null) ? "" : parRow.getCell(1).getStringCellValue();
            authData[i - 1][2] = (parRow.getCell(2) == null) ? "" : parRow.getCell(2).getNumericCellValue();
            authData[i - 1][3] = (parRow.getCell(3) == null) ? "" : parRow.getCell(3).getStringCellValue();
            authData[i - 1][4] = (parRow.getCell(4) == null) ? "" : parRow.getCell(4).getNumericCellValue();
        }

        return authData;
    }
}
