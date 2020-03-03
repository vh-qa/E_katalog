package ua.ek.tablets.filters;

import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.utils.AssertUtils;

public class PriceFilterTest extends BaseTest {

    @Test
    public void priceFilterTest() {
        tabletStep.goTabletPage(driver);
        priceFilterStep.enterMinPriceInMinPriceField("10000");
        priceFilterStep.enterMaxPriceInMinPriceField("14999");
        priceFilterStep.clickShowButton();

        AssertUtils.makeAssert(tabletsListStep.getTabletsListPage().getTextPrices(),
                " от 20000  до 24999 грн.");
    }
}