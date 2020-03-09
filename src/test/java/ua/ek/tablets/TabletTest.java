package ua.ek.tablets;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.model.Price;
import ua.ek.utils.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TabletTest extends BaseTest {

//    @Test(testName = "Tablets Prices Test", dataProvider = "tabletsPricesDataProvider")
//    public void tabletsPricesTest(double minPrice, double maxPrice, String expectedMessage) {

    @Test(testName = "Tablets Prices Test")
    public void tabletsPricesTest() {

        List<Price> prices = null;

        try {
            prices = getPrices();
        } catch (IOException e) {
            e.getMessage();
        }

        for (Price price : prices) {
            getTabletStep().goTabletPage();
            getTabletStep().enterMinPrice(Helper.convertDoubleToString(price.getMinPrice()));
            getTabletStep().enterMaxPrice(Helper.convertDoubleToString(price.getMaxPrice()));
            getTabletStep().submitButtonClick();

            AssertUtils.makeAssert(getTabletsListStep().getTextPrices(), price.getExpectedMessage());
        }
    }

    @Test
    public void tabletsFixedPricesLinkTest() {
        getTabletStep().goTabletPage();
        getTabletStep().clickFixedPriceLink();
        AssertUtils.makeAssert(getTabletsListStep().getTextPrices(),
                " от 7000  до 10000 грн.");
    }

    @Test
    public void tabletsDisplayDiagonalLinkTest() {
        getTabletStep().goTabletPage();
        getTabletStep().clickDisplayDiagonalLink();
        AssertUtils.makeAssert(getTabletsListStep().getTextPrices(),
                "Планшеты 10 дюймов ");
    }

    @Test
    public void tabletsManufacturersLinkTest() {
        getTabletStep().goTabletPage();
        getTabletStep().clickManufacturerLink();
        AssertUtils.makeAssert(getTabletsListStep().getTextPrices(),
                "Планшеты Apple ");
    }

    @DataProvider(name = "tabletsPricesDataProvider")
    private Object[][] tabletsPricesDataProvider() throws IOException {
        return GetDataFromExcel.getDataToObjectArray("/properties/common.properties",
                "tablets.test.prices.data.file", "prices");
    }

    private List<Price> getPrices() throws IOException {
        List<Object> objectList = new ArrayList<>();
        List<Price> prices = new ArrayList<>();

        objectList = GetDataFromExcel.getDataToList("/properties/common.properties",
                "tablets.test.prices.data.file", "prices", "ua.ek.model.Price");

        prices = ClassConverter.cast(Price.class, objectList);
        return prices;
    }
}