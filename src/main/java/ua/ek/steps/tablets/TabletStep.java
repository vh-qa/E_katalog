package ua.ek.steps.tablets;

import org.openqa.selenium.WebDriver;
import ua.ek.pages.tablets.TabletPage;
import ua.ek.pages.tablets.TabletsListPage;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.Helper;
import ua.ek.utils.IWaitTimes;

public class TabletStep extends BaseStep {

    private WebDriver driver;
    private Helper helper;

    public TabletStep(WebDriver driver) {
        super(driver);
        this.driver = driver;
        helper = new Helper(driver);
    }

    public TabletPage goTabletPage(WebDriver driver){
        return goHomePage(driver).clickTabletLink();
    }

    public TabletPage enterMinPrice(String minPrice) {
        helper.enterTextInTextField(getTabletPage().getMinPriceField(), minPrice);
        return new TabletPage(driver);
    }

    public TabletPage enterMaxPrice(String maxPrice) {
        helper.enterTextInTextField(getTabletPage().getMaxPriceField(), maxPrice);
        return new TabletPage(driver);
    }

    public TabletsListPage submitButtonClick(){
        helper.waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, getTabletPage().getSubmitButton()).click();
        return new TabletsListPage(driver);
    }
}
