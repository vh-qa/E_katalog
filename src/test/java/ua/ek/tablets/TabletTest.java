package ua.ek.tablets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.ek.base.BasePage;
import ua.ek.base.BaseTest;
import ua.ek.pages.tablets.TabletPage;
import ua.ek.pages.tablets.TabletsList;
import ua.ek.pages.PageManager;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class TabletTest extends BaseTest {
    private final static Logger LOG = LogManager.getLogger(BasePage.class);
    private PageManager pageManager = new PageManager();

    @BeforeTest
    public void goTabletPage(){

    }

    @Test(testName = "Tablets Prices Test", dataProvider = "tabletsPricesDataProvider")
    public void tabletsPricesTest(String minPrice, String maxPrice, String expectedMessage) {
        TabletPage tabletPage = pageManager.goTabletPage(driver);

        tabletPage.enterMinPrice(minPrice);
        tabletPage.enterMaxPrice(maxPrice);

        TabletsList tabletsList = tabletPage.submitButtonClick();

        try {
            assertEquals(tabletsList.getTextPrices(), expectedMessage);
            LOG.info("Text prices: {} - Expected text prices: {}",
                    tabletsList.getTextPrices(), expectedMessage);
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
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
