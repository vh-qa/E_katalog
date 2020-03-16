package ua.ek.steps.tablets;

import org.openqa.selenium.WebDriver;
import ua.ek.pages.tablets.TabletsManufacturerPage;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.PageType;

public class TabletsManufacturerStep extends BaseStep {

    private TabletsManufacturerPage tabletsManufacturerPage;

    public TabletsManufacturerStep(WebDriver driver) {
        super(driver);
        tabletsManufacturerPage = (TabletsManufacturerPage)getPage(PageType.TABLETS_MANUFACTURER_PAGE, driver);
    }

    public TabletsManufacturerPage getTabletsManufacturerPage() {
        return tabletsManufacturerPage;
    }

    public String getTabletsListTitle(){
        return getHelper().getTextFromWebElement(tabletsManufacturerPage.getPageTitle());
    }
}