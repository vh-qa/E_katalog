package ua.ek.tablets;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.pages.tablets.TabletPage;
import ua.ek.pages.tablets.TabletsList;
import ua.ek.pages.PageManager;
import ua.ek.utils.AssertsUtils;
import java.io.IOException;

public class TabletTest extends BaseTest {

    private PageManager pageManager = new PageManager();

    @Test(testName = "Tablets Prices Test", dataProvider = "tabletsPricesDataProvider")
    public void tabletsPricesTest(String minPrice, String maxPrice, String expectedMessage) {
        TabletPage tabletPage = pageManager.goTabletPage(driver);

        tabletPage.enterMinPrice(minPrice);
        tabletPage.enterMaxPrice(maxPrice);

        TabletsList tabletsList = tabletPage.submitButtonClick();
        AssertsUtils.makeAssert(tabletsList.getTextPrices(), expectedMessage);
    }

    @DataProvider(name = "tabletsPricesDataProvider")
    private Object[][] tabletsPricesDataProvider() throws IOException {

        Object[][] priceData = new Object[2][3];

        priceData[0][0] = "10000";
        priceData[0][1] = "14999";
        priceData[0][2] = "от 10000 до 14999 грн.";

        priceData[1][0] = "15000";
        priceData[1][1] = "20000";
        priceData[1][2] = "от 15000 до 20000 грн.";

        return priceData;
    }
}