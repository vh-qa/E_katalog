package ua.ek.tablets;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.pages.tablets.TabletsManufacturerPage;
import ua.ek.pages.tablets.TabletsPage;
import ua.ek.pages.PageManager;
import ua.ek.utils.AssertUtils;
import ua.ek.utils.Helper;
import ua.ek.utils.PropertyReader;
import java.io.FileInputStream;
import java.io.IOException;

public class TabletsTest extends BaseTest {

    private PageManager pageManager = new PageManager();

    @Test(testName = "Tablets Page Filters Tests", dataProvider = "testTabletsDataProvider")
    public void tabletsPageFiltersTests(String manufacturerName,
                                 double displayDiagonal,
                                 String expectedMessage) {

        TabletsPage tabletsPage = pageManager
                    .goTabletsPage(driver)
                    .clickManufacturer(manufacturerName)
                    .clickDisplayDiagonal(Helper.convertDoubleToInt(displayDiagonal));

        TabletsManufacturerPage tabletsManufacturerPage = tabletsPage.clickShowButton();
        AssertUtils.makeAssert(tabletsManufacturerPage.getPageTitle(), expectedMessage);
    }

    @DataProvider(name = "testTabletsDataProvider")
    private Object[][] testTabletsDataProvider() throws IOException {

        String pathData = PropertyReader
                         .from("/properties/common.properties", "tablets.test.data.file")
                         .getProperty("tablets.test.data.file");

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(pathData));

        XSSFSheet sheet = workbook.getSheet("Filter_test_1");
        Object[][] tabletsData = new Object[sheet.getLastRowNum()][3];

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow parRow = sheet.getRow(i);
            tabletsData[i - 1][0] = (parRow.getCell(0) == null) ? "" : parRow.getCell(0).getStringCellValue();
            tabletsData[i - 1][1] = (parRow.getCell(1) == null) ? "" : parRow.getCell(1).getNumericCellValue();
            tabletsData[i - 1][2] = (parRow.getCell(2) == null) ? "" : parRow.getCell(2).getStringCellValue();
        }

        return tabletsData;
    }
}