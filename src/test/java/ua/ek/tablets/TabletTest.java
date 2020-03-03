package ua.ek.tablets;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.model.Price;
import ua.ek.utils.AssertUtils;
import ua.ek.utils.Helper;
import ua.ek.utils.PropertyReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TabletTest extends BaseTest {

//    @Test(testName = "Tablets Prices Test", dataProvider = "tabletsPricesDataProvider")
//    public void tabletsPricesTest(double minPrice, double maxPrice, String expectedMessage) {

    @Test(testName = "Tablets Prices Test")
    public void tabletsPricesTest() {

        List<Price> prices = null;

        try{
            prices = getPrices();
        }catch (IOException e){
            e.getMessage();
        }

        for (Price price : prices) {
            tabletStep.goTabletPage(driver);
            tabletStep.enterMinPrice(Helper.convertDoubleToString(price.getMinPrice()));
            tabletStep.enterMaxPrice(Helper.convertDoubleToString(price.getMaxPrice()));
            tabletStep.submitButtonClick();

            AssertUtils.makeAssert(tabletsListStep.getTabletsListPage().getTextPrices(), price.getExpectedMessage());
        }
    }

    @Test
    public void tabletsFixedPricesLinkTest(){
        tabletStep.goTabletPage(driver);
        tabletStep.clickFixedPriceLink();
        AssertUtils.makeAssert(tabletsListStep.getTabletsListPage().getTextPrices(),
                " от 7000  до 10000 грн.");
    }

    @Test
    public void tabletsDisplayDiagonalLinkTest(){
        tabletStep.goTabletPage(driver);
        tabletStep.clickDisplayDiagonalLink();
        AssertUtils.makeAssert(tabletsListStep.getTabletsListPage().getTextPrices(),
                "Планшеты 10 дюймов ");
    }

    @Test
    public void tabletsManufacturersLinkTest(){
        tabletStep.goTabletPage(driver);
        tabletStep.clickManufacturerLink();
        AssertUtils.makeAssert(tabletsListStep.getTabletsListPage().getTextPrices(),
                "Планшеты Apple ");
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

    private List<Price> getPrices() throws IOException {
        List<Price> prices = new ArrayList<>();

        String pathData = PropertyReader
                .from("/properties/common.properties", "tablets.test.prices.data.file")
                .getProperty("tablets.test.prices.data.file");

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(pathData));

        XSSFSheet sheet = workbook.getSheet("prices");

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Price price = new Price();
            XSSFRow parRow = sheet.getRow(i);

            price.setMinPrice((parRow.getCell(0) == null) ? 0.0 : parRow.getCell(0).getNumericCellValue());
            price.setMaxPrice((parRow.getCell(1) == null) ? 0.0 : parRow.getCell(1).getNumericCellValue());
            price.setExpectedMessage((parRow.getCell(2) == null) ? "" : parRow.getCell(2).getStringCellValue());
            prices.add(price);
        }

        return prices;
    }
}