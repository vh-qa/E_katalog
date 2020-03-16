package ua.ek.tablets.filters;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.steps.tablets.TabletStep;
import ua.ek.steps.tablets.TabletsListStep;
import ua.ek.steps.tablets.filters.PriceFilterStep;
import ua.ek.utils.AssertUtils;
import ua.ek.utils.PropertyReader;
import ua.ek.utils.StepType;

public class PriceFilterTest extends BaseTest {

    private TabletStep tabletStep;
    private PriceFilterStep priceFilterStep;
    private TabletsListStep tabletsListStep;

    @BeforeMethod
    public void init(){
        tabletStep = (TabletStep)getStep(StepType.TABLET_STEP);
        priceFilterStep = (PriceFilterStep)getStep(StepType.PRICE_FILTER_STEP);
        tabletsListStep = (TabletsListStep)getStep(StepType.TABLETS_LIST_STEP);
    }

    @Test
    public void priceFilterTest() {

        String minPrice = PropertyReader
                .from("/properties/common.properties",
                        "min.price")
                .getProperty("min.price");

        String maxPrice = PropertyReader
                .from("/properties/common.properties",
                        "max.price")
                .getProperty("max.price");

        String resultPrice = PropertyReader
                .from("/properties/expectedMessages.properties",
                        "result.price_10000-14999")
                .getProperty("result.price_10000-14999");

        tabletStep.goTabletPage();
        priceFilterStep.enterMinPriceInMinPriceField(minPrice)
                        .enterMaxPriceInMinPriceField(maxPrice)
                        .clickShowButton();

        AssertUtils.makeAssert(tabletsListStep.getStickerTextElement(), resultPrice);
    }
}