package ua.ek;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.ek.base.BasePage;
import ua.ek.base.BaseTest;
import ua.ek.page.MapCasePage;
import ua.ek.page.MapCasesList;
import ua.ek.page.MapCasesPage;
import ua.ek.page.PageManager;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class MapCaseTest extends BaseTest {
    private final static Logger LOG = LogManager.getLogger(BasePage.class);
    private PageManager pageManager = new PageManager();

    @BeforeTest
    public void goMapCasePage(){

    }

    @Test(testName = "Prices test", dataProvider = "pricesDataProvider")
    public void pricesTest(String minPrice, String maxPrice, String expectedMessage) {
        MapCasePage mapCasePage = pageManager.goMapCasePage(driver);

        mapCasePage.enterMinPrice(minPrice);
        mapCasePage.enterMaxPrice(maxPrice);

        MapCasesList mapCasesList = mapCasePage.submitButtonClick();

        try {
            assertEquals(mapCasesList.getTextPrices(), expectedMessage);
            LOG.info("Text prices: {} - Expected text prices: {}",
                    mapCasesList.getTextPrices(), expectedMessage);
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        pageManager.goMapCasePage(driver);
    }

    @DataProvider(name = "pricesDataProvider")
    private Object[][] pricesDataProvider() throws IOException {

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
