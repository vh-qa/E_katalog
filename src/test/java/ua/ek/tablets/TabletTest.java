package ua.ek.tablets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.model.Price;
import ua.ek.steps.tablets.TabletStep;
import ua.ek.steps.tablets.TabletsListStep;
import ua.ek.utils.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TabletTest extends BaseTest {

    private TabletStep tabletStep;
    private TabletsListStep tabletsListStep;

    @BeforeMethod
    public void init(){
        tabletStep = (TabletStep)getStep(StepType.TABLET_STEP);
        tabletsListStep = (TabletsListStep) getStep((StepType.TABLETS_LIST_STEP));
    }

    @Test(testName = "Tablets Prices Test")
    public void tabletsPricesTest() {

        List<Price> prices = getPrices();

        for (Price price : prices) {
            tabletStep.goTabletPage()
                      .enterMinPrice(Helper.convertDoubleToString(price.getMinPrice()))
                      .enterMaxPrice(Helper.convertDoubleToString(price.getMaxPrice()))
                      .submitButtonClick();

            AssertUtils.makeAssert(tabletsListStep.getStickerTextElement(), price.getExpectedMessage());
        }
    }

    @Test
    public void tabletsFixedPricesLinkTest() {
        String resultPrice = PropertyReader
                .from("/properties/expectedMessages.properties",
                        "result.price_7000-10000")
                .getProperty("result.price_7000-10000");

        tabletStep.goTabletPage()
                  .clickFixedPriceLink();

        AssertUtils.makeAssert(tabletsListStep.getStickerTextElement(), resultPrice);
    }

    @Test
    public void tabletsDisplayDiagonalLinkTest() {
        String tabletDiagonalSize = PropertyReader
                .from("/properties/expectedMessages.properties",
                        "tablet.diagonal.size")
                .getProperty("tablet.diagonal.size");

        tabletStep.goTabletPage()
                  .clickDisplayDiagonalLink();

        AssertUtils.makeAssert(tabletsListStep.getTabletsListTitle(), tabletDiagonalSize);
    }

    @Test
    public void tabletsManufacturersLinkTest() {
        String searchResultText = PropertyReader
                .from("/properties/expectedMessages.properties",
                        "search.result.text")
                .getProperty("search.result.text");

        tabletStep.goTabletPage()
                  .clickManufacturerLink();

        AssertUtils.makeAssert(tabletsListStep.getTabletsListTitle(), searchResultText);
    }

    @DataProvider(name = "tabletsPricesDataProvider")
    private Object[][] tabletsPricesDataProvider() throws IOException {
        return GetDataFromExcel.getDataToObjectArray("/properties/common.properties",
                "tablets.test.prices.data.file", "prices");
    }

    private List<Price> getPrices() {
        List<Object> objectList = new ArrayList<>();
        List<Price> prices = new ArrayList<>();

        objectList = GetDataFromExcel.getDataToList("/properties/common.properties",
                "tablets.test.prices.data.file", "prices", "ua.ek.model.Price");

        prices = ClassConverter.cast(Price.class, objectList);
        return prices;
    }
}