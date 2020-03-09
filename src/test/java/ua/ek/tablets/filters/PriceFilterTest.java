package ua.ek.tablets.filters;

import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.utils.AssertUtils;

public class PriceFilterTest extends BaseTest {

    @Test
    public void priceFilterTest() {
        getTabletStep().goTabletPage();
        getPriceFilterStep().enterMinPriceInMinPriceField("10000")
                        .enterMaxPriceInMinPriceField("14999")
                        .clickShowButton();

        AssertUtils.makeAssert(getTabletsListStep().getTextPrices(),
                " от 20000  до 24999 грн.");
    }
}