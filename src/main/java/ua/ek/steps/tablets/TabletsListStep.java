package ua.ek.steps.tablets;

import org.openqa.selenium.WebDriver;
import ua.ek.steps.base.BaseStep;

public class TabletsListStep extends BaseStep {

    public TabletsListStep(WebDriver driver) {
        super(driver);
    }

    public String getTextPrices(){
        return getHelper().getTextFromWebElement(getTabletsListPage().getTextPricesField());
    }
}