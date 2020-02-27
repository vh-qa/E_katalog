package ua.ek.tablets;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.pages.tablets.TabletPage;
import ua.ek.pages.tablets.TabletsList;
import ua.ek.pages.PageManager;
import ua.ek.utils.AssertUtils;
import ua.ek.utils.Helper;
import ua.ek.utils.PropertyReader;

import java.io.FileInputStream;
import java.io.IOException;

public class TabletTest extends BaseTest {

    private PageManager pageManager = new PageManager();

    @Test(testName = "Tablets Prices Test", dataProvider = "tabletsPricesDataProvider")
    public void tabletsPricesTest(double minPrice, double maxPrice, String expectedMessage) {
        TabletPage tabletPage = pageManager.goTabletPage(driver);

        tabletPage.enterMinPrice(Helper.convertDoubleToString(minPrice));
        tabletPage.enterMaxPrice(Helper.convertDoubleToString(maxPrice));

        TabletsList tabletsList = tabletPage.submitButtonClick();
        AssertUtils.makeAssert(tabletsList.getTextPrices(), expectedMessage);
    }

    @DataProvider(name = "tabletsPricesDataProvider")
    private Object[][] tabletsPricesDataProvider() throws IOException {

        String pathData = PropertyReader
                .from("/properties/common.properties", "tablets.test.prices.data.file")
                .getProperty("tablets.test.prices.data.file");

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(pathData));

        XSSFSheet sheet = workbook.getSheet("prices");
        Object[][] priceData = new Object[sheet.getLastRowNum()][3];

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow parRow = sheet.getRow(i);
            priceData[i - 1][0] = (parRow.getCell(0) == null) ? "" : parRow.getCell(0).getNumericCellValue();
            priceData[i - 1][1] = (parRow.getCell(1) == null) ? "" : parRow.getCell(1).getNumericCellValue();
            priceData[i - 1][2] = (parRow.getCell(2) == null) ? "" : parRow.getCell(2).getStringCellValue();
        }

        return priceData;
    }
}