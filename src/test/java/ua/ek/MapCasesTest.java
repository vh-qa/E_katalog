package ua.ek;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.ek.base.BasePage;
import ua.ek.base.BaseTest;
import ua.ek.page.MapCasesManufacturerPage;
import ua.ek.page.MapCasesPage;
import ua.ek.page.PageManager;
import ua.ek.utils.Manufacturers;
import ua.ek.utils.PropertyReader;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.io.FileInputStream;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class MapCasesTest extends BaseTest {
    private final static Logger LOG = LogManager.getLogger(BasePage.class);
    private PageManager pageManager = new PageManager();

    @BeforeTest
    public void goMapCasesPage() {

    }

    @Test(testName = "MapCases tests", dataProvider = "testMapCasesDataProvider")
    public void MapCasesPageTests(String manufacturer,
                                  double displayDiagonal,
                                  String expectedMessage) {

        MapCasesPage mapCasesPage = pageManager.goMapCasesPage(driver);

        switch (manufacturer.trim().toLowerCase()) {
            case "apple":
                mapCasesPage.clickAppleManufacturer();
                break;
            case "samsung":
                mapCasesPage.clickSamsungManufacturer();
                break;
            default:
                break;
        }

        mapCasesPage.clickDisplayDiagonal();


//        switch(operatingSystem){
//            case "iOs":
//                mapCasesPage.clickIosOperatingSystem();
//                break;
//            case "android 9 pie":
//                mapCasesPage.clickAndroid9PieOperatingSystem();
//                break;
//            default:
//                break;
//        }

        MapCasesManufacturerPage mapCasesManufacturerPage = mapCasesPage.clickShowButton();

        try {
            assertEquals(mapCasesManufacturerPage.getPageTitle(), expectedMessage);
            LOG.info("Page title: {} - Expected page title: {}",
                    mapCasesManufacturerPage.getPageTitle(), expectedMessage);
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @DataProvider(name = "testMapCasesDataProvider")
    private Object[][] testAuthDataProvider() throws IOException {

        String pathData = PropertyReader
                .from("/common.properties", "map.cases.test.data.file")
                .getProperty("map.cases.test.data.file");

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(pathData));

        XSSFSheet sheet = workbook.getSheet("Data-1");
        Object[][] mapCasesData = new Object[sheet.getLastRowNum()][3];

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow parRow = sheet.getRow(i);
            mapCasesData[i - 1][0] = (parRow.getCell(0) == null) ? "" : parRow.getCell(0).getStringCellValue();
            mapCasesData[i - 1][1] = (parRow.getCell(1) == null) ? "" : parRow.getCell(1).getNumericCellValue();
            mapCasesData[i - 1][2] = (parRow.getCell(2) == null) ? "" : parRow.getCell(2).getStringCellValue();
        }

        return mapCasesData;
    }
}
