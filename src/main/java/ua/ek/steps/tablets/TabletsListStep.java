package ua.ek.steps.tablets;

import org.openqa.selenium.WebDriver;
import ua.ek.pages.tablets.TabletsListPage;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.PageType;

public class TabletsListStep extends BaseStep {

    private TabletsListPage tabletsListPage;

    public TabletsListStep(WebDriver driver) {
        super(driver);
        tabletsListPage = (TabletsListPage)getPage(PageType.TABLETS_LIST_PAGE, driver);
    }

    public String getTabletsListTitle(){
        return getHelper().getTextFromWebElement(tabletsListPage.getTabletsListTitle());
    }

    public String getStickerTextElement(){
        return getHelper().getTextFromWebElement(tabletsListPage.getStickerTextElement());
    }
}